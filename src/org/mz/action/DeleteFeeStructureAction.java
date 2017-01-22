package org.mz.action;

import java.util.List;

import org.mz.modal.FeeStructureModal;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteFeeStructureAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {
	
	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private List<FeeStructureModal> feeStructureList;
	private String serialIdForFeeStructure;
	
	
	
	public String execute(){
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.deleteFeeRow(serialIdForFeeStructure);
		feeStructureList=meetingSlipService.viewFeeStructure();		
		
	
		
		
		return SUCCESS;
		
		
	}
	
	public MeetingSlipEntryModal getMeetingSlipEntryModal() {
		return meetingSlipEntryModal;
	}

	public void setMeetingSlipEntryModal(MeetingSlipEntryModal meetingSlipEntryModal) {
		this.meetingSlipEntryModal = meetingSlipEntryModal;
	}

	public List<FeeStructureModal> getFeeStructureList() {
		return feeStructureList;
	}

	public void setFeeStructureList(List<FeeStructureModal> feeStructureList) {
		this.feeStructureList = feeStructureList;
	}

	public String getSerialIdForFeeStructure() {
		return serialIdForFeeStructure;
	}

	public void setSerialIdForFeeStructure(String serialIdForFeeStructure) {
		this.serialIdForFeeStructure = serialIdForFeeStructure;
	}



	@Override
	public MeetingSlipEntryModal getModel() {
		// TODO Auto-generated method stub
		return meetingSlipEntryModal;
	}
	

}
