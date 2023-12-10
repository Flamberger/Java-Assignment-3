import java.util.ArrayList;
public class Student {
    private String name;
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    private boolean fullTime;

    ArrayList<Grade> grades = new ArrayList<>();

    // constructor
    public Student(String n, String dep, int a, String un, int sn, boolean ft) {
        name = n;
        department = dep;
        age = a;
        userName = un;
        studentNumber = sn;
        fullTime = ft;
    }

    // getter methods
    public String GetName() {
        return name;
    }
    public String GetDepartment() {
        return department;
    }
    public int GetAge() {
        return age;
    }
    public String GetUsername() {
        return userName;
    }
    public int GetStudentNumber() {
        return studentNumber;
    }
    public boolean GetFullTime() {
        return fullTime;
    }

    // setter methods
    public void SetName(String n) {
        name = n;
    }
    public void SetDepartment(String n) {
        department = n;
    }
    public void SetAge(int n) {
        age = n;
    }
    public void SetUsername(String n) {
        userName = n;
    }
    public void SetStudentNumber(int n) {
        studentNumber = n;
    }
    public void SetFullTime(boolean n) {
        fullTime = n;
    }
}
