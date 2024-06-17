public class Admin extends Person {

    public Admin(String name,String password, String email, String phoneNumber) {
        super(name,"admin",password,email, phoneNumber); 
    }
    public void addEmployee(String name, String email, String phoneNumber, String post) {
        Employee newEmployee = new Employee(name, email, phoneNumber, post);
        System.out.println("New employee added:\n" + newEmployee);
    }
    public void viewEmployeeDetails(Employee employee) {
        System.out.println("Employee details:\n" + employee);
    }
    @Override
    public String toString() {
        return super.toString(); 
    }
}
