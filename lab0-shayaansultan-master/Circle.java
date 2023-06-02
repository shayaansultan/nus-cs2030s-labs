/**
 * CS2030S Lab 0: Circle.java
 * Semester 2, 2022/23
 *
 * <p>The Circle class represents a circle with a center 
 * and a radius.
 *
 * @author Sultan Shayaan (Group 14C) 
 */
class Circle {
  /** The center of the circle. */
  private Point c;

  /** The radius of the circle (assume positive). */
  private double r;

  /**
   * Constructor for a circle.  Takes in a center c and a 
   * radius r (assume to be positive). 
   *
   * @param c The center of the new circle.
   * @param r The radius of the new circle.
   */
  
  private double a;
  private double b;
  private double x;
  private double y;
  
  public Circle(Point c, double r) {
    this.c = c;
    this.r = r;
  }

  /**
   * Checks if a given point p is contained within the circle.
   *
   * @param p The point to test.
   * @return true if p is within this circle; false otherwise.
   */
  public boolean contains(Point p) {
    a = this.c.getX() ;
    b = this.c.getY() ;

    x = p.getX();
    y = p.getY();

    return (a-x)*(a-x) + (b-y)*(b-y) <= r*r ;
  }

  /**
   * Return the string representation of this circle.
   *
   * @return The string representing of this circle.
   */
  public String toString() {
    return "{ center: " + this.c + ", radius: " + this.r + " }";
  }
}
