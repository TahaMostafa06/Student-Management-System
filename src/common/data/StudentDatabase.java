package common.data;

import java.io.IOException;

public class StudentDatabase extends Database<Student> {

    public StudentDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Student createRecordFrom(String text) {
        String[] arr = text.split("[,]");
        int id = Integer.parseInt(arr[0]);
        String name = arr[1];
        int age = Integer.parseInt(arr[2]);
        String gender = arr[3];
        String department = arr[4];
        Double gpa = Double.parseDouble(arr[5]);
        Student student = new Student(id, name, age, gender, department, gpa);
        return student;
    }
}
