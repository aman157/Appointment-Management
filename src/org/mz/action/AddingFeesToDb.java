package org.mz.action;

import org.mz.modal.AddingFeeDetails;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddingFeesToDb extends ActionSupport implements ModelDriven<AddingFeeDetails> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AddingFeeDetails addingFeeDetails=new AddingFeeDetails();
	
	
	public AddingFeeDetails getAddingFeeDetails() {
		return addingFeeDetails;
	}


	public void setAddingFeeDetails(AddingFeeDetails addingFeeDetails) {
		this.addingFeeDetails = addingFeeDetails;
	}


	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		int result=meetingSlipService.addingFeesdetailsDb(addingFeeDetails);
		
		if(result==1){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
		
		
		
		
	}


	@Override
	public AddingFeeDetails getModel() {
		// TODO Auto-generated method stub
		return addingFeeDetails;
	}


	
	
	
	

}
