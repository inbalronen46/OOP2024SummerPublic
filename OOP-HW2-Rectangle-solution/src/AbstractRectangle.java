public abstract class AbstractRectangle implements Rectangle {
    // Abstract methods for getting dimensions, bottom-left point, and updating dimensions
    public abstract double getWidth();
    public abstract double getHeight();
    public abstract Point getBottomLeft();
    public abstract void setBottomLeft(Point bottomLeft);
    public abstract void updateWidth(double width);
    public abstract void updateHeight(double height);

    // General implementation for calculating area
    public double area() {
        return getWidth() * getHeight();
    }

    // General implementation for calculating perimeter
    public double perimeter() {
        return 2 * (getWidth() + getHeight());
    }

    // General implementation for moving the rectangle by a delta
    public void move(Point delta) {
        Point bottomLeft = getBottomLeft();
        setBottomLeft(new Point(bottomLeft.getX() + delta.getX(), bottomLeft.getY() + delta.getY()));
    }

    // General implementation for moving the rectangle horizontally
    public void moveHorizontal(double distance) {
        Point bottomLeft = getBottomLeft();
        setBottomLeft(new Point(bottomLeft.getX() + distance, bottomLeft.getY()));
    }

    // General implementation for moving the rectangle vertically
    public void moveVertical(double distance) {
        Point bottomLeft = getBottomLeft();
        setBottomLeft(new Point(bottomLeft.getX(), bottomLeft.getY() + distance));
    }

    // General implementation for checking if a point is within the rectangle
    public boolean containsPoint(Point point) {
        Point bottomLeft = getBottomLeft();
        return point.getX() >= bottomLeft.getX() && point.getX() <= bottomLeft.getX() + getWidth() &&
               point.getY() >= bottomLeft.getY() && point.getY() <= bottomLeft.getY() + getHeight();
    }

    // General implementation for getting all points of the rectangle
    public Point[] getAllPoints() {
        Point bottomLeft = getBottomLeft();
        Point topLeft = new Point(bottomLeft.getX(), bottomLeft.getY() + getHeight());
        Point topRight = new Point(bottomLeft.getX() + getWidth(), bottomLeft.getY() + getHeight());
        Point bottomRight = new Point(bottomLeft.getX() + getWidth(), bottomLeft.getY());

        return new Point[] {topLeft, topRight, bottomRight, bottomLeft};
    }

    // Flip the rectangle vertically around its bottom edge
    public void flipVertical() {
        Point bottomLeft = getBottomLeft();
        setBottomLeft(new Point(bottomLeft.getX() - getWidth(), bottomLeft.getY()));
    }

    // Flip the rectangle horizontally around its left edge
    public void flipHorizontal() {
        Point bottomLeft = getBottomLeft();
        setBottomLeft(new Point(bottomLeft.getX(), bottomLeft.getY() -  getHeight()));
        
    }

    @Override
    public void reflect(boolean xAxis, boolean yAxis) {
        Point currBottomLeft = getBottomLeft();
		double newX = currBottomLeft.getX();
        double newY = currBottomLeft.getY();

        // Reflecting over the x-axis moves the rectangle vertically.
        if (xAxis) {
            // After reflection, the 'bottomLeft' point's y-coordinate is adjusted by the height to become the upper left.
            newY = -(newY + getHeight());
        }
        
        // Reflecting over the y-axis moves the rectangle horizontally.
        if (yAxis) {
            // After reflection, the 'bottomLeft' point's x-coordinate is adjusted by the width to become the upper left.
            newX = -(newX + getWidth());
        }

        setBottomLeft(new Point(newX, newY));
    }
    
    @Override
    public boolean isEqual(Rectangle other) {
        if (other == null || !(other instanceof AbstractRectangle)) return false;

        AbstractRectangle otherRect = (AbstractRectangle) other;
        return getBottomLeft().equals(otherRect.getBottomLeft()) &&
               getWidth() == otherRect.getWidth() &&
               getHeight() == otherRect.getHeight();
    }
    
    public void scale(double scaleFactor) {
    	if(scaleFactor <= 0) {
    		return;
    	}
        updateWidth(getWidth() * scaleFactor);
        updateHeight(getHeight() * scaleFactor);
    }
}
