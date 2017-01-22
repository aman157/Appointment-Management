package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForgetPasswordTrainee extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	public String execute(){
			MeetingSlipService meetingSlipService=new MeetingSlipService();
			meetingSlipService.forgetPasswordTrainee(meetingSlipEntryModal);
		
		
		return SUCCESS;
		
	}
	
	@Override
	public MeetingSlipEntryModal getModel() {
		// TODO Auto-generated method stub
		return meetingSlipEntryModal;
	}
	
	

}
