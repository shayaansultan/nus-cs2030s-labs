//@author Sultan Shayaan (Group 14C)

class Counter {
  private int counterId ;
  private boolean available = true ;

  public Counter(int counterId) {
    this.counterId = counterId ;
  }

  public int getCounterId() {
    return this.counterId ;
  }

  public void setCounterId(int id) {
    this.counterId = id ;
  }

  public boolean getAvail() {
    return this.available ;
  }

  public void makeAvailable() {
    this.available = true ;
  }

  public void makeBusy() {
    this.available = false ;
  }

}
