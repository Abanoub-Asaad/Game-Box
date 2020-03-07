
package gamespage;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GamesPage extends Application {
    
    
    @Override
    public void start(Stage gamesStage) throws IOException 
    {
    
        
    games gamesObj = new games(gamesStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
