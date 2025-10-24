package Records;
public class Student implements Record{
    private final String FullName, Department;
    boolean Gender;
    int StudentID, Age, GPA;
    public Student(int StudentID, String FullName, int Age, boolean Gender, String Department, int GPA) {
            this.StudentID = StudentID;
            this.FullName = FullName;
            this.Age = Age;
            this.Gender = Gender;
            this.Department = Department;
            this.GPA = GPA;
    }

    @Override
    public String lineRepresentation() {
            String representation = "";
            representation += this.StudentID + ",";
            representation += this.FullName + ",";
            representation += this.Age + ",";
            representation += this.Gender + ",";
            representation += this.Department + ",";
            representation += this.GPA;
            return representation;
    }

    @Override
    public String getSearchKey() {
            return Integer.toString(this.StudentID);
    }
}
