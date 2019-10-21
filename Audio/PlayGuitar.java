package ai.infrrd.Audio;
import java.io.*;
import sun.audio.*;

public class PlayGuitar {
    public static void main(String[] args)
            throws Exception
    {
        // open the sound file as a Java input stream
        String gongFile = "/Downloads/guitar-music.wav";
        InputStream in = new FileInputStream(gongFile);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}
