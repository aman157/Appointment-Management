package org.mz.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddingEmployee extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();	
	
	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.addingEmployee(meetingSlipEntryModal);
		meetingSlipEntryModal.setStatus("SuccessFully Submitted");
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
