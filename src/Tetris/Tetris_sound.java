/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author Eng.Waleed
 */
public class Tetris_sound {
            static   String sound_back = "C:\\Game-Box\\src\\Resources\\Tetris\\tetris_back.mp3";
            static   Media back_sound = new Media(new File(sound_back).toURI().toString());
            public   static   MediaPlayer mediaPlayer_back = new MediaPlayer(back_sound);
            static   MediaView mediaview_back = new MediaView(mediaPlayer_back);
    
            static   String sound_clear = "C:\\Game-Box\\src\\Resources\\Tetris\\clear.mp3";
            static   Media clear_sound = new Media(new File(sound_clear).toURI().toString());
            static   MediaPlayer mediaPlayer_clear = new MediaPlayer(clear_sound);
            static   MediaView mediaview_clear = new MediaView(mediaPlayer_clear);
  
            public static void back_sound(){    
          mediaPlayer_back.setOnEndOfMedia(new Runnable() {
       public void run() {
         mediaPlayer_back.seek(Duration.ZERO);
       }
   });
  mediaPlayer_back.play();
        }
     
}
