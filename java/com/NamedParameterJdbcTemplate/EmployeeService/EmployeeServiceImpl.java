package com.NamedParameterJdbcTemplate.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NamedParameterJdbcTemplate.EmployeeBean.EmpFetchFields;
import com.NamedParameterJdbcTemplate.EmployeeBean.Employee;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDetailsDto;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDtBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchQueryEmpDt;
import com.NamedParameterJdbcTemplate.EmployeeDAO.EmployeeDAO;
import com.NamedParameterJdbcTemplate.EmployeeDAO.EmployeeDAOImpl;



@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeDAO service;

@Override
public Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest) {

return service.insertEmployeeDetailsUsingMap(insertEmployeeRequest);
}

@Override
public Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest) {

return service.insertEmployeeDetailsUsingSqlParameterSource(insertEmployeeRequest);
}

@Override
public Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource11(Employee insertEmployeeRequest) {

return service.insertEmployeeDetailssingBeanPropertySqlParameterSource(insertEmployeeRequest);
}

@Override
public Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId) {

return service.insertEmployeeDetailssingBeanPropertySqlParameterSource(updateEmployeeRequest);
}

@Override
public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest, Long empId) {

return service.insertEmployeeDetailssingBeanPropertySqlParameterSource(updateEmployeeRequest);
}

@Override
public Boolean updateEmployeeDetailssingBeanPropertySqlParameterSource(Employee updateEmployeeRequest) {

return service.insertEmployeeDetailssingBeanPropertySqlParameterSource(updateEmployeeRequest);
}

@Override
public Boolean fetchEmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList) {
return service.fetchEmployeesDetailsinBatch(insertEmployeeRequestList);
}

@Override
public Boolean insertEmployeeInBatch(Employee insertEmployeeRequest) {

return service.insertEmployeeInBatch(insertEmployeeRequest);
}

@Override
public Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(Employee insertEmployeeRequest) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource1(Employee insertEmployeeRequest) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(EmployeeDAOImpl insertEmployeeRequest) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String fetchEmpNm(Long empId) {
	// TODO Auto-generated method stub
	return service.fetchEmpNm(empId);
}

@Override
public FetchEmployeeDtBean fetchEmpDtBYId(EmpFetchFields reqEmpDt) {
	// TODO Auto-generated method stub
	return service.fetchEmpDtById(reqEmpDt);
}

@Override
public List<FetchEmployeeDtBean> fetchEmpDtBatch() {
	// TODO Auto-generated method stub
	return service.fetchEmpDtBatch();
}

@Override
public String fetchEmpNm(EmpFetchFields empFetchFields) {
	// TODO Auto-generated method stub
	return service.fetchEmployeeNm(empFetchFields);
}

@Override
public List<FetchQueryEmpDt> fetchQuery() {
	// TODO Auto-generated method stub
	return service.fetchQuery();
}

@Override
public List<FetchEmployeeDetailsDto> fetchEmployeeDetailsDto() {
	return service.fetchEmployeeDetailsDto();
}
}
