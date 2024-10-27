// Develop a program in Java for managing a student database system. Design a base class named "Student" with data members such as name, date of birth, blood group, and contact address. Another base class named "PhysicalAttributes" consists of data members for height and weight. Finally, a base class named "InsuranceInfo" holds the insurance policy number. The derived class "StudentRecord" contains additional data members for telephone numbers and driving license number. Implement a menu-driven program to perform operations such as building a master table, displaying records, inserting new entries, deleting entries, editing records, and searching for a specific record.

import java.util.Scanner;
import java.util.ArrayList;

// Base class: Student
class Student {
    String name;
    String dob;
    String bloodGroup;
    String contactAddress;

    public Student(String name, String dob, String bloodGroup, String contactAddress) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.contactAddress = contactAddress;
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Contact Address: " + contactAddress);
    }
}

// Base class: PhysicalAttributes
class PhysicalAttributes {
    double height;
    double weight;

    public PhysicalAttributes(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public void displayPhysicalAttributes() {
        System.out.println("Height: " + height + " meters");
        System.out.println("Weight: " + weight + " kg");
    }
}

// Base class: InsuranceInfo
class InsuranceInfo {
    String policyNumber;

    public InsuranceInfo(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void displayInsuranceInfo() {
        System.out.println("Insurance Policy Number: " + policyNumber);
    }
}

// Derived class: StudentRecord
class StudentRecord extends Student {
    PhysicalAttributes physicalAttributes;
    InsuranceInfo insuranceInfo;
    String phoneNumber;
    String drivingLicenseNumber;

    public StudentRecord(String name, String dob, String bloodGroup, String contactAddress,
                         double height, double weight, String policyNumber,
                         String phoneNumber, String drivingLicenseNumber) {
        super(name, dob, bloodGroup, contactAddress);
        this.physicalAttributes = new PhysicalAttributes(height, weight);
        this.insuranceInfo = new InsuranceInfo(policyNumber);
        this.phoneNumber = phoneNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public void displayRecord() {
        displayStudentInfo();
        physicalAttributes.displayPhysicalAttributes();
        insuranceInfo.displayInsuranceInfo();
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Driving License Number: " + drivingLicenseNumber);
        System.out.println("--------------------------------");
    }
}

public class StudentDatabaseSystem {
    private static ArrayList<StudentRecord> records = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Database System ---");
            System.out.println("1. Build Master Table");
            System.out.println("2. Display All Records");
            System.out.println("3. Insert New Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Edit Record");
            System.out.println("6. Search Record");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    buildMasterTable();
                    break;
                case 2:
                    displayAllRecords();
                    break;
                case 3:
                    insertNewEntry();
                    break;
                case 4:
                    deleteEntry();
                    break;
                case 5:
                    editRecord();
                    break;
                case 6:
                    searchRecord();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private static void buildMasterTable() {
        System.out.print("How many records would you like to enter? ");
        int numberOfRecords = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfRecords; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            insertNewEntry();
        }
        System.out.println("Master table built with " + numberOfRecords + " records.");
    }

    private static void displayAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (StudentRecord record : records) {
                record.displayRecord();
            }
        }
    }

    private static void insertNewEntry() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Date of Birth (dd-mm-yyyy): ");
        String dob = sc.nextLine();
        System.out.print("Enter Blood Group: ");
        String bloodGroup = sc.nextLine();
        System.out.print("Enter Contact Address: ");
        String contactAddress = sc.nextLine();
        System.out.print("Enter Height (in meters): ");
        double height = sc.nextDouble();
        System.out.print("Enter Weight (in kg): ");
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Insurance Policy Number: ");
        String policyNumber = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Driving License Number: ");
        String drivingLicenseNumber = sc.nextLine();

        StudentRecord newRecord = new StudentRecord(name, dob, bloodGroup, contactAddress, height, weight, policyNumber, phoneNumber, drivingLicenseNumber);
        records.add(newRecord);
        System.out.println("New entry added.");
    }

    private static void deleteEntry() {
        System.out.print("Enter Name of the student to delete: ");
        String name = sc.nextLine();
        boolean found = false;
        for (StudentRecord record : records) {
            if (record.name.equalsIgnoreCase(name)) {
                records.remove(record);
                System.out.println("Record deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }

    private static void editRecord() {
        System.out.print("Enter Name of the student to edit: ");
        String name = sc.nextLine();
        boolean found = false;
        for (StudentRecord record : records) {
            if (record.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new Phone Number: ");
                record.phoneNumber = sc.nextLine();
                System.out.println("Record updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }

    private static void searchRecord() {
        System.out.print("Enter Name of the student to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (StudentRecord record : records) {
            if (record.name.equalsIgnoreCase(name)) {
                record.displayRecord();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }
}
