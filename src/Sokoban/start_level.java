/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import GameLoop.GameBox;
import Welcome.Games;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Eng.Waleed
 */
public class start_level {
  public static   int i=0; 
 public GameBox get_root= new GameBox();   
 public    Sokoban_Main s;
 public  static   Pane  pane_storeName = new Pane();
 public   static   Line sep ;
 
    public  static   Scene scene_StoreName= new Scene(pane_storeName,1370,750) ;
  static  TextField textField ;
    
    public  static     Button btn_start ;
 
    static   File file = new File("C:\\Game-Box\\src\\Resources\\Sokoban\\sokoban_player.txt");
  
  static  FileWriter filewriter ;
  static BufferedWriter bufferwriter ;
     
   public static  String PlayerName_string;
    
   // private String nameofplayer ="";
    
     public static   Pane  store_name () throws IOException{
         
       scene_StoreName.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());
         
        textField  = new TextField();
        btn_start = new Button();
      
        pane_storeName.setId("pane");
        textField.setTranslateX(450);
        textField.setTranslateY(350);
        textField.setId("label");
        textField.setPromptText("enter your name");
        textField.setFocusTraversable(false);
         addTextLimiter(textField,14);
         
        btn_start.setTranslateX(450);
        btn_start.setTranslateY(430);
        btn_start.setId("start");
        btn_start.setText("play");
       
         sep= new Line(300,300,1000,0);
        
        sep.setStroke(Color.LIMEGREEN);
        
        pane_storeName.getChildren().addAll(textField,btn_start);
        
        //============================= 
        WriteNameInFile(GameBox.Root);
       
           return pane_storeName ;
     }
       
          public static void addTextLimiter(final TextField tf, final int maxLength)
     {
        tf.textProperty().addListener(new ChangeListener<String>()
         {
        @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) 
                {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
        }
       });
    }
          
          
            public  static  void WriteNameInFile( Stage stage) throws IOException
     {
       // filewriter = new FileWriter(file, true);
       // bufferwriter = new BufferedWriter(filewriter);
        
         
          btn_start.setOnAction(e -> 
          {
              
           PlayerName_string=textField.getText();
           //try
           //{
               /*
                PlayerName_string = textField.getText() ;
                
                if( PlayerName_string.length()>0 && !PlayerName_string.contains(" ") ) //Validation
                {
                    
                    
                    bufferwriter.write( PlayerName_string+":"+i+":");
                    bufferwriter.close();
                    filewriter.close();
                    
         */
                    if(i==0){
                        
                    
              GameBox.Root.setScene(Sokoban_Main.sokoban_scene);
              score.score=0;
              time.seconds=0;
              time.time_text.setText("time :" +"00:00" + " ");
              time.show_moves_number(0);
              time.timer.play();
              
              i++;
              
                }
             else{
                        
              GameBox.Root.setScene(Sokoban_Main.sokoban_scene);        
              map.startlevel();
              score.score=0;
              time.time_text.setText("time :" +"00:00" + " ");
              time.show_moves_number(0);
              time.timer.play();
       
                    i++;
                }
         // }
         //   } 
            
          // catch (IOException ex) 
          //  {
            //    System.out.println("NOT Success");  
           // }
           
        });
         
     }
     
     
                  
     
     
     
     public String getPlayerName()
     {
         return PlayerName_string ;
     }
}

    
