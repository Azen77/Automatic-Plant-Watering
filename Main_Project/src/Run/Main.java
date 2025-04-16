package Run;

import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;
import static Run.Pins.*;


public class Main {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 1023;

    public static void main(String[] args) throws IOException, InterruptedException {
        IODevice arduino = new FirmataDevice("COM5");

        arduino.start();
        arduino.ensureInitializationIsDone();
        System.out.println("Board connected");

        Pin Pot = arduino.getPin(A0);
        Pot.setMode(Pin.Mode.ANALOG);

        Pin MoistureSensor = arduino.getPin(17);
        MoistureSensor.setMode(Pin.Mode.ANALOG);

        Pin Pump = arduino.getPin(2);
        Pump.setMode(Pin.Mode.OUTPUT);

        Graph graphObject = new Graph(WIDTH,HEIGHT,Pot,Pump);
        graphObject.graphThis();

    }
}
