package ai.infrrd.guitarshop;

import ai.infrrd.Customer;
import ai.infrrd.guitar.ElectricGuitar;
import ai.infrrd.guitar.Guitar;

public class Salesman<T extends Guitar> {
    Guitar guitar;

    public T getGuitar() {
        System.out.println("The guitar is ----"+ guitar.getClass().getSimpleName()+"-----");
        return (T) guitar;
    }

    public void setGuitar(T guitar) {
        this.guitar = (Guitar) guitar;
    }

    public void tuneGuitar() {
        this.guitar.tune();
    }

    public Customer.mood playGuitar() {
        long playStartTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - playStartTime) <= 5000) {
            this.guitar.play();
            if (this.guitar instanceof ElectricGuitar && !(((ElectricGuitar) this.guitar).isPoweredOn())) {
                return Customer.mood.SAD;
            }
        }
        return Customer.mood.HAPPY;
    }

    public void plugInGuitar() {
        if (this.guitar instanceof ElectricGuitar) {
            ((ElectricGuitar) this.guitar).plugIn();
        }
    }
}
