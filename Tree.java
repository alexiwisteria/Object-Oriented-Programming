package Draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 * Tree Class. Extends LandscapeObject Class.
 * Note this class inherits 3 protected attributes from LandscapeObject for convenience in coding methods.
 * protected int currentX
 * protected int currentY
 * protected Graphics2D
 *
 * When creating a Tree object in the DrawPanel.paintComponent(Graphics) method, usually the following syntax is used.
 *
 * Tree t1 = new Tree(args);
 * t1.draw();
 *
 * @author Jeffrey L Light
 * @version 1.0
 * @since 2019-11-26
 */
public class Tree extends LandscapeObject {
	// Attributes
	private int levels; // The number of levels (branch triangles) the tree will have.
	private Color trunkColor; // The color of the trunk. Set in the constructor.
	private Color branchColor; // The color of the branches. Set in the constructor.
	private int trunkWidth = 10; // The trunk width in pixels. Default of 10 for a scale of 1. Modified by applyScale method().
	private int trunkHeight = 15; // The trunk height in pixels. Default of 15 for a scale of 1. Modified by applyScale method().
	private int branchWidth = 30; // The branch width in pixels. Default of 30 for a scale of 1. Modified by applyScale method().
	private int branchHeight = 30; // The branch height in pixels. Default of 30 for a scale of 1. Modified by applyScale method().
	private double branchOverlap = .45; // Indicates how much of each triangle is overlapped by the one above it.
	private String shape = ""; // Shape type of the tree
	private BasicStroke treeStroke = new BasicStroke(1); // Stroke of 1 pixel use to outline each shape of the tree.

	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 *
	 * @param g2            The Graphics2D interface.
	 * @param x             int. The startX coordinate. currentX is also set to x upon object creation.
	 * @param y             int. The startY coordinate. currentX is also set to y upon object creation.
	 * @param levels        int indicating how many levels (branch triangles) the tree will have.
	 * @param scale         double. Scale multiplier for the object.
	 * @param s_trunkColor  A String representing the Hex code for the color used for the trunk of the tree.
	 * @param s_branchColor A String representing the Hex code for the color used for the branches of the tree.
	 * @param shape         String. Shape of the tree.
	 */
	public Tree(Graphics2D g2, int x, int y, double scale, int levels, String s_trunkColor, String s_branchColor, String shape) {
		super(g2, x, y, scale);
		this.levels = levels;
		this.trunkColor = new Color(Integer.parseInt(s_trunkColor, 16));
		this.branchColor = new Color(Integer.parseInt(s_branchColor, 16));
		this.shape = shape;
	}

	// Methods
	/**
	 * draw()
	 * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
	 * Calls drawTrunk to draw the trunk of the tree.
	 * Calls drawBranches to draw the branches of the tree.
	 *
	 * @return void.
	 */
	public void draw() {
		applyScale();
		drawTrunk();
		drawBranches();
	}// end of method draw()

	/**
	 * applyScale
	 * Applies the scale multiplier to all shape dimensions for the object.
	 * Called by draw()
	 *
	 * @return void.
	 */
	public void applyScale() {
		trunkWidth *= getScale();
		trunkHeight *= getScale();
		branchWidth *= getScale();
		branchHeight *= getScale();
	}// end of method applyScale()

	/**
	 * drawTrunk()
	 * Draws a rectangle for the trunk of the tree.
	 * Called by draw()
	 *
	 * @return void.
	 */
	private void drawTrunk() {
		g2.setColor(trunkColor);
		g2.fillRect(currentX - trunkWidth / 2, currentY - trunkHeight, trunkWidth, trunkHeight);
		g2.setColor(Color.BLACK); // Set the stroke color to black
		g2.setStroke(treeStroke);
		g2.drawRect(currentX - trunkWidth / 2, currentY - trunkHeight, trunkWidth, trunkHeight);
		currentY -= trunkHeight;
	}// end of method drawTrunk()

	/**
	 * drawBranches()
	 * Draws 'level' number of triangles above the trunk overlapped by 'branchOverlap'.
	 * Called by draw()
	 *
	 * @return void.
	 */
	private void drawBranches() {
		g2.setColor(branchColor); // Set the branch color before the loop
		for (int i = 0; i < levels; i++) {
			Path2D.Double branch = new Path2D.Double();
			branch.moveTo(currentX - branchWidth / 2, currentY);
			branch.lineTo(currentX + branchWidth / 2, currentY);
			branch.lineTo(currentX, currentY - branchHeight);
			branch.closePath();
			g2.fill(branch);

			g2.setColor(Color.BLACK); // Set the stroke color to black
			g2.setStroke(treeStroke);
			g2.draw(branch);

			currentY -= branchHeight * (1 - branchOverlap);
			branchWidth *= 0.8;
			branchHeight *= 0.8;
			g2.setColor(branchColor); // Reset the branch color after drawing the stroke
		}
	}// end of method drawBranches()

}// end of class Tree
