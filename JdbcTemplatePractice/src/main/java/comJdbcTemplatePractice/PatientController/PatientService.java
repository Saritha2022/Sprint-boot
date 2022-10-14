package comJdbcTemplatePractice.PatientController;

import java.util.List;

import org.springframework.stereotype.Service;

import comJdbcTemplatePractice.PatientBean.FetchPatientReq;
import comJdbcTemplatePractice.PatientBean.PatientBean;
import comJdbcTemplatePractice.PatientBean.TemplateLoadReq;

@Service
public interface PatientService {
	public PatientBean fetchPatientDtById(FetchPatientReq fetchPatientReq);
	public List<PatientBean> fetchAllPatientDetails(FetchPatientReq fetchPatientReq);
	public Boolean insertPatientDetails(PatientBean patientDt);
	public Boolean updatePatientDetails(PatientBean patientDt);
	public String loadTemplate(TemplateLoadReq tempReq) throws Exception;
	public TemplateLoadReq fetchResultTemplate(TemplateLoadReq templateRes);

}
