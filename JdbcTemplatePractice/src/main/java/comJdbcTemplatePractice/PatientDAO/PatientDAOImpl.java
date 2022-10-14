package comJdbcTemplatePractice.PatientDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import comJdbcTemplatePractice.PatientBean.FetchPatientReq;
import comJdbcTemplatePractice.PatientBean.PatientBean;
import comJdbcTemplatePractice.PatientBean.TemplateLoadReq;

@Repository
public class PatientDAOImpl implements PatientDAO{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbctemplate; 
	 

	@Override
	public PatientBean fetchPatientDtById(FetchPatientReq fetchPatientReq) {
		
		
	String queryToFetchPatientDtById="select s_no,org_id,created_on,patient_nm,date_of_birth,gender,mobile_no,email_id,state_nm,country_nm,pincode from patient_info_ref where s_no=? and isactive=? and org_id=?";
	
	  
	 // stateNmField=(String) fetchPatientResult.get("state_nm") ;
	 //countryNmField=(String)fetchPatientResult.get("country_nm"); 
	// String address=stateNmField+","+countryNmField;
	
		  Map<String,Object>
		  fetchPatientResult=jdbcTemplate.queryForMap(queryToFetchPatientDtById,
		  fetchPatientReq.getsNo(),fetchPatientReq.getIsactive(),fetchPatientReq.
		  getOrgId()); 
		  PatientBean patientDt=new PatientBean(); String
		  stateNmField,countryNmField;
		  
		  stateNmField=(String) fetchPatientResult.get("state_nm") ;
		  countryNmField=(String)fetchPatientResult.get("country_nm"); String
		  address=stateNmField+","+countryNmField;
		  
		  patientDt.setsNo((Long)fetchPatientResult.get("s_no"));
		  patientDt.setOrgId((Long)fetchPatientReq.getOrgId());
		  patientDt.setpCreatedOn((Date) fetchPatientResult.get("created_on"));
		  if((Long)fetchPatientReq.getOrgId()==20220616) {
		  patientDt.setPatientNm((String)fetchPatientResult.get("patient_nm"));
		  }
		  patientDt.setPatientNm((String)fetchPatientResult.get("patient_nm"));
		  patientDt.setDateOfBirth((String)fetchPatientResult.get("date_of_birth"));
		  patientDt.setGender((String)fetchPatientResult.get("gender"));
		  patientDt.setMobileNo((Long)fetchPatientResult.get("mobile_no"));
		  patientDt.setEmailId((String)fetchPatientResult.get("email_id"));
		  patientDt.setAddress(address);
		  patientDt.setPincode((String)fetchPatientResult.get("pincode"));
		  return
		  patientDt;
		 
		
		
			/*
			 * return jdbcTemplate.queryForObject(queryToFetchPatientDtById,(rs,rowNum)->{
			 * return new
			 * PatientBean(rs.getLong("s_no"),rs.getLong("org_id"),rs.getDate("created_on"),
			 * rs.getString("patient_nm"),rs.getString("date_of_birth"),rs.getString(
			 * "gender"),
			 * rs.getLong("mobile_no"),rs.getString("email_id"),rs.getString("state_nm")+rs.
			 * getString("country_nm"),rs.getString("pincode"));},fetchPatientReq.getsNo(),
			 * fetchPatientReq.getIsactive(),fetchPatientReq. getOrgId());
			 */
		}

