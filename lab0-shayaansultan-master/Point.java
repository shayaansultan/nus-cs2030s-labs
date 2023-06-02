/**
 * CS2030S Lab 0: Point.java
 * Semester 2, 2022/23
 *
 * <p>The Point class encapsulates a point on a 2D plane.
 *
 * @author Sultan Shayaan (Group 14C)
 */
class Point {
 private double x ;
 private double y ;

 public Point (double x, double y) { 
	 this.x = x ;
	 this.y = y ;
 }

 @Override
 public String toString() {
	 return "(" + this.x + ", " + this.y + ")" ;
 } 
 
 public double getX () {
	 return this.x;
 }

 public double getY () {
	 return this.y;
 }

}
