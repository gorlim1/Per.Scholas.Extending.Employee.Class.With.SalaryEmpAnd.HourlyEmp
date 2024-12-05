import java.util.Objects;
import java.util.Scanner;

public class Employee {

    //Declaration, initialization
    protected String firstName;
    protected String lastName;
    protected String title;
    protected String payType;
    protected double payRate;
    Scanner scanner = new Scanner(System.in);

    //Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


    //Default constructor
    public Employee() {
    }

    //Parameterized constructor
    public Employee(String paramFirstName, String paramLastName, String paramTitle, double paramPayRate) {

        firstName = paramFirstName;
        lastName = paramLastName;
        title = paramTitle;
        payRate = paramPayRate;
    }


    //Calculate salary, overridden in child classes
    public double calculateSalary() {

        return 0.0;
    }

    //Display employee fields, overridden in child classes
    public void display() {

        System.out.printf("Employee Name: %s %s, Title is: %s, $%.2f", firstName, lastName, title, payRate);
    }

    public void getEmployeeData() {
        System.out.print("Please enter the employee's first name: ");
        firstName = scanner.nextLine();

        System.out.print("Please enter the employee's last name: ");
        lastName = scanner.nextLine();

        System.out.print("Please enter the employee's title: ");
        title = scanner.nextLine();
    }


    //Get employee fields from user, create relevant objects
    public void inputEmployee() {

        do {

            System.out.print("Please enter the employee's payment terms (Commissioned, Hourly, or Salaried): ");
            payType = scanner.nextLine();

        } while (!payType.equalsIgnoreCase("Commissioned") &&
                !payType.equalsIgnoreCase("Hourly") &&
                !payType.equalsIgnoreCase("Salaried"));


        if (payType.equalsIgnoreCase("Commissioned")) {

            //Prompt user for name and title, stored in local variables
            getEmployeeData();

            //Create a CommEmp object to store the employee name and title
            CommEmp commEmpObject = new CommEmp(firstName, lastName, title, payRate, 0);

            //Prompt user for pay rate and time worked
            System.out.print("Please enter the Commissioned employee's weekly pay rate: ");
            commEmpObject.setPayRate(scanner.nextDouble());
            System.out.print("Please enter the Commissioned employee's weeks worked: ");
            commEmpObject.setWeeksWorked(scanner.nextDouble());

            //Run these CommEmp methods
            commEmpObject.calculateSalary();
            commEmpObject.display();

        } else if (payType.equalsIgnoreCase("Hourly")) {

            //Prompt user for name and title, stored in local variables
            getEmployeeData();

            //Create an HourlyEmp object to store the employee name and title
            HourlyEmp hourlyEmpObject = new HourlyEmp(firstName, lastName, title, payRate, 0);

            //Prompt user for pay rate and time worked
            System.out.print("Please enter the Hourly employee's hourly pay rate: ");
            hourlyEmpObject.setPayRate(scanner.nextDouble());
            System.out.print("Please enter the Hourly employee's hours worked: ");
            hourlyEmpObject.setHoursWorked(scanner.nextDouble());

            //Run these HourlyEmp methods
            hourlyEmpObject.calculateSalary();
            hourlyEmpObject.display();

        } else if (payType.equalsIgnoreCase("Salaried")) {

            //Prompt user for name and title, stored in local variables
            getEmployeeData();

            //Create a SalaryEmp object to store the employee name and title
            SalaryEmp salaryEmpObject = new SalaryEmp(firstName, lastName, title, payRate);

            //Prompt user for the pay rate and time worked
            System.out.print("Please enter the Salaried employee's yearly salary: ");
            salaryEmpObject.setPayRate(scanner.nextDouble());

            salaryEmpObject.calculateSalary();
            salaryEmpObject.display();
        }
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", payRate=" + payRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(payRate, employee.payRate) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(title, employee.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, title, payRate);
    }
}