// @author Sultan Shayaan (Group 14C)

class BankQueueJoin extends Event {
  private Customer customer;
  private Bank currBank;

  //Constructor
  public BankQueueJoin(double time, Customer customer, Bank currBank) {
    super(time);
    this.customer = customer;
    this.currBank = currBank;
  }


  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s joined bank queue %s", this.customer.toString(), 
        this.currBank.queueToString());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    currBank.queueAdd(this.customer);
    return new Event[] {};
  }
   




}
 
