package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Cloud extends LandscapeObject {
    private Color cloudColor;

    // Constructor for the Cloud class.
    public Cloud(Graphics2D g2, int x, int y, double scale, Color color) {
        super(g2, x, y, scale);
        this.cloudColor = color;
    }

    // Applies the scaling factor
    @Override
    public void applyScale() {
    }

    // Draws the cloud using three ellipses.
    @Override
    public void draw() {
        // Set the color for the cloud
        g2.setColor(cloudColor);

        g2.fill(new Ellipse2D.Double(currentX, currentY, 30 * getScale(), 20 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 20 * getScale(), currentY - 7, 40 * getScale(), 30 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 50 * getScale(), currentY, 30 * getScale(), 20 * getScale()));
    }
}
