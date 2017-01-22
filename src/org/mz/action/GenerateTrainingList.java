package org.mz.action;

import java.util.List;

import org.mz.modal.IdCardSendModal;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;

public class GenerateTrainingList extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<IdCardSendModal> training;
	




	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		training=meetingSlipService.generateTrainingList();
		
		return SUCCESS;
		
		
	}
	
	
	
	public List<IdCardSendModal> getTraining() {
		return training;
	}




	public void setTraining(List<IdCardSendModal> training) {
		this.training = training;
	}


}