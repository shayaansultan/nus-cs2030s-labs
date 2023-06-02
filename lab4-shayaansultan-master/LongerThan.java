/**
 * A boolean condition with parameter x that can be applied to
 * a string.  Returns true if the string is longer than x; false
 * otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

class LongerThan implements BooleanCondition<String> {
  private int num;

  public LongerThan(int num) {
    this.num = num;
  }

  @Override
  public boolean test(String s) {
    return (s.length() > num);

  }

}
