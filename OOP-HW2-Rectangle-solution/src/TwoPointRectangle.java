public class TwoPointRectangle extends AbstractRectangle {
    private Point topLeft;
    private Point bottomRight;

    public TwoPointRectangle() {
        this(new Point(0,1), new Point(1,0));
    }
    
    public TwoPointRectangle(Point topLeft, Point bottomRight) {
        this.topLeft = new Point(topLeft);
        this.bottomRight = new Point(bottomRight);
        if (getHeight() == 0 || getWidth() == 0) {
        	this.topLeft = new Point(0,1);
        	this.bottomRight = new Point(1,0);
        }
    }

    @Override
    public double getWidth() {
        return bottomRight.getX() - topLeft.getX();
    }

    @Override
    public double getHeight() {
        return topLeft.getY() - bottomRight.getY();
    }

    @Override
    public Point getBottomLeft() {
        return new Point(topLeft.getX(), bottomRight.getY()); // Constructing bottom left from topLeft and bottomRight
    }

    @Override
    public void setBottomLeft(Point bottomLeft) {
        // Adjust topLeft and bottomRight based on the new bottomLeft and current dimensions
        double width = getWidth();
        double height = getHeight();

        this.topLeft = new Point(bottomLeft.getX(), bottomLeft.getY() + height);
        this.bottomRight = new Point(bottomLeft.getX() + width, bottomLeft.getY());
    }


    @Override
    public void updateWidth(double width) {
    	if (width <= 0)
    		return;
        bottomRight.setX(topLeft.getX() + width);
    }

    @Override
    public void updateHeight(double height) {
    	if (height <= 0)
    		return;
    	topLeft.setY(bottomRight.getY() + height);
    }

}
