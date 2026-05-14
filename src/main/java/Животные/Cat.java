package Животные;

class Cat extends Animal {
    public static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int appetite) {
        if (bowl.decreaseFood(appetite)) {
            this.isFull = true;
            System.out.println(name + " покушал " + appetite + " еды. Теперь он сыт.");
        } else {
            System.out.println(name + " не трогал еду. В миске мало еды для него (нужно " + appetite + ").");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}