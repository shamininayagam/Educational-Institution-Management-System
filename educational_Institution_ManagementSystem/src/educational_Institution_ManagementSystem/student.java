package educational_Institution_ManagementSystem;
import java.util.*;

public class student {
    private String studentId;
    private String name;
    private Map<String, Integer> grades = new HashMap<>();
    private Map<String, Integer> credits = new HashMap<>();
    private String courseEnrolled;

    public student(String studentId, String name, String courseEnrolled) {
        this.studentId = studentId;
        this.name = name;
        this.courseEnrolled = courseEnrolled;
    }

    // Getter method for studentId for checking duplication part 
    public String getStudentId() {
        return studentId;
    }

    // Modified addGrade method to include credit
    public void addGrade(String subject, int score, int credit) {
        grades.put(subject, score);  // Store grade for the subject
        credits.put(subject, credit); // Store credit for the subject
    }

    // GPA calculation
    public double calculateGPA() {
        double totalPoints = 0.0;
        double totalCredits = 0.0;
        for (String subject : grades.keySet()) {
            int score = grades.get(subject);
            int credit = credits.get(subject);
            double gradePoint = getGradePoint(score);
            totalPoints += (gradePoint * credit);
            totalCredits += credit;
        }
        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }

    // Convert score to grade point
    private double getGradePoint(int score) {
        if (score >= 90) return 10;
        if (score >= 80) return 9;
        if (score >= 70) return 8;
        if (score >= 60) return 7;
        if (score >= 50) return 6.5;
        if (score >= 40) return 6;
        return 0;
    }

    // Displaying all the student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course Enrolled: " + courseEnrolled);
        System.out.println("Grades: " + grades);
        System.out.println("Credits: " + credits);
        System.out.println("GPA: " + calculateGPA());
    }
}
