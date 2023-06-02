//@author Sultan Shayaan (Group 14C)

class Counter implements Comparable<Counter> {
  private int counterId;
  private boolean available = true;
  private Queue<Customer> waitlist;


  public Counter(int counterId, int qLength) {
    this.counterId = counterId;
    this.waitlist = new Queue<>(qLength);
  }
  
  @Override
  public String toString() {
    String s = String.format("S%d", this.counterId);
    return s;
  }

  public boolean getAvail() {
    return this.available;
  }

  public void makeAvailable() {
    this.available = true;
  }

  public void makeBusy() {
    this.available = false;
  }

  public int counterQueueLength() {
    return this.waitlist.length();
  }

  public String counterQueueToString() {
    String s = String.format("%d %s", this.counterId, waitlist.toString());
    return s;
  }

  public Customer getFromQueue() {
    return this.waitlist.deq();
  }

  public boolean addToQueue(Customer customer) {
    return this.waitlist.enq(customer);
  }

  public boolean queueFull() {
    return waitlist.isFull();
  }

  public boolean queueEmpty() {
    return waitlist.isEmpty();
  }

  @Override
  public int compareTo(Counter c2) {
    int l1 = this.waitlist.length();
    int l2 = c2.counterQueueLength();

    if (l1 == l2) {
      return 0;
    } else if (l1 > l2) {
      return 1;
    } else {
      return -1;
    }

  }
  
}
