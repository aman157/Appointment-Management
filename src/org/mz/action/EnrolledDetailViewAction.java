package org.mz.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.mz.modal.AcademicDetailsModal;
import org.mz.modal.AddingFeeDetails;
import org.mz.modal.MeetingSlipEntryModal;
import org.mz.service.MeetingSlipService;

import sun.text.normalizer.RangeValueIterator;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EnrolledDetailViewAction extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uidForEnrolled;
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	private List<AcademicDetailsModal> academicDetailsFromDatabase;
	private List<AddingFeeDetails> addingFeedetailsFromDatabase;

	


	public String execute(){
			
			MeetingSlipService meetingSlipService=new MeetingSlipService();
			academicDetailsFromDatabase=meetingSlipService.enrolledDetailView(uidForEnrolled,meetingSlipEntryModal);
			addingFeedetailsFromDatabase=meetingSlipService.feeMonths(uidForEnrolled);
			
			return SUCCESS;
		
		
	}
	
	
	public List<AddingFeeDetails> getAddingFeedetailsFromDatabase() {
		return addingFeedetailsFromDatabase;
	}

	public void setAddingFeedetailsFromDatabase(
			List<AddingFeeDetails> addingFeedetailsFromDatabase) {
		this.addingFeedetailsFromDatabase = addingFeedetailsFromDatabase;
	}

	public List<AcademicDetailsModal> getAcademicDetailsFromDatabase() {
		return academicDetailsFromDatabase;
	}

	public void setAcademicDetailsFromDatabase(
			List<AcademicDetailsModal> academicDetailsFromDatabase) {
		this.academicDetailsFromDatabase = academicDetailsFromDatabase;
	}
	
	public String getUidForEnrolled() {
		return uidForEnrolled;
	}

	public void setUidForEnrolled(String uidForEnrolled) {
		this.uidForEnrolled = uidForEnrolled;
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
