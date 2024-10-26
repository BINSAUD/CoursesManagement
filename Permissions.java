public enum Permissions {
    LOGIN(1), 
    ADD_NEW_COURSE(2), 
    DISPLAY_ALL_COURSES(4), 
    SEARCH_COURSE_BY_TITLE(8), 
    SEARCH_COURSE_BY_INSTRUCTOR(16), 
    DISPLAY_COURSES_BY_AREA(32), 
    REGISTER_FOR_COURSE(64);  

    private final int value;

    Permissions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
