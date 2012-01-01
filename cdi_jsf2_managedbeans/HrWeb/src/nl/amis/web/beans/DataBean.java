package nl.amis.web.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import nl.amis.model.hr.entities.Department;
import nl.amis.model.hr.services.HrSessionLocal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean( name = "dataBean")
@ViewScoped
public class DataBean implements Serializable  {

    public DataBean() {
    }

	private static final long serialVersionUID = -6996992412087723373L;

	@NotNull
    @Size(min=2,max=10)
	private String departmentName = "fieldMBean";

	@EJB
    private HrSessionLocal sessionFacade;

	@Inject
	private DataBeanCDI dataBeanCDI;
	
    public void setSessionFacade(HrSessionLocal sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    public HrSessionLocal getSessionFacade() {
        return sessionFacade;
    }

    private Validator validator;

    public void addDepartment(ActionEvent event) {

       if (validator == null) {
        	validator = Validation.buildDefaultValidatorFactory().getValidator();	
       }
       Department dept = new Department();
       dept.setDepartmentName("1234567890123456789012345678901234567890");
       
       Set<ConstraintViolation<Department>> violations = validator.validate(dept);
       for (ConstraintViolation<Department> violation : violations) {
           System.out.println("error size: "+violations.size());

    	   String propertyPath = violation.getPropertyPath().toString();
           String message = violation.getMessage();
           FacesMessage message2 = 
        		 new FacesMessage(FacesMessage.SEVERITY_ERROR,
        				 		  "Invalid value for: '" + propertyPath + "': " + message,
        				 		  "Validation Error ");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(event.getComponent().getClientId(), message2);
       }
       if ( violations.size() > 0 ) {
    	   return;
       }
       getSessionFacade().persistDepartment(dept);
    }
    
    public List<Department> getAllDepartments() {
    	List<Department> result = getSessionFacade().getAllDepartments();
    	return result;
    }

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
