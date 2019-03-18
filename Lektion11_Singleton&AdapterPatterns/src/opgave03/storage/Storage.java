package opgave03.storage;

import java.util.ArrayList;

import opgave03.model.Company;
import opgave03.model.Employee;

public class Storage
{
	private static Storage instance;
	
	private Storage() {};
	
	public static Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}
	
    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    // -------------------------------------------------------------------------

    public ArrayList<Company> getCompanies()
    {
        return new ArrayList<Company>(companies);
    }

    public void addCompany(Company company)
    {
        companies.add(company);
    }

    public void removeCompany(Company company)
    {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------

    public ArrayList<Employee> getEmployees()
    {
        return new ArrayList<Employee>(employees);
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
    }

}
