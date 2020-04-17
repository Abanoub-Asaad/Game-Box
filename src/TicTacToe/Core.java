
package TicTacToe;

import java.util.Random;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Core {

    /**
     * Best move for Computer to play 
     * it's the number of the rectangle that in the board
     */
    private static int bestMove ;
    protected static Text playerText;
    private static Text computer_symbol_Text;
    protected static String  playerChar, computerChar;
    protected static boolean playerTurn;
    private static Image XO_back_img ;
    private static ImageView XO_back_iv ;
    int numOfPlayer = 1; // to make 2 players 
    
    
    /**
     * draw the game board which consists of 9 rectangles
     * @param GameBoard
     * @param root
     * @param scene
     * @param sym 
     */
    protected void InitializeGameBoard(Rectangle[][] GameBoard, Group root,Scene scene, String[][] sym) { 
        
        int x = 250, y = 50;
        int width = 150, height = 150;
        
        for (int i = 0; i < 3; i++) {
            x = 250;
            y += height + 2;
            for (int j = 0; j < 3; j++) {
                GameBoard[i][j] = new Rectangle(x, y, width, height);
                GameBoard[i][j].setFill(Color.ALICEBLUE);
                x += width + 2;
            }

        } 
        
        drawXO_background(root);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                root.getChildren().add(GameBoard[i][j]);
                sym[i][j] = " "; 
            }
        }

    }

    
    /**
     * Draw XO Background
     * @param group 
     */
    private void drawXO_background(Group group){
        XO_back_img = new Image("Resources/XO/6.jpg", 1400, 800, false, false);
        XO_back_iv = new ImageView(XO_back_img);
        
        group.getChildren().add(XO_back_iv);
    }
    
   /**
    * Determine for whom the first turn , The Player or AI
    * @param rectangles
    * @param symbol
    * @param DEPTH
    * @param scene
    * @param group 
    */
    protected void determineFirstTurn(Rectangle[][] rectangles, String[][] symbol,int DEPTH, Scene scene, Group group) {

        playerTurn = new Random().nextBoolean();

        if (!playerTurn) {
            playerChar = "X";
            computerChar = "O";
        } else {
            playerChar = "O";
            computerChar = "X";
        }

        if (!playerTurn) {
                computerTurn(rectangles, symbol, DEPTH, group);
        }
    }
    
      /**
      * Main Entry for AI 
      * @param rectangles
      * @param symbol
      * @param DEPTH
      * @param group 
      */
     protected static void computerTurn(Rectangle[][] rectangles, String[][] symbol, int DEPTH, Group group) {
         
        bestMove = AI.minMax(symbol, DEPTH, computerChar);
        symbol[bestMove / 3][bestMove % 3] = computerChar;
        
        drawComputerSymbol(rectangles, group);
    }
    
    
    
    /**
     * make Design of Player and Computer that appear in the scene
     * @param group 
     */
     public void setInformationOfPlayers(Group group) {
        Text Player1 = new Text();
        Text Player2 = new Text();
        switch (numOfPlayer) {
            case 1:
                Bloom bloom = new Bloom();

                Player1.setText(" Player : " + playerChar);
                Player1.setFill(Color.BLUE);
                Player1.setX(800);
                Player1.setY(200);
                Player1.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)));
                Player1.setEffect(bloom);

                Player2.setText(" Computer : " + computerChar);
                Player2.setFill(Color.VIOLET);
                Player2.setX(800);
                Player2.setY(250);
                Player2.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)));
                Player2.setEffect(bloom);

                group.getChildren().addAll(Player1, Player2);
                break;
        }
    }
   
     
     /**
      * Draw the computer symbol even X or O
      * @param rectangles
      * @param group 
      */
    private static void drawComputerSymbol(Rectangle[][] rectangles, Group group ){
        
    Bloom bloom = new Bloom();   
    computer_symbol_Text = new Text();
    computer_symbol_Text.setText(computerChar);
    computer_symbol_Text.setX(rectangles[bestMove / 3][bestMove % 3].getX() + 50);
    computer_symbol_Text.setY(rectangles[bestMove / 3][bestMove % 3].getY() + 100);
    computer_symbol_Text.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
    computer_symbol_Text.setFill(Color.VIOLET);
    computer_symbol_Text.setEffect(bloom);
    group.getChildren().add(computer_symbol_Text);
}
    
  
}