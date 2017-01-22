package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MeetingSlipEntriesAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
public String execute(){
		
			MeetingSlipService meetingSlipService=new MeetingSlipService();
			int check=meetingSlipService.newEntrySlip(meetingSlipEntryModal);
			
			if(check==1){
				meetingSlipEntryModal.setStatus("Successful*");
				return SUCCESS;
				
			}
			if(check==0){
				meetingSlipEntryModal.setStatus("Not successful");
				return ERROR;
				
			}
			return null;	
	}
	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}
	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}
	@Override
	public MeetingSlipEntryModal getModel() {
		return meetingSlipEntryModal;
	}
	



}
