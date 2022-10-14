package comJdbcTemplatePractice.PatientDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import comJdbcTemplatePractice.PatientBean.FetchPatientReq;
import comJdbcTemplatePractice.PatientBean.PatientBean;
import comJdbcTemplatePractice.PatientBean.TemplateLoadReq;

@Repository
public interface PatientDAO {
	public PatientBean fetchPatientDtById(FetchPatientReq fetchPatientReq);
	public List<PatientBean> fetchAllPatientDetails(FetchPatientReq fetchPatientReq);
	public Boolean insertPatientDetails(PatientBean patientDt);
	public Boolean updatePatientDetails(PatientBean patientDt);
	public String loadTemplate(TemplateLoadReq tempReq)throws Exception ;
	public TemplateLoadReq fetchResultTemplate(TemplateLoadReq templateRes);

}
