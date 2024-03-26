package task6.serializer;

import task6.Student;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        StringBuilder studentData = new StringBuilder(student.getFullName() + " ");
        for (Map.Entry<String, Double> entry : student.getCourseInformation().entrySet()) {
            studentData.append(entry.getKey()).append(" ").append(entry.getValue()).append(" ");
        }
        studentData.append("\n");
        try {
            outputStream.write(studentData.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
