package com.NamedParameterJdbcTemplate.EmployeeBean;

import java.util.List;

public class FetchEmployeeDetailsDto {
	private Long empId;
	private String firstNm;
	private String middleNm;
	private String lastNm;
	private Long mobileNo;
	private List<EmployeeDeptBean> empDeptList;
	private List<EmployeeDesignationBean> empDesignationList;
	
	
	
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
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<EmployeeDeptBean> getEmpDeptList() {
		return empDeptList;
	}
	public void setEmpDeptList(List<EmployeeDeptBean> empDeptList) {
		this.empDeptList = empDeptList;
	}
	public List<EmployeeDesignationBean> getEmpDesignationList() {
		return empDesignationList;
	}
	public void setEmpDesignationList(List<EmployeeDesignationBean> empDesignationList) {
		this.empDesignationList = empDesignationList;
	}

	
	
	
	

}
