package TicTacToe;

import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * TicTacToe main game class.
 */
public class XO_Main {

    /**
     * XO Stage
     */
    private Stage XO_stage;
    /**
     * GameBoard consists of 9 rectangles
     */
    private static Rectangle[][] GameBoard;

    private static String[][] XO;
    private static Core obj_Core;
    static Group XO_group;
    static Scene XO_scene;

    /**
     * Depth for The Algorithm. if we make it smaller, the Game 'll be easy
     * because the search 'll not reach the end of the Game (It 'llnot Calculate
     * All possible moves)
     */
    private static final int DEPTH = 9;

    /**
     * Main XO object
     */
    private static XO_Main XOInstance;

    /**
     * getInstanceFromXO method for Singleton Pattern
     *
     * @return XOInstance which is an object for The main class of XO
     */
    public static XO_Main getInstanceFromXO() {
        if (XOInstance == null) {
            XOInstance = new XO_Main();
        }

        return XOInstance;
    }

    /**
     * @param Games_Stage which is the stage that contains button for all games
     */
    public void openTicTacToeMain(Stage Games_Stage) {

        GameBoard = new Rectangle[3][3];
        XO = new String[3][3];
        obj_Core = new Core();
        XO_group = new Group();
        XO_scene = new Scene(XO_group, 1370, 750);

        obj_Core.InitializeGameBoard(GameBoard, XO_group, XO_scene, XO);
        obj_Core.determineFirstTurn(GameBoard, XO, DEPTH, XO_scene, XO_group);
        obj_Core.setInformationOfPlayers(XO_group);
        XO_Controller.playerTurn(GameBoard, Core.playerText, XO, Core.playerChar, DEPTH, XO_scene, XO_group);

        XO_stage = Games_Stage;
        XO_stage.setScene(XO_scene);
        XO_stage.show();
    }

}
