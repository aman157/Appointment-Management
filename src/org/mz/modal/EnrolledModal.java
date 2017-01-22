package org.mz.modal;

import java.io.File;
import java.util.List;



public class EnrolledModal extends AcademicDetailsModal{
	
	private String gender;
	private String dateOfBirth;
	private String fatherName;
	private String phoneNumber;
	private String occupation;
	private String presentAddress;
	private String permanentAddress;
	private String password;
	private String confirmPassword;
	private List<AcademicDetailsModal> academicDetails;
	private String trainingEnrolled;
	private File photo;
	private String photoFileName;
	private String endDate;
	private String actualEndDate;
	private String profileMeter;
	private String issueCertificate;
	
	
	
	public String getIssueCertificate() {
		return issueCertificate;
	}
	public void setIssueCertificate(String issueCertificate) {
		this.issueCertificate = issueCertificate;
	}
	public String getProfileMeter() {
		return profileMeter;
	}
	public void setProfileMeter(String profileMeter) {
		this.profileMeter = profileMeter;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	
	
	
	
	
	public List<AcademicDetailsModal> getAcademicDetails() {
		return academicDetails;
	}
	public void setAcademicDetails(List<AcademicDetailsModal> academicDetails) {
		
		

		this.academicDetails = academicDetails;
	}


	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getTrainingEnrolled() {
		return trainingEnrolled;
	}
	public void setTrainingEnrolled(String trainingEnrolled) {
		this.trainingEnrolled = trainingEnrolled;
	}

	
	

}
