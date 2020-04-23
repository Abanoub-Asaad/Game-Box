/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author Eng.Waleed
 */
public class Sound {
    
            static   String sound_back = "C:\\Game-Box\\src\\Resources\\Sokoban\\soko_sound.mp3";
            static   Media back_sound = new Media(new File(sound_back).toURI().toString());
            static   MediaPlayer mediaPlayer_back = new MediaPlayer(back_sound);
            static   MediaView mediaview_back = new MediaView(mediaPlayer_back);
    
            static   String sound_pipe = "C:\\Game-Box\\src\\Resources\\Sokoban\\pipe_sound.mp3";
            static   Media pipe_sound = new Media(new File(sound_pipe).toURI().toString());
            static   MediaPlayer mediaPlayer_pipe = new MediaPlayer(pipe_sound);
            static   MediaView mediaview_pipe = new MediaView(mediaPlayer_pipe);
    
            static   String sound_win = "C:\\Game-Box\\src\\Resources\\Sokoban\\winning.mp3";
            static   Media win_sound = new Media(new File(sound_win).toURI().toString());
            static   MediaPlayer mediaPlayer_win = new MediaPlayer(win_sound);
            static   MediaView  mediaview_win = new MediaView(mediaPlayer_win);
    
            static   String sound_pad = "C:\\Game-Box\\src\\Resources\\Sokoban\\Clash.mp3";
            static   Media pad_sound = new Media(new File(sound_pad).toURI().toString());
            static   MediaPlayer mediaPlayer_pad = new MediaPlayer(pad_sound);
            static   MediaView  mediaview_pad = new MediaView(mediaPlayer_pad);
    
    
              public static void playsound ( MediaPlayer mediaPlayer )
          {
          
                    mediaPlayer.play();
                 
                    mediaPlayer.seek(Duration.ZERO);
          }
      
              
      }
