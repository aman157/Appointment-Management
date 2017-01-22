package org.mz.modal;

import java.io.File;
import java.util.List;

public class MeetingSlipEntryModal extends IdCardSendModal {
	
	/*variables for meeting form*/
	private String uid;
	private String name;
	private String contact;
	private String email;
	private String college;
	private String purpose;
	private String anyOther;
	private String reference;
	private String date;
	/*variables for meeting form end*/
	
	private String status;
	private String password;
	private String between;
	private String education;
	private String enrolledDate;
	private String dueMonth;
	private String applicationFormNumber;
	private String enrolledStatus;
	

	/*variables for add Employee*/
	private String qualification;
	private String specialization;
	private String department;
	private String address;
	private File employeePhoto;
	private String employeePhotoFileName;
	/*variables for add Employee End*/
	
	private List<FeeStructureModal> feeStructure;
	private String feeWords;
	private List<AddingFeeDetails> addingFeeList;
	
	private String pdfFileName;
	
	public String getPdfFileName() {
		return pdfFileName;
	}
	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}
	public List<AddingFeeDetails> getAddingFeeList() {
		return addingFeeList;
	}
	public void setAddingFeeList(List<AddingFeeDetails> addingFeeList) {
		this.addingFeeList = addingFeeList;
	}
	public String getFeeWords() {
		return feeWords;
	}
	public void setFeeWords(String feeWords) {
		this.feeWords = feeWords;
	}
	public List<FeeStructureModal> getFeeStructure() {
		return feeStructure;
	}
	public void setFeeStructure(List<FeeStructureModal> feeStructure) {
		this.feeStructure = feeStructure;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public File getEmployeePhoto() {
		return employeePhoto;
	}
	public void setEmployeePhoto(File employeePhoto) {
		this.employeePhoto = employeePhoto;
	}
	public String getEmployeePhotoFileName() {
		return employeePhotoFileName;
	}
	public void setEmployeePhotoFileName(String employeePhotoFileName) {
		this.employeePhotoFileName = employeePhotoFileName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEnrolledStatus() {
		return enrolledStatus;
	}
	public void setEnrolledStatus(String enrolledStatus) {
		this.enrolledStatus = enrolledStatus;
	}
	public String getBetween() {
		return between;
	}
	public void setBetween(String between) {
		this.between = between;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(String enrolledDate) {
		this.enrolledDate = enrolledDate;
	}
	public String getDueMonth() {
		return dueMonth;
	}
	public void setDueMonth(String dueMonth) {
		this.dueMonth = dueMonth;
	}	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getAnyOther() {
		return anyOther;
	}
	public void setAnyOther(String anyOther) {
		this.anyOther = anyOther;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getApplicationFormNumber() {
		return applicationFormNumber;
	}
	public void setApplicationFormNumber(String applicationFormNumber) {
		this.applicationFormNumber = applicationFormNumber;
	}

	
}
