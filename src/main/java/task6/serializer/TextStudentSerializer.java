package task6.serializer;

import java.io.OutputStream;
import task6.Student;

public class TextStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        String studentData = student.getFullName() + " " + student.getCourseInformation() + "\n";
        try {
            outputStream.write(studentData.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}