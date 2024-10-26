public class Course {
    private String title;
    private String instructor;
    private String area;
    private int creditHours;

    public Course(String title, String instructor, String area, int creditHours) {
        this.title = title;
        this.instructor = instructor;
        this.area = area;
        this.creditHours = creditHours;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getArea() {
        return area;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", area='" + area + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }
}
