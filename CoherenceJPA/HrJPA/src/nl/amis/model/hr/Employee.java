package nl.amis.model.hr;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static javax.persistence.FetchType.LAZY;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@XmlRootElement(name="Employee")
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE")
	private Date hireDate;

	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	private BigDecimal salary;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	@Column(name="MANAGER_ID")
	private Long managerId;


	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}