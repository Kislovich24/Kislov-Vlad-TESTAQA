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
        studentList.add(new Student("Петр Петров", "Б-202", 2, Arrays.asList(2, 3, 2, 3))); // Ср. балл < 3 (будет удален)
        studentList.add(new Student("Анна Сидорова", "А-101", 1, Arrays.asList(5, 5, 5, 4)));
        studentList.add(new Student("Елена Смирнова", "В-303", 3, Arrays.asList(3, 3, 4, 3)));

        System.out.println("Исходный список студентов:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Процесс обработки студентов:");
        // 1. Сначала удаляем неуспевающих
        Upgrade.removeLowPerformingStudents(studentList);

        // 2. Затем переводим оставшихся на следующий курс
        Upgrade.promoteStudents(studentList);
        System.out.println();

        System.out.println("Список студентов после обработки:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();

        // Создаем коллекцию Set из оставшихся студентов
        Set<Student> studentSet = new HashSet<>(studentList);

        // Проверяем курсы с 1 по 4
        for (int course = 1; course <= 4; course++) {
            Upgrade.printStudents(studentSet, course);
        }
    }
}