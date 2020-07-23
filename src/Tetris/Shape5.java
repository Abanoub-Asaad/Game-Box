package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static Tetris.Controller.SIZE;
import static Tetris.Controller.XMAX;

public class Shape5 extends Shape {

    @Override
    protected  void Basic(Rectangle[] rectangles, Pane group) {
     
        for (int i = 0; i < 4; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setHeight(49);
            rectangles[i].setWidth(49);
        }
        
        setShape(rectangles[0], rectangles[1], rectangles[2], rectangles[3]);
        rectangles[0].setX(rectangles[0].getX()+660);
        rectangles[1].setX(rectangles[1].getX()+660);
        rectangles[2].setX(rectangles[2].getX()+660);
        rectangles[3].setX(rectangles[3].getX()+660);
        
        rectangles[0].setY(rectangles[0].getY()+160);
        rectangles[1].setY(rectangles[1].getY()+160);
        rectangles[2].setY(rectangles[2].getY()+160);
        rectangles[3].setY(rectangles[3].getY()+160);
        
        for (int i = 0; i < 4; i++) {
            rectangles[i].setFill(Color.DARKORANGE);
             Shape. lighting.setSurfaceScale(0.8);
            rectangles[i].setEffect(lighting);
            group.getChildren().add(rectangles[i]);
        }
    }
    
    @Override
    protected void setShape(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {

        a.setX(XMAX / 2 + SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 - SIZE);
        d.setY(SIZE);

    }

    @Override
    protected Rectangle[] getShape() {

        return Next;

    }

    @Override
    protected void MoveTurn(Form form, int num_turn, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {

        if (num_turn == 1 && checkRectangle(a, -1, -1) && checkRectangle(c, -1, 1) && checkRectangle(d, 0, 2)) {
            MoveDown(form.a);
            MoveLeft(form.a);
            MoveLeft(form.c);
            MoveUp(form.c);
            MoveUp(form.d);
            MoveUp(form.d);
            form.changeForm();

        }
        if (num_turn == 2 && checkRectangle(a, 1, 1) && checkRectangle(c, 1, -1) && checkRectangle(d, 0, -2)) {
            MoveUp(form.a);
            MoveRight(form.a);
            MoveRight(form.c);
            MoveDown(form.c);
            MoveDown(form.d);
            MoveDown(form.d);
            form.changeForm();

        }
        if (num_turn == 3 && checkRectangle(a, -1, -1) && checkRectangle(c, -1, 1) && checkRectangle(d, 0, 2)) {
            MoveDown(form.a);
            MoveLeft(form.a);
            MoveLeft(form.c);
            MoveUp(form.c);
            MoveUp(form.d);
            MoveUp(form.d);
            form.changeForm();

        }
        if (num_turn == 4 && checkRectangle(a, 1, 1) && checkRectangle(c, 1, -1) && checkRectangle(d, 0, -2)) {
            MoveUp(form.a);
            MoveRight(form.a);
            MoveRight(form.c);
            MoveDown(form.c);
            MoveDown(form.d);
            MoveDown(form.d);
            form.changeForm();

        }

    }

}
