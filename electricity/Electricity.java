package ai.infrrd.electricity;

import ai.infrrd.guitar.ElectricGuitar;
import ai.infrrd.guitar.Guitar;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Electricity extends Thread {
    boolean electricityState = true;
    public static List<ElectricGuitar> guitarsList = new ArrayList<>();

    public void toggleStates() {
        this.electricityState = this.electricityState ? false : true;
        //System.out.println("The current state of electricity is:"+electricityState);
        for (ElectricGuitar e: guitarsList) {
            e.setPoweredOn(this.electricityState);
        }
    }

    public void run() {
        try {
            for(int i=0;i<10;i++) {
                Thread.sleep(30000);
                toggleStates();
                Thread.sleep(2000);
                toggleStates();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
