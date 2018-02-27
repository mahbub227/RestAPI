package com.bjit.RestAPI.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

import com.bjit.RestAPI.util.ConstantUtils;

@Entity
@Table(name="employee_details")
public class Employee  implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer employeeId;
	@Column(unique=true,name="work_mobile")
	@NotNull(message="Mobile Number is Empty!")
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN,message="Please Enter Only Digits!")
	@Size(min=8, max=15, message="Name must be atleast 8 character and atmost 15 character")
	private String workMobile;
	@NotNull(message="Input your name!")
	@Size(min=5, max=20, message="Name must be atleast 5 character and atmost 20 character")
	@Column(name="employee_name")
	@Pattern(regexp=ConstantUtils.CHAR_PATTERN,message="Only Letters Please!")
	private String employeeName;
	@NotNull(message="Input your work Address!")
	@Column(name="work_address")
	private String workAddress;
	@Column(name="job_type")
	private String jobType;
	@Column(name="other_information")
	private String otherInformation;
	@NotNull(message="Input your work email!")
	@Email(message="Please provide a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	@Column(unique=true,name="work_email")
	private String workEmail;
	@Column(name="employee_image")
	private String employeeImage;
	@NotNull(message="Input your work Location!")
	@Column(name="work_location")
	private String workLocation;
	@Size(min=8,max=12, message="Enter valid Work Phone must be atleast 8 and atmost 13 digits!")
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN,message="Please Enter Only Digits!")
	@Column(unique=true,name="work_phone")
	private String workPhone;
	private String department;
	@Column(name="job_title")
	private String jobTitle;
	private String manager;
	private String coach;
	
	private String nationality;
	@NotNull(message="Input your Identification No!")
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN,message="Please Enter Only Digits!")
	@Size(min=10,max=15, message="Identification number must be between 10-15 digits!")
	@Column(name="identification_no", unique=true)
	private String identificationNo;
	@NotNull(message="Input your Passport No!")
	@Size(min=10,max=15, message="Identification number must be between 10-15 digits!")
	@Column(name="passport_no", unique=true)
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN,message="Please Enter Only Digits!")
	private String passportNo;
	@NotNull(message="Input your Bank A/C No!")
	@Size(min=7,max=15, message="Identification number must be between 7-15 digits!")
	@Column(name="bank_ac_no", unique=true)
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN,message="Please Enter Only Digits!")
	private String bankAcNo;
	private String gender;
	@Column(name="home_address")
	@NotNull(message="Input your Home Address!")
	private String homeAddress;
	@Column(name="marital_status")
	private String maritalStatus;
	@NotNull(message="Input your Birth Date!")
	@Column(name="date_of_birth")
	@Past(message="Invalid Date of Birth")
	private java.sql.Date dateOfBirth;
	private boolean active;
	@Transient
	private MultipartFile file;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}
	public String getWorkMobile() {
		return workMobile;
	}
	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}
	public String getWorkaAddress() {
		return workAddress;
	}
	public void setWorkaAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIdentificationNo() {
		return identificationNo;
	}
	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getBankAcNo() {
		return bankAcNo;
	}
	public void setBankAcNo(String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


	
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Employee() {
		this.employeeImage = "EMP"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", workMobile=" + workMobile + ", employeeName=" + employeeName
				+ ", workAddress=" + workAddress + ", jobType=" + jobType + ", otherInformation=" + otherInformation
				+ ", workEmail=" + workEmail + ", employeeImage=" + employeeImage + ", workLocation=" + workLocation
				+ ", workPhone=" + workPhone + ", department=" + department + ", jobTitle=" + jobTitle + ", manager="
				+ manager + ", coach=" + coach + ", nationality=" + nationality + ", identificationNo="
				+ identificationNo + ", passportNo=" + passportNo + ", bankAcNo=" + bankAcNo + ", gender=" + gender
				+ ", homeAddress=" + homeAddress + ", maritalStatus=" + maritalStatus + ", dateOfBirth=" + dateOfBirth
				+ ", active=" + active + ", file=" + file + "]";
	}	
	
	
	
	
}
