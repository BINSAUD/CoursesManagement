import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create lists to store people and courses
        List<Person> people = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        // Initialize Person objects with their ID, name, password, and permissions
        Person admin = new Person(1, "admin", "123", 127); // Admin with all permissions
        Person student = new Person(3, "shady", "123", 64); // Student with permission to register for courses

        // Add Person objects to the people list
        people.add(admin);
        people.add(student);
        // Initialize Course objects and add them to the courses list
        courses.add(new Course("Mathematics", "ayman", "Science", 3)); // Math course
        courses.add(new Course("Biology", "shady", "Science", 3)); // Biology course
        courses.add(new Course("History", "m3aod", "Arts", 4)); // History course
        courses.add(new Course("Computer Science", "Khalid", "Technology", 3)); // CS course

        // Create a Menu object with the people and courses lists
        Menu menu = new Menu(people, courses);
        // Start the menu system
        menu.start();
    }
}