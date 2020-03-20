/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectlevel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author peso
 */
public class SelectLVL {
     Text lvl = new Text("Select Level");
    Group root= new Group();
     Scene scene = new Scene(root, 1800, 750);
     boolean locked = true;
 Image Imageback ;
 ImageView ImagbackIV;
 int x,y;
   private static SelectLVL Page1;
    String fileName =    "C:\\SelectLevel\\src\\Resource\\unlockedLVL.txt";;
       private FileReader file_reader;
    private BufferedReader buffered_reader;
     Image lvlImage ;
    ImageView IV ;
       public static SelectLVL getInstance2(){
               if (Page1 == null) {
            Page1 = new SelectLVL();
        }
       return Page1;
       }

    public SelectLVL() {
      
    }
 
    public  SelectLVL(Stage stage) throws IOException {
       
        x=200; y=200;
     stage.setMaximized(true);
        stage.setResizable(false);   
     CreateBackground( );
     SelectLvlTxt();
     createImage();
     MovePage(stage);
     
        stage.setScene(scene);
        stage.show();
    }
     public void CreateBackground(){
          Imageback = new Image("Resource/ww.jpg", 1370, 780, true, false);
         ImagbackIV = new ImageView(Imageback);
       root.getChildren().add(ImagbackIV);
     }
     public void SelectLvlTxt(){
       lvl.setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 100));
      lvl.setFill(Color.DEEPPINK);
      lvl.setStroke(Color.GOLD);
      lvl.setStrokeDashOffset(2);
      lvl.setStrokeWidth(4);
       lvl.setX(300);
     lvl.setY(130);
    
         FadeTransition Fade = new FadeTransition(Duration.millis(5000));
        Fade.setNode(lvl);
        Fade.setFromValue(0);
        Fade.setToValue(6);
        Fade.setCycleCount(1);
        Fade.play();
      root.getChildren().add(lvl);}

     public void createImage() throws IOException{
     SetImage(0,x,y);
         IV.setLayoutX(200);
        x+=100;
        IV.setLayoutY(200);
        IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.GREY));
        root.getChildren().addAll(IV);
          Text t;
         t = new Text(Integer.toString(1));
         t.setFill(Color.WHITE);
        t.setFont(Font.font(30));
        t.setX(x-75);
        t.setY(y+45);
       t.toFront();
          root.getChildren().addAll(t);
        for(int i=1; i<10; i++){
      
         SetImage(i,x,y);
         IV.setLayoutX(x);
     IV.setLayoutY(200);
        IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.PINK));
            x+=100;
        root.getChildren().addAll(IV);
        if(!locked){
                            t = new Text(Integer.toString(i+1));
          t.setFill(Color.WHITE);
        t.setFont(Font.font(30));
        t.setX(x-75);
        t.setY(y+45);
       t.toFront();
          root.getChildren().addAll(t);}
     }
        
      
    
        for(int j =10;j<50;j++){
        if(j%10==0)   {y+=100; x=200;}
         SetImage(j,x,y);
         IV.setLayoutX(x);
     IV.setLayoutY(y);
        IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.PINK));
            x+=100;
        root.getChildren().addAll(IV);
          if(!locked){
                            t = new Text(Integer.toString(j+1));
          t.setFill(Color.WHITE);
        t.setFont(Font.font(30));
        t.setX(x-80);
        t.setY(y+45);
       t.toFront();
          root.getChildren().addAll(t);}
      
        }
        
     }
     
     public void MovePage(Stage stage){
     
        Circle page1 , page2;
        page1 = new Circle();
         page2 = new Circle();
        page1.setRadius(10);
        page1.setFill(Color.WHITE);
    
              page1.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));
       page1.setCenterX(690);
       page1.setCenterY(710);
     
        page2.setRadius(10);
          page2.setFill(Color.GREY);
           page2.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));
        page2.setOnMouseEntered(event ->  {
            page2.setFill(Color.WHITE);
             });
            page2.setOnMouseExited(event ->  {
            page2.setFill(Color.GREY);
             });
        
            page2.setOnMouseClicked(event ->  {
             try
            {
              page2_Main.getInstance().page2_Main(stage);
            } 
            catch (IOException ex)
            {
                Logger.getLogger(SelectLVL.class.getName()).log(Level.SEVERE, null, ex);
            }});
        page2.setCenterX(660);
       page2.setCenterY(710);
          root.getChildren().addAll(page1,page2);
     }
     
     
     public void SetImage(int lvlN,int X,int Y)throws FileNotFoundException, IOException{
         locked=true;
        lvlImage= new Image("Resource/lock.png",70,70,true,true);
        IV=new ImageView(lvlImage);
     
        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);
      
        String currentLine;
        
        while((currentLine = buffered_reader.readLine()) != null)
        { 
            if( lvlN==Integer.parseInt(currentLine)) 
            { locked = false;
                if(lvlN%8==0){lvlImage= new Image("Resource/0.png",70,70,true,true);}
            else if(lvlN%2==0){lvlImage= new Image("Resource/1.png",70,70,true,true);}
            else if(lvlN%3==0){lvlImage= new Image("Resource/2.png",70,70,true,true);}
            else if(lvlN%4==0){lvlImage= new Image("Resource/3.png",70,70,true,true);}
            else if(lvlN%5==0){lvlImage= new Image("Resource/4.png",70,70,true,true);}
            else if(lvlN%6==0){lvlImage= new Image("Resource/5.png",70,70,true,true);}
            else if(lvlN%7==0){lvlImage= new Image("Resource/6.png",70,70,true,true);}
            else{lvlImage= new Image("Resource/7.png",70,70,true,true);}
                    IV.setImage(lvlImage);
        
        break;
        }
        
        
        }
     }
}
