public class Main {
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
