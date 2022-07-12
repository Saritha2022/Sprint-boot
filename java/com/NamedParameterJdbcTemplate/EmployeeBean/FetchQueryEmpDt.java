package com.NamedParameterJdbcTemplate.EmployeeBean;

public class FetchQueryEmpDt {
	private String firstNm;
	private Long salary;
	private String deptNm;
	public FetchQueryEmpDt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FetchQueryEmpDt(String firstNm, Long salary, String deptNm) {
		super();
		this.firstNm = firstNm;
		this.salary = salary;
		this.deptNm = deptNm;
	}
	public String getFirstNm() {
		return firstNm;
	}
	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	@Override
	public String toString() {
		return "FetchQueryEmpDt [firstNm=" + firstNm + ", salary=" + salary + ", deptNm=" + deptNm + "]";
	}
	
	

}
