/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author egypt
 */
public class paddle {
    Timeline timelineDragUsingMouse ;
    
    Image paddle = new Image("Resources/Arkanoid/n-paddle0.png",200,40,false,false);
    Image paddle2 = new Image("Resources/Arkanoid/n-paddle1.png",200,40,false,false);
    Image paddle3 = new Image("Resources/Arkanoid/n-paddle1.png",200,40,false,false);
    ImageView paddle_iv = new ImageView(paddle);
    
    double Height = 25 ; 
    double Width  = 100 ; 
    double speed  = 10 ; 
     
    private Timeline t = new Timeline();
    
    public double mouse_pos_x ,orgTranslateX  , newTranslateX;
    
    public double getX()
    {
        return paddle_iv.getX();
    }
    
    public  void setX(double x)
    {
        paddle_iv.setX(x);
    } 
    
    public double getY()
    {
        return paddle_iv.getY();
    }

    public void setY(double y)
    {
        paddle_iv.setY(y);
    }

    public double getHeight() 
    {
        return Height;
    }

    public void setHeight(double height)
    {
        Height = height;
    }

    public double getWidth()
    {
        return Width;
    }

    public void setWidth(double width)
    {
        Width = width;
    }
    
    public double getSpeed()
    {
       return  speed ; 
    }
    
    public void setSpeed(double speed)
    {
        this.speed = speed ; 
    }
    
    
    //Animation for the Paddle 
    public void Animation_Paddle(boolean playAnimation)
    { 
        
       /// paddle_iv.setCursor(Cursor.HAND);
        
        KeyFrame key_f1=new  KeyFrame(Duration.millis(10),new EventHandler<ActionEvent>(){
               @Override
           public void handle(final ActionEvent t) {
               paddle_iv.setImage(paddle);
             
            }
        }) ; 
        
          KeyFrame key_f2=new  KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>(){
               @Override
           public void handle(final ActionEvent t) {
              
               paddle_iv.setImage(paddle2);
             
            }
        }) ; 
         
        
       KeyFrame key_f3=new  KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>(){
               @Override
           public void handle(final ActionEvent t) {
            
              paddle_iv.setImage(paddle3);
            }
        }) ; 
        
         t.getKeyFrames().addAll(key_f1,key_f2,key_f3);
         t.setCycleCount(Timeline.INDEFINITE);
         t.setAutoReverse(true);
         
         if(playAnimation)
             t.play();
         else 
             t.pause();
    } 


   //======================================================================== 
    

    public void dragPaddleUsingMouse(paddle paddle_obj)
    {
//        System.out.println("hhh");
         paddle_obj.paddle_iv.setCursor(Cursor.HAND); //Change The Cursor 
         timelineDragUsingMouse = new Timeline(new KeyFrame(Duration.millis(20),
            new EventHandler<ActionEvent>() 
              {
                
                //velocity of ball 
                  ball bl = new ball();
                 double dx = bl.speed; 
                 double dy = bl.speed;
                 
        //the event for the paddle
         @Override
         public void handle(ActionEvent t ) {

         EventHandler<MouseEvent> paddlepress = new EventHandler<MouseEvent>() {

         @Override
         public void handle(MouseEvent t) {

               mouse_pos_x = t.getSceneX();
              // System.out.println("mouse_pos_x"+mouse_pos_x);
               orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
             // System.out.println("orgTranslateX"+orgTranslateX);

           }
       };

     EventHandler<MouseEvent> paddledrag;      
     paddledrag = new EventHandler<MouseEvent>()
     {

         @Override
         public void handle(MouseEvent t) {
             double amount_of_move = t.getSceneX() - mouse_pos_x;
             newTranslateX = orgTranslateX + amount_of_move; 
           // System.out.println("newTranslateX  "+newTranslateX);

             if(newTranslateX <= 580 && newTranslateX >= -580)
             ((ImageView)(t.getSource())).setTranslateX(newTranslateX); 

         }
     };

     paddle_iv.setCursor(Cursor.HAND); //Change The Cursor 
     paddle_iv.setOnMousePressed(paddlepress);
     paddle_iv.setOnMouseDragged(paddledrag);

    }}));
        
       
          
          timelineDragUsingMouse.setCycleCount(Timeline.INDEFINITE);       
          timelineDragUsingMouse.play();
          
         
       }
}
