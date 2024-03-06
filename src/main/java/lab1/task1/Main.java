package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args){
//        Student[] students = StudentAllocator.createStudents();
//        Course course = new Course("PAO", 5, students);
//        System.out.println(course.chooseStudentRandomly());
//
//        for(Student student : course.showAllPassingStudents()){
//            System.out.println(student);
//        }
//
//        System.out.println(course.isStudentPassing(1));
//        System.out.println(course.isStudentPassing("Doru"));

        DummyCalculator calculator = new DummyCalculator();
        calculator.calculate();
    }
}
