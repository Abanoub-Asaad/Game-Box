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
import selectlevel.SelectLVL;

public class page2_Main {
     static Group root = new Group();
     boolean   locked=false;
      Image lvlImage ;
        ImageView IV ;
           String fileName;
       private FileReader file_reader;
    private BufferedReader buffered_reader;
      private static page2_Main Page2;
       public static page2_Main getInstance(){
               if (Page2 == null) {
            Page2 = new page2_Main();
        }
       return Page2;
       }

    public page2_Main() {
                 fileName = "C:\\SelectLevel\\src\\Resource\\unlockedLVL.txt";

        SelectLVL sLVL = new SelectLVL();
        
    }
       public void page2_Main(Stage stage) throws IOException {
    
            Text lvl = new Text("Select Level");
   
     Scene scene = new Scene(root, 1800, 750);
     stage.setMaximized(true);
        stage.setResizable(false);   
             Image Imageback = new Image("Resource/ww.jpg", 1370, 780, true, false);
        ImageView ImagbackIV = new ImageView(Imageback);
       root.getChildren().add(ImagbackIV);
       //txt
       lvl.setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 100));
      lvl.setFill(Color.DEEPPINK);
      lvl.setStroke(Color.GOLD);
      lvl.setStrokeDashOffset(2);
      lvl.setStrokeWidth(4);
       lvl.setX(300);
     lvl.setY(130);
    
      root.getChildren().add(lvl);
       
       int x=200 , y=100;
  
        Text t;
       
        for(int j =50;j<100;j++){
         if(j%10==0)   {y+=100; x=200;}
        SetImage(j);
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
        
        
         FadeTransition Fade = new FadeTransition(Duration.millis(5000));
        Fade.setNode(lvl);
        Fade.setFromValue(0);
        Fade.setToValue(6);
        Fade.setCycleCount(1);
        Fade.play();
        
        Circle page1 , page2;
        page1 = new Circle();
         page2 = new Circle();
        page2.setRadius(10);
        page2.setFill(Color.WHITE);
    
              page2.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));
       page2.setCenterX(660);
       page2.setCenterY(710);
     
        page1.setRadius(10);
          page1.setFill(Color.GREY);
           page1.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));
        page1.setOnMouseEntered(event ->  {
            page1.setFill(Color.WHITE);
             });
            page1.setOnMouseExited(event ->  {
            page1.setFill(Color.GREY);
             });
       
//           page1.setOnMouseClicked(event ->  {
//             try
//            {
//              SelectLVL.getInstance2().SelectLVL(stage);
//            }  
//            catch (IOException ex)
//            {
//                Logger.getLogger(page2_Main.class.getName()).log(Level.SEVERE, null, ex);
//            }});
        page1.setCenterX(690);
       page1.setCenterY(710);
          root.getChildren().addAll(page1,page2);
          
        stage.setScene(scene);
        stage.show();
       
       }
       public void SetImage(int lvlN)throws FileNotFoundException, IOException{
           locked=true;
        lvlImage= new Image("Resource/lock.png",70,70,true,true);
        IV=new ImageView(lvlImage);
        
        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);
        
        String currentLine;
        
        while((currentLine = buffered_reader.readLine()) != null)
        { 
            if( lvlN==Integer.parseInt(currentLine)) 
            {locked = false;
          if(lvlN%8==0){ 
              lvlImage= new Image("Resource/0.png",70,70,true,true);}
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
