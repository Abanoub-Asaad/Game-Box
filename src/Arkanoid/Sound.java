package Arkanoid;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Sound {

         //sound 
    //sound of block
    private static String ssound = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\hit.mp3";
    public static Media sound = new Media(new File(ssound).toURI().toString());
    public static MediaPlayer mediaPlayer_block = new MediaPlayer(sound);
    public static MediaView mediaview = new MediaView(mediaPlayer_block);
    //sound of ball when he lose
    public static String ssound2 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\losing sounds.mp3";
    public static Media sound2 = new Media(new File(ssound2).toURI().toString());
    public static MediaPlayer mediaPlayer_ball_out = new MediaPlayer(sound2);
    public static MediaView mediaview2 = new MediaView(mediaPlayer_ball_out);
    // wining sound 
    public static String ssound3 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\nextLevel.mp3";
    public static Media sound3 = new Media(new File(ssound3).toURI().toString());
    public static MediaPlayer mediaPlayer_win = new MediaPlayer(sound3);
    public static MediaView mediaview3 = new MediaView(mediaPlayer_win);
    //menu sound
    public static String ssound4 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\menu_item_select.mp3";
    public static Media sound4 = new Media(new File(ssound4).toURI().toString());
    public static MediaPlayer mediaPlayer_menu = new MediaPlayer(sound4);
    public static MediaView mediaview4 = new MediaView(mediaPlayer_menu);

    //Background Sound 
    public static String ssound5 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\background.mp3";
    public static Media sound5 = new Media(new File(ssound5).toURI().toString());
    public static MediaPlayer mediaPlayer_background = new MediaPlayer(sound5);
    public static MediaView mediaview5 = new MediaView(mediaPlayer_background);

    //When Capsule hits the paddle "Sound" 
    public static String ssound6 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\capsule.mp3";
    public static Media sound6 = new Media(new File(ssound6).toURI().toString());
    public static MediaPlayer mediaPlayer_Capsule = new MediaPlayer(sound6);
    public static MediaView mediaview6 = new MediaView(mediaPlayer_Capsule);

    //Mouse's click sound in draw your level
    public static String ssound7 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\Mouse-Click.mp3";
    public static Media sound7 = new Media(new File(ssound7).toURI().toString());
    public static MediaPlayer mediaPlayer_clickMouse = new MediaPlayer(sound7);
    public static MediaView mediaview7 = new MediaView(mediaPlayer_clickMouse);

    //Menu Background
    public static String ssound8 = "C:\\Game-Box\\src\\Resources\\Arkanoid\\Sounds\\Groovy-drum-beat-112-bpm.wav";
    public static Media sound8 = new Media(new File(ssound8).toURI().toString());
    public static MediaPlayer mediaPlayer_Menu_Back = new MediaPlayer(sound8);
    public static MediaView mediaview8 = new MediaView(mediaPlayer_Menu_Back);

    public static void playsound() {

        mediaPlayer_block.play();
        mediaPlayer_block.pause();
        mediaPlayer_block.seek(Duration.ZERO);
    }

    public static void playsound_capsule() {

        mediaPlayer_Capsule.play();
        mediaPlayer_Capsule.pause();
        mediaPlayer_Capsule.seek(Duration.millis(.1));
    }

    public static void BackGround_Sound() {

    }
}
