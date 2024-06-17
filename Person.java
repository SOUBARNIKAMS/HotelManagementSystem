public class Person {
    protected String name;
    private String type;
    private String password;
    private String email;
    private String phoneNumber;
    public Person(String name, String type, String password, String email, String phoneNumber) {
        this.name = name;
        this.type = type;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    @Override
    public String toString() {
        return "Name=" + name +
               "\nEmail=" + email +
               "\nPhone Number=" + phoneNumber +
               "\nType=" + type;
    }
}
