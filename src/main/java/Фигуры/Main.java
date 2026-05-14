package Фигуры;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0, "Красный", "Черный"),
                new Rectangle(4.0, 6.0, "Синий", "Белый"),
                new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый")
        };

        // Вызов дефолтного метода printInfo() для каждой фигуры
        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}