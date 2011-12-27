package nl.amis.model.hr.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;
import static javax.persistence.FetchType.EAGER;

/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name = "department.FindAll", query = "SELECT o FROM Department o")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;


	@NotNull
    @Size(min=2,max=30, message = "Name must between 2 and 30 characters")
	@Pattern( regexp="[A-Za-z ]*" ,message = "{departmentNameValidation}")
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Id
	@SequenceGenerator(name="DEPARTMENTS_DEPARTMENTID_GENERATOR", sequenceName="DEPARTMENTS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENTS_DEPARTMENTID_GENERATOR")
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	
	
	@Column(name="LOCATION_ID")
	private java.math.BigDecimal locationId;

	//bi-directional many-to-one association to Employee
    @ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department", fetch = EAGER)
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}