public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Парк: " + parkName +
                    " | Аттракцион: " + name +
                    " | Время работы: " + workingHours +
                    " | Стоимость: " + cost + " руб.");
        }
    }
}