
package fx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {
    
    @FXML
     private Circle c1; 
   @FXML
   private Circle c2;
     @FXML
   private Circle c3;
         @FXML
private ProgressIndicator PI;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Progress progress = new Progress(PI);
        SetRotate(c1,true,345,22);
        SetRotate(c2,true,290,8);
        SetRotate(c3,true,100,15);
        progress.start();

    }    
     int rotate = 0;
     //3 circles rotation fn.
    private void SetRotate(Circle c, boolean reverse , double angle,int duration){
    RotateTransition RT = new RotateTransition(Duration.seconds(duration),c);
    RT.setAutoReverse(reverse);
    RT.setByAngle(angle);
    RT.setDelay(Duration.seconds(0));
    RT.setRate(3);
    RT.setCycleCount(20);
    RT.play();
    }
}
