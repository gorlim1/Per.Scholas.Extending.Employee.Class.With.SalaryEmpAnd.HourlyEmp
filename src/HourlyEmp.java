public class HourlyEmp extends Employee {

    //Declaration, initialization
    private double hoursWorked;
    private double weeklySalary;

    //Getters, Setters
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    //Parameterized constructor
    public HourlyEmp(String paramFirstName, String paramLastName, String paramTitle,
                     double paramPayRate, double paramHoursWorked) {

        super(paramFirstName, paramLastName, paramTitle, paramPayRate);
        hoursWorked = paramHoursWorked;
    }


    //Override of Employee class method
    @Override
    public double calculateSalary() {

        return weeklySalary = hoursWorked * payRate;
    }

    //Override of Employee class method
    @Override
    public void display() {

        System.out.println("Employee name is: " + firstName + " " + lastName);
        System.out.println("Employee title is: " + title);
        System.out.printf("Employee Hours worked: %.2f%n", hoursWorked);
        System.out.printf("Employee Weekly salary is: $%.2f%n", weeklySalary);
    }
}