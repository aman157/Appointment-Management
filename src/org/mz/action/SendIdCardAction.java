package org.mz.action;

import org.mz.modal.IdCardSendModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SendIdCardAction extends ActionSupport implements ModelDriven<IdCardSendModal>  {

	private static final long serialVersionUID = 1L;
	private String sendIdCardUid;
	private IdCardSendModal idCardSendModal=new IdCardSendModal();
	

	public String execute(){
			MeetingSlipService meetingSlipService=new MeetingSlipService();
			String recordExitsStrng=meetingSlipService.chkRecord(sendIdCardUid);
			int recordExits=Integer.parseInt(recordExitsStrng);
			if(recordExits==0)
			{
				int statusForIdCardDataBase=meetingSlipService.saveIdCardDetails(sendIdCardUid,idCardSendModal);
					if(statusForIdCardDataBase == 1)
					{
						meetingSlipService.sendMail(sendIdCardUid,idCardSendModal);
						return SUCCESS;				
					}
			}
			if(recordExits==1){
				int statusForIdCardDataBase=meetingSlipService.updateIdCardDetails(sendIdCardUid, idCardSendModal);
				if(statusForIdCardDataBase==1){
					meetingSlipService.sendMail(sendIdCardUid,idCardSendModal);
					return SUCCESS;
				}
				
			}
			
			return SUCCESS;
			
	}
	
	public String getSendIdCardUid() {
		return sendIdCardUid;
	}

	public void setSendIdCardUid(String sendIdCardUid) {
		this.sendIdCardUid = sendIdCardUid;
	}
	
	public IdCardSendModal getIdCardSendModal() {
		return idCardSendModal;
	}

	public void setIdCardSendModal(IdCardSendModal idCardSendModal) {
		this.idCardSendModal = idCardSendModal;
	}


	@Override
	public IdCardSendModal getModel() {
		// TODO Auto-generated method stub
		return idCardSendModal;
	}

}