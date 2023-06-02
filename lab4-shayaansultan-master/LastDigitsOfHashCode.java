/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

class LastDigitsOfHashCode implements Transformer<Object, Integer>{

  private int num;

  public LastDigitsOfHashCode (int num) {
    this.num = num;
  }

  @Override
  public Integer transform(Object s) {
    int code = s.hashCode();
    String temp1 = String.valueOf(code);
    String temp2 = temp1.substring(temp1.length()-this.num);
    Integer output = Integer.valueOf(temp2);

    return output;


  }


}

