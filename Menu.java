import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Person> people;
    private List<Course> courses;
    private Person currentUser;
    private Scanner scanner;

    public Menu(List<Person> people, List<Course> courses) {
        this.people = people;
        this.courses = courses;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            if (currentUser == null) {
                loginMenu();
            } else {
                mainMenu();
            }
        }
    }

    private void loginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = getIntInput();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Person person : people) {
            if (person.getPersonName().equals(username) && person.getPassword().equals(password)) {
                currentUser = person;
                System.out.println("Login successful. Welcome, " + currentUser.getPersonName() + "!");
                return;
            }
        }
        System.out.println("Login failed. Please try again.");
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Search course by title");
            System.out.println("4. Search course by instructor");
            System.out.println("5. Display courses by area");
            System.out.println("6. Register for a course");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    searchCourseByTitle();
                    break;
                case 4:
                    searchCourseByInstructor();
                    break;
                case 5:
                    displayCoursesByArea();
                    break;
                case 6:
                    registerForCourse();
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("You have logged out.");
                    return;
            }
        }
    }

    private void addNewCourse() {
        if (!currentUser.hasPermission(Permissions.ADD_NEW_COURSE.getValue())) {
            System.out.println("Permission denied to add new course.");
            return;
        }

        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter instructor: ");
        String instructor = scanner.nextLine();
        System.out.print("Enter course area: ");
        String area = scanner.nextLine();
        System.out.print("Enter credit hours: ");
        int creditHours = getIntInput();

        Course newCourse = new Course(title, instructor, area, creditHours);
        courses.add(newCourse);
        System.out.println("New course added: " + newCourse);
    }

    private void displayAllCourses() {
        if (!currentUser.hasPermission(Permissions.DISPLAY_ALL_COURSES.getValue())) {
            System.out.println("Permission denied to display courses.");
            return;
        }
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private void searchCourseByTitle() {
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found course: " + course);
                return;
            }
        }
        System.out.println("Course not found.");
    }

    private void searchCourseByInstructor() {
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        for (Course course : courses) {
            if (course.getInstructor().equalsIgnoreCase(instructor)) {
                System.out.println("Found course: " + course);
                return;
            }
        }
        System.out.println("Course not found.");
    }

    private void displayCoursesByArea() {
        System.out.print("Enter course area: ");
        String area = scanner.nextLine();
        boolean found = false;
        for (Course course : courses) {
            if (course.getArea().equalsIgnoreCase(area)) {
                System.out.println(course);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found in this area.");
        }
    }

    private void registerForCourse() {
        System.out.print("Enter course title to register: ");
        String title = scanner.nextLine();

        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                System.out.println("You have successfully registered for " + course.getTitle());
                return;
            }
        }
        System.out.println("Course not found.");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
        }
        int input = scanner.nextInt();
        scanner.nextLine(); 
        return input;
    }
}
