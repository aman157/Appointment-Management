package org.mz.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class loginAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal = new MeetingSlipEntryModal();
	private ArrayList<MeetingSlipEntryModal> arrayList;
	private Map<String, Object> session;
	



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
/*	public void validate(){
		String emailId=meetingSlipEntryModal.getEmail();
		String password=meetingSlipEntryModal.getPassword();
		if(emailId==null){
			addFieldError("emailId", "Cannot be NULL");
		}
		
		if(password==null){
			addFieldError("password", "Cannot be NULL");
		}else if(password.trim().length()<4 || password.trim().length()>30){
			System.out.println(password);
			addFieldError("passwordError", "Password must be 6 to 30 characters long");
		}
	}*/

	public String execute(){

		MeetingSlipService meetingSlipService=new MeetingSlipService();
		int loginResult=meetingSlipService.adminLogin(meetingSlipEntryModal.getEmail(),meetingSlipEntryModal.getPassword());
		if(loginResult==1){
			session.put("adminMail", meetingSlipEntryModal.getEmail());
			String sessionName=(String)session.get("adminMail");
			return SUCCESS;
		}
		else{
			addActionError("UserName or Password is Incorrect");
			return ERROR;
		}
	}
	
	public String check(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		arrayList=meetingSlipService.login();
		return SUCCESS;

	}
	
	public String logout(){
		session.remove("adminMail");
		addActionMessage("you have been successfully logout");
		return "login";
	}

	@Override
	public MeetingSlipEntryModal getModel() {
		// TODO Auto-generated method stub
		return meetingSlipEntryModal;
	}


	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}


	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}
	
	
	
	public ArrayList<MeetingSlipEntryModal> getArrayList() {
		return arrayList;
	}


	public void setArrayList(ArrayList<MeetingSlipEntryModal> arrayList) {
		this.arrayList = arrayList;
	}
	


}
