/**
 * Takes an item and return the item in a box.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

class BoxIt<T> implements Transformer<T, Box<T>> {

  @Override
  public Box<T> transform(T things) {
    if (things != null) {
      return Box.ofNullable(things);
    } else {
      return Box.empty();
    }

  }

}
