// @author Sultan Shayaan (Group 14C)

class JoinQueue extends Event {
  private Customer customer;
  private Bank currBank;

  //Constructor
  public JoinQueue(double time, Customer customer, Bank currBank) {
    super(time);
    this.customer = customer;
    this.currBank = currBank;
  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": %s joined queue %s", this.customer.toString(), 
        this.currBank.queueToString());
    return super.toString() + str;
  }
  
  @Override
  public Event[] simulate() {
    currBank.queueAdd(this.customer);
    return new Event[] {};
  }
   




}
 
