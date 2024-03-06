package lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents(){
        Student[] students = new Student[5];
        students[0] = new Student("Popescu", 5);
        students[1] = new Student("Andrei", 5);
        students[2] = new Student("Radu", 3);
        students[3] = new Student("Mihaila", 6.25);
        students[4] = new Student("Doru", 7);

        return students;
    }
}
