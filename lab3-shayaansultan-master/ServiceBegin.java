// @author Sultan Shayaan (Group 14C)

class ServiceBegin extends Event {
  private Customer customer;
  private Bank currBank;
  private Counter counter;
  
  ServiceBegin(double time, Customer customer, Bank bank, Counter counter) {
    super(time);
    this.customer = customer;
    this.currBank = bank;
    this.counter = counter;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s begin (by S%s)", 
        this.customer.toStringType(), this.counter.counterQueueToString());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    // The current event is a service-begin event.  
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.counter.makeBusy();
    double endTime = this.customer.endTimeGenerator(this.getTime());
    return new Event[] { 
      new ServiceEnd(endTime, this.customer, this.currBank, 
          this.counter)
    };
  }
}
