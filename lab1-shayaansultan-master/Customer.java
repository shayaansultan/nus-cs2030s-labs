//@author Sultan Shayaan (Group 14C)

class Customer {

  private int customerId ;
  private double serviceTime ;

  public Customer(int customerId, double serviceTime) {
  
    this.customerId = customerId ;
    this.serviceTime = serviceTime ;
  }

  public int getId() {
    return customerId ;
  }

  public double getServiceTime() {
    return this.serviceTime ;
  }

}


