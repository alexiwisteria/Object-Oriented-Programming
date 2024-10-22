package Draw;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.util.Random;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 6311020027600344213L;

// Colors for the different elements
	private final String bodyColor = "#92613b"; // Jackelope body color
	private final String antlerColor = "#92613b"; // Jackelope antler color
	private final String sunColor = "#ffce00"; // Sun color


	// Constructs a new DrawPanel with a size of 800x600 pixels.
	public DrawPanel() {
		this.setPreferredSize(new Dimension(800, 600));
	}


	// Paints the component by drawing a gradient background, ground, and various landscape objects.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		drawGradientBackground(g2);
		drawGround(g2);
		drawLandscapeObjects(g2);
	}

	// Draws a gradient background from top to bottom.
	private void drawGradientBackground(Graphics2D g2) {
		Color color10 = Color.decode("#8704d7");
		Color color9 = Color.decode("#970bca");
		Color color8 = Color.decode("#b820a9");
		Color color7 = Color.decode("#bf22a6");
		Color color6 = Color.decode("#c73290");
		Color color5 = Color.decode("#da4968");
		Color color4 = Color.decode("#e8615f");
		Color color3 = Color.decode("#f0814d");
		Color color2 = Color.decode("#fcc16b");
		Color color1 = Color.decode("#fdcf8f");

		Color[] colors = { color10, color9, color8, color7, color6, color5, color4, color3, color2, color1 };
		float[] fractions = { 0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 1.0f };

		LinearGradientPaint gp = new LinearGradientPaint(0, 0, 0, getHeight(), fractions, colors);
		g2.setPaint(gp);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}

	// Draws the ground as a brown rectangle at the bottom of the panel.
	private void drawGround(Graphics2D g2) {
		g2.setColor(Color.decode("#8B4513")); // Brown color for the ground
		g2.fillRect(0, getHeight() - 100, getWidth(), 100); // Ground covering the bottom 100 pixels
	}

	// Draws various landscape objects such as the sun, clouds, rocks, sand dunes, desert burrow, flowers, jackelope, lizard, and cacti.
	private void drawLandscapeObjects(Graphics2D g2) {

		// Draw Sun
		Sun sun = new Sun(g2, 650, 50, 2.0, Color.decode(sunColor), 12);
		sun.draw();

		// Draw Clouds
		Cloud cloud = new Cloud(g2, 250, 100, 2, Color.WHITE);
		cloud.draw();

		Cloud cloud2 = new Cloud(g2, 450, 150, 1, Color.WHITE);
		cloud2.draw();

		Cloud cloud3 = new Cloud(g2, 75, 150, 1.5, Color.WHITE);
		cloud3.draw();

		Cloud cloud4 = new Cloud(g2, 600, 250, 1.5, Color.WHITE);
		cloud4.draw();

		Cloud cloud5 = new Cloud(g2, 175, 250, 1.9, Color.WHITE);
		cloud5.draw();

		Cloud cloud6 = new Cloud(g2, 525, 50, .75, Color.WHITE);
		cloud6.draw();

		Cloud cloud7 = new Cloud(g2, 50, 90, .75, Color.WHITE);
		cloud7.draw();

		// Draw Sand Dunes
		SandDune sandDune2 = new SandDune(g2, 300, 500, 1.8, Color.decode("#c8913d"), 50);
		sandDune2.draw();

		Rectangle2D rectangle = new Rectangle2D.Double(300, 500, 270, 200);
		g2.fill(rectangle);

		SandDune sandDune1 = new SandDune(g2, 0, 500, 2, Color.decode("#ffc051"), 50);
		sandDune1.draw();

		SandDune sandDune3 = new SandDune(g2, 570, 500, 2.4, Color.decode("#e4a546"), 50);
		sandDune3.draw();

		// Draw Cacti
		Cactus cactus1 = new Cactus(g2, 375, 450, 1.25, Color.decode("#b7ff71"));
		cactus1.draw();

		Cactus cactus2 = new Cactus(g2, 750, 390, .8, Color.decode("#00ff64"));
		cactus2.draw();

		Cactus cactus3 = new Cactus(g2, 75, 425, .9, Color.decode("#00e07b"));
		cactus3.draw();

		// Draw Flowers
		drawRandomFlowers(g2);

		// Draw Desert Burrow
		DesertBurrow burrow = new DesertBurrow(g2, 100, getHeight() - 100, 2, Color.BLACK);
		burrow.draw();

		// Draw Jackelope
		Jackelope jackelope = new Jackelope(g2, 175, 475, 1.5, Color.decode(bodyColor), Color.decode(antlerColor));
		jackelope.draw();

		Jackelope babyJackelope2 = new Jackelope(g2, 220, 510, .75, Color.decode(bodyColor), Color.decode(antlerColor));
		babyJackelope2.draw();

		Jackelope babyJackelope1 = new Jackelope(g2, 140, 513, .9, Color.decode(bodyColor), Color.decode(antlerColor));
		babyJackelope1.draw();

		// Draw Lizard
		Lizard lizard = new Lizard(g2, 700, 500, .8, Color.decode("#ddff00"));
		lizard.draw();

	}

	// Draws random flowers on the sand dunes.
	private void drawRandomFlowers(Graphics2D g2) {
		Random rand = new Random();
		int flowerCount = 100;

		for (int i = 0; i < flowerCount; i++) {
			int x = rand.nextInt(getWidth());
			int y = getHeight() - rand.nextInt(150);

			Flower flower = new Flower(g2, x, y, 0.5 + rand.nextDouble(), Color.PINK, Color.YELLOW);
			flower.draw();
		}
	}
}
