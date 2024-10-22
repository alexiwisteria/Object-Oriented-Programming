package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Lizard extends LandscapeObject {
    private Color color;
    private final int defaultSize = 10;


    // Constructor for the Lizard class.
    public Lizard(Graphics2D g2, int x, int y, double scale, Color color) {
        super(g2, x, y, scale);
        this.color = color;
    }


    // Draws the lizard by drawing its diamonds and rectangles in a rotated position.
    @Override
    public void draw() {
        // Apply scale to all dimensions
        applyScale();

        // Save the original transform
        AffineTransform originalTransform = g2.getTransform();

        // Rotate around the lizard's center
        AffineTransform rotateTransform = new AffineTransform();
        rotateTransform.rotate(Math.toRadians(40), currentX, currentY);
        g2.transform(rotateTransform);

        // Set the color
        g2.setColor(color);

        // Draw the top diamond
        int[] xPointsTop = {
                currentX,
                currentX + (int) (defaultSize * getScale()),
                currentX,
                currentX - (int) (defaultSize * getScale())
        };
        int[] yPointsTop = {
                currentY,
                currentY + (int) (defaultSize * getScale()),
                currentY + 2 * (int) (defaultSize * getScale()),
                currentY + (int) (defaultSize * getScale())
        };
        g2.fillPolygon(xPointsTop, yPointsTop, 4);

        // Draw the middle diamond
        int[] xPointsMiddle = {
                currentX,
                currentX + (int) (defaultSize * getScale()),
                currentX,
                currentX - (int) (defaultSize * getScale())
        };
        int[] yPointsMiddle = {
                currentY + 2 * (int) (defaultSize * getScale()),
                currentY + 3 * (int) (defaultSize * getScale()),
                currentY + 4 * (int) (defaultSize * getScale()),
                currentY + 3 * (int) (defaultSize * getScale())
        };
        g2.fillPolygon(xPointsMiddle, yPointsMiddle, 4);

        // Draw the bottom diamond
        int[] xPointsBottom = {
                currentX,
                currentX + (int) (defaultSize * getScale()),
                currentX,
                currentX - (int) (defaultSize * getScale())
        };
        int[] yPointsBottom = {
                currentY + 4 * (int) (defaultSize * getScale()),
                currentY + 5 * (int) (defaultSize * getScale()),
                currentY + 6 * (int) (defaultSize * getScale()),
                currentY + 5 * (int) (defaultSize * getScale())
        };
        g2.fillPolygon(xPointsBottom, yPointsBottom, 4);

        // Draw the rotated rectangles for the middle diamond
        int rectLength = (int) (defaultSize * getScale() * 2);
        int rectWidth = (int) (defaultSize * getScale() * 0.5);

        // Draw the rectangles at a 45-degree angle from the middle diamond
        drawRotatedRectangle(g2, currentX + (int) (defaultSize * getScale() * 0.5),
                (currentY - 1) + 3 * (int) (defaultSize * getScale()),
                rectWidth, rectLength, 45);
        drawRotatedRectangle(g2, (currentX - 2) - (int) (defaultSize * getScale() * 0.5),
                (currentY + 4) + 3 * (int) (defaultSize * getScale()),
                rectWidth, rectLength, -45);

        // Draw the rectangles for the bottom diamond
        // Right rectangle from bottom diamond
        g2.fillRect(
                currentX + (int) (defaultSize * getScale() * 0.5),
                currentY + 5 * (int) (defaultSize * getScale()),
                rectWidth,
                rectLength
        );

        // Left rectangle from bottom diamond
        g2.fillRect(
                currentX - (int) (defaultSize * getScale() * 0.5) - rectWidth,
                currentY + 5 * (int) (defaultSize * getScale()),
                rectWidth,
                rectLength
        );

        // Draw the tail flipped vertically
        int[] xPointsTail = {
                currentX,
                currentX + (int) (defaultSize * getScale() * 0.5),
                currentX - (int) (defaultSize * getScale() * 0.5)
        };
        int[] yPointsTail = {
                (currentY + 12) + 6 * (int) (defaultSize * getScale()),
                (currentY + 12) + 4 * (int) (defaultSize * getScale()),
                (currentY + 12) + 4 * (int) (defaultSize * getScale())
        };
        g2.fillPolygon(xPointsTail, yPointsTail, 3);

        // Restore the original transform
        g2.setTransform(originalTransform);
    }


    // Draws a rotated rectangle.
    private void drawRotatedRectangle(Graphics2D g2, int x, int y, int width, int height, double angle) {
        AffineTransform old = g2.getTransform();
        g2.rotate(Math.toRadians(angle), x, y);
        g2.fill(new Rectangle2D.Double(x, y - height, width, height));
        g2.setTransform(old);
    }


    // Applies the scaling factor to the lizard. Currently, this method is empty,
    @Override
    public void applyScale() {
    }
}
