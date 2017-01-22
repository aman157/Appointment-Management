package org.mz.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.mz.modal.AcademicDetailsModal;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddingEnrolledDataToDatabase extends ActionSupport implements ModelDriven<MeetingSlipEntryModal> {

	private static final long serialVersionUID = 1L;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	private String checkEnrollnment="anyValue";
	

	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		int stat=meetingSlipService.addingEnrolledData(meetingSlipEntryModal);
		
		if(stat==1){
			meetingSlipEntryModal.setStatus("Successful");
			if(checkEnrollnment.equals("fromEmail")){
				return "SuccessFromEmail";
			}
			else{
				return SUCCESS;
			}
			
		}
		else{
			meetingSlipEntryModal.setStatus(" Not Successful");
				return ERROR;
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	public String getCheckEnrollnment() {
		return checkEnrollnment;
	}

	public void setCheckEnrollnment(String checkEnrollnment) {
		this.checkEnrollnment = checkEnrollnment;
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
