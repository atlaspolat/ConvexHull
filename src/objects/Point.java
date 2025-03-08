package objects;

public class Point {
	
	protected double x;
	protected double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	
	public double findDistance(Point p) {
		double xDiff = p.getX() - x;
		double yDiff = p.getY() - y;
		
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
	
	public double findAngle(Point p) {
		double xDiff = p.getX() - x;
		double yDiff = p.getY() - y;
		
		return Math.atan2(yDiff, xDiff);
	}
	
	

}
