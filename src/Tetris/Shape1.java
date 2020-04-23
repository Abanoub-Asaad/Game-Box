package Tetris;

import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Shape1 extends Shape {

    protected void Basic(Rectangle[] rectangles, float x, float y, Group group) {
        NumOfTurn = 1;

        rectangles[0] = new Rectangle(x, y, width, height);
        for (int i = 1; i < 4; i++) {
            rectangles[i] = new Rectangle(x += width + 1, y, width, height);
        }
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.BLUE);
            group.getChildren().add(rectangles[i]);
        }
        // shapeObj.tranformation(rectangles, 690,690,690,690); 
        // DoFirstTurn(rectangles, x, y, group);
    }

    protected void turn90(Rectangle[] rectangles, float x, float y, Group group) {
        NumOfTurn = 2;

        x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);
        
        for (int i = 1; i < 4; i++) {
            rectangles[i].setX(x);
            rectangles[i].setY(y += height + 1);
        }
        //DoSecondTurn(rectangles, x, y, group);
        //  shapeObj.tranformation(rectangles, 550,500,450,400); 

    }

    protected void turn180(Rectangle[] rectangles, float x, float y, Group group) {
        NumOfTurn = 3;

        x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        for (int i = 1; i < 4; i++) {
            rectangles[i].setX(x += width + 1);
            rectangles[i].setY(y);
        }

    }

    protected void turn270(Rectangle[] rectangles, float x, float y, Group group) {
        NumOfTurn = 4;

        x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        rectangles[0].setY(y);
        for (int i = 1; i < 4; i++) {
            rectangles[i].setX(x);
            rectangles[i].setY(y += height + 1);
        }

    }

    protected void turn360(Rectangle[] rectangles, float x, float y, Group group) {
        NumOfTurn = 5;

        x = (float) rectangles[0].getX();
        y = (float) rectangles[0].getY();
        System.out.println(" x : " + x);
        System.out.println(" y : " + y);

        rectangles[0].setX(x);
        for (int i = 1; i < 4; i++) {
            rectangles[i].setX(x += width + 1);
            rectangles[i].setY(y);
        }
    }

}
