package ai.infrrd;

public class GuitarStoreSimulator {
    private int numberOfCustomers;

    public GuitarStoreSimulator(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public void startSimulation() {
        Thread currentThread;
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer temp = new Customer(i);
            currentThread = new Thread(temp);
            currentThread.start();
        }
    }
}