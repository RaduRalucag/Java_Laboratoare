package lab1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private double grade;

    @Override
    public String toString(){
        return "Studentul " + name + " a obtinut nota " + grade;
    }
}
