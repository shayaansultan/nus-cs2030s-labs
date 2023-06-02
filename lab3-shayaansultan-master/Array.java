/**
 * The Array<T> for CS2030S 
 *
 * @author Sultan Shayaan
 * @version CS2030S AY22/23 Semester 2
 */
class Array<T extends Comparable<T>> { 
  private T[] array;

  
  @SuppressWarnings({"rawtypes", "unchecked"})
  Array(int size) { 
    this.array = (T[]) new Comparable[size];
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int index) {
    return this.array[index];
  }

  public T[] getArray() {
    return this.array;
  }

  public T min() {
    T output = this.array[0];
    for (int i = 0; i < array.length; i++) {
      if (output.compareTo(this.array[i]) > 0) {
        output = this.array[i];
      }
    }
    return output;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
