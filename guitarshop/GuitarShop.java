package ai.infrrd.guitarshop;

import ai.infrrd.electricity.Electricity;
import ai.infrrd.guitar.AcousticGuitar;
import ai.infrrd.guitar.ElectricGuitar;
import ai.infrrd.guitar.Guitar;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import static java.util.Arrays.asList;

public class GuitarShop {
    Electricity electricity = new Electricity();
    public List<ElectricGuitar> guitarsList = new ArrayList();
    private List<Salesman> freeSalesmenList = new ArrayList<>();
    private List<Salesman> busySalesmenList = new ArrayList<>();

    public GuitarShop() {
        electricity.start();
        for(int i=0;i<3;i++)
            freeSalesmenList.add(new Salesman());
    }

    private static GuitarShop instance = new GuitarShop();
    private Random randomGenerator = new Random();
    List<Class<? extends Guitar>> guitars = asList(ElectricGuitar.class, AcousticGuitar.class);
    int randomIndex = randomGenerator.nextInt(guitars.size());
    Class currentGuitar = (guitars.get(randomIndex));

    public static GuitarShop getInstance() {
        return instance;
    }

    public synchronized Salesman assignSalesman() throws IllegalAccessException, InstantiationException {
        Salesman tempSalesman = this.freeSalesmenList.size() >0 ? this.freeSalesmenList.remove(0) : null;
        if(tempSalesman!=null) tempSalesman.setGuitar((Guitar) currentGuitar.newInstance());
        if (tempSalesman != null) this.busySalesmenList.add(tempSalesman);
        return tempSalesman;
    }

    public synchronized Salesman freeSalesman() {
        return this.freeSalesmenList.size() >0 ? this.freeSalesmenList.remove(0) : null;
    }
}
