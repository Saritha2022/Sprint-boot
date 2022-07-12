package com.NamedParameterJdbcTemplate.EmployeeDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.NamedParameterJdbcTemplate.EmployeeBean.EmpFetchFields;
import com.NamedParameterJdbcTemplate.EmployeeBean.Employee;
import com.NamedParameterJdbcTemplate.EmployeeBean.EmployeeDepartmentsXref;
import com.NamedParameterJdbcTemplate.EmployeeBean.EmployeeDeptBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.EmployeeDesignationBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.EmployeeDesignationXref;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDetailsDto;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchEmployeeDtBean;
import com.NamedParameterJdbcTemplate.EmployeeBean.FetchQueryEmpDt;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean insertEmployeeInBatch(Employee insertEmployeeRequest) {
		
		
	String queryToInsertEmployeeDetails = "Insert into employee_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_no,state_nm,country_nm,city_nm,org_id,isactive)"
	+ "values(:empId,:lastNm,:firstNm,:middleNm,:empCode,:mobileNo,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";
	KeyHolder holder = new GeneratedKeyHolder();
	int count = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
	new BeanPropertySqlParameterSource(insertEmployeeRequest), holder, new String[] { "emp_id" });
	long empId = holder.getKey().longValue();
	Boolean result = false;
	if (count > 0) {
	String queryForInsertEmployeeDepartments = "insert into employee_dept_xref (emp_design_id,designation_id,emp_id,org_id,isactive) values(:empId,:deptId,true)";
	if (insertEmployeeRequest.getDepartmentList() != null
	&& insertEmployeeRequest.getDepartmentList().size() > 0)
	for (EmployeeDepartmentsXref empDepartmentRef : insertEmployeeRequest.getDepartmentList()) {

	MapSqlParameterSource map = new MapSqlParameterSource();
	map.addValue("empId", empId);
	map.addValue("deptId", empDepartmentRef.getDeptId());
	result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDepartments, map) > 0;
	}
	String queryForInsertEmployeeDesignation = "insert into employee_designation_xref (emp_id,designation_id,isactive) values(:empId,:designationId,true)";
	if (insertEmployeeRequest.getDesignationList() != null
	&& insertEmployeeRequest.getDesignationList().size() > 0)
	for (EmployeeDesignationXref empDesignationRef : insertEmployeeRequest.getDesignationList()) {
	MapSqlParameterSource parameters = new MapSqlParameterSource()
	.addValue("empId", empId)
	.addValue("designationId", empDesignationRef.getDesignationId());
	result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDesignation, parameters) > 0;
	}
	}
	return result;
	}
	
	
	@Override
	public Boolean fetchEmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList) {
		
		
	Boolean result = false;
	for (Employee employee : insertEmployeeRequestList) {
	int count = 0;
	KeyHolder holder = new GeneratedKeyHolder();
	String queryToInsertEmployeeDetails = "Insert into employee_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_no,state_nm,country_nm,city_nm,org_id,isactive)"
	+ "values(:empId,:lastNm,:firstNm,:middleNm,:empCode,:mobileNo,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";
	if(employee.getEmpId() == null) {
	count = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
	new BeanPropertySqlParameterSource(employee), holder, new String[] { "emp_id" });
	Long key = holder.getKey().longValue();
	employee.setEmpId(key);

	} else {
	String queryForUpdateEmployeeData = "Update employee_info_ref set first_nm=:firstNm,last_nm=:lastNm,mobile_no=:mobileNo where emp_id=:empId";
	count = namedParameterJdbcTemplate.update(queryForUpdateEmployeeData,
	new BeanPropertySqlParameterSource(employee));
	}
	if (count > 0) {

	String queryToInsertEmpDeprtments = "insert into employee_department_ref (dept_id,emp_id,isactive) values (:deptId,:empId,true)";
	List<EmployeeDepartmentsXref> empDeptRefSave = new ArrayList<>();
	if (employee.getDepartmentList() != null
	&& employee.getDepartmentList().size() > 0)
	for (EmployeeDepartmentsXref employeeDeptBean : employee.getDepartmentList()) {
	employeeDeptBean.setEmpDeptId(holder.getKey().longValue());
	empDeptRefSave.add(employeeDeptBean);
	}

	SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(empDeptRefSave.toArray());
	namedParameterJdbcTemplate.batchUpdate(queryToInsertEmpDeprtments, parameters);

	String queryToInsertEmpDesignations = "insert into employee_designation_ref (designation_id,emp_id,isactive) values (:designationId,:empId,true)";
	List<EmployeeDesignationXref> empDesignationRefSave = new ArrayList<>();
	if (employee.getDesignationList() != null
	&& employee.getDesignationList().size() > 0) {
	for (EmployeeDesignationXref employeeDesignationBean : employee.getDesignationList()) {
	employeeDesignationBean.setEmpId(holder.getKey().longValue());
	empDesignationRefSave.add(employeeDesignationBean);
	SqlParameterSource[] values = SqlParameterSourceUtils
	.createBatch(empDesignationRefSave.toArray());
	namedParameterJdbcTemplate.batchUpdate(queryToInsertEmpDesignations, values);

	}

	}

	}

	}
	return result;
	}
	@Override
	public Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(Employee insertEmployeeRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest, Long empId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateEmployeeDetailssingBeanPropertySqlParameterSource(Employee updateEmployeeRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	//@Override
	//public Boolean fetchEmployeesDetailsinBatch(List<Employee> employeeRequest){
	//	// TODO Auto-generated method stub
	//	return null;
	//}

@Override
	public String fetchEmpNm(Long empId) {
		String queryToFetchEmpNm="select concat(first_nm,' ',middle_nm,' ',last_nm) empName from employee_info_ref where org_id=6789 and emp_id="+empId+" and isactive=true";
		
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.queryForObject(queryToFetchEmpNm, new BeanPropertySqlParameterSource(queryToFetchEmpNm),String.class);
	}

@Override
	public FetchEmployeeDtBean fetchEmpDtById(EmpFetchFields reqEmpDt) {
		

	
	//System.out.println(empFetchFields.getEmpId()+"   "+empFetchFields.getOrgId()+"  "+empFetchFields.getIsactive());
	
	String queryToFetchEmpDtById="select emp_id,first_nm,middle_nm,last_nm,email_id,emp_code,mobile_no,state_nm,country_nm,city_nm,org_id,isactive,address,pincode,alternate_mobile_no from employee_info_ref where emp_id=:empId and org_id=:orgId and isactive=:isactive";
		
		
		FetchEmployeeDtBean fetchEmpDt=new FetchEmployeeDtBean();
		Map<String,Object> map=namedParameterJdbcTemplate.queryForMap(queryToFetchEmpDtById,new BeanPropertySqlParameterSource(reqEmpDt));
	
		//fetchEmpDt.setEmpId(empId);
		fetchEmpDt.setEmpId((Long)map.get("emp_id"));
		fetchEmpDt.setFirstNm((String)map.get("first_nm"));
		fetchEmpDt.setMiddleNm((String)map.get("middle_nm"));
		fetchEmpDt.setLastNm((String)map.get("last_nm"));
		fetchEmpDt.setEmailId((String)map.get("email_id"));
		fetchEmpDt.setEmpCode((String)map.get("emp_code"));
		fetchEmpDt.setMobileNo((Long)map.get("mobile_no"));
		fetchEmpDt.setStateNm((String)map.get("state_nm"));
		fetchEmpDt.setCountryNm((String)map.get("country_nm"));
		fetchEmpDt.setCityNm((String)map.get("city_nm"));
		fetchEmpDt.setOrgId((Long)map.get("org_id"));
		fetchEmpDt.setAlternateMobileNo((Long)map.get("alternate_mobile_no"));
		fetchEmpDt.setIsactive((Boolean)map.get("isactive"));
		fetchEmpDt.setAddress((String)map.get("address"));
		fetchEmpDt.setPincode((String)map.get("pincode"));

		
		return fetchEmpDt;
	}


@Override
public List<FetchEmployeeDtBean> fetchEmpDtBatch() {
	String queryToFetchEmpDtBatch="select emp_id,first_nm,middle_nm,last_nm,emp_code,mobile_no,state_nm,country_nm,org_id,isactive,address,pincode,email_id,alternate_mobile_no,city_nm from employee_info_ref";
	List<Map<String,Object>> rows=namedParameterJdbcTemplate.queryForList(queryToFetchEmpDtBatch,new BeanPropertySqlParameterSource(queryToFetchEmpDtBatch));
	
	List<FetchEmployeeDtBean> fetchEmpList=new ArrayList<>();
	//if(CollectionUtils.getIndexMap(rows)){
	//if (null == rows || rows.isEmpty()) {
	try {
	for(Map<String,Object> row:rows)
	{
		FetchEmployeeDtBean fetchEmpDt=new FetchEmployeeDtBean();
		fetchEmpDt.setEmpId((Long)row.get("emp_id"));
		fetchEmpDt.setFirstNm((String)row.get("first_nm"));
		fetchEmpDt.setMiddleNm((String)row.get("middle_nm"));
		fetchEmpDt.setLastNm((String)row.get("last_nm"));
		fetchEmpDt.setEmailId((String)row.get("email_id"));
		fetchEmpDt.setEmpCode((String)row.get("emp_code"));
		fetchEmpDt.setMobileNo((Long)row.get("mobile_no"));
		fetchEmpDt.setStateNm((String)row.get("state_nm"));
		fetchEmpDt.setCountryNm((String)row.get("country_nm"));
		fetchEmpDt.setCityNm((String)row.get("city_nm"));
		fetchEmpDt.setOrgId((Long)row.get("org_id"));
		fetchEmpDt.setAlternateMobileNo((Long)row.get("alternate_mobile_no"));
		fetchEmpDt.setIsactive((Boolean)row.get("isactive"));
		fetchEmpDt.setAddress((String)row.get("address"));
		fetchEmpDt.setPincode((String)row.get("pincode"));
		
		
		
		fetchEmpList.add(fetchEmpDt);
	//}
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return fetchEmpList;
}


@Override
public String fetchEmployeeNm(EmpFetchFields empFetchFields) {
	
	
	MapSqlParameterSource map = new MapSqlParameterSource();
	
	map.addValue("empId",empFetchFields.getEmpId());
	map.addValue("orgId",empFetchFields.getOrgId());
	map.addValue("isactive",empFetchFields.getIsactive());
		
	String queryToFetchEmpNm="select concat(first_nm,' ',middle_nm,' ',last_nm) empName from employee_info_ref where org_id=:orgId and emp_id=:empId and isactive=:isactive";
	
	return namedParameterJdbcTemplate.queryForObject(queryToFetchEmpNm,new BeanPropertySqlParameterSource(empFetchFields),String.class);
	
	
}


@Override
public List<FetchQueryEmpDt> fetchQuery() {
	String queryDynamic="SELECT first_name, salary, dept_name  FROM emp_model WHERE salary >(SELECT AVG(salary)"
			+ " FROM emp_model  WHERE dept_name = emp_model.dept_name)";
	List<FetchQueryEmpDt> fetchEmpDtlist=new ArrayList<>();
	
	List<Map<String,Object>> rows=namedParameterJdbcTemplate.queryForList(queryDynamic,new BeanPropertySqlParameterSource(queryDynamic));
	try {
		for(Map<String,Object> row:rows){
			FetchQueryEmpDt fetchEmpDt=new FetchQueryEmpDt();
			fetchEmpDt.setFirstNm((String)row.get("first_name"));
	     	fetchEmpDt.setSalary((Long)row.get("salary"));
	        fetchEmpDt.setDeptNm((String)row.get("dept_name"));
	        fetchEmpDtlist.add(fetchEmpDt);
	       
         }
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return fetchEmpDtlist;
	}


@Override
public List<FetchEmployeeDetailsDto> fetchEmployeeDetailsDto() {
	
	
	String queryToFetchEmployeeDetailsDto="select eir.emp_id,eir.first_nm,eir.middle_nm,eir.last_nm,eir.mobile_no,\r\n"
			+ "edx.emp_design_id,edx.designation_id,dr.designation_nm,edr.emp_dept_id,edr.dept_id,dp.dept_nm\r\n"
			+ "from employee_info_ref eir,\r\n"
			+ " employee_designation_xref edx,designation_ref dr, employee_departments_xref edr,department_ref dp\r\n"
			+ " where\r\n"
			+ "eir.emp_id=edx.emp_id and edx.emp_id=edr.emp_id\r\n"
			+ "and edx.isactive=true\r\n"
			+ "and edx.designation_id=dr.designation_id\r\n"
			+ "and edr.dept_id=dp.dept_id order by eir.emp_id asc ";
	List<FetchEmployeeDetailsDto> empList= new ArrayList<>();

	List<Map<String,Object>> rows=namedParameterJdbcTemplate.queryForList(queryToFetchEmployeeDetailsDto, new BeanPropertySqlParameterSource(queryToFetchEmployeeDetailsDto));
	FetchEmployeeDetailsDto fetchEmployeeDetailsDto = null;
		List<EmployeeDeptBean> empDeptList = null;
		List<EmployeeDesignationBean> empDesignationList=null;
		Set<Long> set = new HashSet<>();
		try {
		int count = 0;

		for (Map<String, Object> row : rows) {

			count++;
		

			if (set.add((Long) row.get("emp_id"))) {

				if (fetchEmployeeDetailsDto != null) 
				{
					if	 (CollectionUtils.isNotEmpty(empDesignationList)) {
						
						fetchEmployeeDetailsDto.setEmpDesignationList(empDesignationList);
						
					}
				}
					
				
				
				// employee basic details
				
				fetchEmployeeDetailsDto = new FetchEmployeeDetailsDto();
				fetchEmployeeDetailsDto.setEmpId((Long)row.get("emp_id"));
				fetchEmployeeDetailsDto.setFirstNm((String)row.get("first_nm"));
				fetchEmployeeDetailsDto.setMiddleNm((String)row.get("middle_nm"));
				fetchEmployeeDetailsDto.setLastNm((String)row.get("last_nm"));
				fetchEmployeeDetailsDto.setMobileNo((Long)row.get("mobile_no"));
				
				empList.add(fetchEmployeeDetailsDto);

				
				
				empDeptList = new ArrayList<>();	

			}
			 if (CollectionUtils.isNotEmpty(empDeptList)) {
				 fetchEmployeeDetailsDto.setEmpDeptList(empDeptList);
				 
			 }
			 
			if (row.get("dept_id") != null) {
				
				// department  details

				EmployeeDeptBean employeeDeptBean = new EmployeeDeptBean();
				employeeDeptBean.setDeptId((Long) row.get("dept_id"));
				employeeDeptBean.setEmpDeptId((Long)row.get("emp_dept_id"));
				employeeDeptBean.setDeptNm((String)row.get("dept_nm"));
				empDeptList.add(employeeDeptBean);
				
				empDesignationList=new ArrayList<>();
				
			}
			
			
			 if (row.get("designation_id") != null) {
				 //designation details
					EmployeeDesignationBean empDesignationBean=new EmployeeDesignationBean();
					empDesignationBean.setDesignationId((Long)row.get("designation_id"));
					empDesignationBean.setEmpDesignId((Long)row.get("emp_design_id"));
					empDesignationBean.setDesignationNm((String)row.get("designation_nm"));
					empDesignationList.add(empDesignationBean);
					
					
				}
					  
		}  
		if (count == rows.size() && fetchEmployeeDetailsDto != null) {

			if (CollectionUtils.isNotEmpty(empDeptList) && CollectionUtils.isNotEmpty(empDesignationList)) {
				
				//adding designationList and departmentList to EmployeeDetails
				
				fetchEmployeeDetailsDto.setEmpDeptList(empDeptList);
				fetchEmployeeDetailsDto.setEmpDesignationList(empDesignationList);
				//empList.add(fetchEmployeeDetailsDto);

			}
		
			empList.add(fetchEmployeeDetailsDto);

		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empList;
	}
}

	
	 


