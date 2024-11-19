public class Course { 

    //---Attributes---//
    
    // Title of the course
    private String title;
    // Instructor of the course
    private String instructor;
    // Area of study the course belongs to
    private String area;
    // Number of credit hours for the course
    private int creditHours;

    //---Constructor---//
    
    // Constructor for initializing a Course object with title, instructor, area, and credit hours
    public Course(String title, String instructor, String area, int creditHours) {
        this.title = title;          // Set the course title
        this.instructor = instructor; // Set the instructor's name
        this.area = area;            // Set the area of study
        this.creditHours = creditHours; // Set the number of credit hours
    }

    //---Methods---//

    // Getter method for the course title
    public String getTitle() {
        return title;
    }

    // Getter method for the instructor's name
    public String getInstructor() {
        return instructor;
    }

    // Getter method for the area of study
    public String getArea() {
        return area;
    }

    // Getter method for the number of credit hours
    public int getCreditHours() {
        return creditHours;
    }

    // Overriding toString method to provide a string representation of the Course object
    @Override
    public String toString() {
        return '\n' +"Course" +
                "title=" + title + '\n' +
                "instructor= " + instructor + '\n' +
                "area= " + area + '\n' +
                "creditHours=" + creditHours + "\n\n\n"; // Format output with all course details
    }
}
