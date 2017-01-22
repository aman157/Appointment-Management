package org.mz.action;

import java.util.List;
import java.util.Map;



import org.apache.struts2.interceptor.SessionAware;
import org.mz.modal.AcademicDetailsModal;
import org.mz.modal.AddingFeeDetails;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginActionTrainee extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private List<AcademicDetailsModal> academicDetailsFromDatabase;
	private List<AddingFeeDetails> addingFeedetailsFromDatabase;
	
	private Map<String, Object> session;
	
	
	public String execute(){
		String traineeUid=meetingSlipEntryModal.getUid();
		String password=meetingSlipEntryModal.getPassword();
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		boolean status=meetingSlipService.traineeLogin(traineeUid,password);
		
		if(status){
			session.put("traineeUid", traineeUid);
			return SUCCESS;
		}
		else{
			return "loginTrainee";
		}

	}
	
	
	public String checkTrainee(){
		     
		String uid=(String)session.get("traineeUid");

		MeetingSlipService meetingSlipService=new MeetingSlipService();
		setAcademicDetailsFromDatabase(meetingSlipService.getTraineeDetails(uid,meetingSlipEntryModal));
		setAddingFeedetailsFromDatabase(meetingSlipService.feeMonths(uid));
		
		return SUCCESS;

	}
	
	
	public String logout(){
		String s=(String) session.get("traineeUid");
		session.remove("traineeUid");
		return "loginTrainee";
	}
	
	
	

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}

	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}
	
	@Override
	public MeetingSlipEntryModal getModel() {
		// TODO Auto-generated method stub
		return meetingSlipEntryModal;
	}


	public List<AcademicDetailsModal> getAcademicDetailsFromDatabase() {
		return academicDetailsFromDatabase;
	}


	public void setAcademicDetailsFromDatabase(
			List<AcademicDetailsModal> academicDetailsFromDatabase) {
		this.academicDetailsFromDatabase = academicDetailsFromDatabase;
	}


	public List<AddingFeeDetails> getAddingFeedetailsFromDatabase() {
		return addingFeedetailsFromDatabase;
	}


	public void setAddingFeedetailsFromDatabase(
			List<AddingFeeDetails> addingFeedetailsFromDatabase) {
		this.addingFeedetailsFromDatabase = addingFeedetailsFromDatabase;
	}

}
