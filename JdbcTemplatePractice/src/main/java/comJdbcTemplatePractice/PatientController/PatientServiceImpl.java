package comJdbcTemplatePractice.PatientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comJdbcTemplatePractice.PatientBean.FetchPatientReq;
import comJdbcTemplatePractice.PatientBean.PatientBean;
import comJdbcTemplatePractice.PatientBean.TemplateLoadReq;
import comJdbcTemplatePractice.PatientDAO.PatientDAO;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientDAO patientDAO;

	@Override
	public PatientBean fetchPatientDtById(FetchPatientReq fetchPatientReq) {
		// TODO Auto-generated method stub
		return patientDAO.fetchPatientDtById(fetchPatientReq);
	}

	@Override
	public List<PatientBean> fetchAllPatientDetails(FetchPatientReq fetchPatientReq) {
		// TODO Auto-generated method stub
		return patientDAO.fetchAllPatientDetails(fetchPatientReq);
	}

	@Override
	public Boolean insertPatientDetails(PatientBean patientDt) {
		// TODO Auto-generated method stub
		return patientDAO.insertPatientDetails(patientDt);
	}

	@Override
	public Boolean updatePatientDetails(PatientBean patientDt) {
		// TODO Auto-generated method stub
		return patientDAO.updatePatientDetails(patientDt);
	}

	@Override
	public String loadTemplate(TemplateLoadReq tempReq) throws Exception {
		// TODO Auto-generated method stub
		return patientDAO.loadTemplate(tempReq);
	}

	@Override
	public TemplateLoadReq fetchResultTemplate(TemplateLoadReq templateRes) {
		// TODO Auto-generated method stub
		return patientDAO.fetchResultTemplate(templateRes);
	}
	

}
