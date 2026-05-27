import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MathOperationsTest {

    @Test
    public void testFactorial() {
        assertEquals(MathOperations.factorial(5), 120);
        assertEquals(MathOperations.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialException() {
        MathOperations.factorial(-1);
    }

    @Test
    public void testTriangleArea() {
        assertEquals(MathOperations.triangleArea(4, 5), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaException() {
        MathOperations.triangleArea(-4, 5);
    }

    @Test
    public void testCalculate() {
        assertEquals(MathOperations.calculate(6, 4, '+'), 10.0);
        assertEquals(MathOperations.calculate(6, 4, '-'), 2.0);
        assertEquals(MathOperations.calculate(6, 4, '*'), 24.0);
        assertEquals(MathOperations.calculate(6, 4, '/'), 1.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testCalculateException() {
        MathOperations.calculate(6, 0, '/');
    }

    @Test
    public void testCompare() {
        assertTrue(MathOperations.compare(3, 5) < 0);
        assertEquals(MathOperations.compare(5, 5), 0);
        assertTrue(MathOperations.compare(7, 5) > 0);
    }
}