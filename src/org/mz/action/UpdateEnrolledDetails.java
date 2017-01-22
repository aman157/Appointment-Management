package org.mz.action;

import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateEnrolledDetails extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal =new MeetingSlipEntryModal();
	private String uidForupdateToEnrolled;
	
	
	public String getUidForupdateToEnrolled() {
		return uidForupdateToEnrolled;
	}

	public void setUidForupdateToEnrolled(String uidForupdateToEnrolled) {
		this.uidForupdateToEnrolled = uidForupdateToEnrolled;
	}

	public String execute()
	{
		uidForupdateToEnrolled=meetingSlipEntryModal.getUid();
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.updateEnrolledDetails(meetingSlipEntryModal);
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
