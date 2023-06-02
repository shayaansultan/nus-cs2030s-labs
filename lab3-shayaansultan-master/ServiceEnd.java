// @author Sultan Shayaan (Group 14C)

class ServiceEnd extends Event {
  private Customer customer;
  private Bank currBank;
  private Counter counter; 
  
  public ServiceEnd(double time, Customer customer, Bank bank, Counter counter) {
    super(time);
    this.customer = customer;
    this.currBank = bank;
    this.counter = counter;
  }
  
  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s done (by S%s)", 
        this.customer.toStringType(), this.counter.counterQueueToString());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    this.counter.makeAvailable();
    
    if (this.counter.queueEmpty()) {
      if (this.currBank.queueIsEmpty()) {
        return new Event[] {new Departure(getTime(), customer)};
      } else {
        Customer newServiceCustomer = currBank.queueRemove();
        return new Event[] {new Departure(getTime(), customer), 
          new ServiceBegin(getTime(), newServiceCustomer, currBank, counter)};
      }
    } else {
      if (this.currBank.queueIsEmpty()) {
        Customer newServiceCustomer = this.counter.getFromQueue();
        return new Event[] {
          new Departure(getTime(), this.customer),
          new ServiceBegin(getTime(), newServiceCustomer, currBank, counter)
        };
      } else {
        Customer newServiceCustomer = this.counter.getFromQueue();
        Customer newQueueCustomer = this.currBank.queueRemove();
        return new Event[] {
          new Departure(getTime(), this.customer),
          new ServiceBegin(getTime(), newServiceCustomer, currBank, counter),
          new CounterQueueJoin(getTime(), newQueueCustomer, counter)
        };
      }
    }
  }
}
