public class Main {

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "ПРИВЕТ", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        System.out.println("--- Тест 1: Корректный массив ---");
        try {
            int result = checkAndSumArray(correctArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка в Тесте 1: " + e.getMessage());
        }

        System.out.println("\n--- Тест 2: Массив неверного размера ---");
        try {
            checkAndSumArray(wrongSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        System.out.println("\n--- Тест 3: Массив с некорректными данными ---");
        try {
            checkAndSumArray(wrongDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        System.out.println("\n--- Тест 4: Генерация и поимка ArrayIndexOutOfBoundsException ---");
        try {
            int[] smallArray = {1, 2, 3};
            int badElement = smallArray[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено стандартное исключение: " + e);
        }
    }

    public static int checkAndSumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива не соответствует 4x4 (неверное количество строк: " + array.length + ")");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Размер массива не соответствует 4x4 (в строке " + i + " количество элементов: " + array[i].length + ")");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }
}