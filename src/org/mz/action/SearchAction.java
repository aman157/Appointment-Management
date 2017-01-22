package org.mz.action;

import java.util.ArrayList;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SearchAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>{
	
	private static final long serialVersionUID = 1L;

	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private ArrayList<MeetingSlipEntryModal> arrayList=null;
	
	
	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		arrayList=meetingSlipService.search(meetingSlipEntryModal);
		
		return SUCCESS;
		
	}


	
	
	public ArrayList<MeetingSlipEntryModal> getArrayList() {
		return arrayList;
	}


	public void setArrayList(ArrayList<MeetingSlipEntryModal> arrayList) {
		this.arrayList = arrayList;
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
