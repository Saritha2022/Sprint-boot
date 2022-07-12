package com.NamedParameterJdbcTemplate.EmployeeBean;

public class EmployeeDesignationXref {
	private Long empDesignationId;
    private Long designationId;
    private String designationNm;
    private Long empId;
    private Long orgId;
    private Boolean isactive;
    
    
    
	public EmployeeDesignationXref() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDesignationXref(Long empDesignationId, Long designationId, String designationNm, Long empId,
			Long orgId, Boolean isactive) {
		super();
		this.empDesignationId = empDesignationId;
		this.designationId = designationId;
		this.designationNm = designationNm;
		this.empId = empId;
		this.orgId = orgId;
		this.isactive = isactive;
	}
	public Long getEmpDesignationId() {
		return empDesignationId;
	}
	public void setEmpDesignationId(Long empDesignationId) {
		this.empDesignationId = empDesignationId;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public String getDesignationNm() {
		return designationNm;
	}
	public void setDesignationNm(String designationNm) {
		this.designationNm = designationNm;
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
		return "EmployeeDesignationXref [empDesignationId=" + empDesignationId + ", designationId=" + designationId
				+ ", designationNm=" + designationNm + ", empId=" + empId + ", orgId=" + orgId + ", isactive="
				+ isactive + "]";
	}
    
    
    
    
}
