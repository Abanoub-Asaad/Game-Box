package TicTacToe;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class XO_Main {

    public Stage XOStage;
    private static Rectangle[][] GameBoard = new Rectangle[3][3];
    private static String [][] XO = new String[3][3];
    private static Core obj_Core = new Core();
    static Group XOGroup = new Group();
    static Scene XOScene;


    /**
     * Depth for The Algorithm. if we make it smaller, the Game 'll be easy
     * because the search 'll not reach the end of the Game (It 'llnot Calculate
     * All possible moves)
     */
    private static final int DEPTH = 9 ;
    
    private static XO_Main XOInstance;

    public static XO_Main getInstanceFromXO() {
        if (XOInstance == null) {
            XOInstance = new XO_Main();
        }

        return XOInstance;
    }

    public  void XO_Main(Stage Games_Stage) {
        XOScene = new Scene(XOGroup , 1370, 750);
        System.out.println("1\t|\t2\t|\t3\t\n" + "4\t|\t5\t|\t6\t\n" + "7\t|\t8\t|\t9\t\n");
        obj_Core.InitializeGameBoard(GameBoard ,XOGroup,XOScene, XO); 
        obj_Core.determineFirstTurn(GameBoard , XO , DEPTH , XOScene  , XOGroup);
        obj_Core.setInformationOfPlayers(XOGroup);
         XO_Controller.playerTurn(GameBoard, Core.playerText, XO, Core.playerChar,DEPTH, XOScene, XOGroup);


         XOStage = Games_Stage;
        XOStage.setScene(XOScene);
       XOStage.show();
    }

}
