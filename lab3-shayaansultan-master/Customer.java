//@author Sultan Shayaan (Group 14C)

class Customer {

  private int customerId;
  private double serviceTime;
  private String type;

  public Customer(int customerId, double serviceTime, int typeNum) {
    this.customerId = customerId;
    this.serviceTime = serviceTime;
    if (typeNum == 0) {
      type = "Deposit";
    } else if (typeNum == 1) {
      type = "Withdrawal";
    } else if (typeNum == 2) {
      type = "OpenAccount";
    }
  }

  @Override
  public String toString() {
    String s = String.format("C%d", this.customerId);
    return s;
  }

  public String toStringType() {
    String s = String.format("C%d %s", this.customerId, this.type);
    return s;
  }

  public double getServiceTime() {
    return this.serviceTime;
  }

  public double endTimeGenerator(double currTime) {
    double endTime = this.serviceTime + currTime;
    return endTime;
  }

}


