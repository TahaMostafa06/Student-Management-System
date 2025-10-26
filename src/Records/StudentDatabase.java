package Records;

import java.io.IOException;
import java.util.ArrayList;

public class StudentDatabase extends Database<Student> {
    private ArrayList<Student> records;
    private String filename;

    public StudentDatabase(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Student createRecordFrom(String text) {
        String comma_regex = "[,]"; 
        String[] arr = text.split(comma_regex);
        int StudentID = Integer.parseInt(arr[0]);
        String FullName = arr[1];
        int Age = Integer.parseInt(arr[2]);
        Boolean Gender = Boolean.parseBoolean(arr[3]);
        String Department = arr[4];
        Double GPA = Double.parseDouble(arr[5]);
        Student eu = new Student(StudentID, FullName, Age, Gender, Department, GPA);
        return eu;
    }
}
