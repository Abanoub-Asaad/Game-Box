/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Shape6 extends Shapes {
  
    
   
    public void Basic(Rectangle[] rect, double x, float y, Group root) {
         NumOfTurn =1;
        rect[0] = new Rectangle(x, y, width-1, height);
        rect[1] = new Rectangle(x + width, y, width-1, height);
        rect[2] = new Rectangle(x - width, y, width-1, height);
        rect[3] = new Rectangle(x, y + height, width-1, height-1);
        for (int i = 0; i < 4; i++) {
            rect[i].setFill(Color.LIME);
            root.getChildren().addAll(rect[i]);
        }
      //  shapeObj.tranformation(rect, 550,550,550,500); 
    }

    public void turn90(Rectangle[] rect, float x, float y, Group root) {
         NumOfTurn =2;
         x =(float) rect[0].getX();
        y= (float)rect[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);
        
        rect[0].setX(x); 
        rect[0].setY(y); 

        rect[1].setX(x + width);
        rect[1].setY(y);
        
        rect[2].setX(x);
        rect[2].setY(y + height);

        rect[3].setX(x);
        rect[3].setY(y - height);
        
         //  shapeObj.tranformation(rect, 550,550,500,600); 
    }

    public void turn180(Rectangle[] rect, float x, float y, Group root) {
         NumOfTurn =3;
         x = (float) rect[0].getX();
        y = (float) rect[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rect[0].setX(x);
        rect[0].setY(y);
        
        rect[1].setX(x + width);
        rect[1].setY(y);
        
        rect[2].setX(x - width);
        rect[2].setY(y);
        
        rect[3].setX(x );
        rect[3].setY(y+ height);
       //    shapeObj.tranformation(rect, 500,500,550,500); 
    }

    public void turn270(Rectangle[] rect, float x, float y, Group root) {
         NumOfTurn =4;
         x =(float) rect[0].getX();
        y= (float)rect[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);
        
        rect[0].setX(x); 
        rect[0].setY(y); 

        rect[1].setX(x + width);
        rect[1].setY(y);
        
        rect[2].setX(x);
        rect[2].setY(y + height);

        rect[3].setX(x);
        rect[3].setY(y - height);
        
    }

    public void turn360(Rectangle[] rect, float x, float y, Group root) {
         NumOfTurn =5;
         x =(float) rect[0].getX();
        y= (float)rect[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);
        
        rect[0].setX(x); 
        rect[0].setY(y); 
        
        rect[1].setX(x + width); 
        rect[1].setY(y); 
        
        rect[2].setX(x - width); 
        rect[2].setY(y); 
        
        rect[3].setX(x); 
        rect[3].setY(y + height);
    }
}
