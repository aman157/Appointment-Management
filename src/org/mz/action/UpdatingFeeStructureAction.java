package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdatingFeeStructureAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowTraining;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	
	
	
	
	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.updateFeeStructure(rowTraining,meetingSlipEntryModal);
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

	public String getRowTraining() {
		return rowTraining;
	}

	public void setRowTraining(String rowTraining) {
		this.rowTraining = rowTraining;
	}

}
