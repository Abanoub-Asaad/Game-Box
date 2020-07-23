
package TicTacToe;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class sound {

    static String sound_back = "C:\\Game-Box\\src\\Resources\\XO\\tic_sound.mp3";
    static Media back_sound = new Media(new File(sound_back).toURI().toString());
    public static MediaPlayer mediaPlayer_back = new MediaPlayer(back_sound);
    static MediaView mediaview_back = new MediaView(mediaPlayer_back);

}
