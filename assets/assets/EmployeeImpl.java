class Employee {
// declare a static counter
static int cntr = 100;
// declare instance variable
private int empId;
private String empName;
// declare a constructor
Employee(String empName) {
// autoincrement the emp id
cntr += 1;
// assign emp id
this.empId = cntr;
this.empName = empName;
}
// add setters and getters
public void setEmpName(String empName) {
this.empName = empName;
}
public String getEmpName() {
return this.empName;
}
public int getEmpId() {
return this.empId;
}
}
class EmployeeImpl {
public static void main(String[] args) {
Employee e1 = new Employee("Akshay");
Employee e2 = new Employee("Pranav");
Employee e3 = new Employee("Nishant");
System.out.println("Employee 1: ");
System.out.println("Emp id: " + e1.getEmpId());
System.out.println("Emp Name: " + e1.getEmpName());
System.out.println("\nEmployee 2: ");
System.out.println("Emp id: " + e2.getEmpId());
System.out.println("Emp Name: " + e2.getEmpName());
System.out.println("\nEmployee 3: ");
System.out.println("Emp id: " + e3.getEmpId());
System.out.println("Emp Name: " + e3.getEmpName());
}
}