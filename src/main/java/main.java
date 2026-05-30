public class main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(10, 5));
        printIsPositive(-5);
        System.out.println(isNegative(-10));
        printStringMultipleTimes("Java", 3);
        System.out.println(isLeapYear(2024));
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        int[] myArr = createArray(5, 10);
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2
    public static void checkSumSign() {
        int b = -20;
        int a = 10;
        if (a + b >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    // Задание 3
    public static void printColor() {
        int value = 50;
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    // Задание 4
    public static void compareNumbers() {
        int a = 5, b = 10;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
    // Задание 5
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание 6
    public static void printIsPositive(int x) {
        if (x >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    // Задание 7
    public static boolean isNegative(int x) {
        return x < 0;
    }

    // Задание 8
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // Задание 9
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Задание 10
    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }
    }

    // Задание 11
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    // Задание 12
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
    }

    // Задание 13
    public static void fillDiagonal() {
        int[][] matrix = new int[5][5]; // Пример для квадрата 5х5
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
    }

    // Задание 14
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}