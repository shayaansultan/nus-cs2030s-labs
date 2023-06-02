// @author Sultan Shayaan (Group 14C)

class ServiceBegin extends Event{
  private Customer customer ;
  private Counter counter ;
  
  ServiceBegin(double time, Customer customer, Counter counter) {
    super(time) ;
    this.customer = customer ;
    this.counter = counter ;
  }
    
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d service begin (by Counter %d)", 
        this.customer.getId(), this.counter.getCounterId());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    // The current event is a service-begin event.  
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.counter.makeBusy();
    double endTime = this.getTime() + this.customer.getServiceTime();
    return new Event[] { 
      new ServiceEnd(endTime, this.customer, this.counter)
    } ;
  }
}
