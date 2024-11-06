public class Person {

    //---Attributes---//

    // Variable for ID, useful for searching by person ID
    private int personID;
    // Variable for the name, used for login in the system
    private String personName;
    // Variable for the password, used for login in the system
    private String password;
    // Variable for permission level (e.g., Admin, Student, etc.)
    private int permission;

    //---Constructor---//

    // Constructor to initialize a Person object with ID, name, password, and permission
    public Person(int personID, String personName, String password, int permission) {
        this.personID = personID;          // Set the person's ID
        this.personName = personName;      // Set the person's name
        this.password = password;          // Set the person's password
        this.permission = permission;      // Set the person's permission level
    }

    //---Methods---//

    // Getter method to retrieve the person's ID
    public int getPersonID() {
        return personID;
    }

    // Getter method to retrieve the person's name
    public String getPersonName() {
        return personName;
    }

    // Getter method to retrieve the person's password
    public String getPassword() {
        return password;
    }

    // Getter method to retrieve the person's permission level
    public int getPermission() {
        return permission;
    }
    
    // Method to check if the person has a specific permission
    public boolean hasPermission(int perm) {
        return (this.permission & perm) == perm; // Bitwise check for permission
    }
}
