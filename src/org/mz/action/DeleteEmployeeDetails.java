package org.mz.action;

import java.util.ArrayList;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteEmployeeDetails extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	
	private static final long serialVersionUID = 1L;

	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private ArrayList<MeetingSlipEntryModal> arraylist=null;
	private String uidForEmployee;
	
	
	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.DeleteEmployeeDetails(uidForEmployee);
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

	public String getUidForEmployee() {
		return uidForEmployee;
	}

	public void setUidForEmployee(String uidForEmployee) {
		this.uidForEmployee = uidForEmployee;
	}

	@Override
	public MeetingSlipEntryModal getModel() {
		return meetingSlipEntryModal;
	}

}
