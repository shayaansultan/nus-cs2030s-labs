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
    int availCounter = currBank.findAvailCounter();
    if (availCounter == -1) {
      // If no such counter can be found, check if queue is full.
      // If queue full, customer departs
      // If queue not full, customer added to queue
      if (currBank.queueIsFull()) {
        return new Event[] {
          new Departure(this.getTime(), customer)
        };
      } else {
        return new Event[] {
          new JoinQueue(this.getTime(), customer, currBank)
        };
      }
    
    } else {
      // Else, the customer should go the the first 
      // available counter and get served.
      return new Event[] { 
        new ServiceBegin(this.getTime(), this.customer, this.currBank, 
            availCounter)
      };
    }

  }

}
