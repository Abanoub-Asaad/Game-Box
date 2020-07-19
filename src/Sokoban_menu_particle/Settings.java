package Sokoban_menu_particle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Application settings
 */
public class Settings {

	// scene settings
	// -------------------------------
	private DoubleProperty sceneWidth = new SimpleDoubleProperty(1370);
	private DoubleProperty sceneHeight = new SimpleDoubleProperty(720);
	//private ObjectProperty<Color> sceneColor = new SimpleObjectProperty<>( Color.BEIGE);

	private DoubleProperty toolbarWidth = new SimpleDoubleProperty(250);
	private DoubleProperty canvasWidth = new SimpleDoubleProperty(1370);
	private DoubleProperty canvasHeight = new SimpleDoubleProperty(sceneHeight.doubleValue());

	private ObjectProperty<Vector2D> forceGravity = new SimpleObjectProperty<>( new Vector2D(0,0)); 	 
	private DoubleProperty gravityX = new SimpleDoubleProperty( forceGravity.getValue().x);
	private DoubleProperty gravityY = new SimpleDoubleProperty( forceGravity.getValue().y);
	
	// emitter
	// -------------------------------
	private IntegerProperty emitterFrequency = new SimpleIntegerProperty(100); // particles per frame
        double  emiwidth = 1370;
	private DoubleProperty emitterWidth = new SimpleDoubleProperty(emiwidth);
	private DoubleProperty emitterLocationY = new SimpleDoubleProperty(sceneHeight.doubleValue());
      

	// particles
	// -------------------------------
	private DoubleProperty particleWidth = new SimpleDoubleProperty( 3);
	private DoubleProperty particleHeight = new SimpleDoubleProperty( particleWidth.doubleValue());
	private DoubleProperty particleLifeSpanMax = new SimpleDoubleProperty( 230);
	private DoubleProperty particleMaxSpeed = new SimpleDoubleProperty( 15);

	// instance handling
	// ----------------------------------------
	private static Settings settings = new Settings();
	
	private Settings() {
	}
	
	/**
	 * Return the one instance of this class
	 */
	public static Settings get() {
		return settings;
	}
	

	private Node createSeparator( String text) {

		VBox box = new VBox();
		
		Label label = new Label( text);
		label.setFont(Font.font(null, FontWeight.BOLD, 14));	

		Separator separator = new Separator();

		box.getChildren().addAll(separator, label);
		
		box.setFillWidth(true);
		
		GridPane.setColumnSpan(box, 2);

		GridPane.setFillWidth(box, true);
		GridPane.setHgrow(box, Priority.ALWAYS);
	    
		return box;
	}
	
	private Slider createNumberSlider( Property<Number> observable, double min, double max) {
		
		Slider slider = new Slider( min, max, observable.getValue().doubleValue());
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.valueProperty().bindBidirectional(observable);
		
		return slider;
		
	}
	
	// -------------------------------
	// auto-generated begin
	// -------------------------------
	public final DoubleProperty sceneWidthProperty() {
		return this.sceneWidth;
	}
	public final double getSceneWidth() {
		return this.sceneWidthProperty().get();
	}
	public final void setSceneWidth(final double sceneWidth) {
		this.sceneWidthProperty().set(sceneWidth);
	}
	public final DoubleProperty sceneHeightProperty() {
		return this.sceneHeight;
	}
	public final double getSceneHeight() {
		return this.sceneHeightProperty().get();
	}
	public final void setSceneHeight(final double sceneHeight) {
		this.sceneHeightProperty().set(sceneHeight);
	}
//////	public final ObjectProperty<Color> sceneColorProperty() {
//////		return this.sceneColor;
//////	}
//////	public final javafx.scene.paint.Color getSceneColor() {
//////		return this.sceneColorProperty().get();
//////	}
//////	public final void setSceneColor(final javafx.scene.paint.Color sceneColor) {
//////		this.sceneColorProperty().set(sceneColor);
//////	}

	public final ObjectProperty<Vector2D> forceGravityProperty() {
		return this.forceGravity;
	}
	public final Sokoban_menu_particle.Vector2D getForceGravity() {
		return this.forceGravityProperty().get();
	}
	public final void setForceGravity(final Sokoban_menu_particle.Vector2D forceGravity) {
		this.forceGravityProperty().set(forceGravity);
	}
	public final IntegerProperty emitterFrequencyProperty() {
		return this.emitterFrequency;
	}
	public final int getEmitterFrequency() {
		return this.emitterFrequencyProperty().get();
	}
	public final void setEmitterFrequency(final int emitterFrequency) {
		this.emitterFrequencyProperty().set(emitterFrequency);
	}
	public final DoubleProperty emitterWidthProperty() {
		return this.emitterWidth;
	}
	public final double getEmitterWidth() {
		return this.emitterWidthProperty().get();
	}
	public final void setEmitterWidth(final double emitterWidth) {
		this.emitterWidthProperty().set(emitterWidth);
	}
	public final DoubleProperty emitterLocationYProperty() {
		return this.emitterLocationY;
	}
	public final double getEmitterLocationY() {
		return this.emitterLocationYProperty().get();
	}
	public final void setEmitterLocationY(final double emitterLocationY) {
		this.emitterLocationYProperty().set(emitterLocationY);
	}
	public final DoubleProperty particleWidthProperty() {
		return this.particleWidth;
	}
	public final double getParticleWidth() {
		return this.particleWidthProperty().get();
	}
	public final void setParticleWidth(final double particleWidth) {
		this.particleWidthProperty().set(particleWidth);
	}
	public final DoubleProperty particleHeightProperty() {
		return this.particleHeight;
	}
	public final double getParticleHeight() {
		return this.particleHeightProperty().get();
	}
	public final void setParticleHeight(final double particleHeight) {
		this.particleHeightProperty().set(particleHeight);
	}
	public final DoubleProperty particleLifeSpanMaxProperty() {
		return this.particleLifeSpanMax;
	}
	public final double getParticleLifeSpanMax() {
		return this.particleLifeSpanMaxProperty().get();
	}
	public final void setParticleLifeSpanMax(final double particleLifeSpanMax) {
		this.particleLifeSpanMaxProperty().set(particleLifeSpanMax);
	}
	public final DoubleProperty particleMaxSpeedProperty() {
		return this.particleMaxSpeed;
	}
	public final double getParticleMaxSpeed() {
		return this.particleMaxSpeedProperty().get();
	}
	public final void setParticleMaxSpeed(final double particleMaxSpeed) {
		this.particleMaxSpeedProperty().set(particleMaxSpeed);
	}

	public final DoubleProperty toolbarWidthProperty() {
		return this.toolbarWidth;
	}

	public final double getToolbarWidth() {
		return this.toolbarWidthProperty().get();
	}

	public final void setToolbarWidth(final double toolbarWidth) {
		this.toolbarWidthProperty().set(toolbarWidth);
	}

	public final DoubleProperty canvasWidthProperty() {
		return this.canvasWidth;
	}

	public final double getCanvasWidth() {
		return this.canvasWidthProperty().get();
	}

	public final void setCanvasWidth(final double canvasWidth) {
		this.canvasWidthProperty().set(canvasWidth);
	}

	public final DoubleProperty canvasHeightProperty() {
		return this.canvasHeight;
	}

	public final double getCanvasHeight() {
		return this.canvasHeightProperty().get();
	}

	public final void setCanvasHeight(final double canvasHeight) {
		this.canvasHeightProperty().set(canvasHeight);
	}


	
	
}
