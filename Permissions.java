// This Enum defines constants for various permissions.
// Each constant is associated with a unique integer value.
public enum Permissions {

    // Constants representing different permissions, each with a unique integer value.
    LOGIN(1), 
    ADD_NEW_COURSE(2), 
    DISPLAY_ALL_COURSES(4), 
    SEARCH_COURSE_BY_TITLE(8), 
    SEARCH_COURSE_BY_INSTRUCTOR(16), 
    DISPLAY_COURSES_BY_AREA(32), 
    REGISTER_FOR_COURSE(64);  

    // Declares a private final integer variable named value.
    // This variable holds the integer value associated with each permission.
    private final int value;

    // Constructor to initialize the permission with its associated integer value.
    Permissions(int value) {
        this.value = value; // Set the value for this permission
    }

    // Getter method to retrieve the integer value of the permission.
    public int getValue() {
        return value; // Return the associated value
    }
}
