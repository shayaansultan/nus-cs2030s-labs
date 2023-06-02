/**
 * A conditional statement that returns either true of false.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

package cs2030s.fp;

public interface BooleanCondition<T> {
  public boolean test(T x);
}
