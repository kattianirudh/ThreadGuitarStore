package ai.infrrd;

import ai.infrrd.Audio.PlaySound;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Customer customer1 = new Customer();
//        Thread t1 = new Thread(customer1);
//        t1.start();
//        Customer customer2 = new Customer();
//        Thread t2 = new Thread(customer2);
//        t2.start();
        GuitarStoreSimulator simulator = new GuitarStoreSimulator(2);
        simulator.startSimulation();
        //System.out.println("Hello World!");
    }
}
