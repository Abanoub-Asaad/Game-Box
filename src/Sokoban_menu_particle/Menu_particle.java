package Sokoban_menu_particle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Sokoban.Menu;

public class Menu_particle  {

	private static Random random = new Random();

	Canvas canvas;
	GraphicsContext graphicsContext;

	/**
	 * Container for canvas and other nodes like attractors and repellers
	 */
	  Image m = new Image("Resources/Sokoban/black.jpg");
                ImageView mv =new ImageView(m);

	List<Particle> allParticles = new ArrayList<>();

	AnimationTimer animationLoop;

	/**
	 * Container for pre-created images which have color and size depending on
	 * the particle's lifespan
	 */
	Image[] images;

	public void start() {

		

		canvas = new Canvas(1370, 750);
		graphicsContext = canvas.getGraphicsContext2D();

		
              
         //    Menu.layerPane.getChildren().add(mv);
		Menu.layerPane.getChildren().addAll(canvas);

		canvas.widthProperty().bind(Menu.layerPane.widthProperty());
		Menu.root.setCenter(Menu.layerPane);

	
		// initialize content
		preCreateImages();
		
		// add content
		prepareObjects();

	
		
		// run animation loop
		startAnimation();
      

	}

	private void preCreateImages() {
		this.images = Utils.preCreateImages();
	}

	private void prepareObjects() {

	}

	private void startAnimation() {

		animationLoop = new AnimationTimer() {
			
			FpsCounter fpsCounter = new FpsCounter();
			
			@Override
			public void handle(long now) {

				// update fps
				fpsCounter.update( now);
				
				// add new particles
				for (int i = 0; i < Settings.get().getEmitterFrequency(); i++) {
					
                                       addParticle(750);
                                       addParticle(15);
				}

				// apply force: gravity
				Vector2D forceGravity = Settings.get().getForceGravity();
				allParticles.forEach(sprite -> {
					sprite.applyForce(forceGravity);
				});

				allParticles.stream().parallel().forEach(Sprite::move);


//				 draw all particles on canvas
//				 -----------------------------------------
			        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				graphicsContext.setFill(Color.BEIGE);
                                       // .setFill(Color.BEIGE);
				graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

				// TODO: parallel?
				double particleSizeHalf = Settings.get().getParticleWidth() / 2;
				allParticles.stream().forEach(particle -> {

					Image img = images[particle.getLifeSpan()];
					graphicsContext.drawImage(img, particle.getLocation().x - particleSizeHalf, particle.getLocation().y - particleSizeHalf);

				});

				// life span of particle
				allParticles.stream().parallel().forEach(Sprite::decreaseLifeSpan);

				// remove all particles that aren't visible anymore
				removeDeadParticles();

			}
		};

		animationLoop.start();

	}

	private void removeDeadParticles() {

		Iterator<Particle> iter = allParticles.iterator();
		while (iter.hasNext()) {

			Particle particle = iter.next();
			if (particle.isDead()) {

				// remove from particle list
				iter.remove();
			}

		}

	}

	private void addParticle(double y) {

		// random location
		double x = Settings.get().getCanvasWidth() / 2 + random.nextDouble() * Settings.get().getEmitterWidth() - Settings.get().getEmitterWidth() / 2;
		//double y = Settings.get().getEmitterLocationY();

		// dimensions
		double width = Settings.get().getParticleWidth();
		double height = Settings.get().getParticleHeight();

		// create motion data
		Vector2D location = new Vector2D(x, y);

		double vx = random.nextGaussian()+1.0 ;
		double vy = random.nextGaussian() * 0.8 + 1.0 ;
		Vector2D velocity = new Vector2D(vx, vy);

		Vector2D acceleration = new Vector2D(0, 0);

		// create sprite and add to layer
		Particle sprite = new Particle(location, velocity, acceleration, width, height);

		// register sprite
		allParticles.add(sprite);

	}




	/**
	 * Helper class for frame rate calculation
	 */
	private static class FpsCounter {

		final long[] frameTimes = new long[100];
		int frameTimeIndex = 0;
		boolean arrayFilled = false;
		double frameRate;

		double decimalsFactor = 1000; // we want 3 decimals
		
		public void update(long now) {

			long oldFrameTime = frameTimes[frameTimeIndex];
			frameTimes[frameTimeIndex] = now;
			frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length;

			if (frameTimeIndex == 0) {
				arrayFilled = true;
			}

			if (arrayFilled) {

				long elapsedNanos = now - oldFrameTime;
				long elapsedNanosPerFrame = elapsedNanos / frameTimes.length;
				frameRate = 1_000_000_000.0 / elapsedNanosPerFrame;

			}
		}

		public double getFrameRate() {
			// return frameRate;
			return ((int) (frameRate * decimalsFactor)) / decimalsFactor; // reduce to n decimals
		}
	}
}
