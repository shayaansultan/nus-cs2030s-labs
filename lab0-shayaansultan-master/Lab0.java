import java.util.Scanner;

/**
 * CS2030S Lab 0: Estimating Pi with Monte Carlo
 * Semester 2, 2022/23
 *
 * <p>This program takes in two command line arguments: the 
 * number of points and a random seed.  It runs the
 * Monte Carlo simulation with the given argument and print
 * out the estimated pi value.
 *
 * @author Sultan Shayaan (Group 14C) 
 */

class Lab0 {

  public static double estimatePi(int numOfPoints, int seed) {
      RandomPoint.setSeed(seed) ;
      Point center = new Point(0.5,0.5) ;
      double radius = 0.5 ;
      Circle testCircle = new Circle(center, radius) ;
      double pointsIn = 0 ;
      long pointsTotal = 0 ;

      
      for (int i = 0; i < numOfPoints; i++) {
          pointsTotal++ ;
          Point newPoint = new RandomPoint(0,1,0,1) ;
          if (testCircle.contains(newPoint)) {
              pointsIn += 1 ;
          } 
      }

      double result = 4*(pointsIn/pointsTotal) ;
      return result ;
  
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfPoints = sc.nextInt();
    int seed = sc.nextInt();

    double pi = estimatePi(numOfPoints, seed);

    System.out.println(pi);
    sc.close();
  }
}

