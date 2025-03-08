package objects;

public class Line {
	
	
	protected double angle;
	
	protected Point startPoint;
	protected Point endPoint;

	
	public Line(Point p1, Point p2){
		
		angle = p1.findAngle(p2);
	}
		
	
	public Line() {
		// TODO Auto-generated constructor stub
	}


	public double getAngle() {
		return angle;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	

}
