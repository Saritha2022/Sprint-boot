package com.NamedParameterJdbcTemplate.EmployeeBean;

public class EmployeeDepartmentsXref {
	private Long empDeptId;
	private String deptId;
	private Long orgId;
	private Boolean isactive;
	
		
	public EmployeeDepartmentsXref() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDepartmentsXref(Long empDeptId, String deptId, Long orgId, Boolean isactive) {
		super();
		this.empDeptId = empDeptId;
		this.deptId = deptId;
		this.orgId = orgId;
		this.isactive = isactive;
	}
	public Long getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(Long empDeptId) {
		this.empDeptId = empDeptId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
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
		return "EmployeeDepartmentsXref [empDeptId=" + empDeptId + ", deptId=" + deptId + ", orgId=" + orgId
				+ ", isactive=" + isactive + "]";
	}
	
	


}
