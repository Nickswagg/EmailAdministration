package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPassowrdLenght = 10;
    private String alternateEmail;
    private String companySuffix = "bankofamerica.com";

    // Setting constructor to receive firstname and lastname
    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("EMAIL CREATED : " + this.firstName + " " +
        // this.lastName);

        // Call a method asking for the department and return the department
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPassowrdLenght);
        // System.out.println("Your password is : " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is : " + email);
    }

    // Ask for Department
    private String setDepartment() {
        System.out.print("New Worker: " + firstName
                + "DEPARTMENT CODES\n 1.for Sales\n 2.for Development\n 3.for Accounting\n 0.for None\n Enter Department code : ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    // Generate a Random Password
    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set Alternate Email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change Password
    public void changePassword(String password) {
        this.password = password;
    }

    // Get mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Get Alternate Email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Get Password
    public String getPassword() {
        return password;
    }

    // Method to show User infos
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: "
                + mailboxCapacity + "MB";
    }

}
