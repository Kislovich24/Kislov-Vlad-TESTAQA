package Animals;

public class Dog extends Animal {
    public static int dogCount = 0;

    public Dog(String name) {
        // Передаем имя, лимит бега (500) и лимит плавания (10)
        super(name, 500, 10);
        dogCount++;
    }
}