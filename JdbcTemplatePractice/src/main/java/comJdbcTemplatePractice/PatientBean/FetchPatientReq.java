package comJdbcTemplatePractice.PatientBean;

public class FetchPatientReq {
	private Long sNo;
	private Boolean isactive;
	private Long orgId;
	public Long getsNo() {
		return sNo;
	}
	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	
}
