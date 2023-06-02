package cs2030s.fp;

import java.util.NoSuchElementException;

/**
 * CS2030S Lab 5
 * AY22/23 Semester 2
 *
 * @author Shayaan Sultan (Lab Group 14C)
 */

public abstract class Maybe<T> { 

  public static <T> Maybe<T> none() {
    @SuppressWarnings("unchecked")
    Maybe<T> none = ((Maybe<T>) None.NONE);
    return none;
  }

  public static <T> Maybe<T> some(T t) {
    return new Some<>(t);
  }

  public static <T> Maybe<T> of(T t) {
    if (t == null) {
      return none();
    } else {
      return some(t);
    }
  }

  protected abstract T get() throws NoSuchElementException;

  public abstract Maybe<T> filter(BooleanCondition<? super T> t);

  public abstract <S> Maybe<S> map(Transformer<? super T, ? extends S> t);

  public abstract <S> Maybe<S> flatMap(Transformer<? super T, ? extends Maybe<? extends S>> t);

  public abstract T orElse(T things);

  public abstract T orElseGet(Producer<? extends T> t);

  public abstract void ifPresent(Consumer<? super T> t);


  private static class None extends Maybe<Object> {

    private static final Maybe<?> NONE = new None();

    
    @Override 
    public String toString() {
      return "[]";
    }
    
    @Override
    public boolean equals(Object other) {
      return other == NONE;
    }

    @Override
    public Object get() throws NoSuchElementException {
      throw new NoSuchElementException();
    }

    @Override
    public Maybe<Object> filter(BooleanCondition<? super Object> t) {
      return Maybe.none();
    }

    @Override
    public <S> Maybe<S> map(Transformer<? super Object, ? extends S> t) {
      return Maybe.none();
    }

    @Override
    public <S> Maybe<S> flatMap(Transformer<? super Object, ? extends Maybe<? extends S>> t) {
      return Maybe.none();
    }

    @Override
    public Object orElse(Object things) {
      return things;
    }

    @Override
    public Object orElseGet(Producer<? extends Object> t) {
      return t.produce();
    }

    @Override
    public void ifPresent(Consumer<? super Object> t) {
    }

  }

  private static final class Some<T> extends Maybe<T> {
    
    private final T things;

    public Some(T things) {
      this.things = things;
    }

    @Override 
    public String toString() {
      return "[" + things + "]";
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj instanceof Some<?>) {
        @SuppressWarnings ("Unchecked")
        Some<?> s = (Some<?>) obj;
        if (this.things == s.things) {
          return true;
        }
        if (this.things == null || s.things == null) {
          return false;
        }
        return this.things.equals(s.things);
      }
      return false;
    }
    
    @Override
    public T get() { 
      return this.things;
    }

    @Override
    public Maybe<T> filter(BooleanCondition<? super T> t) {
      if ((this.things != null) && !t.test(this.things)) {
        return Maybe.none();
      }
      return this;
    }

    @Override
    public <S> Maybe<S> map(Transformer<? super T, ? extends S> t) {
      S s = t.transform(this.things);
      return Maybe.some(s);
    }

    @Override
    public <S> Maybe<S> flatMap(Transformer<? super T, ? extends Maybe<? extends S>> t) {
      Maybe<? extends S> trans = t.transform(this.get());
      @SuppressWarnings("unchecked")
      Maybe<S> output = (Maybe<S>) trans;
      return output;
    }

    @Override
    public T orElse(T things) {
      return this.things;
    }

    @Override
    public T orElseGet(Producer<? extends T> t) {
      return this.things;
    }

    @Override
    public void ifPresent(Consumer<? super T> t) {
      t.consume(this.things);
    }

  }
 
}
