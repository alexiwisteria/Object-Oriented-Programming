package Draw;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DesertBurrow extends LandscapeObject {
    private Color entranceColor;

    // Constructor for the DesertBurrow class.
    public DesertBurrow(Graphics2D g2, int x, int y, double scale, Color entranceColor) {
        super(g2, x, y, scale);
        this.entranceColor = entranceColor;
    }

    // Applies the scaling factor
    @Override
    public void applyScale() {
    }

    @Override
    public void draw() {

        // Draw the entrance of the burrow
        g2.setColor(entranceColor);
        Ellipse2D entrance = new Ellipse2D.Double(currentX - 15 * getScale(), currentY, 30 * getScale(), 20 * getScale());
        g2.fill(entrance);

        // Outline the entrance
        g2.setColor(Color.BLACK);
        g2.draw(entrance);

        // Add some details around the entrance (e.g., stones)
        g2.setColor(new Color(169, 169, 169)); // Gray color for stones
        g2.fill(new Ellipse2D.Double(currentX - 20 * getScale(), currentY + 10 * getScale(), 5 * getScale(), 5 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 15 * getScale(), currentY + 10 * getScale(), 5 * getScale(), 5 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX - 10 * getScale(), currentY + 15 * getScale(), 4 * getScale(), 4 * getScale()));
        g2.fill(new Ellipse2D.Double(currentX + 10 * getScale(), currentY + 15 * getScale(), 4 * getScale(), 4 * getScale()));

        // Draw some tufts of desert grass around the entrance
        g2.setStroke(new BasicStroke(2.0f));
        g2.setColor(Color.decode("#7ba428")); // Olive green color for grass
        g2.drawLine((int) (currentX - 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX - 8 * getScale()), (int) (currentY + 15 * getScale()));
        g2.drawLine((int) (currentX - 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX - 12 * getScale()), (int) (currentY + 15 * getScale()));
        g2.drawLine((int) (currentX + 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX + 8 * getScale()), (int) (currentY + 15 * getScale()));
        g2.drawLine((int) (currentX + 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX + 8 * getScale()), (int) (currentY + 15 * getScale()));
        g2.drawLine((int) (currentX + 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX + 12 * getScale()), (int) (currentY + 15 * getScale()));
        g2.drawLine((int) (currentX + 10 * getScale()), (int) (currentY + 20 * getScale()), (int) (currentX + 12 * getScale()), (int) (currentY + 15 * getScale()));
    }
}
