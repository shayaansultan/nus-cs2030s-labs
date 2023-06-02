// @author Sultan Shayaan (Group 14C)
//

class Bank {
  
  private Counter[] allCounters;
  private Queue waitlist;
  
  public Bank(int numCounters, int maxLengthQ) {
    this.allCounters = new Counter[numCounters];
    for (int i = 0; i < this.allCounters.length; i++) {
      allCounters[i] = new Counter(i);
    }
    this.waitlist = new Queue(maxLengthQ);
  }

  public int findAvailCounter() {
    int count = -1;
    for (int i = 0; i < this.allCounters.length; i++) {
      if (allCounters[i].getAvail()) {
        count = i;
        break;
      }
    }
    return count;
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

  public void makeCounterAvail(int counterId) {
    Counter currCounter = allCounters[counterId];
    currCounter.makeAvailable();
  }

  public void makeCounterBusy(int counterId) {
    Counter currCounter = allCounters[counterId];
    currCounter.makeBusy();
  }


}

