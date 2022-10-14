package com.NamedParameterJdbcTemplate.EmployeeBean;

public class FetchEmployeeDtBean {
private Long empId;
private String firstNm;
private String middleNm;
private String lastNm;
private String emailId;
private Long mobileNo;
private String stateNm;
private String countryNm;
private String cityNm;
private String empCode;
private Long alternateMobileNo;
private Long orgId;
private Boolean isactive;
private String address;
private String pincode;



public FetchEmployeeDtBean() {
	super();
	// TODO Auto-generated constructor stub
}

public FetchEmployeeDtBean(Long empId, String firstNm, String middleNm, String lastNm, String emailId, Long mobileNo,
		String stateNm, String countryNm, String cityNm, String empCode, Long alternateMobileNo, Long orgId,
		Boolean isactive, String address, String pincode) {
	super();
	this.empId = empId;
	this.firstNm = firstNm;
	this.middleNm = middleNm;
	this.lastNm = lastNm;
	this.emailId = emailId;
	this.mobileNo = mobileNo;
	this.stateNm = stateNm;
	this.countryNm = countryNm;
	this.cityNm = cityNm;
	this.empCode = empCode;
	this.alternateMobileNo = alternateMobileNo;
	this.orgId = orgId;
	this.isactive = isactive;
	this.address = address;
	this.pincode = pincode;
}



public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getFirstNm() {
	return firstNm;
}
public void setFirstNm(String firstNm) {
	this.firstNm = firstNm;
}
public String getMiddleNm() {
	return middleNm;
}
public void setMiddleNm(String middleNm) {
	this.middleNm = middleNm;
}
public String getLastNm() {
	return lastNm;
}
public void setLastNm(String lastNm) {
	this.lastNm = lastNm;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public Long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(Long mobileNo) {
	this.mobileNo = mobileNo;
}
public String getStateNm() {
	return stateNm;
}
public void setStateNm(String stateNm) {
	this.stateNm = stateNm;
}
public String getCountryNm() {
	return countryNm;
}
public void setCountryNm(String countryNm) {
	this.countryNm = countryNm;
}
public String getCityNm() {
	return cityNm;
}
public void setCityNm(String cityNm) {
	this.cityNm = cityNm;
}
public String getEmpCode() {
	return empCode;
}
public void setEmpCode(String empCode) {
	this.empCode = empCode;
}
public Long getAlternateMobileNo() {
	return alternateMobileNo;
}
public void setAlternateMobileNo(Long alternateMobileNo) {
	this.alternateMobileNo = alternateMobileNo;
}
public Long getOrgId() {
	return orgId;
}
public void setOrgId(Long orgId) {
	this.orgId = orgId;
}
public Boolean getIsactive() {
	return isactive;
}
public void setIsactive(Boolean isactive) {
	this.isactive = isactive;
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
@Override
public String toString() {
	return "FetchEmployeeDtBean [empId=" + empId + ", firstNm=" + firstNm + ", middleNm=" + middleNm + ", lastNm="
			+ lastNm + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", stateNm=" + stateNm + ", countryNm="
			+ countryNm + ", cityNm=" + cityNm + ", empCode=" + empCode + ", alternateMobileNo=" + alternateMobileNo
			+ ", orgId=" + orgId + ", isactive=" + isactive + ", address=" + address + ", pincode=" + pincode + "]";
}




}
