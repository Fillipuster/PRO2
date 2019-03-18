package opgave03.service;

import opgave03.model.Company;
import opgave03.model.Employee;
import opgave03.storage.Storage;

public class Service
{
	private static Service instance;
	
	private Service() {};
	
	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}
	
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public Company createCompany(String name, int hours)
    {
        Company company = new Company(name, hours);
        Storage.getInstance().addCompany(company);
        return company;
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public void deleteCompany(Company company)
    {
        Storage.getInstance().removeCompany(company);
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public void updateCompany(Company company, String name, int hours)
    {
        company.setName(name);
        company.setHours(hours);
    }

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public Employee createEmployee(String name, int wage)
    {
        Employee employee = new Employee(name, wage);
        Storage.getInstance().addEmployee(employee);
        return employee;
    }

//    /**
//     * Creates a new employee linked to the company.<br />
//     * Requires: wage >= 0.
//     */
//    public static Employee createEmployee(String name, int wage, Company company)
//    {
//        Employee employee = new Employee(name, wage);
//        employee.setCompany(company);
//        company.addEmployee(employee);
//        Storage.addEmployee(employee);
//        return employee;
//    }

    /**
     * Deletes the employee.
     */
    public void deleteEmployee(Employee employee)
    {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
        Storage.getInstance().removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public void updateEmployee(Employee employee, String name, int wage)
    {
        employee.setName(name);
        employee.setWage(wage);
    }

// -------------------------------------------------------------------------

    /**
     * Updates the employee's company.
     */
    public void updateCompanyOfEmployee(Employee employee, Company company)
    {
        Company current = employee.getCompany();
        if (current != null) {
            current.removeEmployee(employee);
            employee.clearCompany();
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    /**
     * Sets the company of the employee.
     */
    public static void setCompanyOfEmployee(Employee employee, Company company)
    {
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    /**
     * Clears the company of the employee.
     */
    public void clearCompanyOfEmployee(Employee employee)
    {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
    }

// -------------------------------------------------------------------------

    /**
     * Initializes the storage with some objects.
     */
    public void initStorage()
    {
        Company c1 = createCompany("IBM", 37);
        Company c2 = createCompany("AMD", 40);
        createCompany("SLED", 45);
        createCompany("Vector", 32);

        Employee e1 = createEmployee("Bob Dole", 210);
        setCompanyOfEmployee(e1, c2);
        Employee e2 = createEmployee("Alice Schmidt", 250);
        setCompanyOfEmployee(e2, c1);
        Employee e3 = createEmployee("George Down", 150);
        setCompanyOfEmployee(e3, c2);
        createEmployee("Rita Uphill", 300);
    }

}
