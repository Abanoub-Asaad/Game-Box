package Tetris;

public class ShapeFactory {

    ShapeFactory() {
    }

    public Shape getShape(String shapeType) {

        if (shapeType.equalsIgnoreCase("Line_shape")) {
            return new Shape1();
        } else if (shapeType.equalsIgnoreCase("Square_shape")) {
            return new Shape2();
        } else if (shapeType.equalsIgnoreCase("L_shape")) {
            return new Shape4();
        } else if (shapeType.equalsIgnoreCase("MirroredL_shape")) {
            return new Shape3();
        } else if (shapeType.equalsIgnoreCase("S_shape")) {
            return new Shape5();
        } else if (shapeType.equalsIgnoreCase("T_shape")) {
            return new Shape6();
        } else if (shapeType.equalsIgnoreCase("Z_shape")) {
            return new Shape7();
        }

        return null;
    }

}
