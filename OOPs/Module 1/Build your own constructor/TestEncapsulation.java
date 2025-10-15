// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee employee1 = new Employee("Alice", 30, 5000);
        Employee employee2 = new Employee();
        employee2.setName("Bob");
        employee2.setAge(25);
        employee2.setSalary(4000);
        // Step 2: Print details of both employees
        employee1.displayDetails(); 
        employee2.displayDetails();
        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        // explain the try setting invalid values
        // Using try-catch blocks to handle potential IllegalArgumentExceptions

        try {
            employee1.setName(null);
        } catch (IllegalArgumentException e) {  //what is e here?  // e is the exception object that contains information about the error
            System.out.println("Validation error: " + e.getMessage());  // where is the getMessage() method defined?
            // It is defined in the Throwable class, which is the superclass of all exceptions
            // so it auto defined in all exception classes? 

        }

        try {
            employee2.setAge(70);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            employee1.setSalary(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        // Step 4: Give both employees a 10% raise and display their details again
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        employee1.displayDetails();
        employee2.displayDetails();

        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            System.out.println("Cloned Employee Details:");
            clonedEmployee.displayDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }

        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        employee1.setName("Alice Smith");
        employee1.setSalary(6000);
        System.out.println("Original Employee Details After Modification:");
        employee1.displayDetails();
        System.out.println("Cloned Employee Details After Original Modification:");
        try {
            Employee clonedEmployee2 = (Employee) employee1.clone();
            clonedEmployee2.displayDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }

        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"
        String higherSalaryEmployee = compareSalaries(employee1, employee2);
        System.out.println("Employee with higher salary: " + higherSalaryEmployee);
    }
    
    // Helper method to compare salaries
    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName();
        } else if (emp2.getSalary() > emp1.getSalary()) {
            return emp2.getName();
        } else {
            return "Equal salaries";
        }
    }
}
