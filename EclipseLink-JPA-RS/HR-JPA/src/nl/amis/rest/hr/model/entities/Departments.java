package nl.amis.rest.hr.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries( { @NamedQuery(name = "Departments.findAll", query = "select o from Departments o"),
	             @NamedQuery(name = "Departments.findById", query = "select o from Departments o where o.departmentId = :departmentId")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "DEPARTMENT_ID", 
            nullable = false)
    private BigDecimal departmentId;

    @Column(name = "DEPARTMENT_NAME", 
    		nullable = false, 
    		length = 30)
    private String departmentName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MANAGER_ID")
    private Employees manager;

    @OneToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private List<Employees> employeesList;

    public Departments() {
    }

    public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

    public BigDecimal getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName()+"@"+Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("departmentId=");
        buffer.append(getDepartmentId());
        buffer.append(',');
        buffer.append("departmentName=");
        buffer.append(getDepartmentName());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
