/**
 * Interface defining the essential characteristics and behaviors of a rectangle.
 */
public interface Rectangle {
    
	/**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    double getWidth();

    /**
     * Gets the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    double getHeight();
    
    /**
     * Retrieves the bottom-left point of the rectangle. This method typically creates
     * and returns a new {@link Point} object based on the rectangle's position and dimensions.
     *
     * @return A new {@link Point} object representing the bottom-left corner of the rectangle.
     */
    Point getBottomLeft();
    
    /**
     * Provides an array of points representing the corners of the rectangle.
     *
     * @return An array of {@link Point} objects representing each corner of the rectangle. The
     * points should be new {@link Point} objects
     */
    Point[] getAllPoints();

    

    /**
     * Updates the width of the rectangle. If width <= 0, nothing is done. 
     * Width is relative to bottom left point.
     *
     * @param width The new width of the rectangle. 
     */
    void updateWidth(double width);

    /**
     * Updates the height of the rectangle. If height <= 0, nothing is done. 
     * Height is relative to bottom left point.
     *
     * @param height The new height of the rectangle.
     */
    void updateHeight(double height);
	
    /**
     * Sets the bottom-left point of the rectangle. This method adjusts the bottomRight
     * point to maintain the rectangle's width and height.
     *
     * @param bottomLeft The new bottom-left point of the rectangle.
     */
    public void setBottomLeft(Point bottomLeft);
    
    /**
     * Scales the rectangle's width and height by specified factor.
     * 
     * @param scaleFactor The factor by which to scale. If scaleFactor<=0 then nothing is done.
     */
    void scale(double scaleFactor);


    /**
     * Moves the rectangle by a specified delta in both the x and y directions.
     *
     * @param delta The point representing the delta to move in the x and y directions.
     */
    void move(Point delta);
    
    
    /**
     * Moves the rectangle horizontally by a specified distance.
     *
     * @param distance The distance to move the rectangle horizontally.
     */
    void moveHorizontal(double distance);

    /**
     * Moves the rectangle vertically by a specified distance.
     *
     * @param distance The distance to move the rectangle vertically.
     */
    void moveVertical(double distance);
    
    /**
     * Flips the rectangle vertically around its <b>left</b> edge.
     */
    void flipVertical();

    /**
     * Flips the rectangle horizontally around its bottom edge.
     */
    void flipHorizontal();
    
    /**
     * Reflects the rectangle across the specified axes.
     *
     * @param xAxis {@code true} to reflect across the x-axis, {@code false} to not.
     * @param yAxis {@code true} to reflect across the y-axis, {@code false} to not.
     */
    void reflect(boolean xAxis, boolean yAxis);
    
    
    
    /**
    * Calculates the area of the rectangle.
    *
    * @return The area of the rectangle.
    */
    double area();

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */
    double perimeter();    
    

    /**
     * Determines whether a given point lies within the bounds of the rectangle.
     *
     * @param point The point to check.
     * @return {@code true} if the point is within the rectangle, {@code false} otherwise.
     */
    boolean containsPoint(Point point);
    
    /**
     * Checks if another rectangle is equal to this one.
     * Equality is based on the dimensions and position of the rectangle.
     *
     * @param other The other rectangle to compare with.
     * @return {@code true} if the rectangles are equal, {@code false} otherwise.
     */
    boolean isEqual(Rectangle other);

}
