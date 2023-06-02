import java.util.Scanner;


/**
 * This class implements a bank simulation.
 *
 * @author Sultan Shayaan (Group 14C)
 * @version CS2030S AY21/22 Semester 2
 */ 
class BankSimulation extends Simulation {

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  
  /** 
   * Main Bank
  */
  public Bank currBank;

  /** 
   * Constructor for a bank simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public BankSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();
    int queueLength = sc.nextInt();

    //Initializing the Bank
    Bank currBank = new Bank(numOfCounters, queueLength);

    //Creating Arrival Events
    int id = 0;
    while (sc.hasNextDouble() || sc.hasNextInt()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      int customerType = sc.nextInt();
      initEvents[id] = new Arrival(id, arrivalTime, serviceTime, 
          customerType, currBank);
      id += 1;
    } 

  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
