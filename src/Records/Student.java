package Records;
public class Student implements Record{
    private final String FullName, Department;
    int StudentID, Age;
    double GPA;
    boolean Gender;
    public Student(int StudentID, String FullName, int Age, boolean Gender, String Department, double GPA) {
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
            return String.valueOf(this.StudentID);
    }
    
    public String getName() {
            return this.FullName;
    }
    
    public Integer getAge() {
            return this.Age;
    }
     
    public Boolean getGender() {
            return this.Gender;
    }
    
    public String getDepartment(){
            return this.Department;
    }
    
    public Double getGPA(){
            return this.GPA;
    }
}
