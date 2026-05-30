package Animals;

public class Cat extends Animal {
    public static int catCount = 0;
    private boolean isFull = false;

    public Cat(String name) {
        // Передаем имя, лимит бега (200) и лимит плавания (0)
        super(name, 200, 0);
        catCount++;
    }

    public boolean isFull() {
        return isFull;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            this.isFull = true;
            System.out.println("Кот " + name + " съел " + amount + " еды.");
        } else {
            this.isFull = false;
            System.out.println("Кот " + name + " не смог поесть, мало еды.");
        }
    }
}