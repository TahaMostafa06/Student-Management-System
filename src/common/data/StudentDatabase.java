package common.data;

import java.io.IOException;
import java.util.ArrayList;

public class StudentDatabase extends Database<Student> {

    private static final ArrayList<StudentDatabase> instances = new ArrayList<>();

    public StudentDatabase(String filename) throws IOException {
        super(filename);
    }

    public static StudentDatabase getInstance(String filename) throws IOException {
        for (var i : instances) {
            if (i.filename.equals(filename))
                return i;
        }
        var db = new StudentDatabase(filename);
        instances.add(db);
        return db;
    }

    @Override
    public Student createRecordFrom(String text) {
        String[] arr = text.split("[,]");
        int id = Integer.parseInt(arr[0]);
        String name = arr[1];
        int age = Integer.parseInt(arr[2]);
        String gender = arr[3];
        String department = arr[4];
        Double gpa = Double.valueOf(arr[5]);
        Student student = new Student(id, name, age, gender, department, gpa);
        return student;
    }
}
