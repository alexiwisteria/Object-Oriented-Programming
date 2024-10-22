package Draw;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Jackelope extends LandscapeObject {
    private Color bodyColor;
    private Color antlerColor;

    //Constructor for the Jackelope class.
    public Jackelope(Graphics2D g2, int x, int y, double scale, Color bodyColor, Color antlerColor) {
        super(g2, x, y, scale);
        this.bodyColor = bodyColor;
        this.antlerColor = antlerColor;
    }

    // Applies the scaling factor
    @Override
    public void applyScale() {
    }

    @Override
    public void draw() {

        // Define colors for realistic details
        Color pinkInnerEar = new Color(255, 192, 203);
        Color eyeHighlightColor = new Color(255, 255, 255);
        Color noseColor = new Color(0, 0, 0);
        Color footPadColor = Color.decode("#cf8f69");

        // Tail
        g2.setColor(bodyColor);
        Ellipse2D tail = new Ellipse2D.Double(currentX - 7  * getScale(), currentY + 8 * getScale(), 12 * getScale(), 12 * getScale());
        g2.fill(tail);
        g2.setColor(Color.BLACK);
        g2.draw(tail);

        // Rear legs
        g2.setColor(bodyColor);
        Ellipse2D rearLeg1 = new Ellipse2D.Double(currentX - 5 * getScale(), currentY + 15 * getScale(), 10 * getScale(), 10 * getScale());
        Ellipse2D rearLeg2 = new Ellipse2D.Double(currentX + 20 * getScale(), currentY + 15 * getScale(), 10 * getScale(), 10 * getScale());
        g2.fill(rearLeg1);
        g2.fill(rearLeg2);
        g2.setColor(footPadColor);
        g2.fill(new Ellipse2D.Double(currentX - 2 * getScale(), currentY + 18 * getScale(), 5 * getScale(), 5 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 23 * getScale(), currentY + 18 * getScale(), 5 * getScale(), 5 * getScale()));
        g2.setColor(Color.BLACK);
        g2.draw(rearLeg1);
        g2.draw(rearLeg2);

        // Body
        g2.setStroke(new BasicStroke(1.0f));
        g2.setColor(bodyColor);
        Ellipse2D body = new Ellipse2D.Double(currentX, currentY, 25 * getScale(), 25 * getScale());
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);

        // Ears with inner ear details
        g2.setColor(bodyColor);
        g2.fill(new Ellipse2D.Double(currentX + 3 * getScale(), currentY - 40 * getScale(), 10 * getScale(), 25 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 16 * getScale(), currentY - 40 * getScale(), 10 * getScale(), 25 * getScale()));
        g2.setColor(Color.black);
        g2.draw(new Ellipse2D.Double(currentX + 3 * getScale(), currentY - 40 * getScale(), 10 * getScale(), 25 * getScale()));
        g2.draw(new Ellipse2D.Double(currentX + 16 * getScale(), currentY - 40 * getScale(), 10 * getScale(), 25 * getScale()));
        g2.setColor(pinkInnerEar);
        g2.fill(new Ellipse2D.Double(currentX + 6 * getScale(), currentY - 38 * getScale(), 5 * getScale(), 20 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 19 * getScale(), currentY - 38 * getScale(), 5 * getScale(), 20 * getScale()));

// Antlers
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.black);

// Left Antler
        Path2D.Double leftAntler = new Path2D.Double();
// Starting point for left antler
        leftAntler.moveTo(currentX + 13 * getScale(), currentY - 17 * getScale());
// Curve for the main part of the left antler
        leftAntler.curveTo(currentX + 10 * getScale(), currentY - 40 * getScale(), currentX, currentY - 25 * getScale(), currentX + 3 * getScale(), currentY - 50 * getScale());
// Smaller branch of the left antler
        leftAntler.moveTo(currentX + 10 * getScale(), currentY - 30 * getScale());
        leftAntler.lineTo(currentX + 7 * getScale(), currentY - 50 * getScale());
