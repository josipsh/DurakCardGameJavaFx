package hr.algebra.sharedModel;

public class User {
    private final int userId;
    private final String FirstName;
    private final String LastName;
    private String MiddleName;
    private final String userName;

    public User(int userId, String firstName, String lastName, String userName) {
        this.userId = userId;
        FirstName = firstName;
        LastName = lastName;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getUserName() {
        return userName;
    }
}
