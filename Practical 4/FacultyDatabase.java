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
        System.out.println("Professor");
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
        System.out.println("Staff");
        super.displayDetails();
        System.out.println("Designation: " + designation);
        System.out.println("Years of Service: " + yearsOfService);
    }
}

public class FacultyDatabase {
    public static void main(String args[]) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n- University Faculty Database -");
            System.out.println("1. Add Professor");
            System.out.println("2. Add Staff");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {
                int ch = Integer.parseInt(sc.nextLine());
                switch(ch) {
                    case 1 -> {
                        System.out.print("\nEnter Employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();
                        System.out.print("Enter Research Interest: ");
                        String interest = sc.nextLine();
                        employees.add(new Professor(id, name, salary, department, interest));
                        System.out.println("Professor added successfully!");
                    }
                    case 2 -> {
                        System.out.print("\nEnter Employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter Designation: ");
                        String designation = sc.nextLine();
                        System.out.print("Enter Years of Service: ");
                        int years = Integer.parseInt(sc.nextLine());
                        employees.add(new Staff(id, name, salary, designation, years));
                        System.out.println("Staff added successfully!");
                    }
                    case 3 -> {
                        System.out.println("\n- Employee Details -");
                        System.out.println("-------------------------");
                        for(Employee emp : employees) {
                            emp.displayDetails();
                            System.out.println("-------------------------");
                        }
                    }
                    case 4 -> {
                        System.out.println("\nExiting...");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("\nInvalid option! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("\nAn unexpected error occured: " + e.getMessage());
            }
        }
    }
}
