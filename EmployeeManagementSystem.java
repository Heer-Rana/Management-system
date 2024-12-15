import java.util.Scanner;

class Employee {
     String name;
     int employeeId;
     double salary;
     String designation;
	 String adhar;
	 long phoneno;
     String education;
	String email;

    public Employee()	{
    }

    public Employee(String name, int employeeId, String email,double salary, String designation, String adhar, long phoneno, String education) {
        this.name = name;
        this.employeeId = employeeId;
		this.email=email;
        this.salary = salary;
        this.designation = designation;
		this.adhar = adhar;
		this.phoneno = phoneno;
		this.education = education;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Enter Employee's name: " + name);
		System.out.println("Enter Employee's Email id:"+email);
        System.out.println("Enter Employee's Salary: $" + salary);
        System.out.println("Enter Employee's Designation: " + designation);
		System.out.println("Enter Employee's Aadhar Number: " + adhar);
        System.out.println("Enter Employee's Phone Number: " + phoneno);
        System.out.println("Enter Employee's highest Education: " + education);
        System.out.println("------------------------");
    }

    public void updateInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new name: ");
        this.name = sc.nextLine();

        System.out.print("Enter new salary: $");
        this.salary = sc.nextDouble();
        sc.nextLine(); // Consume the newline character left by nextDouble()
        System.out.println("Enter new Email id:");
        this.email=sc.next();
		        boolean b=true;
        while(b){
            email=sc.next();
            int i=email.indexOf("@gmail.com");
            if(email.length()>10){
                ////
                if(i==-1){
                    System.out.println("Enter Valid Email Address!");
                }
                else if( email.substring(i).equals("@gmail.com")){
                    b=false;
                }
            }else{
                System.out.println("Enter Valid Email Address!");
            }
        }
        System.out.print("Enter new designation: ");
        this.designation = sc.nextLine();
		 System.out.print("Enter new Aadhar number: ");
        this.adhar = sc.next();
        while (adhar.length() != 12) {
            System.out.println("Please enter a 12-digit Aadhar number");
            System.out.print("Enter new Aadhar number: ");
            this.adhar = sc.next();
        }

        System.out.print("Enter new phone number: ");
        String phoneNumber = sc.next();
        while (phoneNumber.length() != 10) {
            System.out.println("Please enter a 10-digit phone number");
            System.out.print("Enter new phone number: ");
            phoneNumber = sc.next();
        }
        this.phoneno = Long.parseLong(phoneNumber);

        System.out.print("Enter new education: ");
        this.education = sc.next();

        System.out.println("Employee information updated successfully.");
    }
	 public static Employee searchEmployeeById(Employee[] employees, int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}

public class EmployeeManagementSystem {
	  private static void calculatePayroll(Employee[] employees) {
        for (Employee employee : employees) {
            double basicPay = employee.getEmployeeId();
            double da = basicPay * 0.10; // Assuming DA is 10% of Basic Pay
            double hra = basicPay *0.20; // Assuming HRA is 20% of Basic Pay
            double pf = basicPay *0.05; // Assuming PF is 5% of Basic Pay

            double totalSalary = basicPay + da + hra - pf;
            
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Basic Pay: $" + basicPay);
            System.out.println("Dearness Allowance (DA): $" + da);
            System.out.println("House Rent Allowance (HRA): $" + hra);
            System.out.println("Provident Fund (PF): $" + pf);
            System.out.println("Total Salary: $" + totalSalary);
            System.out.println("------------------------");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of employees you want to manage: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        // Adding employees
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            employees[i] = createEmployee();
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nEmployee Management System");
            System.out.println("Press 1 to Add Employee");
            System.out.println("Press 2 to Display All Employees");
            System.out.println("Press 3 to Update Employee Information");
            System.out.println("Press 4 to Search Employee by it's ID");
			System.out.println("Press 5 to displayPayroll!");
			System.out.println("Press 6 to exit!!");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.println("\nEnter details for new Employee:");
                    employees = addEmployee(employees);
                    break;
                case 2:
                    // Display All Employees
                    displayAllEmployees(employees);
                    break;
                case 3:
                    // Update Employee Information
                    updateEmployeeInformation(employees);
                    break;
					   case 4:
                    // Search Employee by ID
                    searchEmployeeById(employees);
                    break;
                case 5:
                  calculatePayroll(employees);
                    break;
					case 6: 
				 exit = true;
                    break;
					
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        sc.close();
    }
	private static void searchEmployeeById(Employee[] employees) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Employee ID to search: ");
        int employeeIdToSearch = sc.nextInt();
		
        Employee foundEmployee = Employee.searchEmployeeById(employees, employeeIdToSearch);

        if (foundEmployee != null) {
            System.out.println("Employee found:");
            foundEmployee.display();
        } else {
            System.out.println("Employee with ID " + employeeIdToSearch + " not found.");
        }
    }

    private static Employee[] addEmployee(Employee[] oldEmployees) {
        Scanner sc = new Scanner(System.in);

        // Creating a new array with one extra slot
        Employee[] newEmployees = new Employee[oldEmployees.length + 1];

        for (int i = 0; i < oldEmployees.length; i++) {
            newEmployees[i] = oldEmployees[i];
        }

        // Add a new employee
        newEmployees[newEmployees.length - 1] = createEmployee();

        System.out.println("Employee added successfully.");

        return newEmployees;
    }

    private static void displayAllEmployees(Employee[] employees) {
        if (employees.length == 0) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employees) {
                employee.display();
            }
        }
    }

    private static void updateEmployeeInformation(Employee[] employees) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Employee ID to update information: ");
        int employeeIdToUpdate = sc.nextInt();

        boolean employeeFound = false;

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeIdToUpdate) {
                employee.updateInfo();
                employeeFound = true;
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("Employee with ID " + employeeIdToUpdate + " not found.");
        }
    }

    private static Employee createEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int employeeId = sc.nextInt();
		System.out.print("Enter Email id:");
		String email=sc.nextLine();
		        boolean b=true;
        while(b){
            email=sc.next();
            int i=email.indexOf("@gmail.com");
            if(email.length()>=10){
                ////
                if(i==-1){
                    System.out.println("Enter Valid Email Address!");
                }
                else if( email.substring(i).equals("@gmail.com")){
                    b=false;
                }
            }else{
                System.out.println("Enter Valid Email Address!");
            }
        }

        System.out.print("Enter salary: $");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter designation: ");
        String designation = sc.nextLine();
		
        System.out.print("Enter Aadhar number: ");
        String adhar = sc.next();
        while (adhar.length() != 12) {
            System.out.println("Please enter a 12-digit Aadhar number");
            System.out.print("Enter Aadhar number: ");
            adhar = sc.next();
        }

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.next();
        while (phoneNumber.length() != 10) {
            System.out.println("Please enter a 10-digit phone number");
            System.out.print("Enter phone number: ");
            phoneNumber = sc.next();
        }
        long phoneno = Long.parseLong(phoneNumber);

        System.out.print("Enter education: ");
        String education = sc.next();

        return new Employee(name, employeeId,email, salary, designation, adhar, phoneno, education);
    }
}
