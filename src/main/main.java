package main;

import objects.InfiniteLine;
import objects.Point;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InfiniteLine l1 = new InfiniteLine(new Point(2, 0), Math.PI / 2);
		
		InfiniteLine l2 = new InfiniteLine(new Point(-2, -2), Math.PI / 4);
		
		System.out.println(l1.getAngle() + " " + l2.getAngle());
		
		System.out.println(Math.tan(l1.getAngle()) + " " + Math.tan(l2.getAngle()));
		
		System.out.println(l1.getYIntercept() + " " + l1.getXIntercept());
		System.out.println(l2.getYIntercept() + " " + l2.getXIntercept());
		
		Point p = InfiniteLine.findIntersection(l1, l2);
		
		System.out.println(p.getX() + " " + p.getY());

	}

}
