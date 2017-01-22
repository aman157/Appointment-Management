package org.mz.action;

import org.mz.service.MeetingSlipService;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePaymentStatus extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getJuidForEnrolled() {
		return juidForEnrolled;
	}


	public void setJuidForEnrolled(String juidForEnrolled) {
		this.juidForEnrolled = juidForEnrolled;
	}


	public String getJfeeOfMonth() {
		return jfeeOfMonth;
	}


	public void setJfeeOfMonth(String jfeeOfMonth) {
		this.jfeeOfMonth = jfeeOfMonth;
	}


	public String getJpaymentStatus() {
		return jpaymentStatus;
	}


	public void setJpaymentStatus(String jpaymentStatus) {
		this.jpaymentStatus = jpaymentStatus;
	}


	private String juidForEnrolled;
	private String jfeeOfMonth;
	private String jpaymentStatus;
	
	
	public String execute(){
		
		MeetingSlipService meetingSlipService=new MeetingSlipService();
		meetingSlipService.changePaymentSta(juidForEnrolled,jfeeOfMonth,jpaymentStatus);
		return SUCCESS;
		
		
	}
	
	
}
