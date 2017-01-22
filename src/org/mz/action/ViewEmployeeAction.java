package org.mz.action;

import java.util.ArrayList;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ViewEmployeeAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>{
	
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private ArrayList<MeetingSlipEntryModal> arraylist=null;

	

	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		arraylist=meetingSlipService.viewEmployee();
			
		return SUCCESS;
	}
	
	
	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}
	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}
	public ArrayList<MeetingSlipEntryModal> getArraylist() {
		return arraylist;
	}
	public void setArraylist(ArrayList<MeetingSlipEntryModal> arraylist) {
		this.arraylist = arraylist;
	}
	
	@Override
	public MeetingSlipEntryModal getModel() {
		// TODO Auto-generated method stub
		return meetingSlipEntryModal;
	}

}
