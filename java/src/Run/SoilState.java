package Run;

import org.firmata4j.Pin;
import java.io.IOException;

public class SoilState {
    static void SoilState(Pin MoistureSensor,Pin Pump) throws InterruptedException, IOException {
        PumpTask Pumptask = new PumpTask(Pump);
        double sensorData = (MoistureSensor.getValue()* 5.0) / 1023;
        if (sensorData > 2.93){
            System.out.printf("%-33s %-3s %.2f\n", "Soil is dry. Pumping water", "V = ", sensorData);
            Pumptask.run();
        }
        else if (sensorData >= 2.64 && sensorData <= 2.93){
            System.out.printf("%-33s %-3s %.2f\n", "Soil is slightly wet. On standby", "V = ", sensorData);
        }
        else if (sensorData < 2.64){
            System.out.printf("%-33s %-3s %.2f\n", "Soil is wet. ", "V = ", sensorData);
        }
        else{
            System.out.println("N/A");
        }

    }
}
