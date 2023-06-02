// @author Sultan Shayaan (Group 14C)

class Departure extends Event {
  private Customer customer ;
  

  public Departure (double time, Customer customer) {
    super(time) ;
    this.customer = customer ;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {} ;

  }

  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d departed", this.customer.getId());
    return super.toString() + str;
  }

}
