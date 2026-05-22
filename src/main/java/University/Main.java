package University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Создаем изначальный список студентов
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Иван Иванов", "А-101", 1, Arrays.asList(4, 5, 3, 4)));
        studentList.add(new Student("Петр Петров", "Б-202", 2, Arrays.asList(2, 3, 2, 3)));
        studentList.add(new Student("Анна Сидорова", "А-101", 1, Arrays.asList(5, 5, 5, 4)));
        studentList.add(new Student("Елена Смирнова", "В-303", 3, Arrays.asList(3, 3, 4, 3)));

        System.out.println("Исходный список студентов:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        // Обрабатываем список через класс Upgrade
        System.out.println("Процесс обработки студентов:");
        Upgrade.processStudents(studentList);
        System.out.println();

        System.out.println("Список студентов после обработки:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        // Создаем коллекцию Set из оставшихся студентов
        Set<Student> studentSet = new HashSet<>(studentList);

        for (int course = 1; course <= 4; course++) {
            Upgrade.printStudents(studentSet, course);
        }
    }
}