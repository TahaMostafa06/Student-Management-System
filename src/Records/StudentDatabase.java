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
        String comma_regex = "[,]"; /*
                                     * method that helps in readFromFile and createRecordFrom
                                     * methods
                                     */
        String[] arr = text.split(comma_regex);
        int StudentID = Integer.parseInt(arr[0]);
        String FullName = arr[1];
        int Age = Integer.parseInt(arr[2]);
        boolean Gender = Boolean.parseBoolean(arr[3]);
        String Department = arr[4];
        int GPA = Integer.parseInt(arr[5]);
        Student eu = new Student(StudentID, FullName, Age, Gender, Department, GPA);
        return eu;
    }
}
