// @author Sultan Shayaan (Group 14C)

class ServiceEnd extends Event {
  private Customer customer;
  private Counter counter;
  
  public ServiceEnd(double time, Customer customer, Counter counter) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d service done (by Counter %d)",
        this.customer.getId(), this.counter.getCounterId());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.counter.makeAvailable();
    return new Event[] {
      new Departure(getTime(), this.customer)
    };
  }
}

