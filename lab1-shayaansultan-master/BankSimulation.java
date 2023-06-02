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
   * List of all counters available
  */
  public static Counter[] allCounters ;

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

    /*available = new boolean[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      available[i] = true;
    }
    */
    
    //Creating an array of Counters
    allCounters = new Counter[numOfCounters] ;
    for (int i = 0; i < allCounters.length ; i++) {
      allCounters[i] = new Counter(i) ;
    }

    

    //Creating Arrival Events
    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      initEvents[id] = new Arrival(id, arrivalTime, serviceTime, allCounters) ;
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
