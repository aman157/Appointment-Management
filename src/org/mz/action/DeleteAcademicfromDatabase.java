package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteAcademicfromDatabase extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	public String execute(){

		MeetingSlipService meetingSlipService=new MeetingSlipService();
		int rowDelete=meetingSlipService.deleteAcademicfromDatabase(meetingSlipEntryModal);
		
		if(rowDelete==1){
			return SUCCESS;
		}
		else{
			return ERROR;
			
		}
		
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
