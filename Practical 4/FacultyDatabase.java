import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    private int empID;
    private String name;
    private double salary;

    public Employee(int empID, String name, double salary) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

class Professor extends Employee {
    private String dept;
    private String researchInterest;

    public Professor(int empID, String name, double salary, String dept, String researchInterest) {
        super(empID, name, salary);
        this.dept = dept;
        this.researchInterest = researchInterest;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + dept);
        System.out.println("Research Interests: " + researchInterest);
    }
}

class Staff extends Employee {
    private String designation;
    private int yearsOfService;

    public Staff(int empID, String name, double salary, String designation, int yearsOfService) {
        super(empID, name, salary);
        this.designation = designation;
        this.yearsOfService = yearsOfService;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Designation: " + designation);
        System.out.println("Years of Service: " + yearsOfService);
    }
}

public class FacultyDatabase {
    public static void main(String args[]) {
        ArrayList<Employee> emp = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n- University Faculty Database -");
            System.out.println("1. Add Professor");
            System.out.println("2. Add Staff");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
        }
    }
}