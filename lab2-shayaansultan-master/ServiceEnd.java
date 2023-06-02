// @author Sultan Shayaan (Group 14C)

class ServiceEnd extends Event {
  private Customer customer;
  private Bank currBank;
  private int counterId; 
  
  public ServiceEnd(double time, Customer customer, Bank bank, int counterId) {
    super(time);
    this.customer = customer;
    this.currBank = bank;
    this.counterId = counterId;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s done (by S%d)", 
        this.customer.toStringType(), this.counterId);
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.currBank.makeCounterAvail(this.counterId);
    // If queue is empty, customer just leaves
    // If queue is not empty, customer leaves and new customer arrives
    if (currBank.queueIsEmpty()) {
      return new Event[] { 
        new Departure(getTime(), this.customer) 
      };
    } else {
      Customer waitingCustomer = currBank.queueRemove();
      return new Event[] {
        new Departure(getTime(), this.customer), new ServiceBegin(getTime(),
            waitingCustomer, this.currBank, this.counterId) 
      };
    }
  }
}

