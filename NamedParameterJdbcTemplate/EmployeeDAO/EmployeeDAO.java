package com.NamedParameterJdbcTemplate.EmployeeDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.NamedParameterJdbcTemplate.EmployeeBean.EmpFetchFields;
import com.NamedParameterJdbcTemplate.EmployeeBean.Employee;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDetailsDto;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDtBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchQueryEmpDt;

@Repository
public interface EmployeeDAO {
	Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(Employee insertEmployeeRequest);

	Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId);
	Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest, Long empId);
	Boolean updateEmployeeDetailssingBeanPropertySqlParameterSource(Employee updateEmployeeRequest);

	Boolean insertEmployeeInBatch(Employee insertEmployeeRequest);
	//Boolean fetchEmployeesDetailsinBatch(List<Employee> EmployeeRequest);
	Boolean fetchEmployeesDetailsinBatch(List<Employee> employeeRequest);
String fetchEmpNm(Long empId);
FetchEmployeeDtBean fetchEmpDtById(EmpFetchFields reqEmpDt);
List<FetchEmployeeDtBean> fetchEmpDtBatch();

String fetchEmployeeNm(EmpFetchFields empFetchFields);
List<FetchQueryEmpDt> fetchQuery();
List<FetchEmployeeDetailsDto> fetchEmployeeDetailsDto();
}
