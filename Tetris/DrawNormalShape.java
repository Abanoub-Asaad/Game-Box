package Tetris;

import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class DrawNormalShape {

    float width, height;
    Shapes shapeObj ;
    public DrawNormalShape() {
        width = 50f;
         height = 50f;
       shapeObj= new Shapes();
    }

    public void Basic(Rectangle[] rectangles, float x, float y, Group group ) {
        rectangles[0] = new Rectangle(x, y, width, height);
        for (int i = 1; i < 4; i++) {
            rectangles[i] = new Rectangle(x += width+1, y, width, height);
        }
        for (int i = 0; i < 4; i++) {
      rectangles[i].setFill(Color.RED);
            group.getChildren().add(rectangles[i]);
        }
         shapeObj.tranformation(rectangles, 500,500,500,500); 
         
      
     
      
    }
   
 public void turn90(Rectangle[] rectangles, float x, float y, Group group) {
        x += (width / 2)+1;
        y -= height * 2+1;
        rectangles[0] = new Rectangle(x, y, width, height);

        for (int i = 1; i < 4; i++) {
            rectangles[i] = new Rectangle(x, y += height+1, width, height);
        }

        for (int i = 0; i < 4; i++) 
        {  rectangles[i].setFill(Color.RED);
            group.getChildren().add(rectangles[i]);
        }
          shapeObj.tranformation(rectangles, 550,500,450,400); 
          
       
    }


  
    public void turn180(Rectangle[] rectangles, float x, float y, Group group ) {
        Basic(rectangles, x, y, group );
    }

   
      
    public void turn270(Rectangle[] rectangles, float x, float y, Group group ) {
            turn90(rectangles, x, y, group );
    }

    public void turn360(Rectangle[] rectangles, float x, float y, Group group ) {
        Basic(rectangles, x, y, group );
    }
  
}