// Another smaller branch of the left antler
        leftAntler.moveTo(currentX + 7 * getScale(), currentY - 40 * getScale());
        leftAntler.lineTo(currentX, currentY - 55 * getScale());
        g2.draw(leftAntler);

// Right Antler
        Path2D.Double rightAntler = new Path2D.Double();
// Starting point for right antler
        rightAntler.moveTo(currentX + 17 * getScale(), currentY - 17 * getScale());
// Curve for the main part of the right antler
        rightAntler.curveTo(currentX + 20 * getScale(), currentY - 40 * getScale(), currentX + 30 * getScale(), currentY - 25 * getScale(), currentX + 27 * getScale(), currentY - 50 * getScale());
// Smaller branch of the right antler
        rightAntler.moveTo(currentX + 20 * getScale(), currentY - 30 * getScale());
        rightAntler.lineTo(currentX + 23 * getScale(), currentY - 50 * getScale());
// Another smaller branch of the right antler
        rightAntler.moveTo(currentX + 23 * getScale(), currentY - 40 * getScale());
        rightAntler.lineTo(currentX + 30 * getScale(), currentY - 55 * getScale());
        g2.draw(rightAntler);


        // Head
        g2.setStroke(new BasicStroke(1.0f));
        g2.setColor(bodyColor);
        Ellipse2D head = new Ellipse2D.Double(currentX + 2 * getScale(), currentY - 20 * getScale(), 25 * getScale(), 25 * getScale());
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);

       // Eyes
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(currentX + 6 * getScale(), currentY - 12 * getScale(), 7 * getScale(), 7 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 17 * getScale(), currentY - 12 * getScale(), 7 * getScale(), 7 * getScale()));
        g2.setColor(eyeHighlightColor);
        g2.fill(new Ellipse2D.Double(currentX + 8 * getScale(), currentY - 9 * getScale(), 3 * getScale(), 3 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 18 * getScale(), currentY - 9 * getScale(), 3 * getScale(), 3 * getScale()));

        // Nose
        g2.setColor(noseColor);
        int[] xPoints = {(int) (currentX + 15 * getScale()), (int) (currentX + 13 * getScale()), (int) (currentX + 17 * getScale())};
        int[] yPoints = {(int) (currentY - 2 * getScale()), (int) (currentY - 5 * getScale()), (int) (currentY - 5 * getScale())};
        g2.fill(new Polygon(xPoints, yPoints, 3));

        // Whiskers
        g2.setStroke(new BasicStroke(0.5f));
        g2.setColor(Color.black);
        g2.drawLine((int) (currentX + 12 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX - 1 * getScale()), (int) (currentY - 1 * getScale()));
        g2.drawLine((int) (currentX + 12 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX - 1 * getScale()), (int) (currentY - 5 * getScale()));
        g2.drawLine((int) (currentX + 12 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX - 1 * getScale()), (int) (currentY + 1 * getScale()));
        g2.drawLine((int) (currentX + 18 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX + 28 * getScale()), (int) (currentY - 1 * getScale()));
        g2.drawLine((int) (currentX + 18 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX + 28 * getScale()), (int) (currentY - 5 * getScale()));
        g2.drawLine((int) (currentX + 18 * getScale()), (int) (currentY - 3 * getScale()), (int) (currentX + 28 * getScale()), (int) (currentY + 1 * getScale()));

        // Front legs
        g2.setColor(bodyColor);
        Ellipse2D frontLeg1 = new Ellipse2D.Double(currentX + 5 * getScale(), currentY + 15 * getScale(), 8 * getScale(), 12 * getScale());
        Ellipse2D frontLeg2 = new Ellipse2D.Double(currentX + 15 * getScale(), currentY + 15 * getScale(), 8 * getScale(), 12 * getScale());
        g2.fill(frontLeg1);
        g2.fill(frontLeg2);
        g2.setColor(footPadColor);
        g2.setColor(Color.BLACK);
        g2.draw(frontLeg1);
        g2.draw(frontLeg2);

    }
}
