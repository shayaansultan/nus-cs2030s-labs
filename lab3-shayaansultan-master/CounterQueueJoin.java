// @author Sultan Shayaan (Group 14C)

class CounterQueueJoin extends Event {
  private Customer customer;
  private Counter counter;

  //Constructor
  public CounterQueueJoin(double time, Customer customer, Counter counter) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }


  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s joined counter queue (at S%s)", this.customer.toString(), 
        this.counter.counterQueueToString());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    counter.addToQueue(this.customer);
    return new Event[] {};
  }
   




}
 
