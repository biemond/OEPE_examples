package nl.amis.rest.hr.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private long locationId;

	private String city;

	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Departments> locationDepartmentsList;
	
	public List<Departments> getLocationDepartmentsList() {
		return locationDepartmentsList;
	}

	public void setLocationDepartmentsList(List<Departments> locationDepartmentsList) {
		this.locationDepartmentsList = locationDepartmentsList;
	}

	public Location() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}