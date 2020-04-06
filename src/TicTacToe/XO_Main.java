package TicTacToe;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class XO_Main {

    private static char[][] GameBoard = new char[3][3];
    private static Core obj_Core = new Core();

    /**
     * Depth for The Algorithm. if we make it smaller, the Game 'll be easy
     * because the search 'll not reach the end of the Game (It 'llnot Calculate
     * All possible moves)
     */
    private static final int DEPTH = 9;

    //--------------------------------
    //Singleton
    private static XO_Main xoInstance;

    public static XO_Main getInstanceFromXO() {
        if (xoInstance == null) {
            xoInstance = new XO_Main();
        }

        return xoInstance;
    }

    private XO_Main() {

    }

    //---------------------------------

    public void XO_Main(Stage Games) {

        System.out.println("1\t|\t2\t|\t3\t\n" + "4\t|\t5\t|\t6\t\n" + "7\t|\t8\t|\t9\t\n");
        obj_Core.InitializeGameBoard(GameBoard);
        obj_Core.determineFirstTurn(GameBoard);
        obj_Core.startGameLoop(GameBoard, DEPTH);
        
    }

}
