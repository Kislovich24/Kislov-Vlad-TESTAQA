public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Неверные данные в ячейке [%d][%d]: '%s' невозможно преобразовать в число", row, col, value));
    }
}
