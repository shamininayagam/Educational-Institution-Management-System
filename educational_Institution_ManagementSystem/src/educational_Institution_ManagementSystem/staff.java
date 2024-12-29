package educational_Institution_ManagementSystem;

public class staff {
    private String staffId;
    private String name;
    private String role;
    private String department;

    // Constructor
    public staff(String staffId, String name, String role, String department) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    // Getter for staffId
    public String getStaffId() {
        return staffId;
    }

    // Method to display staff details
    public void displayStaffDetails() {
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Department: " + department);
    }
}
