package nl.amis.model.hr.services;


import java.util.List;

import javax.ejb.Local;

import nl.amis.model.hr.entities.Department;
import nl.amis.model.hr.entities.Employee;

@Local
public interface HrSessionLocal {
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults);
	public List<Department> getAllDepartments();
	public Department persistDepartment(Department department);
	public Department mergeDepartment(Department department);
	public void removeDepartment(Department department);
	public Employee persistEmployee(Employee employee);
	public Employee mergeEmployee(Employee employee) ;
	public void removeEmployee(Employee employee) ;
}
