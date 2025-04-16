package Run;

import edu.princeton.cs.introcs.StdDraw;
import org.firmata4j.Pin;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static Run.SoilState.*;

public class Graph {
    public final int WIDTH;
    public final int HEIGHT;
    private final Pin MoistureSensor;
    public final Pin Pump;

    Graph(int width, int height, Pin moistureSensor, Pin pump) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.MoistureSensor = moistureSensor;
        this.Pump = pump;
    }

    static double YScale(int HEIGHT, int DIVISIONS) {
        return (double) HEIGHT /DIVISIONS;
    }

    static double XScale(int WIDTH, int DIVISIONSX) {
        return (double) WIDTH /DIVISIONSX;
    }

    static String TwoDecimalPoint(double Number) {
        return String.format("%.2f",Number);
    }

    public void graphThis() throws InterruptedException, IOException {
        ArrayList<Double> sensorData = new ArrayList<>();
        HashMap<Double,Double> sensorDataSeconds = new HashMap<>();
// Graph setup
        StdDraw.setXscale(-25, WIDTH);
        StdDraw.setYscale(-50, HEIGHT);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0,0,WIDTH,0);
        StdDraw.line(0,0,0,HEIGHT);

    // Axis scales
        int DIVISIONS = 20;
        int DIVISIONSX = 15;

        Font small = new Font("Times New Roman", Font.PLAIN,16);
        StdDraw.setFont(small);

        for (int i = 0; i <= DIVISIONS; i++) {
            StdDraw.setPenColor(StdDraw.BLACK);
        // x-axis
            if (i <= DIVISIONSX) {
                StdDraw.line(i*XScale(WIDTH, DIVISIONSX), -10, i*XScale(WIDTH, DIVISIONSX), 10);
                StdDraw.text(i*XScale(WIDTH, DIVISIONSX), -35, "" + ((WIDTH / 10)*i / DIVISIONSX));
            }
        // y-axis
            StdDraw.line(-3, i*YScale(HEIGHT,DIVISIONS),3,i*YScale(HEIGHT,DIVISIONS));
            StdDraw.text(-15, i*YScale(HEIGHT,DIVISIONS), TwoDecimalPoint(i*YScale(5,DIVISIONS)));

            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            if (i>0) { StdDraw.line(3, i*YScale(HEIGHT,DIVISIONS),WIDTH,i*YScale(HEIGHT,DIVISIONS)); }

        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((double) WIDTH /2,-70,"Time(s)");
        StdDraw.text(-35,(double) HEIGHT /2,"Voltage(V)",90);
        StdDraw.text((double) WIDTH /2,HEIGHT + 20,"Moisture Sensor vs Time");

// Graph data
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < WIDTH; i++) {
            double sensorValue = MoistureSensor.getValue();
            sensorData.add(i, sensorValue);
            StdDraw.point(i, sensorValue);
            if (i>0){ StdDraw.line(i,sensorData.get(i),(i-1), sensorData.get(i-1)); }

            SoilState(MoistureSensor,Pump);
            sensorDataSeconds.put(i*0.1, ((sensorValue*5)/1023));
            Thread.sleep(100);
        }
    // Testing if Hashmap actually stores in Seconds:Voltage
        System.out.printf("%.2f",sensorDataSeconds.get(15.00));

    }
}