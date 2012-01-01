package nl.amis.web.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.myfaces.extensions.validator.baseval.annotation.Length;
import org.apache.myfaces.extensions.validator.baseval.annotation.Pattern;

@Named( value = "dataBeanCDI")
@SessionScoped
public class DataBeanCDI implements Serializable {

    public DataBeanCDI() {
    }

	private static final long serialVersionUID = -2504683342522467997L;

	@Length(minimum=2 , maximum=50)
	@Pattern(value="[A-Za-z ]*" , validationErrorMsgKey="locationValidation")
	private String departmentLocation = "fieldCDI";
	
	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
}
