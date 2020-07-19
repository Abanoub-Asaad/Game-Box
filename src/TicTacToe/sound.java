/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Eng.Waleed
 */
public class sound {
    
            static   String sound_back = "C:\\Game-Box\\src\\Resources\\XO\\tic_sound.mp3";
            static   Media back_sound = new Media(new File(sound_back).toURI().toString());
        public    static   MediaPlayer mediaPlayer_back = new MediaPlayer(back_sound);
            static   MediaView mediaview_back = new MediaView(mediaPlayer_back);
    
}
