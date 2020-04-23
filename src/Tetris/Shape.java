package Tetris;

import javafx.scene.shape.Rectangle;
import javafx.scene.Group;

public abstract class Shape {

    ShapeFactory shapeFactory_obj = new ShapeFactory();
    protected final float width = 50f, height = 50f;
    protected static int NumOfTurn;

    abstract void Basic(Rectangle[] rectangles, float x, float y, Group group);
    abstract void turn90(Rectangle[] rectangles, float x, float y, Group group);
    abstract void turn180(Rectangle[] rectangles, float x, float y, Group group);
    abstract void turn270(Rectangle[] rectangles, float x, float y, Group group);
    abstract void turn360(Rectangle[] rectangles, float x, float y, Group group);
    
    protected void SetShapes(Rectangle[] rectangles, float X, float Y, Group group, int number) {

        Shape shape1_obj = shapeFactory_obj.getShape("Line_shape");
        Shape shape2_obj = shapeFactory_obj.getShape("Square_shape");
        Shape shape3_obj = shapeFactory_obj.getShape("L_shape");
        Shape shape4_obj = shapeFactory_obj.getShape("MirroredL_shape");
        Shape shape5_obj = shapeFactory_obj.getShape("S_shape");
        Shape shape6_obj = shapeFactory_obj.getShape("T_shape");
        Shape shape7_obj = shapeFactory_obj.getShape("Z_shape");

        switch (number) {

            case 1:
                shape1_obj.Basic(rectangles, X, Y, group);
                break;

            case 2:
                shape2_obj.Basic(rectangles, X, Y, group);
                break;

            case 3:
                shape3_obj.Basic(rectangles, X, Y, group);
                break;

            case 4:
                shape4_obj.Basic(rectangles, X, Y, group);
                break;

            case 5:
                shape5_obj.Basic(rectangles, X, Y, group);
                break;

            case 6:
                shape6_obj.Basic(rectangles, X, Y, group);
                break;

            case 7:
                shape7_obj.Basic(rectangles, X, Y, group);
                break;
        }
    }

}
