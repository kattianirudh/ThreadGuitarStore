package ai.infrrd.guitar;

public interface Connectable {
    void setElectriciyState(Boolean state);
    void getElectriciyState();
    void plugIn();
    void plugOut();
}
