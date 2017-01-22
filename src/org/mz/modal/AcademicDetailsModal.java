package org.mz.modal;

import java.io.File;

public class AcademicDetailsModal extends FeeStructureModal{
	
	private String education;
	private String year;
	private String college;
	private String board;
	private String marks;
	private File document;
	private String documentFileName;
	
	
	public File getDocument() {
		return document;
	}
	public void setDocument(File document) {
		this.document = document;
	}
	public String getDocumentFileName() {
		return documentFileName;
	}
	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}

}
