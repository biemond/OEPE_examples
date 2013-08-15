package nl.amis.hr.services;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import nl.amis.hr.model.Department;
import nl.amis.hr.model.Employee;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "HrDataBean", mappedName = "ADF12cHrApp-ADFHrModel-HrDataBean")
public class HrDataBean
        implements HrDataBeanLocal, HrDataBeanRemote
{

    /**
     * @generated DT_ID=none
     */
	@Resource
	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="ADFHrModel")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public HrDataBean() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Department persistDepartment(Department department) {
        em.persist(department);
        return department;
    }

    /**
     * @generated DT_ID=none
     */
    public Department mergeDepartment(Department department) {
        return em.merge(department);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeDepartment(Department department) {
        department = em.find(Department.class, department.getDepartmentId());
        em.remove(department);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Department> getDepartmentFindAll() {
        return em.createNamedQuery("Department.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Department> getDepartmentFindByName(String departmentName) {
        return em.createNamedQuery("Department.findByName").setParameter("departmentName", departmentName).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Employee persistEmployee(Employee employee) {
        em.persist(employee);
        return employee;
    }

    /**
     * @generated DT_ID=none
     */
    public Employee mergeEmployee(Employee employee) {
        return em.merge(employee);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeEmployee(Employee employee) {
        employee = em.find(Employee.class, employee.getEmployeeId());
        em.remove(employee);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Employee> getEmployeeFindAll() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

}
