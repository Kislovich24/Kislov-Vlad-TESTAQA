public class MathOperations {

    // 1. Факториал числа
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 2. Площадь треугольника
    public static double triangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Размеры должны быть больше нуля");
        }
        return 0.5 * base * height;
    }

    // 3. Арифметические действия и 4. Сравнение двух чисел
    public static double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неверная операция: " + operation);
        }
    }

    // 4. Метод сравнения двух чисел
    public static int compare(double a, double b) {
        return Double.compare(a, b);
    }
}