package algos;

import java.util.ArrayList;

import objects.InfiniteLine;
import objects.Line;
import objects.Point;

public class ConvexHallDivideConquer {
	
	private ArrayList<Point> points;
	private ArrayList<Point> convexHall;
	
	public ConvexHallDivideConquer(ArrayList<Point> points) {
		this.points = points;
	}
	
	public ArrayList<Line> ConvexLines(ArrayList<Point> points, ArrayList<Line> lines) {
		
		ArrayList<Line> returnLines = new ArrayList<>();
		
		
		if (points.size() == 1) {
			return returnLines;
		}
		
		if (points.size() == 2) {
			Line l = new Line(points.get(0), points.get(1));
			returnLines.add(l);
			return returnLines;
		}

		ArrayList<Point> leftPoints = new ArrayList<>();
		ArrayList<Point> rightPoints = new ArrayList<>();
		
		points.sort((p1, p2) -> {
			if (p1.getX() < p2.getX()) {
				return -1;
			}else if (p1.getX() > p2.getX()) {
				return 1;
			}else {
				return 0;
			}
		});
		
		for (int i = 0; i < points.size(); i++) {
			if (i < points.size() / 2) {
				leftPoints.add(points.get(i));
			}else {
				rightPoints.add(points.get(i));
			}
		}
		
		ArrayList<Line> leftLines = ConvexLines(leftPoints, lines);
		ArrayList<Line> rightLines = ConvexLines(rightPoints, lines);
		
		if(leftLines.size() == 0) {
			
			returnLines.add(rightLines.get(0));
			
			Line l1 = new Line(leftPoints.get(0), rightPoints.get(0));
			Line l2 = new Line(rightPoints.get(1), leftPoints.get(0));
			
			returnLines.add(l1);
			returnLines.add(l2);
			
			return rightLines;
			
		}
		
		if(rightLines.size() == 0) {
			
			returnLines.add(leftLines.get(0));
			
			Line l1 = new Line(leftPoints.get(leftPoints.size() - 1), rightPoints.get(rightPoints.size() - 1));
			Line l2 = new Line(rightPoints.get(rightPoints.size() - 2), leftPoints.get(leftPoints.size() - 1));
			
			returnLines.add(l1);
			returnLines.add(l2);
			
			return leftLines;
			
		}
		
		// Merge the two convex hulls
		
		// Find the rightmost point of the left hull
		Point leftMost = leftPoints.get(leftPoints.size() - 1);
		
		// Find the leftmost point of the right hull
		
		Point rightMost = rightPoints.get(0);
		
		Point crossPoint = new Point((leftMost.getX() + rightMost.getX()) / 2, 0);
		
		InfiniteLine separationLine = new InfiniteLine(crossPoint, Math.PI / 2);
		
		
		
		
		
		
		
		
		return returnLines;
	}
	
	
	
	public void printPoints() {
		for (Point p : points) {
			System.out.println(p.getX() + " " + p.getY());
		}
	}
}
