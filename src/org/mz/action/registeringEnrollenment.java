package org.mz.action;

import java.util.Random;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class registeringEnrollenment extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	
	private static final long serialVersionUID = 1L;
	private String uidForEnrolled;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private String identity="notEmail";
	

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String execute(){
		if(identity.equals("email")){
			MeetingSlipService meetingSlipService=new MeetingSlipService();
			boolean toggle=meetingSlipService.checkingEnrollnmentInsideDatabase(uidForEnrolled,meetingSlipEntryModal);
			if (toggle==true){
				return ERROR;
			}
			else{
				Random random=new Random();
				int randomInteger = random.nextInt(1000);
				String randomStr =Integer.toString(randomInteger);
				String appliactionFormNumber=uidForEnrolled+"-"+randomStr;
				meetingSlipEntryModal.setUid(uidForEnrolled);
				meetingSlipEntryModal.setApplicationFormNumber(appliactionFormNumber);
				return "SUCCESSFORMAILUSER";
			}
			
			
		}
		else{
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		boolean toggle=meetingSlipService.checkingEnrollnmentInsideDatabase(uidForEnrolled,meetingSlipEntryModal);
		
		if (toggle==true){
			return ERROR;
		}
		else{
			Random random=new Random();
			int randomInteger = random.nextInt(1000);
			String randomStr =Integer.toString(randomInteger);
			String appliactionFormNumber=uidForEnrolled+"-"+randomStr;
			meetingSlipEntryModal.setUid(uidForEnrolled);
			meetingSlipEntryModal.setApplicationFormNumber(appliactionFormNumber);
			return SUCCESS;
		}
		
		}
	}
	
	public String getUidForEnrolled() {
		return uidForEnrolled;
	}

	public void setUidForEnrolled(String uidForEnrolled) {
		this.uidForEnrolled = uidForEnrolled;
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

}
