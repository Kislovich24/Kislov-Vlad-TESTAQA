import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    void testFactorial() {
        assertEquals(120, MathOperations.factorial(5));
        assertEquals(1, MathOperations.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> MathOperations.factorial(-1));
    }

    @Test
    void testTriangleArea() {
        assertEquals(10.0, MathOperations.triangleArea(4, 5));
        assertThrows(IllegalArgumentException.class, () -> MathOperations.triangleArea(-1, 5));
    }

    @Test
    void testCalculate() {
        assertEquals(10, MathOperations.calculate(6, 4, '+'));
        assertEquals(2, MathOperations.calculate(6, 4, '-'));
        assertEquals(24, MathOperations.calculate(6, 4, '*'));
        assertEquals(1.5, MathOperations.calculate(6, 4, '/'));
        assertThrows(ArithmeticException.class, () -> MathOperations.calculate(6, 0, '/'));
    }

    @Test
    void testCompare() {
        // Если первое число меньше второго, возвращает отрицательное число (< 0)
        assertTrue(MathOperations.compare(3, 5) < 0);

        // Если числа равны, возвращает 0
        assertEquals(0, MathOperations.compare(5, 5));

        // Если первое число больше второго, возвращает положительное число (> 0)
        assertTrue(MathOperations.compare(7, 5) > 0);
    }
}