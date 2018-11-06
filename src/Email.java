import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String departement;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "companyname.com";

    // Constructor to receive firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: "+this.firstName+" "+this.lastName);

        this.departement = setDepartment();
        System.out.println("Department: "+this.departement);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password: "+this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departement + "." + companySuffix;
        System.out.println("NEW EMAIL IS: "+ email);
    }

    // Ask for the departement
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) return "sales";
        else if(depChoice == 2) return "dev";
        else if(depChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; ++i) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
