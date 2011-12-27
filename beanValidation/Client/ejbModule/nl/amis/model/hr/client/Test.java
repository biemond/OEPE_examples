package nl.amis.model.hr.client;

import java.util.Hashtable;
import java.util.Set;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;


import nl.amis.mode.hr.services.HrSession;
import nl.amis.model.hr.entities.Department;
import nl.amis.model.hr.entities.Employee;

public class Test {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
        final Context context =  getInitialContext();
     
		try {
			
			HrSession hRSession = (HrSession)context.lookup("HrEar-HrJPA-HrSessionBean#nl.amis.mode.hr.services.HrSession");
            Department dept = new Department();
            dept.setDepartmentName("1234567890123456789012345678901234567890");
            hRSession.persistDepartment(dept);
            
//            for (Department department : hRSession.getAllDepartments() ) {
//                System.out.println( "Department Id = " + department.getDepartmentId() );
//                for (Employee employee : department.getEmployees() ) {
//                    System.out.println( "Employee Name = " + employee.getLastName() );	
//               }   
//            }
        } catch ( EJBException ce) {
           ce.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

    private static Context getInitialContext() throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        // WebLogic Server 10.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext( env );
    }
}
