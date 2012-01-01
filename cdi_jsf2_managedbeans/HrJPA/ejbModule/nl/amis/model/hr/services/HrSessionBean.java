package nl.amis.model.hr.services;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import nl.amis.model.hr.entities.Department;
import nl.amis.model.hr.entities.Employee;


/**
 * @generated DT_ID=HrSessionBean
 */
@Stateless(name = "HrSessionBean", mappedName = "HrEar-HrJPA-HrSessionBean")
public class HrSessionBean implements HrSession, HrSessionLocal
{

	@Resource 
	Validator validator;

    @PersistenceContext(unitName="HrJPA")
    private EntityManager em;

    public HrSessionBean() {
    }
    
    public Department persistDepartment(Department department) {
    	
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        System.out.println("error size: "+violations.size());
        for (ConstraintViolation<Department> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            System.out.println("invalid value for: '" + propertyPath + "': " + message);
        }
  	
        em.persist(department);
        return department;
    }
    
    /**
     * @generated DT_ID=HrSessionBean
     */
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

    @SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
    	return em.createNamedQuery("department.FindAll").getResultList();
    }
    

    /**
     * @generated DT_ID=HrSessionBean
     */
    public Department mergeDepartment(Department department) {
        return em.merge(department);
    }

    /**
     * @generated DT_ID=HrSessionBean
     */
    public void removeDepartment(Department department) {
        department = em.find(Department.class, department.getDepartmentId());
        em.remove(department);
    }

    /**
     * @generated DT_ID=HrSessionBean
     */
    public Employee persistEmployee(Employee employee) {
        em.persist(employee);
        return employee;
    }

    /**
     * @generated DT_ID=HrSessionBean
     */
    public Employee mergeEmployee(Employee employee) {
        return em.merge(employee);
    }

    /**
     * @generated DT_ID=HrSessionBean
     */
    public void removeEmployee(Employee employee) {
        employee = em.find(Employee.class, employee.getEmployeeId());
        em.remove(employee);
    }

}
