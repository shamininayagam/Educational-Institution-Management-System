package educational_Institution_ManagementSystem;

import java.util.*;

public class Management {
    private static ArrayList<student> students = new ArrayList<>();
    private static ArrayList<teacher> teachers = new ArrayList<>();
    private static ArrayList<staff> staffMembers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- Educational Institution Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View Teachers");
            System.out.println("5. Add Staff");
            System.out.println("6. View Staff");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> addTeacher(scanner);
                case 4 -> viewTeachers();
                case 5 -> addStaff(scanner);
                case 6 -> viewStaff();
                case 7 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        // Check if the student ID already exists
        for (student stu : students) {
            if (stu.getStudentId().equals(id)) {
                System.out.println("Error: A student with this ID already exists.");
                return;  // Exit 
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course Enrolled: ");
        String course = scanner.nextLine();

        //object creation for student 
        student stu = new student(id, name, course);

        int numSubjects = 0;
        boolean validInput = false;

        
        while (!validInput) {
            try {
                System.out.print("Enter number of subjects: ");
                numSubjects = scanner.nextInt();
                scanner.nextLine();

                if (numSubjects <= 0 || numSubjects > 6) {
                    System.out.println("A student can have only up to 6 subjects so Please enter a valid number.");
                } else {
                    validInput = true; // valid means exit here
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }

        // Add grades for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter Subject " + (i + 1) + ": ");
            String subject = scanner.nextLine();
            System.out.print("Enter Score: ");
            int score = scanner.nextInt();
            System.out.print("Enter Credit (1-3): ");
            int credit = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            stu.addGrade(subject, score, credit);
        }

        students.add(stu);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (student stu : students) {
                stu.displayStudentDetails();
                System.out.println("-------");
            }
        }
    }

    private static void addTeacher(Scanner scanner) {
        String id = "";
        boolean validId = false;

        
        while (!validId) {
            System.out.print("Enter Teacher ID: ");
            id = scanner.nextLine();
            
            for (teacher t : teachers) {
                if (t.getTeacherId().equals(id)) {
                    System.out.println("Error: A teacher with this ID already exists.");
                    return;  // Exit 
                }
            }
            if (id.length() > 1 && id.charAt(0) == 't' && id.substring(1).matches("\\d+")) {
                int teacherIdNumber = Integer.parseInt(id.substring(1));
                if (teacherIdNumber >= 1 && teacherIdNumber <= 500) {
                    validId = true; // Valid teacher ID checking 
                } else {
                    System.out.println("Teacher ID does not exist.");
                }
            } else if (id.length() > 1 && id.charAt(0) == 's' && id.substring(1).matches("\\d+")) {
                System.out.println("The given ID is for a staff member so Please enter a valid teacher ID");
            } else {
                System.out.println("Invalid teacher ID.");
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 

        teacher t = new teacher(id, name, salary);

        int numSubjects = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter number of subjects taught (at least 1): ");
                numSubjects = scanner.nextInt();
                scanner.nextLine();

                if (numSubjects <= 0) {
                    System.out.println("A teacher must have at least one subject.");
                } else {
                    validInput = true; //valid-exits
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter Subject " + (i + 1) + ": ");
            String subject = scanner.nextLine();
            t.addSubject(subject);
        }

        teachers.add(t);
        System.out.println("Teacher added successfully!");
    }

    private static void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers to display.");
        } else {
            for (teacher t : teachers) {
                t.displayTeacherDetails();
                System.out.println("----");
            }
        }
    }

    private static void addStaff(Scanner scanner) {
        String id = "";
        boolean validId = false;

        // Validate staff ID
        while (!validId) {
            System.out.print("Enter Staff ID : ");
            id = scanner.nextLine();
            for (staff st : staffMembers) {
                if (st.getStaffId().equals(id)) {
                    System.out.println("Error: A staff member with this ID already exists.");
                    return;  // Exit here
                }
            }
            if (id.length() > 1 && id.charAt(0) == 's' && id.substring(1).matches("\\d+")) {
                int staffIdNumber = Integer.parseInt(id.substring(1));
                if (staffIdNumber >= 1 && staffIdNumber <= 300) {
                    validId = true; 
                } else {
                    System.out.println("Staff ID does not exist. Please enter a valid ID:");
                }
            } else {
                System.out.println("Invalid staff ID");
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        System.out.print("Enter Department (Administration, Library, Maintenance): ");
        String department = scanner.nextLine();

        String[] validDepartments = {"Administration", "Library", "Maintenance","administration","library","maintenance"};
        boolean validDepartment = false;

        for (String dept : validDepartments) {
            if (department.equalsIgnoreCase(dept)) {
                validDepartment = true;
                break;
            }
        }

        if (!validDepartment) {
            System.out.println("Invalid department. Please enter a valid department.");
            return;
        }

        staff st = new staff(id, name, role, department);
        staffMembers.add(st);
        System.out.println("Staff added successfully!");
    }

    private static void viewStaff() {
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members to display.");
        } else {
            for (staff st : staffMembers) {
                st.displayStaffDetails();
                System.out.println("----");
            }
        }
    }
}
