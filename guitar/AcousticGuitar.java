package ai.infrrd.guitar;

import ai.infrrd.Audio.PlaySound;

public class AcousticGuitar extends Guitar {
    PlaySound sound = new PlaySound();

    public void play() {
        System.out.println("Acoustic Guitar playing");
        for(int i = 0;i<5;i++) {
            try {
                Thread.sleep(1000);
                this.sound.playSound();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
