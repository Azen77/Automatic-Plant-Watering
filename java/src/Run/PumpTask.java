package Run;

import org.firmata4j.Pin;
import java.io.IOException;
import java.util.TimerTask;

public class PumpTask extends TimerTask {
    private final Pin Pump;

    public PumpTask(Pin Pump) {
        this.Pump = Pump;
    }

    @Override
    public void run() {
        try {
            Pump.setValue(1);
            Thread.sleep(50);
            Pump.setValue(0);
        } catch (IOException | InterruptedException e) {
            System.out.print("");
        }
    }
}