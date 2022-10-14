package comJdbcTemplatePractice.PatientBean;

import java.sql.Date;

public class PatientBean {
	private Long sNo;
	private Long orgId;
	
	private Date pCreatedOn;
	private String patientNm;
	private String dateOfBirth;
	private String gender;
	private Long mobileNo;
	private String emailId;
	private String address;	
	private String pincode;
	
	

	public PatientBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientBean(Long sNo, Long orgId, Date pCreatedOn, String patientNm, String dateOfBirth, String gender,
			Long mobileNo, String emailId, String address, String pincode) {
		super();
		this.sNo = sNo;
		this.orgId = orgId;
		this.pCreatedOn = pCreatedOn;
		this.patientNm = patientNm;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.address = address;
		this.pincode = pincode;
	}
	public Long getsNo() {
		return sNo;
	}
	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}
	public Date getpCreatedOn() {
		return pCreatedOn;
	}
	public void setpCreatedOn(Date pCreatedOn) {
		this.pCreatedOn = pCreatedOn;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getPatientNm() {
		return patientNm;
	}
	public void setPatientNm(String patientNm) {
		this.patientNm = patientNm;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	

}
