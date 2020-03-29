
package Tetris;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Draw__1Shape extends Shapes{

    
    public void Basic(Rectangle[] rectangles, float x, float y, Group group) {
        rectangles[0] = new Rectangle(x, y, width, height);
        for (int i = 1; i < 3; i++) {
            rectangles[i] = new Rectangle(x += width+1 , y, width, height);
        }
        rectangles[3] = new Rectangle(x, y -= height+1 , width, height);
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.PURPLE);
            group.getChildren().add(rectangles[i]);
        }
      //  shapeObj.tranformation(rectangles, 500, 500, 500, 550);
    }

    public void turn90(Rectangle[] rectangles, float x, float y, Group group) {
        rectangles[0] = new Rectangle(x, y, width, height);
        for (int i = 1; i < 3; i++) {
            rectangles[i] = new Rectangle(x, y += height + 1, width, height);
        }
        rectangles[3] = new Rectangle(x += width + 1, y, width, height);

        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.YELLOW);
            group.getChildren().add(rectangles[i]);
        }
       // shapeObj.tranformation(rectangles, 600, 550, 500, 500);
    }

    public void turn180(Rectangle[] rectangles, float x, float y, Group group) {
        rectangles[0] = new Rectangle(x, y, width, height);
        y -= height + 1;
        rectangles[1] = new Rectangle(x, y, width, height);
        for (int i = 2; i < 4; i++) {
            rectangles[i] = new Rectangle(x += width + 1, y, width, height);
        }

        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.YELLOW);
            group.getChildren().add(rectangles[i]);
        }
       // shapeObj.tranformation(rectangles, 500, 550, 550, 550);
    }

    public void turn270(Rectangle[] rectangles, float x, float y, Group group) {
        rectangles[0] = new Rectangle(x, y, width, height);
        x += width + 1;
        rectangles[1] = new Rectangle(x, y, width, height);
        for (int i = 2; i < 4; i++) {
            rectangles[i] = new Rectangle(x, y += height + 1, width, height);
        }

        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.YELLOW);
            group.getChildren().add(rectangles[i]);
        }
        //shapeObj.tranformation(rectangles, 550, 550, 500, 450);
    }

    public void turn360(Rectangle[] rectangles, float x, float y, Group group) {
        Basic(rectangles, x, y, group);

    }
}
