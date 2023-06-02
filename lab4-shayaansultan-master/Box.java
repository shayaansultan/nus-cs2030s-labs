/**
 * A generic box storing an item.
 * CS2030S Lab 4
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

class Box<T> {
  private final T things;
  private static final Box<?> EMPTY_BOX = new Box<>(null);
  
  private Box(T things) {
    this.things = things;
  }

  public static <T> Box<T> of(T things) {
    if (things == null) {
      return null;
    } else {
      return new Box<T>(things);
    }
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Box<?>) {
      @SuppressWarnings ("Unchecked")
      Box<?> b = (Box<?>) obj;
      if (this.things == b.things) {
        return true;
      }
      if (this.things == null || b.things == null) {
        return false;
      }
      return this.things.equals(b.things);
    }
    return false;
  }


  @Override
  public String toString() {
    if (this.things != null) {
      return "[" + this.things.toString() + "]";
    } else {
      return "[]";
    }
  }

  //PART 1 END ----------------- PART 2 BEGIN 


  public static <T> Box<T> empty() {
    @SuppressWarnings ("Unchecked")
    Box<T> output = (Box<T>) EMPTY_BOX;
    return output;
  }

  public boolean isPresent() {
    if (this.things == null) {
      return false;
    } else {
      return true;
    }
  }

  public static <T> Box<T> ofNullable(T things) {
    if (things == null) {
      return empty();
    } else {
      return new Box<T>(things);
    }
  }
  
  //PART 2 END ------------------ PART 3 BEGIN

  public Box<T> filter(BooleanCondition<? super T> s) {
    if (this.things == null) {
      return empty();
    } else if (s.test(this.things) == false) {
      return empty();
    } else {
      return this; 
    }
  }
  
  //PART 3 END ------------------ PART 5 BEGIN

  public <U> Box<U> map(Transformer<? super T, ? extends U> s) {
    if (this.things == null) {
      return empty();
    }
    U output = s.transform(this.things);
    return Box.ofNullable(output);
  }


}


