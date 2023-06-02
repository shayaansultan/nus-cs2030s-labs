/**
 * The Transformer interface that can transform a type T
 * to type U.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

package cs2030s.fp;

public interface Transformer<T, U> {

  public U transform(T x);  

}
