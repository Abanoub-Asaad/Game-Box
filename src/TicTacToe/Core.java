
package TicTacToe;

import java.util.Random;


public class Core {
    
    private static char playerLetter;
    private static char computerLetter;
    private static boolean playerTurn ;
    private char winner = ' ';
    private  AI obj_ai = new AI();
    private static XO_Controller obj_xoController = new XO_Controller();
    
    
    /**
     * GameBoard is the Board of the Game which contains 9 squares in three
     * lines Here I make all the squares empty
     */
      protected void InitializeGameBoard(char[][] GameBoard) {
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameBoard[i][j] = ' ';
            }
        }
    }
      

      
      /**
       * Determine for whom the first turn , The Player or AI
       * @param GameBoard 
       */
      protected void determineFirstTurn(char GameBoard [][] ){
          
          playerTurn = new Random().nextBoolean();
          
          if (!playerTurn) {
            playerLetter = 'X';
            computerLetter = 'O';
        } else {
            playerLetter = 'O';
            computerLetter = 'X';
        }

        if (playerTurn) {
            obj_xoController.playerTurn(GameBoard, playerLetter);
            obj_xoController.printBoard(GameBoard);
        } 
      }
    
      
      
      
      
    /*
     * Here The Game Loop for X - O Game 
     */  
    protected void startGameLoop(char GameBoard [][] , int DEPTH ){
        do {

            int bestMove =  AI.minMax(GameBoard, DEPTH, computerLetter);
            GameBoard[bestMove / 3][bestMove % 3] = computerLetter;

            obj_xoController.printBoard(GameBoard);
            winner = obj_xoController.getWinnerIfThere(GameBoard);

            /*
             * if Game hasn't been finished yet 
            */
            if (winner == ' ' && !obj_xoController.checkIfGameIsFinishedOrNot(GameBoard)) {
                obj_xoController.playerTurn(GameBoard, playerLetter);
                obj_xoController.printBoard(GameBoard);
            } else {
                /*
                 * Computer Won Or Draw, Break!
                 * */
                break;
            }

            playerTurn = !playerTurn;
            winner = obj_xoController.getWinnerIfThere(GameBoard);
        } while (!obj_xoController.checkIfGameIsFinishedOrNot(GameBoard) && winner == ' ');

        if (winner == ' ') {
            System.out.println("Draw");
        } else {
            System.out.println(winner + " Wins");
        }
    }

    
}
