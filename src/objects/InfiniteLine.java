package objects;

public class InfiniteLine extends Line {
	
	protected double yIntercept;
	protected double xIntercept;
	
	
	public static Point noIntersection = new Point(0, 0);
	public static Point infiniteIntersection = new Point(0, 0);

	public InfiniteLine(Point p1, Point p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}
	
	public InfiniteLine(Point p1, double angle) {
		super();
		
		if (angle <= -Math.PI / 2) {
			angle += Math.PI / 2;
		}else if (angle > Math.PI / 2) {
			angle -= Math.PI / 2;
		}
		
		
		this.angle = angle;
		
		if (angle == Math.PI / 2) {
			this.yIntercept = 0;
			this.xIntercept = p1.getX();
			}else if (angle == 0) {
				this.yIntercept = p1.getY();
				this.xIntercept = 0;
			}else {	
				this.yIntercept = p1.getY() - Math.tan(angle) * p1.getX();
				this.xIntercept = -yIntercept / Math.tan(angle);
			}
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Point getStartPoint() {
		return new Point(0, 0);
	}
	
	@Override
	public Point getEndPoint() {
		return new Point(0, 0);
	}
	
	public double getYIntercept() {
		return yIntercept;
	}
	
	public double getXIntercept() {
		return xIntercept;
	}
	
	public double findY(double x) {
		
		if (angle == Math.PI / 2) {
			return 0;
		}else if (angle == 0) {
			return yIntercept;
		}
		
		return Math.tan(angle) * x + yIntercept;
	}
	
	public double findX(double y) {
		
		if (angle == Math.PI / 2) {
			return xIntercept;
			}else if (angle == 0) {
				return 0;
			}
		
		
		return (y - yIntercept) / Math.tan(angle);
	}
	
	
	public static Point findIntersection(InfiniteLine l1, InfiniteLine l2) {
		
		if (l1.angle == l2.angle) {
			return noIntersection;
		}
		
		if (l1.angle == Math.PI / 2) {
			return new Point(l1.xIntercept, l2.findY(l1.xIntercept));
		}
		
		if (l2.angle == Math.PI / 2) {
			return new Point(l2.xIntercept, l1.findY(l2.xIntercept));
		}
		
		if (l1.angle == 0) {
			return new Point(l2.findX(l1.yIntercept), l1.yIntercept);
		}
		
		if (l2.angle == 0) {
			return new Point(l1.findX(l2.yIntercept), l2.yIntercept);
		}
		
		double x = (l2.yIntercept - l1.yIntercept) / (Math.tan(l1.angle) - Math.tan(l2.angle));
		double y = l1.findY(x);
		
		return new Point(x, y);
	
		
		
	}
	
	public double findDistance(Point p) {
		InfiniteLine l = new InfiniteLine(p, angle + Math.PI / 2);
		
		Point intersection = findIntersection(l);
		
		double xDiff = p.getX() - intersection.getX();
		double yDiff = p.getY() - intersection.getY();
		
		
		
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
	
	public boolean isXPerpendicular() {
		return angle == Math.PI / 2;
	}
	
	public boolean isYPerpendicular() {
		return angle == 0;
	}
}
