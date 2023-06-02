// @author Sultan Shayaan (Group 14C)

class ServiceBegin extends Event {
  private Customer customer;
  private Bank currBank;
  private int counterId;
  
  ServiceBegin(double time, Customer customer, Bank bank, int counterId) {
    super(time);
    this.customer = customer;
    this.currBank = bank;
    this.counterId = counterId;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s begin (by S%d)", 
        this.customer.toStringType(), this.counterId);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    // The current event is a service-begin event.  
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.currBank.makeCounterBusy(this.counterId);
    double endTime = this.getTime() + this.customer.getServiceTime();
    return new Event[] { 
      new ServiceEnd(endTime, this.customer, this.currBank, 
          this.counterId)
    };
  }
}
