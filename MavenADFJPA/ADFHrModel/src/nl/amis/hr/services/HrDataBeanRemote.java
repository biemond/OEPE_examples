package nl.amis.hr.services;

import java.util.List;
import javax.ejb.Remote;
import nl.amis.hr.model.Department;
import nl.amis.hr.model.Employee;


/**
 * @generated DT_ID=none
 */
@Remote
public interface HrDataBeanRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Department persistDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public Department mergeDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public void removeDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public List<Department> getDepartmentFindAll();

    /**
     * @generated DT_ID=none
     */
    public List<Department> getDepartmentFindByName(String departmentName);

    /**
     * @generated DT_ID=none
     */
    public Employee persistEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public Employee mergeEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public void removeEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public List<Employee> getEmployeeFindAll();

}
