package ai.infrrd.guitar;

import ai.infrrd.Audio.PlaySound;

import static ai.infrrd.electricity.Electricity.guitarsList;

public class ElectricGuitar extends Guitar {
    boolean isPoweredOn = true;
    PlaySound sound = new PlaySound();

    public void play() {
        long start = System.currentTimeMillis();
        System.out.println("Playing electric guitar");
        //while (this.isPoweredOn && (System.currentTimeMillis() - start) <= 5000) {
        for(int i=0;i<5;i++) {
            if (this.isPoweredOn && (System.currentTimeMillis() - start) <= 5000) {
                try {
                    Thread.sleep(1000);
                    this.sound.playSound();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setPoweredOn(boolean state) {
        this.isPoweredOn = state;
    }

    public boolean isPoweredOn() {
        return this.isPoweredOn;
    }

    public void plugIn() {
        guitarsList.add(this);
    }

    public void plugOut() {
        guitarsList.remove(this);
    }
}
