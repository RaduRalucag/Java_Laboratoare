package lab1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Course {
    private String name;
    private double minimumGrade;
    Student[] students;

    public Student chooseStudentRandomly(){
        Random random = new Random();
        int random_int = random.nextInt(students.length);
        return students[random_int];
    }

    public Student[] showAllPassingStudents(){
        Student[] passingStudents = new Student[students.length];
        int i=0;
        for(Student student : students){
            if(student.getGrade() >= minimumGrade){
                passingStudents[i] = student;
                i++;
            }
        }
        return passingStudents;
    }

    public Boolean isStudentPassing(int index){
        return students[index].getGrade() > minimumGrade;
    }

    public Boolean isStudentPassing(String nume){
        for(Student student : students){
            if(student.getName().equals(nume))
                return student.getGrade() > minimumGrade;
        }
        return false;
    }
}
