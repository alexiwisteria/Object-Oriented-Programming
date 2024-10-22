package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class SandDune extends LandscapeObject {
    private Color color;
    private int height;

    //Constructor for the SandDune class.
    public SandDune(Graphics2D g2, int x, int y, double scale, Color color, int height) {
        super(g2, x, y, scale);
        this.color = color;
        this.height = height;
    }

    // Applies the scaling factor
    @Override
    public void applyScale() {
    }

    // Draws the sand dune using an oval and a rectangle.
    @Override
    public void draw() {

        // Set the color
        g2.setColor(color);

        // Draw the oval (top part of the dune)
        double ovalWidth = 150 * getScale();
        double ovalHeight = height * getScale();
        Ellipse2D.Double oval = new Ellipse2D.Double(currentX, (currentY+50) - ovalHeight, ovalWidth, ovalHeight);
        g2.fill(oval);

        // Draw the rectangle (bottom part of the dune)
        double rectWidth = ovalWidth;
        double rectHeight = 100 * getScale();
        Rectangle2D.Double rect = new Rectangle2D.Double(currentX, currentY, rectWidth, rectHeight);
        g2.fill(rect);
    }
}
