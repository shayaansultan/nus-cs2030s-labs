/**
 * A boolean condition with an integer parameter y that can be 
 * apply to another integer x.  Returns true if x is divisible 
 * by y, false otherwise.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

class DivisibleBy implements BooleanCondition<Integer> {
  private int num;

  public DivisibleBy(int num) {
    this.num = num;
  }


  @Override
  public boolean test(Integer i) {
    return (i%num) == 0;
  }  

}
