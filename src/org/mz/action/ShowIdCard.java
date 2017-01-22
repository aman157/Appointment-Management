package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;


public class ShowIdCard extends ActionSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();


	private String uidForCard;
	

	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.showIdCard(uidForCard,meetingSlipEntryModal);
		return SUCCESS;
		
	}
	
	
	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}

	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}
	
	public String getUidForCard() {
		return uidForCard;
	}


	public void setUidForCard(String uidForCard) {
		this.uidForCard = uidForCard;
	}

}
