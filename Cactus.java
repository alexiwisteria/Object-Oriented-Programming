package Draw;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Cactus extends LandscapeObject {
    private Color cactiColor;

    // Constructor for the Cactus class.
    public Cactus(Graphics2D g2, int x, int y, double scale, Color color) {
        super(g2, x, y, scale);
        this.cactiColor = color;
    }

    // Applies the scaling factor to the cactus.
    @Override
    public void applyScale() {
    }

    // Draws the cactus by combining rectangles and ellipses.
    @Override
    public void draw() {
        g2.setColor(cactiColor);

        // Draw the main body of the cactus
        Rectangle2D mainBody = new Rectangle2D.Double(currentX - 10 * getScale(),
                currentY - 140 * getScale(),
                20 * getScale(),
                200 * getScale());
        Ellipse2D mainTop = new Ellipse2D.Double(currentX - 10 * getScale(),
                currentY - 150 * getScale(),
                20 * getScale(),
                20 * getScale());
        g2.fill(mainBody);
        g2.fill(mainTop);

        // Draw the left arm of the cactus
        Rectangle2D leftLowerArm = new Rectangle2D.Double(currentX - 20 * getScale(),
                currentY - 60 * getScale(),
                10 * getScale(),
                20 * getScale());
        Rectangle2D leftUpperArm = new Rectangle2D.Double(currentX - 40 * getScale(),
                currentY - 100 * getScale(),
                20 * getScale(),
                50 * getScale());
        Ellipse2D leftLowerArmCurve = new Ellipse2D.Double(currentX - 40 * getScale(),
                currentY - 60 * getScale(),
                30 * getScale(),
                20 * getScale());
        Ellipse2D leftUpperArmCurve = new Ellipse2D.Double(currentX - 40 * getScale(),
                currentY - 110 * getScale(),
                20 * getScale(),
                20 * getScale());
        g2.fill(leftLowerArm);
        g2.fill(leftUpperArm);
        g2.fill(leftLowerArmCurve);
        g2.fill(leftUpperArmCurve);

        // Draw the right arm of the cactus
        Rectangle2D rightLowerArm = new Rectangle2D.Double(currentX + 10 * getScale(),
                currentY - 60 * getScale(),
                10 * getScale(),
                20 * getScale());
        Rectangle2D rightUpperArm = new Rectangle2D.Double(currentX + 20 * getScale(),
                currentY - 100 * getScale(),
                20 * getScale(),
                50 * getScale());
        Ellipse2D rightLowerArmCurve = new Ellipse2D.Double(currentX + 10 * getScale(),
                currentY - 60 * getScale(),
                30 * getScale(),
                20 * getScale());
        Ellipse2D rightUpperArmCurve = new Ellipse2D.Double(currentX + 20 * getScale(),
                currentY - 110 * getScale(),
                20 * getScale(),
                20 * getScale());
        g2.fill(rightLowerArm);
        g2.fill(rightUpperArm);
        g2.fill(rightLowerArmCurve);
        g2.fill(rightUpperArmCurve);

        // Draw the spines on the cactus
        g2.setStroke(new BasicStroke());
        g2.setColor(Color.BLACK);
        drawSpines(mainBody);
        drawSpines(mainTop);
        drawSpines(leftLowerArm);
        drawSpines(leftUpperArm);
        drawSpines(rightLowerArm);
        drawSpines(rightUpperArm);
    }

    // Draws spines on a rectangular part of the cactus.
    private void drawSpines(Rectangle2D rect) {
        double spineSpacing = 10 * getScale();
        for (double x = rect.getX(); x <= rect.getX() + rect.getWidth(); x += spineSpacing) {
            for (double y = rect.getY(); y <= rect.getY() + rect.getHeight(); y += spineSpacing) {
                drawSpine(x, y);
            }
        }
    }

    // Draws spines on an elliptical part of the cactus.
    private void drawSpines(Ellipse2D ellipse) {
        double spineSpacing = 10 * getScale();
        for (double x = ellipse.getX(); x <= ellipse.getX() + ellipse.getWidth(); x += spineSpacing) {
            for (double y = ellipse.getY(); y <= ellipse.getY() + ellipse.getHeight(); y += spineSpacing) {
                if (ellipse.contains(x, y)) {
                    drawSpine(x, y);
                }
            }
        }
    }

    // Draws a single spine at a specified position.
    private void drawSpine(double x, double y) {
        double spineLength = 3 * getScale();
        g2.drawLine((int) x, (int) y, (int) (x + spineLength), (int) y);
        g2.drawLine((int) x, (int) y, (int) (x - spineLength), (int) y);
        g2.drawLine((int) x, (int) y, (int) x, (int) (y + spineLength));
        g2.drawLine((int) x, (int) y, (int) x, (int) (y - spineLength));
    }
}
