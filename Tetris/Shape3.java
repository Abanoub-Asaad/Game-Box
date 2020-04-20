package Tetris;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Shape3 extends Shapes
{
   

    public void Basic(Rectangle[] rectangles, float x, float y, Group group) {
         NumOfTurn =1;
        rectangles[0] = new Rectangle(x, y, width, height);
        y += height+1;
        rectangles[1] = new Rectangle(x, y, width, height);
        for (int i = 2; i < 4; i++) {
            rectangles[i] = new Rectangle(x += width+1, y, width, height);
        }

        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.MEDIUMORCHID);
            group.getChildren().add(rectangles[i]);
        }
         //  shapeObj.tranformation(rectangles, 550, 500, 500, 500); 

    }

   
   
    public void turn90(Rectangle[] rectangles, float x, float y, Group group) {
         NumOfTurn =2;
         x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);

        for (int i = 1; i < 3; i++) {
            rectangles[i].setX(x);
            rectangles[i].setY(y += height + 1);
        }
        rectangles[3].setX(x -= width + 1);
        rectangles[3].setY(y);
       //shapeObj. tranformation(rectangles, 600, 550, 500, 500); 

    }
   

    public void turn180(Rectangle[] rectangles, float x, float y, Group group) {
         NumOfTurn =3;
       x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);

        for (int i = 1; i < 3; i++) {
            rectangles[i].setX(x += width + 1);
            rectangles[i].setY(y);
        }
        y += height + 1;
        rectangles[3].setX(x);
        rectangles[3].setY(y);
       //  shapeObj.tranformation(rectangles, 550, 550, 550, 500); 

    }
  
 
     public void turn270(Rectangle[] rectangles, float x, float y, Group group) {
          NumOfTurn =4;
         x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);

        x += width + 1;
        rectangles[1].setX(x);
        rectangles[1].setY(y);

        x -= width + 1;
        for (int i = 2; i < 4; i++) {
            rectangles[i].setX(x);
            rectangles[i].setY(y += height + 1);
        }
       // shapeObj. tranformation(rectangles, 550, 550, 500, 450); 

    }
   
     public void turn360(Rectangle[] rectangles, float x, float y, Group group) {
          NumOfTurn =5;
          x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);

        y += height + 1;
        rectangles[1].setX(x);
        rectangles[1].setY(y);

        for (int i = 2; i < 4; i++) {
            rectangles[i].setX(x += width + 1);
            rectangles[i].setY(y);
        }

    }
         
}
