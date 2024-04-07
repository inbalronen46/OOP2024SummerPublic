public class DimensionRectangle extends AbstractRectangle {
    private Point bottomLeft;
    private double width;
    private double height;

    public DimensionRectangle() {
    	this(new Point(0,0), 1, 1);
        
    }
    
    public DimensionRectangle(Point bottomLeft, double width, double height) {
    	if (width  > 0 && height > 0) {
    		this.bottomLeft = new Point(bottomLeft);
            this.width = width;
            this.height = height;
    	} else {
    		this.bottomLeft = new Point(0,0);
            this.width = 1;
            this.height = 1;
    	}
        
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Point getBottomLeft() {
        return bottomLeft;
    }

    @Override
    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = new Point(bottomLeft);
    }

    
    
    @Override
    public void updateWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    @Override
    public void updateHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }

}
