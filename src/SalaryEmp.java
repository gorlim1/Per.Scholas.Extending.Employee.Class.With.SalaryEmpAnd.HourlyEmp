public class SalaryEmp extends Employee {

    //Declaration, initialization
    private double biMonthlySalary = 0;

    //Getters and setters
    public double getBiMonthlySalary() {
        return biMonthlySalary;
    }

    public void setBiMonthlySalary(double biMonthlySalary) {
        this.biMonthlySalary = biMonthlySalary;
    }


    //Parameterized constructor
    public SalaryEmp(String paramFirstName, String paramLastName, String paramTitle,
                     double paramPayRate) {

        super(paramFirstName, paramLastName, paramTitle, paramPayRate);
    }

    //Override of Employee class method
    @Override
    public double calculateSalary() {

        return biMonthlySalary = payRate / 24;
    }

    //Override of Employee class method
    @Override
    public void display() {

        //super.display(); //not needed, unless wanted, as display is a method and not a constructor
        System.out.println("Employee name is: " + firstName + " " + lastName);
        System.out.println("Employee Title is: " + title);
        System.out.printf("Employee Yearly salary is: $%.2f%n", payRate);
        System.out.printf("Employee Bi-Monthly pay is: $%.2f%n", biMonthlySalary);
    }
}