// Superclass Employee
class Employee {
    private String employeeNo;
    private String employeeName;
    private double basicSalary;

    // Constructor
    public Employee(String employeeNo, String employeeName, double basicSalary) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    // Getter methods
    public String getEmployeeNo() {
        return employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Calculate bonus
    public double calBonus() {
        return 0.05 * basicSalary; // 5% of basic salary
    }

    // Calculate gross salary
    public double calGrossSalary() {
        return basicSalary + calBonus();
    }
}

// Subclass Manager
class Manager extends Employee {
    // Constructor
    public Manager(String employeeNo, String employeeName, double basicSalary) {
        super(employeeNo, employeeName, basicSalary);
    }

    // Calculate bonus (override)
    @Override
    public double calBonus() {
        return 0.2 * getBasicSalary(); // 20% of basic salary
    }

    // Calculate tax for manager
    public double calTax() {
        return 0.15 * getBasicSalary(); // 15% of basic salary
    }

    // Calculate gross salary (override)
    @Override
    public double calGrossSalary() {
        return getBasicSalary() + calBonus() - calTax();
    }
}

// Subclass Clerk
class Clerk extends Employee {
    private String category;

    // Constructor
    public Clerk(String employeeNo, String employeeName, double basicSalary, String category) {
        super(employeeNo, employeeName, basicSalary);
        this.category = category;
    }

    // Getter method for category
    public String getCategory() {
        return category;
    }

    // Calculate bonus (override)
    @Override
    public double calBonus() {
        if (category.equals("Grade I"))
            return 0.1 * getBasicSalary(); // 10% of basic salary
        else
            return 0.05 * getBasicSalary(); // 5% of basic salary
    }
}

// Driver class Company
public class Grossary {
    public static void main(String[] args) {
        // Create instances for employees
        Manager manager = new Manager("M0001", "Malinga", 80000);
        Clerk clerk = new Clerk("C0010", "Amjath", 30000, "Grade I");
        Employee otherEmployee = new Employee("E0013", "Sivanjali", 20000);

        // Calculate and display gross salary
        System.out.println("Manager's Gross Salary: " + manager.calGrossSalary());
        System.out.println("Clerk's Gross Salary: " + clerk.calGrossSalary());
        System.out.println("Other Employee's Gross Salary: " + otherEmployee.calGrossSalary());
    }
}

