// @author Sultan Shayaan (Group 14C)

class Arrival extends Event {
  private Customer customer;
  private Bank currBank;

  //Constructor
  public Arrival(int customerId, double arrivalTime, double serviceTime, 
      int customerType, Bank currBank) {
    super(arrivalTime);
    this.customer = new Customer(customerId, serviceTime, customerType);
    this.currBank = currBank;
    
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s arrived %s", this.customer.toString(), 
        this.currBank.queueToString());

    return super.toString() + str;
  }

  @Override
  public Event[] simulate() {
    // Find the first available counter.
    Counter availCounter = currBank.findAvailCounter();
    if (availCounter == null) {
      Counter minCounter = currBank.minCounter();
      if (minCounter.queueFull()) {
        if (currBank.queueIsFull()) {
          return new Event[] {new Departure(getTime(), customer)};
        } else {
          return new Event[] {new BankQueueJoin(getTime(), customer, currBank)};
        } 
      } else {
        return new Event[] {new CounterQueueJoin(getTime(), customer, minCounter)};
      } 
    } else {
      return new Event[] {new ServiceBegin(getTime(), customer, currBank, availCounter)};
    }
  }
}