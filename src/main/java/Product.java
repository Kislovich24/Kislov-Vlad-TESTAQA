public class Product {
    // Поля класса
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isBooked;

    // Конструктор для заполнения всех полей
    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isBooked = isBooked;
    }

    // Метод вывода информации об объекте в консоль
    public void printInfo() {
        System.out.println("Товар: " + name +
                " | Дата производства: " + productionDate +
                " | Производитель: " + manufacturer +
                " | Страна: " + countryOfOrigin +
                " | Цена: " + price +
                " | Забронирован: " + (isBooked ? "Да" : "Нет"));
    }
}