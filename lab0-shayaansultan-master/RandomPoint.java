import java.util.Random;
/* 
 * @author Sultan Shayaan (Group 14C)
 */

class RandomPoint extends Point {
	//min max variables
	private double minX ;
	private double maxX ;
	private double minY ;
	private double maxY ;
	
	//seed related variables
	private static long seed = 1 ;
	private static Random rng = new Random(seed) ;
	
	RandomPoint (double minX, double maxX, double minY, double maxY) {
		// rng.nextDouble() doesn't guarrantee that double is between max and min
		// to ensure double within bound we have to apply the following formula :
		// result = rng.nextDouble() * (max - min) + min
		super(rng.nextDouble() * (maxX - minX) + minX, rng.nextDouble() * (maxY - minY) + minY) ;
		this.minX = minX ;
		this.maxX = maxX ;
		this.minY = minY ;
		this.maxY = maxY ;
	}

	public static void setSeed(long s) {
		RandomPoint.seed = s ;
		rng = new Random(seed) ;
	}

	

}





