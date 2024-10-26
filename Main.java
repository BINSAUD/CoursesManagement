import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        Person admin = new Person(1, "admin", "admin123", 127); // All permissions
        Person admin2 = new Person(1, "admin2", "admin123", 127); // All permissions
        Person instructor1 = new Person(2, "ayman", "ayman123", 28); // Can display and search courses
        Person student1 = new Person(3, "ff", "ff123", 64); // Can register for courses
        Person supervisor = new Person(4, "ss", "ss123", 62); // Can manage courses

        people.add(admin);
        people.add(admin2);
        people.add(instructor1);
        people.add(student1);
        people.add(supervisor);

        courses.add(new Course("Mathematics", "ayman", "Science", 3));
        courses.add(new Course("Biology", "shady", "Science", 3));
        courses.add(new Course("History", "m3oad", "Arts", 4));
        courses.add(new Course("Computer Science", "Khalid", "Technology", 3));

        Menu menu = new Menu(people, courses);
        menu.start();
    }
}
