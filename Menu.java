import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Person> people; // List of registered people (users)
    private List<Course> courses; // List of available courses
    private Person currentUser; // Currently logged-in user
    private Scanner scanner; // Scanner for user input

    // Constructor to initialize Menu with people and courses
    public Menu(List<Person> people, List<Course> courses) {
        this.people = people; // Initialize people list
        this.courses = courses; // Initialize courses list
        this.scanner = new Scanner(System.in); // Initialize scanner for input
    }

    // Start method to control the flow of the menu
    public void start() {
        try {
            while (true) {
                if (currentUser == null) {
                    loginMenu(); // Show login menu if no user is logged in
                } else {
                    mainMenu(); // Show main menu if a user is logged in
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error : " + e.getMessage());
            System.out.println("The application will now exit.");
            System.exit(1);
        }
    }

    // Display login menu options
    private void loginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = getIntInput(); // Get user choice

        switch (choice) {
            case 1:
                login(); // Attempt to log in
                break;
            case 2:
                System.exit(0); // Exit the application
                break;
            default:
                System.out.println("Invalid option. Please try again."); // Handle invalid input
        }
    }

    // Method to handle user login
    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine(); // Get username
        System.out.print("Enter password: ");
        String password = scanner.nextLine(); // Get password

        // Check credentials against registered people
        for (Person person : people) {
            if (person.getPersonName().equals(username) && person.getPassword().equals(password)) {
                currentUser = person; // Set current user upon successful login
                System.out.println("Login successful. Welcome, " + currentUser.getPersonName() + "!");
                return;
            }
        }
        System.out.println("Login failed. Please try again."); // Handle failed login
    }

    // Display main menu options for logged-in users
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

            int choice = getIntInput(); // Get user choice

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid option. Please try again."); // Handle invalid input
                continue;
            }

            // Execute corresponding action based on user choice
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
                    currentUser = null; // Log out the current user
                    System.out.println("You have logged out.");
                    return;
            }
        }
    }

    // Method to add a new course
    private void addNewCourse() {
        // Check if the current user has permission to add a new course
        if (!currentUser.hasPermission(Permissions.ADD_NEW_COURSE.getValue())) {
            System.out.println("Permission denied to add new course.");
            return; // Exit method if no permission
        }

        // Collect course details from the user
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter instructor: ");
        String instructor = scanner.nextLine();
        System.out.print("Enter course area: ");
        String area = scanner.nextLine();
        System.out.print("Enter credit hours: ");
        int creditHours = getIntInput();

        // Create new course and add it to the list
        Course newCourse = new Course(title, instructor, area, creditHours);
        courses.add(newCourse);
        System.out.println("New course added: " + newCourse);
    }

    // Method to display all courses
    private void displayAllCourses() {
        // Check if the current user has permission to display courses
        if (!currentUser.hasPermission(Permissions.DISPLAY_ALL_COURSES.getValue())) {
            System.out.println("Permission denied to display courses.");
            return; // Exit method if no permission
        }
        System.out.println("Courses:");
        // Print each course in the list
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Method to search for a course by title
    private void searchCourseByTitle() {
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        // Search for the course in the list
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found course: " + course);
                return; // Exit method if course is found
            }
        }
        System.out.println("Course not found."); // Handle not found case
    }

    // Method to search for a course by instructor
    private void searchCourseByInstructor() {
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        // Search for the course in the list
        for (Course course : courses) {
            if (course.getInstructor().equalsIgnoreCase(instructor)) {
                System.out.println("Found course: " + course);
                return; // Exit method if course is found
            }
        }
        System.out.println("Course not found."); // Handle not found case
    }

    // Method to display courses by area
    private void displayCoursesByArea() {
        System.out.print("Enter course area: ");
        String area = scanner.nextLine();
        boolean found = false; // Flag to track if any courses were found
        // Search for courses in the specified area
        for (Course course : courses) {
            if (course.getArea().equalsIgnoreCase(area)) {
                System.out.println(course);
                found = true; // Set flag if a course is found
            }
        }
        if (!found) {
            System.out.println("No courses found in this area."); // Handle no courses found
        }
    }

    // Method to register for a course
    private void registerForCourse() {
        System.out.print("Enter course title to register: ");
        String title = scanner.nextLine();

        // Search for the course to register
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                System.out.println("You have successfully registered for " + course.getTitle());
                return; // Exit method if registration is successful
            }
        }
        System.out.println("Course not found."); // Handle not found case
    }

    // Method to get an integer input from the user
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number."); // Handle invalid input
            scanner.next(); // Clear invalid input
        }
        int input = scanner.nextInt(); // Read integer input
        scanner.nextLine(); // Consume the newline character
        return input; // Return the valid input
    }
}