package org.mz.action;

import java.util.List;

import org.mz.modal.FeeStructureModal;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;

public class GenerateTrainerList extends ActionSupport {
	
	
	
	private static final long serialVersionUID = 1L;
	private List<MeetingSlipEntryModal> trainer;
	

	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		trainer=meetingSlipService.generateTrainerList();
		return SUCCESS;
		
	}
	
	public List<MeetingSlipEntryModal> getTrainer() {
		return trainer;
	}

	public void setTrainer(List<MeetingSlipEntryModal> trainer) {
		this.trainer = trainer;
	}




}
