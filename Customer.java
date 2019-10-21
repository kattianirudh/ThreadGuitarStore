package ai.infrrd;

import ai.infrrd.electricity.Electricity;
import ai.infrrd.guitar.ElectricGuitar;
import ai.infrrd.guitar.Guitar;
import ai.infrrd.guitarshop.GuitarShop;
import ai.infrrd.guitarshop.Salesman;


public class Customer implements Runnable {
    int currentCustomer;
    Customer(int currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
    public enum mood {
        HAPPY, SAD, DISAPPOINTED;
    }

    private mood feedback;
    private Salesman assignedSalesman = null;
    private GuitarShop shop = GuitarShop.getInstance();
    Thread t;

    @Override
    public void run() {
        System.out.println("----Customer "+currentCustomer+" enters the shop----");
        long start = System.currentTimeMillis();
        do {
            try {
                assignedSalesman = shop.assignSalesman();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        } while (assignedSalesman == null && (System.currentTimeMillis() - start) <= 30000);

        if (assignedSalesman != null) {
            if (assignedSalesman.getGuitar() instanceof ElectricGuitar) {
                assignedSalesman.plugInGuitar();
            }
            assignedSalesman.tuneGuitar();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            feedback = assignedSalesman.playGuitar();
        } else {
            feedback = mood.DISAPPOINTED;
        }
        System.out.println("-----The customer "+currentCustomer+" is leaving the shop----");
        System.out.println("**Customer "+currentCustomer+" Feedback is :"+feedback+"**");
        shop.freeSalesman();
    }

//    void enterStore() {
//        t = new Thread(new Customer(currentCustomer));
//        t.start();
//    }

}
