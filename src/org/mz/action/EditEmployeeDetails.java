package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditEmployeeDetails extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();

	
	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.editEmployeeDetails(meetingSlipEntryModal);
		return SUCCESS;
		
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
