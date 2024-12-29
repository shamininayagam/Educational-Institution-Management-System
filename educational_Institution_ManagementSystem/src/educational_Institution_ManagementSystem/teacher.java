package educational_Institution_ManagementSystem;

import java.util.ArrayList;

public class teacher {
    private String teacherId;
    private String name;
    private double salary;
    private ArrayList<String> subjects;

    // Constructor- inializing
    public teacher(String teacherId, String name, double salary) {
        this.teacherId = teacherId;
        this.name = name;
        this.salary = salary;
        this.subjects = new ArrayList<>();
    }

    // Getter for teacherId for checking duplication part 
    public String getTeacherId() {
        return teacherId;
    }

    

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void displayTeacherDetails() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Subjects: " + subjects);
    }
}
