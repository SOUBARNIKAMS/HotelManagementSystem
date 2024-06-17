public class Employee extends Person {
    private String post;
    private double salary;
    public Employee(String name, String email, String phoneNumber, String post) {
        super(name, "Employee", "", email, phoneNumber); // Empty password
        this.post = post;
        setSalary(post);
    }
    public void setSalary(String post) {
        switch (post.toLowerCase()) {
            case "chef":
                this.salary = 40000;
                break;
            case "server":
                this.salary = 20000;
                break;
            case "manager":
                this.salary = 30000;
                break;
            case "housekeeping":
                this.salary = 15000;
                break;
            default:
                this.salary = 0; 
        }
    }
    @Override
    public String toString() {
        return super.toString() +
               "\nPost=" + post +
               "\nSalary=" + salary;
    }
}
