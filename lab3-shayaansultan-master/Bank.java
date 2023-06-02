// @author Sultan Shayaan (Group 14C)
//

class Bank {
  
  private Array<Counter> allCounters;
  private Queue<Customer> waitlist;
  private int numCounters;
  
  public Bank(int numCounters, int maxLengthQ, int counterQueueLength) {
    this.waitlist = new Queue<>(maxLengthQ);
    this.numCounters = numCounters;
    this.allCounters = new Array<>(numCounters);
    for (int i = 0; i < numCounters; i++) {
      allCounters.set(i, new Counter(i, counterQueueLength));
    }
  }


  
  public Counter findAvailCounter() {
    Counter output = null;
    for (int i = 0; i < numCounters; i++) {
      if (allCounters.get(i).getAvail()) {
        output = allCounters.get(i);
        break;
      }
    }
    return output;
  }



  public boolean queueIsFull() {
    return waitlist.isFull();
  }

  public boolean queueIsEmpty() {
    return waitlist.isEmpty();
  }


  public boolean queueAdd(Customer customer) {
    return waitlist.enq(customer);
  }

  public String queueToString() {
    return waitlist.toString();
  }

  public Customer queueRemove() {
    Customer output = (Customer) waitlist.deq();
    return output;
  }


  public Counter minCounter() {
    return this.allCounters.min();
  }

}

