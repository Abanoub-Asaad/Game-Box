
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

    static Text playerText;
    static Text computerText;
    static String  playerChar, computerChar;
    static boolean playerTurn;
  
    private static XO_Controller obj_xoController = new XO_Controller();
    int numOfPlayer = 1; // to make 2 players 
    
//--------------------------------------------
    int width = 150, height = 150;
    int x = 250, y = 50;
    private static Image XO_back_img = new Image("Resources/XO/6.jpg", 1400, 800, false, false);
    protected static ImageView XO_back_iv = new ImageView(XO_back_img);
//-------------------------------------------------
    protected void InitializeGameBoard(Rectangle[][] GameBoard, Group root,Scene scene, String[][] sym) { 
      
        for (int i = 0; i < 3; i++) {
            x = 250;
            y += height + 2;
            for (int j = 0; j < 3; j++) {
                GameBoard[i][j] = new Rectangle(x, y, width, height);
                GameBoard[i][j].setFill(Color.ALICEBLUE);
                x += width + 2;
            }

        }
        root .getChildren().add(XO_back_iv);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                root.getChildren().add(GameBoard[i][j]);
                sym[i][j] = " ";
            }
        }

    }

    /**
     * Determine for whom the first turn , The Player or AI
     *
     * @param GameBoard
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
    //--------------------------------
     public void setInformationOfPlayers(Group group)
    {
        Text Player1 = new Text();
        Text Player2 = new Text();
   switch ( numOfPlayer )
   {
       case 1 :
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
           
           group . getChildren().addAll(Player1 , Player2);
           break;
   }
    }
   
    //---------------------------------
    /*
     * Here The Game Loop for X - O Game 
     */
     public static void computerTurn(Rectangle[][] rectangles , String[][] symbol , int DEPTH , Group group)
     {
          int bestMove = AI.minMax(symbol, DEPTH, computerChar);
            symbol[bestMove / 3][bestMove % 3] = computerChar;
            Bloom bloom = new Bloom();
            computerText = new Text();
            
            computerText.setText(computerChar);
            computerText.setX(rectangles[bestMove / 3][bestMove % 3].getX() + 50);
            computerText.setY(rectangles[bestMove / 3][bestMove % 3].getY() + 100);
            computerText.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
            computerText.setFill(Color.VIOLET);
            computerText .setEffect(bloom);
            
            group.getChildren().add(computerText);
     }
    
    
    
  
}