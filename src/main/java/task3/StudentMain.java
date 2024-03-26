package task3;

import java.util.HashMap;
import java.util.Map;

public class StudentMain {
    public static void main(String[] args) {
        Map<String, Double> courseInfo = new HashMap<>();
        courseInfo.put("Biologie", 8.5);
        courseInfo.put("Chimie", 9.0);

        Student originalStudent = new Student("Radu Raluca", courseInfo);

        try {
            Student clonedStudent = (Student) originalStudent.clone();

            originalStudent.getCourseInformation().put("Mate", 9.0);

            System.out.println("Student: " + originalStudent);
            System.out.println("Clona: " + clonedStudent);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
