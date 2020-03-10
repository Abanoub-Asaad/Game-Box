//progress counter class
package fx;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;

public class Progress extends Thread {
    ProgressIndicator  PI;
    double prog ;
    public Progress( ProgressIndicator  PI){
    this.PI = PI;
    prog = 0;
    }
    public void run(){
    for(;prog<=1;prog+=0.03){
        try {
            Thread.sleep( 200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Progress.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(()->{
         PI.setProgress(prog);
        });
   
    }
    }
}
