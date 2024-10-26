public class Person {
    private int personID;
    private String personName;
    private String password;
    private int permission;

    public Person(int personID, String personName, String password, int permission) {
        this.personID = personID;
        this.personName = personName;
        this.password = password;
        this.permission = permission;
    }

    public int getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPassword() {
        return password;
    }

    public int getPermission() {
        return permission;
    }

    public boolean hasPermission(int perm) {
        return (this.permission & perm) == perm;
    }
}
