
package Tetris;

import static Tetris.Tetris_Main.tetris_back_iv;
import static Tetris.Tetris_Main.tetris_pane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Help {
    
    Image help_back_img = new Image("Resources/Tetris/g.jpg", 1370, 780, false, false);
    Image key_img = new Image("Resources/Tetris/center.png", 600, 350, false, false);
    Image key_imgg = new Image("Resources/Tetris/keys.png", 300, 200, false, false);
    Image l_img = new Image("Resources/Tetris/l.png", 100, 100, false, false);
    Image r_img = new Image("Resources/Tetris/r.png", 100, 100, false, false);
    Image u_img = new Image("Resources/Tetris/u.png", 100, 100, false, false);
    Image d_img = new Image("Resources/Tetris/d.png", 100, 100, false, false);
    
    ImageView help_back_imgIv = new ImageView(help_back_img);
    ImageView key_imgIv = new ImageView(key_img);
    ImageView key_imggIv = new ImageView(key_imgg);
    ImageView l_iv = new ImageView(l_img);
    ImageView r_iv = new ImageView(r_img);
    ImageView u_iv = new ImageView(u_img);
    ImageView d_iv = new ImageView(d_img);
    
    
    Pane help_pane = new Pane();
    
    
    Help(){
        help_pane.getChildren().addAll(help_back_imgIv, key_imgIv, key_imggIv, l_iv, r_iv, d_iv, u_iv);
        put_imgKey();
        setText();
    }
        
    private void put_imgKey(){
        key_imgIv.setX(100);
        key_imgIv.setY(150);
        
        key_imggIv.setX(920);
        key_imggIv.setY(80);
        
        r_iv.setX(800);
        r_iv.setY(290);
        
        l_iv.setX(800);
        l_iv.setY(400);
        
        d_iv.setX(800);
        d_iv.setY(510);
        
        u_iv.setX(800);
        u_iv.setY(620);
        
        
    }
    
    private void setText(){
        Text text_tetris = new Text(50, 80, "TETRIS");
      //Loading a font from local file system
      text_tetris.setFont((Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60)));
      text_tetris.setFill(Color.BLUE);
      text_tetris.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_tetris);
      
      Text text_how = new Text(480, 80, "How to play?");
      text_how.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)));
      text_tetris.setFill(Color.BLUE);
      text_tetris.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_how);
      
      Text text_r = new Text(920, 350, "Move Right");
      text_r.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 45 )));
      text_r.setFill(Color.BLUE);
      text_r.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_r);
      
      Text text_l = new Text(920, 460, "Move Left");
      text_l.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 45 )));
      text_l.setFill(Color.BLUE);
      text_l.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_l);
      
      Text text_d = new Text(920, 570, "Move Down");
      text_d.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 45 )));
      text_d.setFill(Color.BLUE);
      text_d.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_d);
      
      Text text_u = new Text(920, 680, "Rotate the shape");
      text_u.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 45 )));
      text_u.setFill(Color.BLUE);
      text_u.setStroke(Color.BLACK);
      help_pane.getChildren().add(text_u);
      
  
    }
    
    
    
    Scene help_scene = new Scene(help_pane, 1370, 780);
    
    
}
