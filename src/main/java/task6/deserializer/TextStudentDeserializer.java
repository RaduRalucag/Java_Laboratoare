package task6.deserializer;

import task6.Student;

import java.io.InputStream;
import java.util.Scanner;

public class TextStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream)) {
            String fullName = scanner.nextLine();
            return new Student(fullName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}