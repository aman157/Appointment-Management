package org.mz.action;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.mz.modal.AcademicDetailsModal;
import org.mz.modal.FeeStructureModal;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddingFeeStructureAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {
	

	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private List<FeeStructureModal> feeStructureList;
	
	




public String execute(){
	
	MeetingSlipService meetingSlipService=new MeetingSlipService();
	meetingSlipService.addingFeeStructure(meetingSlipEntryModal);
	feeStructureList=meetingSlipService.viewFeeStructure();
	return SUCCESS;
}
	


public List<FeeStructureModal> getFeeStructureList() {
		return feeStructureList;
	}


	public void setFeeStructureList(List<FeeStructureModal> feeStructureList) {
		this.feeStructureList = feeStructureList;
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
