package com.NamedParameterJdbcTemplate.EmployeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NamedParameterJdbcTemplate.EmployeeBean.EmpFetchFields;
import com.NamedParameterJdbcTemplate.EmployeeBean.Employee;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDetailsDto;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDtBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchQueryEmpDt;
import com.NamedParameterJdbcTemplate.EmployeeService.EmployeeService;

@RestController
public class EmployeeController {
	 @Autowired
	   EmployeeService employeeService;
//Employee Details insertion using map
	@PostMapping("/insertEmployeeDetailsUsingMap")
	Boolean insertEmployeeDetailsUsingMap(@RequestBody Employee insertEmployeeRequest){
	return employeeService.insertEmployeeDetailsUsingMap(insertEmployeeRequest);
	}
	@PostMapping("/insertEmployeeDetailsUsingSqlParameterSource")
	Boolean insertEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee insertEmployeeRequest){
	return employeeService.insertEmployeeDetailsUsingSqlParameterSource(insertEmployeeRequest);
	}
	@PostMapping("/insertEmployeeDetailssingBeanPropertySqlParameterSource")
	Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(@RequestBody Employee insertEmployeeRequest) {
	return employeeService.insertEmployeeDetailssingBeanPropertySqlParameterSource(insertEmployeeRequest);
	}
	@PutMapping("/updateEmployeeDetailsUsingMap")
	Boolean updateEmployeeDetailsUsingMap(@RequestBody Employee updateEmployeeRequest, Long empId) {
	return employeeService.updateEmployeeDetailsUsingMap(updateEmployeeRequest, empId);
	}

	@PutMapping("/updateEmployeeDetailsUsingSqlParameterSource")
	Boolean updateEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee updateEmployeeRequest, Long empId) {
	return employeeService.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest,empId);
	}
	@PutMapping("/updateEmployeeDetailssingBeanPropertySqlParameterSource")
	Boolean updateEmployeeDetailssingBeanPropertySqlParameterSource(@RequestBody Employee updateEmployeeRequest) {
	return employeeService.updateEmployeeDetailssingBeanPropertySqlParameterSource(updateEmployeeRequest);
	}
	@GetMapping("/insertEmployeeInBatch")
	public Boolean insertEmployeeInBatch(@RequestBody Employee insertEmployeeRequest) {
	return employeeService.insertEmployeeInBatch(insertEmployeeRequest);
	}

	@GetMapping("/fetchEmployeesDetailsinBatch")
	public Boolean fetchEmployeesDetailsinBatch(@RequestBody List<Employee> insertEmployeeRequestList) {
	return employeeService.fetchEmployeesDetailsinBatch(insertEmployeeRequestList);
	}
	//fetch employee with employeeId
	@GetMapping("/fetchEmpNm/{empId}")
	public String fetchEmpNm(@PathVariable("empId") long empId) {
	
		return employeeService.fetchEmpNm(empId);
		
	} 
	//fetching employee details with 3 inputs empId,orgId,isactive
	@GetMapping("/fetchEmpDt")
	public FetchEmployeeDtBean fetchEmpDt(@RequestBody EmpFetchFields emp) {
	
		return employeeService.fetchEmpDtBYId(emp);
		
	}
	//fetching all the employees details
	@GetMapping("/fetchAllEmp")
	public List<FetchEmployeeDtBean> fetchEmpBatch() {
	
		return employeeService.fetchEmpDtBatch();
		
	}
	//fetching string with request body
	@GetMapping("/fetchEmpNm1")
	public String fetchEmpString(@RequestBody EmpFetchFields emp) {
	
	return employeeService.fetchEmpNm(emp);
	}
	//fetching Employees details  of  employees having avg(Salary)
	@GetMapping("/fetchDynamicQuery")
		public List<FetchQueryEmpDt> fetchQuery() {
		return employeeService.fetchQuery();
	}
	//fetching Employee details with multiple tables
	
	@GetMapping("/fetchEmployeeDetailsDto")
	List<FetchEmployeeDetailsDto> fetchEmployeeDetailsDto(){
		return employeeService.fetchEmployeeDetailsDto();
		
	}
	
}

