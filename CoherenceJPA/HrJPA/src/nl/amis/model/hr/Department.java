package nl.amis.model.hr;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@XmlRootElement(name="Department")
@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private java.math.BigDecimal locationId;

	@Column(name="MANAGER_ID")
	private Long managerId;

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	//bi-directional many-to-one association to Employee
	@XmlTransient
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Department() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(java.math.BigDecimal locationId) {
		this.locationId = locationId;
	}

	@XmlTransient
	public List<Employee> getEmployees() {
		return this.employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}