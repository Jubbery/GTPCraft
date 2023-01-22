import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

public class MicrophoneRecorder {

    private static final int NUM_BYTES_PER_SECOND = 16000;
    private static final int SECONDS_TO_RECORD = 5;
    private static final int NUM_BYTES_TO_RECORD = NUM_BYTES_PER_SECOND * SECONDS_TO_RECORD;

    public static byte[] record() {
        try {
            AudioFormat format = new AudioFormat(NUM_BYTES_PER_SECOND, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            byte[] bytes = new byte[NUM_BYTES_TO_RECORD];
            microphone.read(bytes, 0, bytes.length);

            microphone.stop();
            microphone.close();

            return bytes;
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
