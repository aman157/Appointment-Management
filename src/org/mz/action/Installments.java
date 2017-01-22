package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Installments extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uidForEnrolled;
	
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	
	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.installments(uidForEnrolled,meetingSlipEntryModal);
		
		return SUCCESS;
		
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

}
