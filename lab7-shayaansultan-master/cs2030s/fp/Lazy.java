package cs2030s.fp;

/**
 * Lazy class used for lazy evaluation and memoization. 
 */
public class Lazy<T> {

  /**
   * Producer that can produce a value when needed
   */
  private Producer<? extends T> producer;

  /**
   * Value to be stored in Lazy instance
   */
  private Maybe<T> value;

  /**
   * Object constructor taking in a value of type T
   * @param things The value to be stored in Lazy, 
   * will be converted to type Maybe first 
   */
  private Lazy(T things) {
    this.value = Maybe.some(things);
    this.producer = null;
  }

  /**
   * Object constructor for taking in a subtype of producer
   * @param producer Must be a subtype of producer and type T 
   */
  private Lazy(Producer<? extends T> producer) {
    this.producer = producer;
    this.value = Maybe.none();
  }

  /**
   * Static factory method for initializing Lazy object with the given value
   * @param <T> Generic type, should be replaced by type of object t
   * @param t Object of type T to be stored as value in Lazy instance
   * @return returns a new instance of Lazy
   */
  public static <T> Lazy<T> of(T t) {
    return new Lazy<T>(t);
  }

  /**
   * Static factory method that takes in a producer that produces the value when needed
   * @param <T> Generic type, should be replaced by type of object t
   * @param s Producer which must also be subtype of T
   * @return Returns a new instance of Lazy
   */
  public static <T> Lazy<T> of(Producer<? extends T> s) {
    return new Lazy<T>(s);
  }

  /**
   * Gets value stored in Lazy instance
   * If value not already available compute the value and return it.
   * @return Returns the value in Lazy
   */
  public T get() {
    T things = this.value.orElseGet(this.producer);
    this.value = Maybe.some(things);
    return things;
  }

  /**
   * Overriden toString method returns string representation of value in instance
   * returns "?" if the value is not yet available
   */
  @Override
  public String toString() {
    Transformer<T, String> m = tempVal -> String.valueOf(tempVal);
    return this.value.map(m).orElse("?");
  }

  /**
   * Map method taking in a transformer and returning a new Lazy instance with value transformed
   * @param t A transformer satisfying the relevant typing relationships
   * @param <S> the type of the value in the new Lazy instance
   * @return Returns a new Lazy instance
   */
  public <S> Lazy<S> map(Transformer<? super T, ? extends S> t) {
    Producer<S> output = () -> t.transform(this.get());
    return Lazy.of(output);
  }

  /**
   * flatMap method taking in a transformer and returning new Lazy instance
   * @param t A transformaer satisfying relevant typing relationships
   * @param <S> the type of the value in the new Lazy instance
   * @return Returns a new Lazy instance
   */
  public <S> Lazy<S> flatMap(Transformer<? super T, 
      ? extends Lazy<? extends S>> t) {
    Producer<S> output = () -> t.transform(this.get()).get();
    return Lazy.of(output);
  }


  /**
   * filter method which lazily tests if the value passes the test or not
   * @param c takes in a BooleanCondition against which the value in Lazy is tested
   * @return returns a Lazy-Boolean object based on test output
   */
  public Lazy<Boolean> filter(BooleanCondition<? super T> c) {
    Producer<Boolean> tempProd = () -> c.test(this.get());
    Lazy<Boolean> output = Lazy.of(tempProd);
    return output;
  }


  /**
   * Performs an eager operation that causes 
   * the values to be evaluated (if not already cached).
   * Only returns true if both objects being compared are Lazy
   * @param obj takes in an object to be compared
   * @return returns True if values in both are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Lazy) {
      Lazy<?> temp = (Lazy<?>) obj;
      if (this.get().equals(temp.get())) {
        return true;
      }
    }
    return false; 
  }


  /**
   * Method to lazily combine the two Lazy objects
   * @param lazy The lazy object to be combined
   * @param combiner A combiner implementation based on which 2 object will be combined
   * @param <S> Type of value A which is to be combined
   * @param <R> Type of value in lazy instance which is returned
   * @return a new Lazy object after combining the 2 objects
   */
  public <S, R> Lazy<R> combine(Lazy<? extends S> lazy, 
      Combiner<? super T, ? super S, ? extends R> combiner) {
    Lazy<R> output = Lazy.of(() -> combiner.combine(this.get(), lazy.get()));
    return output;
  }


}
