package GameLoop;

import Welcome.Games;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameBox extends Application {

     //    to access  root to switch scenes 
 public static Stage Root  = new Stage() ;
    @Override
    public void start(Stage Root_Stage) {

        Root_Stage = new Stage();
         Root = Root_Stage;
        Games games_obj = new Games(Root_Stage);
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
