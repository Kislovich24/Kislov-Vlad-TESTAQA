package Фигуры;

public interface Shape {
    default double getArea() {
        return 0.0;
    }

    default double getPerimeter() {
        return 0.0;
    }

    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Фигура: " + getClass().getSimpleName());
        System.out.printf("Периметр: %.2f", getPerimeter());
        System.out.printf("Площадь: %.2f", getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-----------------------------------");
    }
}
