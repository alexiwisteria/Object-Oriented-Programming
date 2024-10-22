package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Sun extends LandscapeObject {
    private Color sunColor;
    private int rays;

    // Constructor for the Sun class.
    public Sun(Graphics2D g2, int x, int y, double scale, Color color, int rays) {
        super(g2, x, y, scale);
        this.sunColor = color;
        this.rays = rays;
    }

    // Applies the scaling factor

    @Override
    public void applyScale() {
    }

    // Draws the sun with a circle and rays around it.
    @Override
    public void draw() {
        // Set the color for the sun
        g2.setColor(sunColor);

        // Draw the sun (a circle)
        g2.fill(new Ellipse2D.Double(currentX, currentY, 40 * getScale(), 40 * getScale()));

        // Draw the rays around the sun
        for (int i = 0; i < rays; i++) {
            double angle = 2 * Math.PI * i / rays; // Calculate the angle for each ray
            int x = (int)(currentX + 20 * getScale() + 30 * getScale() * Math.cos(angle)); // X-coordinate of the ray's endpoint
            int y = (int)(currentY + 20 * getScale() + 30 * getScale() * Math.sin(angle)); // Y-coordinate of the ray's endpoint
            g2.drawLine((int)(currentX + 20 * getScale()), (int)(currentY + 20 * getScale()), x, y); // Draw the ray
        }
    }
}
