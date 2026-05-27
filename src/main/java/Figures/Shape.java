package Figures;

public abstract class Shape {
    private String fillColor;
    private String borderColor;

    public Shape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void printInfo() {
        System.out.println("Фигура: " + getClass().getSimpleName());
        System.out.printf("Периметр: %.2f\n", getPerimeter());
        System.out.printf("Площадь: %.2f\n", getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-----------------------------------");
    }
}