	@Override
	public List<PatientBean> fetchAllPatientDetails(FetchPatientReq fetchPatientReq) {
		String queryToFetchPatientAllDetails="select s_no,org_id,created_on,patient_nm,date_of_birth,gender,mobile_no,email_id,state_nm,country_nm,pincode from patient_info_ref where isactive=? and org_id=?";
		
		  List<Map<String,Object>>
		  rows=jdbcTemplate.queryForList(queryToFetchPatientAllDetails,fetchPatientReq.
		  getIsactive(),fetchPatientReq.getOrgId()); List<PatientBean> patientList=new
		  ArrayList<>(); for(Map<String,Object> row:rows) {
		  
		  
		  PatientBean patientDt=new PatientBean(); String stateNmField,countryNmField;
		  
		  stateNmField=(String) row.get("state_nm") ;
		  
		  patientDt.setOrgId((Long)fetchPatientReq.getOrgId());
		  countryNmField=(String)row.get("country_nm"); String
		  address=stateNmField+"  "+countryNmField;
		
		  patientDt.setsNo((Long)row.get("s_no")); 
		  patientDt.setpCreatedOn((Date)row.get("created_on"));
		  patientDt.setPatientNm((String)row.get("patient_nm"));
		  patientDt.setDateOfBirth((String)row.get("date_of_birth"));
		  patientDt.setGender((String)row.get("gender"));
		  patientDt.setMobileNo((Long)row.get("mobile_no"));
		  patientDt.setEmailId((String)row.get("email_id"));
		  patientDt.setAddress(address);
		  patientDt.setPincode((String)row.get("pincode"));
		  
		  //patient details adding to list
		  patientList.add(patientDt); }
		  
		  return patientList;
		 
		
		/*//jdbcTemplate query using
		 * return jdbcTemplate.query(queryToFetchPatientAllDetails,(rs,rowNum)->{ return
		 * new
		 * PatientBean(rs.getLong("s_no"),rs.getLong("org_id"),rs.getDate("created_on"),
		 * rs.getString("patient_nm"),rs.getString("date_of_birth"),rs.getString(
		 * "gender"),
		 * rs.getLong("mobile_no"),rs.getString("email_id"),rs.getString("state_nm")+rs.
		 * getString("country_nm"),rs.getString("pincode"));},fetchPatientReq.
		 * getIsactive(),fetchPatientReq. getOrgId());
		 */
	}

	@Override
	public Boolean insertPatientDetails(PatientBean patientDt) {
		String queryForInsertPateintDt="INSERT INTO patient_info_ref(org_id,created_on, patient_nm, date_of_birth, gender, mobile_no, email_id, state_nm, country_nm, pincode,  isactive )	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String address=patientDt.getAddress();
		String[] addr=address.split(",",2);
		Boolean res=false;
		
		try {
			jdbcTemplate.update(queryForInsertPateintDt,patientDt.getOrgId(),patientDt.getpCreatedOn(),patientDt.getPatientNm(),patientDt.getDateOfBirth(),patientDt.getGender(),patientDt.getMobileNo(),patientDt.getEmailId(),addr[0],addr[0],patientDt.getPincode(),true);
				
			res=true;
		}catch(Exception e) {e.printStackTrace();}		return res;
	}

	@Override
	public Boolean updatePatientDetails(PatientBean patientDt) {
		String queryForUpdatePateintDt="UPDATE  patient_info_ref set org_id=?,created_on=?, patient_nm=?,date_of_birth=?, gender=?, mobile_no=?, email_id=?, state_nm=?, country_nm=?, pincode=?  WHERE s_no=? ";
		 
		  String address=patientDt.getAddress(); 
		  String[] addr=address.split(",",2);
		  System.out.println(addr[0]+addr[1]);
		 
		
		Boolean res=false;
		try {
			jdbcTemplate.update(queryForUpdatePateintDt,patientDt.getOrgId(),patientDt.getpCreatedOn(),patientDt.getPatientNm(),patientDt.getDateOfBirth(),patientDt.getGender(),patientDt.getMobileNo(),patientDt.getEmailId(),addr[0],addr[1],patientDt.getPincode(),patientDt.getsNo());	
		res=true;
		}catch(Exception e) {e.printStackTrace();}
		
		
		return res;
	}

	@Override
	public String loadTemplate(TemplateLoadReq tempReq)throws Exception {
		String queryToLoadTemplate=("select template_code from template_info_ref where template_id="+tempReq.getTemplateId());
		
		return namedParameterJdbctemplate.queryForObject(queryToLoadTemplate,new BeanPropertySqlParameterSource(tempReq),String.class);
		
		
		
	}

	@Override
	public TemplateLoadReq fetchResultTemplate(TemplateLoadReq templateRes) {
		String queryToFetchResultTemplate="select template_code,template_result from template_info_ref tir,template_result_info tri where tir.template_id=tri.template_id ";
		return namedParameterJdbctemplate.queryForObject(queryToFetchResultTemplate, new BeanPropertySqlParameterSource(templateRes),new BeanPropertyRowMapper<TemplateLoadReq>(TemplateLoadReq.class));
	}
	
	
	
	
	

}
