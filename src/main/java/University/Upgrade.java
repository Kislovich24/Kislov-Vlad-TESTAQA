package University;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Upgrade {

    public static void removeLowPerformingStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                System.out.println("Студент отчислен за неуспеваемость: " + student.getName());
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.nextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("--- Студенты на " + course + " курсе ---");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("На данном курсе никто не обучается.");
        }
    }
}