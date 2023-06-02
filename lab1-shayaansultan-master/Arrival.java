// @author Sultan Shayaan (Group 14C)

class Arrival extends Event {
  private Customer customer ;
  private Counter[] allCounters ;

  //Constructor
  public Arrival(int customerId, double arrivalTime, double serviceTime, Counter[] allCounters) {
    super(arrivalTime) ;
    this.customer = new Customer(customerId, serviceTime) ;
    this.allCounters = allCounters ;
    
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d arrives", this.customer.getId());

    return super.toString() + str;
  }

  private int findAvailCounter(Counter[] allCounters) {
    int count = -1 ;
    for (int i = 0; i < allCounters.length ; i++) {
      if (allCounters[i].getAvail()) {
        count = i;
        break;
      }
    }
    return count ;
  }


  @Override
  public Event[] simulate() {
    // Find the first available counter.
    int counter = findAvailCounter(allCounters) ;
    if (counter == -1) {
      // If no such counter can be found, the customer
      // should depart.
      return new Event[] {new Departure(this.getTime(), customer)};

      } 
      
    else {
      // Else, the customer should go the the first 
      // available counter and get served.
      Counter assignedCounter = allCounters[counter] ;
      return new Event[] { 
        new ServiceBegin(this.getTime(), this.customer, assignedCounter)
      };
    }

  }

}
