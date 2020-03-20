/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectlevel;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author peso
 */

public class SelectLevel extends Application {
     
    @Override
    public void start(Stage stage) throws IOException {
   SelectLVL selectLvl = new SelectLVL(stage);
  
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
}
