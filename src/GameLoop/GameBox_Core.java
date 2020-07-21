package GameLoop;

import static GameLoop.Games.for_esc;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Platform;

public class GameBox_Core extends Application {

    Image img_icon = new Image("Resources/Icons/download.jpg");
    //    to access  root to switch scenes 
    public static Stage Root;

    @Override
    public void start(Stage Root_Stage) {

       
        Root = Root_Stage;
        
        Games games_obj = new Games(Root_Stage);
        Root_Stage.getIcons().add(img_icon);
         
        
          
                    for_esc();
                
    }

    public static void main(String[] args) {
        launch(args);
    }

}
