package com.NamedParameterJdbcTemplate.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.NamedParameterJdbcTemplate.EmployeeBean.EmpFetchFields;
import com.NamedParameterJdbcTemplate.EmployeeBean.Employee;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDetailsDto;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDtBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchQueryEmpDt;
import com.NamedParameterJdbcTemplate.EmployeeDAO.EmployeeDAOImpl;


@Service
public interface EmployeeService {

Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest);
Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest);
Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource1(Employee insertEmployeeRequest);

Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId);
Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest, Long empId);
Boolean updateEmployeeDetailssingBeanPropertySqlParameterSource(Employee updateEmployeeRequest);

Boolean insertEmployeeInBatch(Employee insertEmployeeRequest);
Boolean fetchEmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList);
Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(Employee insertEmployeeRequest);
Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(EmployeeDAOImpl insertEmployeeRequest);
Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource11(Employee insertEmployeeRequest);
public String fetchEmpNm(Long empId);
public FetchEmployeeDtBean fetchEmpDtBYId(EmpFetchFields reqEmpDt);
List<FetchEmployeeDtBean> fetchEmpDtBatch();
public String fetchEmpNm(EmpFetchFields empFetchFields);
List<FetchQueryEmpDt> fetchQuery();
List<FetchEmployeeDetailsDto> fetchEmployeeDetailsDto();



}