package Tetris;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static Tetris.Controller.SIZE;
import static Tetris.Controller.XMAX;

public class Shape1 extends Shape {

    @Override
    protected  void Basic(Rectangle[] rectangles, Pane group) {
     
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setHeight(49);
            rectangles[i].setWidth(49);
        }
        
        setShape(rectangles[0], rectangles[1], rectangles[2], rectangles[3]);
        rectangles[0].setX(rectangles[0].getX()+700);
        rectangles[1].setX(rectangles[1].getX()+700);
        rectangles[2].setX(rectangles[2].getX()+700);
        rectangles[3].setX(rectangles[3].getX()+700);
        
        rectangles[0].setY(rectangles[0].getY()+180);
        rectangles[1].setY(rectangles[1].getY()+180);
        rectangles[2].setY(rectangles[2].getY()+180);
        rectangles[3].setY(rectangles[3].getY()+180);
        
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.BLUE);
            group.getChildren().add(rectangles[i]);
        }
    }
    
    @Override
    protected void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        a.setX(XMAX / 2 - SIZE - SIZE);
        b.setX(XMAX / 2 - SIZE);
        c.setX(XMAX / 2);
        d.setX(XMAX / 2 + SIZE);

    }

    @Override
    protected Rectangle[] getShape() {

        return Next;

    }

    @Override
    protected void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        if (num_turn == 1 && checkRectangle(a, 2, 2) && checkRectangle(b, 1, 1) && checkRectangle(d, -1, -1)) {
            MoveUp(form.a);
            MoveUp(form.a);
            MoveRight(form.a);
            MoveRight(form.a);
            MoveUp(form.b);
            MoveRight(form.b);
            MoveDown(form.d);
            MoveLeft(form.d);
            form.changeForm();

        }
        if (num_turn == 2 && checkRectangle(a, -2, -2) && checkRectangle(b, -1, -1) && checkRectangle(d, 1, 1)) {
            MoveDown(form.a);
            MoveDown(form.a);
            MoveLeft(form.a);
            MoveLeft(form.a);
            MoveDown(form.b);
            MoveLeft(form.b);
            MoveUp(form.d);
            MoveRight(form.d);
            form.changeForm();

        }
        if (num_turn == 3 && checkRectangle(a, 2, 2) && checkRectangle(b, 1, 1) && checkRectangle(d, -1, -1)) {
            MoveUp(form.a);
            MoveUp(form.a);
            MoveRight(form.a);
            MoveRight(form.a);
            MoveUp(form.b);
            MoveRight(form.b);
            MoveDown(form.d);
            MoveLeft(form.d);
            form.changeForm();

        }
        if (num_turn == 4 && checkRectangle(a, -2, -2) && checkRectangle(b, -1, -1) && checkRectangle(d, 1, 1)) {
            MoveDown(form.a);
            MoveDown(form.a);
            MoveLeft(form.a);
            MoveLeft(form.a);
            MoveDown(form.b);
            MoveLeft(form.b);
            MoveUp(form.d);
            MoveRight(form.d);
            form.changeForm();

        }
    }

}
