package Animals;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем животных для проверки базового задания
        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик");

        System.out.println("--- Проверка бега и плавания ---");
        dogBobik.run(150);
        dogBobik.swim(5);
        catBarsik.run(250); // Превысит лимит кота (200м)
        catBarsik.swim(5);  // Кот не умеет плавать

        System.out.println("--- Проверка миски с едой ---");
        // 2. Создаем миску с 25 единицами еды
        Bowl bowl = new Bowl(25);
        System.out.println("Еды в миске изначально: " + bowl.getFoodAmount());

        // Создаем массив из трех котов
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Пушок"),
                new Cat("Рыжик")
        };

        // Каждый кот пытается съесть по 10 единиц еды
        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println("--- Статус сытости котов ---");
        for (Cat cat : cats) {
            System.out.println("Кот " + cat.name + " сыт? -> " + cat.isFull());
        }

        System.out.println("--- Подсчет созданных животных ---");
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего собак: " + Dog.dogCount);
        System.out.println("Всего котов: " + Cat.catCount);
    }
}