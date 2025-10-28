package common.data;

public class Student implements Record {
    private String fullname;
    private String department;
    private final int studentId;
    private int age;
    private double gpa;
    private String gender;

    public Student(int studentId, String fullname, int age, String gender, String department, double gpa) {
        this.studentId = studentId;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    @Override
    public String lineRepresentation() {
        String representation = "";
        representation += this.studentId + ",";
        representation += this.fullname + ",";
        representation += this.age + ",";
        representation += this.gender + ",";
        representation += this.department + ",";
        representation += this.gpa;
        return representation;
    }

    @Override
    public String getSearchKey() {
        return String.valueOf(this.studentId);
    }

    public Integer getId() {
        return this.studentId;
    }

    public String getName() {
        return this.fullname;
    }

    public void setName(String name) {
        this.fullname = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getGpa() {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}