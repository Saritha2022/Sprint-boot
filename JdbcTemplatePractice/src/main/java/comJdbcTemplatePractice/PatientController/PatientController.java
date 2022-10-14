package comJdbcTemplatePractice.PatientController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comJdbcTemplatePractice.PatientBean.FetchPatientReq;
import comJdbcTemplatePractice.PatientBean.PatientBean;
import comJdbcTemplatePractice.PatientBean.TemplateLoadReq;

@RestController
public class PatientController {
	
	@Autowired
	PatientService  patientService;
	
	@GetMapping("/fetchPatientById")
	public PatientBean fetchPatientDtById(@RequestBody FetchPatientReq fetchPatientReq) {
		return patientService.fetchPatientDtById(fetchPatientReq);
	}

	@GetMapping("/fetchAllPatientsDt")
	public List<PatientBean> fetchAllPatientDetails(@RequestBody FetchPatientReq fetchPatientReq) {
		return patientService.fetchAllPatientDetails(fetchPatientReq);
		
	}
	@PostMapping("/insertPatientsDt")
	public Boolean insertPatientDetails(@RequestBody PatientBean patientDt) {
		return patientService.insertPatientDetails(patientDt);
	}
	@PutMapping("/updatePatientDetails")
	public Boolean updatePatientDetails(@RequestBody PatientBean patientDt) {
		return patientService.updatePatientDetails(patientDt);	
	}
	
	@PostMapping("/fetchTemplate")
	public String loadTemplate(@RequestBody TemplateLoadReq tempReq) throws Exception{
		return patientService.loadTemplate(tempReq);
}
	@PostMapping("/fetchResultTemplate")
	public TemplateLoadReq fetchResultTemplate(TemplateLoadReq templateRes) {
		return patientService.fetchResultTemplate(templateRes);
	}
}
