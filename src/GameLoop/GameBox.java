package GameLoop;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameBox extends Application {

     //    to access  root to switch scenes 
 public static Stage Root  = new Stage() ;
    @Override
    public void start(Stage GameBoxCore_Stage) {

        GameBoxCore_Stage = new Stage();
         Root = GameBoxCore_Stage;
        Games games_obj = new Games(GameBoxCore_Stage);
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
