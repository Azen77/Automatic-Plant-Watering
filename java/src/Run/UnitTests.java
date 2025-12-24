package Run;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {

    @Test
    void testTwoDecimalPoint() {
        double testValue = 2.2312222;
        String expected = "2.23";

        assertEquals(expected, Graph.TwoDecimalPoint(testValue));
    }

    @Test
    void testXAxisScaling() {
        int WIDTH = 300;
        int DIVISIONSX = 15;

        double expected = 100;
        // testing 5th iteration of the loop
        assertEquals(expected, 5 * Graph.XScale(WIDTH, DIVISIONSX));
    }

    @Test
    void testYAxisScaling() {
        int HEIGHT = 1023;
        int DIVISIONS = 20;

        double expected = 255.75;
        // testing 5th iteration of the loop
        assertEquals(expected, 5 * Graph.YScale(HEIGHT, DIVISIONS));
    }
}