package org.mz.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;










import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.mz.modal.MeetingSlipEntryModal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IdCardPdf extends ActionSupport implements ModelDriven<MeetingSlipEntryModal>,SessionAware{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
	
	private Map<String, Object> session;
	
	private String fileName;
	private InputStream fileInputStream;
	



	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute(){
		
		
		Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
		Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
		Font underline=new Font(FontFamily.TIMES_ROMAN,10,Font.UNDERLINE,BaseColor.BLACK);
		
		
		try {

			OutputStream file = new FileOutputStream(new File("D:\\"+meetingSlipEntryModal.getName()+".pdf"));
			meetingSlipEntryModal.setPdfFileName("D:\\"+meetingSlipEntryModal.getName()+".pdf");
			
			session.put("pdfFile", meetingSlipEntryModal.getPdfFileName());
			
			
			
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			PdfWriter.getInstance(document, file);
			
			 Image image = Image.getInstance ("C:/Users/Aman Saini/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/MeetingSlip/images/MZ_logo.png");
			 image.scaleAbsolute(60f, 60f);
			 image.setAlignment(Image.MIDDLE);
			 
			 Paragraph p1 = new Paragraph("METAZONE INFOTECH PVT. LTD.",blueFont);
			 p1.setAlignment(Element.ALIGN_CENTER);
			 
			 Paragraph p2 = new Paragraph("Trainee ID CARD",underline);
			 p2.setAlignment(Element.ALIGN_CENTER);
			 
		        
			 

			 Chunk c1=new Chunk("UID : \t\t",smallFont);
			 Chunk c11=new Chunk(meetingSlipEntryModal.getUid()+"  ",underline);
			 
			 Chunk c2=new Chunk("NAME : \t\t",smallFont);
			 Chunk c22=new Chunk(meetingSlipEntryModal.getName()+"  ",underline);
			 
			 Chunk c3=new Chunk("CONTACT : \t\t",smallFont);
			 Chunk c33=new Chunk(meetingSlipEntryModal.getContact()+"  ",underline);
			 
			 Chunk c4=new Chunk("TRAINER : \t\t",smallFont);
			 Chunk c44=new Chunk(meetingSlipEntryModal.getTrainer()+"  ",underline);
			 
			 Chunk c5=new Chunk("TIMING : ",smallFont);
			 Chunk c55=new Chunk(meetingSlipEntryModal.getTiming()+"  ",underline);
			 
			 Chunk c6=new Chunk("TRAINING : \t\t",smallFont);
			 Chunk c66=new Chunk(meetingSlipEntryModal.getTraining()+"  ",underline);
			 
			 Chunk c7=new Chunk("DEMO's DATE 1 : \t\t",smallFont);
			 Chunk c77=new Chunk(meetingSlipEntryModal.getDemoDate1()+"  ",underline);
			 
			 Chunk c8=new Chunk("DEMO's DATE 2 : \t\t",smallFont);
			 Chunk c88=new Chunk(meetingSlipEntryModal.getDemoDate2()+"  ",underline);
			 
			 Chunk c9=new Chunk("DEMO's DATE 3 : \t\t",smallFont);
			 Chunk c99=new Chunk(meetingSlipEntryModal.getDemoDate3()+"  ",underline);
			 
			 
			 Phrase phrase = new Phrase();
			 phrase.add(c1);
			 phrase.add(c11);
			 phrase.add(c2);
			 phrase.add(c22);
			 phrase.add(c3);
			 phrase.add(c33);
			 phrase.add(Chunk.NEWLINE);
			 
			 phrase.add(c4);
			 phrase.add(c44);
			 phrase.add(c5);
			 phrase.add(c55);
			 phrase.add(c6);
			 phrase.add(c66);
			 phrase.add(Chunk.NEWLINE);
			 
			 phrase.add(c7);
			 phrase.add(c77);
			 phrase.add(c8);
			 phrase.add(c88);
			 phrase.add(c9);
			 phrase.add(c99);
			 
			 Paragraph p3=new Paragraph();
			 p3.setAlignment(Element.ALIGN_CENTER);
			 p3.add(phrase);
			 
			 Paragraph p4=new Paragraph("Authorized Signator");
			 p4.setAlignment(Element.ALIGN_CENTER);
			 document.open();
			 
			 document.add(image);
			 document.add(p1);
			 document.add(p2);
			 document.add(p3);
			 document.add(p4);
			 
			 
			document.close();
			file.close();
			
			
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;	
			
	}
	
	public String idCardDownload(){
		
	String sessionName=(String)session.get("pdfFile");
		
File fileToDownload = new File(sessionName);
fileName = sessionName;	
try {
	fileInputStream = new FileInputStream(fileToDownload);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return SUCCESS;
		
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
