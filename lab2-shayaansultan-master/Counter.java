//@author Sultan Shayaan (Group 14C)

class Counter {
  private int counterId;
  private boolean available = true;


  public Counter(int counterId) {
    this.counterId = counterId;
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

}
