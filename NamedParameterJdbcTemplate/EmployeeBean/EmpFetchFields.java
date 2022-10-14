package com.NamedParameterJdbcTemplate.EmployeeBean;

public class EmpFetchFields {
	private Long empId;
	private Long orgId;
	private Boolean isactive;
	
	
	public EmpFetchFields() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmpFetchFields(Long empId, Long orgId, Boolean isactive) {
		super();
		this.empId = empId;
		this.orgId = orgId;
		this.isactive = isactive;
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
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


	@Override
	public String toString() {
		return "EmpFetchFields [empId=" + empId + ", orgId=" + orgId + ", isactive=" + isactive + "]";
	}
	
	
	
	

}
