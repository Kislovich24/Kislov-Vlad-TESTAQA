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
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "10.09.2024", "Apple Inc.", "USA", 6200, false);
        productsArray[2] = new Product("Xiaomi 14", "15.03.2024", "Xiaomi", "China", 4100, false);
        productsArray[3] = new Product("PlayStation 5 Pro", "07.11.2024", "Sony", "Japan", 3800, true);
        productsArray[4] = new Product("Nintendo Switch", "03.03.2017", "Nintendo", "Japan", 1500, false);

        for (Product product : productsArray) {
            product.printInfo();
        }

        Park centralPark = new Park("Центральный Парк");

        Park.Attraction rollerCoaster = centralPark.new Attraction("Американские горки", "10:00-22:00", 500.0);
        Park.Attraction ferrisWheel = centralPark.new Attraction("Колесо обозрения", "09:00-23:00", 300.0);

        rollerCoaster.printAttractionInfo();
        ferrisWheel.printAttractionInfo();
    }
}

