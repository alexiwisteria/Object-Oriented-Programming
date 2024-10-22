package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Flower extends LandscapeObject {
    private Color petalColor;
    private Color centerColor;

    // Constructor for the Flower class.
    public Flower(Graphics2D g2, int x, int y, double scale, Color petalColor, Color centerColor) {
        super(g2, x, y, scale);
        this.petalColor = petalColor;
        this.centerColor = centerColor;
    }

    // Applies the scaling factor to the flower.
    @Override
    public void applyScale() {
    }

    // Draws the flower by drawing its petals and center.
    @Override
    public void draw() {
        g2.setColor(petalColor);
        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5;
            int x = (int)(currentX + 10 * getScale() * Math.cos(angle));
            int y = (int)(currentY + 10 * getScale() * Math.sin(angle));
            g2.fill(new Ellipse2D.Double(x, y, 10 * getScale(), 10 * getScale()));
        }

        g2.setColor(centerColor);
        g2.fill(new Ellipse2D.Double(currentX, currentY, 10 * getScale(), 10 * getScale()));
    }
}
