package Sokoban_menu_particle;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Utils {

    /**
     * Clamp value between min and max
     *
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static double clamp(double value, double min, double max) {

        if (value < min) {
            return min;
        }

        if (value > max) {
            return max;
        }

        return value;
    }

    /**
     * Map value of a given range to a target range
     *
     * @param value
     * @param currentRangeStart
     * @param currentRangeStop
     * @param targetRangeStart
     * @param targetRangeStop
     * @return
     */
    public static double map(double value, double currentRangeStart, double currentRangeStop, double targetRangeStart, double targetRangeStop) {
        return targetRangeStart + (targetRangeStop - targetRangeStart) * ((value - currentRangeStart) / (currentRangeStop - currentRangeStart));
    }

    /**
     * Snapshot an image out of a node, consider transparency.
     *
     * @param node
     * @return
     */
    public static Image createImage(Node node) {

        WritableImage wi;

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);

        int imageWidth = (int) node.getBoundsInLocal().getWidth();
        int imageHeight = (int) node.getBoundsInLocal().getHeight();

        wi = new WritableImage(imageWidth, imageHeight);
        node.snapshot(parameters, wi);

        return wi;

    }

    /**
     * Pre-create images with various gradient colors and sizes.
     *
     * @return
     */
    public static Image[] preCreateImages() {

        // get number of images
        int count = (int) Settings.get().getParticleLifeSpanMax();

        // create linear gradient lookup image: lifespan 0 -> lifespan max
        double width = count;
        Stop[] stops = new Stop[]{new Stop(0.2, Color.web("#d84315")), new Stop(0.3, Color.web("#d84315")), new Stop(0.9, Color.YELLOW), new Stop(1, Color.web("#ffee58"))};
        LinearGradient linearGradient = new LinearGradient(0, 0, width, 0, false, CycleMethod.NO_CYCLE, stops);

        Rectangle rectangle = new Rectangle(width, 1);
        rectangle.setFill(linearGradient);

        Image lookupImage = createImage(rectangle);

        // pre-create images
        Image[] list = new Image[count];

        double radius = Settings.get().getParticleWidth();

        for (int i = 0; i < count; i++) {

            // get color depending on lifespan
            Color color = lookupImage.getPixelReader().getColor(i, 0);

            // create gradient image with given color
            Circle ball = new Circle(radius);

            RadialGradient gradient1 = new RadialGradient(0, 0, 0, 0, radius, false, CycleMethod.NO_CYCLE, new Stop(0, color.deriveColor(1, 1, 1, 1)), new Stop(1, color.deriveColor(1, 1, 1, 0)));

            ball.setFill(gradient1);

            // create image
            list[i] = Utils.createImage(ball);
        }

        return list;
    }
}
