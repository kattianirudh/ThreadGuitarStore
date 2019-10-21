package ai.infrrd.Audio;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

public class PlaySound {
    public void playSound()
    {
        String gongFile = "/home/users015/IdeaProjects/AnirudhGuitarStore/src/main/java/ai/infrrd/Audio/guitar-music-[AudioTrimmer.com].wav";
        InputStream in = null;
        try {
            in = new FileInputStream(gongFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
    }
}
