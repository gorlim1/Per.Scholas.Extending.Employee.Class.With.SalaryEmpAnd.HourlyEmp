public class CommEmp extends Employee {

    //Declaration, initialization
    final private double COMMISSION_PERCENTAGE = 0.1;
    private double weeksWorked = 0.0;
    private double weeklySalary = 0.0;
    private double totalSalary = 0.0;

    //Getters, setters
    public double getCOMMISSION_PERCENTAGE() {
        return COMMISSION_PERCENTAGE;
    }

    public double getWeeksWorked() {
        return weeksWorked;
    }

    public void setWeeksWorked(double weeksWorked) {
        this.weeksWorked = weeksWorked;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }


    //Parameterized constructor
    public CommEmp(String paramFirstName, String paramLastName, String paramTitle,
                   double paramPayRate, double paramWeeksWorked) {

        super(paramFirstName, paramLastName, paramTitle, paramPayRate);
        weeksWorked = paramWeeksWorked;
    }

    @Override
    public double calculateSalary() {

        weeklySalary = weeksWorked * payRate;

        if ((weeklySalary - 1000) >= 0) {

            totalSalary = weeklySalary + ((weeklySalary - 1000) * COMMISSION_PERCENTAGE);

        } else {

            totalSalary = weeklySalary;
        }

        return totalSalary;
    }

    @Override
    public void display() {

        System.out.println("Employee name is: " + firstName + " " + lastName);
        System.out.println("Employee title is: " + title);
        System.out.printf("Employee Weekly salary is: $%.2f%n", weeklySalary);
        System.out.printf("Employee weeks worked: %.2f%n", weeksWorked);

        if ((weeklySalary - 1000) > 0 ) {

            System.out.printf("Employee Commission is: $%.2f%n", ((weeklySalary - 1000) * COMMISSION_PERCENTAGE));
            System.out.printf("Employee Total Weekly salary is: $%.2f%n", totalSalary);
        }
    }
}

//Purpose: Calculate weekly pay based on rate, commission 10%
//based on sales over $1000.00.
//● Constructor: Parameterized
//● Invoke the parent class constructor to initialize parameters
//● calculateSalary() : Calculate weekly pay based on rate, commission
//10% based on sales over $1000.00.
//● display(): Output employee name, title, hours worked, commission
//on sales, weekly pay.
