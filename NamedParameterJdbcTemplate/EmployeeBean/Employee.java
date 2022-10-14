package com.NamedParameterJdbcTemplate.EmployeeBean;

import java.util.List;

public class Employee{
	private Long empId;
	private String lastNm;
	private String firstNm;
	private String middleNm;
	private Long empCode;
	private Long mobileNo;
	private String stateNm;
	private String countryNm;
	private Long orgId;
	private Boolean isactive;
	private List<EmployeeDepartmentsXref> departmentList;
	private List<EmployeeDesignationXref> designationList;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", lastNm=" + lastNm + ", firstNm=" + firstNm + ", middleNm=" + middleNm
				+ ", empCode=" + empCode + ", mobileNo=" + mobileNo + ", stateNm=" + stateNm + ", countryNm="
				+ countryNm + ", orgId=" + orgId + ", isactive=" + isactive + ", departmentList=" + departmentList
				+ ", designationList=" + designationList + "]";
	}
	public String getLastNm() {
		return lastNm;
	}
	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
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
	public Long getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
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
	public List<EmployeeDepartmentsXref> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<EmployeeDepartmentsXref> departmentList) {
		this.departmentList = departmentList;
	}
	public List<EmployeeDesignationXref> getDesignationList() {
		return designationList;
	}
	public void setDesignationList(List<EmployeeDesignationXref> designationList) {
		this.designationList = designationList;
	}
	


}
