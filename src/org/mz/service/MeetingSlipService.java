package org.mz.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.mz.common.MeetingSlipCommon;
import org.mz.modal.AcademicDetailsModal;
import org.mz.modal.AddingFeeDetails;
import org.mz.modal.FeeStructureModal;
import org.mz.modal.IdCardSendModal;
import org.mz.modal.MeetingSlipEntryModal;

import com.mysql.jdbc.Statement;

public class MeetingSlipService {
	
	
	 static HashMap<Integer,String> numberMap = new HashMap<Integer,String>();
     static{
         numberMap.put(0,"Zero");
         numberMap.put(1,"One");
         numberMap.put(2,"Two");
         numberMap.put(3,"Three");
         numberMap.put(4,"Four");
         numberMap.put(5,"Five");
         numberMap.put(6,"Six");
         numberMap.put(7,"Seven");
         numberMap.put(8,"Eight");
         numberMap.put(9,"Nine");
         numberMap.put(10,"Ten");
         numberMap.put(11,"Eleven");
         numberMap.put(12,"Twelve");
         numberMap.put(13,"Thirteen");
         numberMap.put(14,"Fourteen");
         numberMap.put(15,"Fifteen");
         numberMap.put(16,"Sixteen");
         numberMap.put(17,"Seventeen");
         numberMap.put(18,"Eighteen");
         numberMap.put(19,"Nineteen");
         numberMap.put(20,"Twenty");
         numberMap.put(30,"Thirty");
         numberMap.put(40,"Forty");
         numberMap.put(50,"Fifty");
         numberMap.put(60,"Sixty");
         numberMap.put(70,"Seventy");
         numberMap.put(80,"Eighty");
         numberMap.put(90,"Ninety");
         numberMap.put(100,"Hundred");
         numberMap.put(1000,"Thousand");

     }


	private ArrayList<MeetingSlipEntryModal> arrayList1;

	public int newEntrySlip(MeetingSlipEntryModal meetingSlipEntryModal) {
		int rowInserted=0;

		String name=meetingSlipEntryModal.getName();
		String contact=meetingSlipEntryModal.getContact();
		String email=meetingSlipEntryModal.getEmail();
		String college=meetingSlipEntryModal.getCollege();
		String purpose=meetingSlipEntryModal.getPurpose();
		String anyOther=meetingSlipEntryModal.getAnyOther();
		String reference=meetingSlipEntryModal.getReference();
		String date=meetingSlipEntryModal.getDate();

		try{	
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			PreparedStatement pstatement=connection.prepareStatement("insert into meetingslipentries (name,contact,email,college,purpose,anyOther,reference,date) values(?,?,?,?,?,?,?,?)");

			pstatement.setString(1,name);  
			pstatement.setString(2,contact);  
			pstatement.setString(3,email);  
			pstatement.setString(4,college);
			pstatement.setString(5,purpose);  
			pstatement.setString(6,anyOther);  
			pstatement.setString(7,reference);  
			pstatement.setString(8,date);

			rowInserted=pstatement.executeUpdate();  
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowInserted;
	}

	public ArrayList<MeetingSlipEntryModal> login() {

		ArrayList<MeetingSlipEntryModal> arrayList=null;

		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT meetingslipentries.uid,meetingslipentries.name,meetingslipentries.contact,meetingslipentries.email,meetingslipentries.college,meetingslipentries.purpose,meetingslipentries.anyOther,meetingslipentries.reference,meetingslipentries.date,idcarddetail.email_status,enrolleddetalis.admissionFormNumber,enrolleddetalis.profileMeter  FROM meetingslipentries LEFT JOIN idcarddetail  ON meetingslipentries.uid=idcarddetail.uid  LEFT JOIN enrolleddetalis ON meetingslipentries.uid=enrolleddetalis.uid ORDER BY meetingslipentries.date DESC";
			result=statement.executeQuery(query);
			arrayList=new ArrayList<>();
			while(result.next()){

				MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
				String uid=result.getString(1);
				String name=result.getString(2);
				String contact=result.getString(3);
				String email=result.getString(4);
				String college=result.getString(5);
				String purpose=result.getString(6);
				String anyOther=result.getString(7);
				String reference=result.getString(8);
				String date=result.getString(9);
				String emailStatus=result.getString(10);
				String enrolledStatus=result.getString(11);
				String profileMeter=result.getString(12);

				meetingSlipEntryModal.setUid(uid);
				meetingSlipEntryModal.setName(name);
				meetingSlipEntryModal.setContact(contact);
				meetingSlipEntryModal.setEmail(email);
				meetingSlipEntryModal.setCollege(college);
				meetingSlipEntryModal.setPurpose(purpose);
				meetingSlipEntryModal.setAnyOther(anyOther);
				meetingSlipEntryModal.setReference(reference);
				meetingSlipEntryModal.setDate(date);
				meetingSlipEntryModal.setEmailStatus(emailStatus);
				meetingSlipEntryModal.setEnrolledStatus(enrolledStatus);
				meetingSlipEntryModal.setProfileMeter(profileMeter);
				arrayList.add(meetingSlipEntryModal);
			}

			connection.close();
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return arrayList;


	}
	
	

	public ArrayList<MeetingSlipEntryModal> search(MeetingSlipEntryModal meetingSlipEntryModal) {
		
		ArrayList<MeetingSlipEntryModal> arrayList=null;

		String uid=meetingSlipEntryModal.getUid();
		String name=meetingSlipEntryModal.getName();
		String contact=meetingSlipEntryModal.getContact();
		String email=meetingSlipEntryModal.getEmail();
		String college=meetingSlipEntryModal.getCollege();
		String purpose=meetingSlipEntryModal.getPurpose();
		String anyOther=meetingSlipEntryModal.getAnyOther();
		String reference=meetingSlipEntryModal.getReference();
		String date=meetingSlipEntryModal.getDate();
		String between=meetingSlipEntryModal.getBetween();
		String education=meetingSlipEntryModal.getEducation();
		String enrolledDate=meetingSlipEntryModal.getEnrolledDate();
		String dueDate=meetingSlipEntryModal.getDueMonth();


	

		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			
			StringBuilder stringBuilderSearchQuery=new StringBuilder("SELECT meetingslipentries.uid,meetingslipentries.name,meetingslipentries.contact,meetingslipentries.email,meetingslipentries.college,meetingslipentries.purpose,meetingslipentries.anyOther,meetingslipentries.reference,meetingslipentries.date,idcarddetail.email_status,enrolleddetalis.admissionFormNumber,enrolleddetalis.profileMeter FROM meetingslipentries LEFT JOIN idcarddetail  ON meetingslipentries.uid=idcarddetail.uid  LEFT JOIN enrolleddetalis ON meetingslipentries.uid=enrolleddetalis.uid where");
				
			if(!uid.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.uid= '");
				stringBuilderSearchQuery.append(uid);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!name.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.name= '");
				stringBuilderSearchQuery.append(name);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!contact.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.contact= '");
				stringBuilderSearchQuery.append(contact);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!email.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.email= '");
				stringBuilderSearchQuery.append(email);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!college.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.college= '");
				stringBuilderSearchQuery.append(college);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!purpose.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.purpose= '");
				stringBuilderSearchQuery.append(purpose);
				stringBuilderSearchQuery.append(" ' and ");
			}
			
			if(!anyOther.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.anyOther= '");
				stringBuilderSearchQuery.append(anyOther);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!reference.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.reference= '");
				stringBuilderSearchQuery.append(reference);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!date.isEmpty()){
				if(!between.isEmpty()){
					stringBuilderSearchQuery.append(" meetingslipentries.date= '");
					stringBuilderSearchQuery.append(date);
					stringBuilderSearchQuery.append(" meetingslipentries.between= '");
					stringBuilderSearchQuery.append(between);
					stringBuilderSearchQuery.append("' and ");
				}
				else{
				stringBuilderSearchQuery.append(" meetingslipentries.date= '");
				stringBuilderSearchQuery.append(date);
				stringBuilderSearchQuery.append("' and ");
				}
			}
			
			
			
			if(!education.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.education= '");
				stringBuilderSearchQuery.append(education);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!enrolledDate.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.enrolledDate= '");
				stringBuilderSearchQuery.append(enrolledDate);
				stringBuilderSearchQuery.append("' and ");
			}
			
			if(!dueDate.isEmpty()){
				stringBuilderSearchQuery.append(" meetingslipentries.dueDate= '");
				stringBuilderSearchQuery.append(dueDate);
				stringBuilderSearchQuery.append("' and ");
			}
			String query=stringBuilderSearchQuery.substring(0, stringBuilderSearchQuery.length()-5);
			result=statement.executeQuery(query);

			arrayList=new ArrayList<>();

			while (result.next()) {
				MeetingSlipEntryModal meetingSlipEntryModal2=new MeetingSlipEntryModal();
				meetingSlipEntryModal2.setUid(result.getString(1));
				meetingSlipEntryModal2.setName(result.getString(2));
				meetingSlipEntryModal2.setContact(result.getString(3));
				meetingSlipEntryModal2.setEmail(result.getString(4));
				meetingSlipEntryModal2.setCollege(result.getString(5));
				meetingSlipEntryModal2.setPurpose(result.getString(6));
				meetingSlipEntryModal2.setAnyOther(result.getString(7));
				meetingSlipEntryModal2.setReference(result.getString(8));
				meetingSlipEntryModal2.setDate(result.getString(9));
				meetingSlipEntryModal2.setEmailStatus(result.getString(10));
				meetingSlipEntryModal2.setEnrolledStatus(result.getString(11));
				meetingSlipEntryModal2.setProfileMeter(result.getString(12));
				arrayList.add(meetingSlipEntryModal2);
			
			}
			
			connection.close();
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return arrayList;
	}

	public MeetingSlipEntryModal showIdCard(String uidForCard, MeetingSlipEntryModal meetingSlipEntryModal) {
		try{

			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT meetingslipentries.uid,meetingslipentries.name,meetingslipentries.contact, idcarddetail.timing,idcarddetail.trainer,idcarddetail.training,idcarddetail.demo_date1,idcarddetail.demo_date2,idcarddetail.demo_date3,idcarddetail.email_status FROM meetingslipentries LEFT JOIN idcarddetail ON meetingslipentries.uid=idcarddetail.uid WHERE meetingslipentries.uid='"+uidForCard+"'";
			result=statement.executeQuery(query);

			if(result.next()){
				
				meetingSlipEntryModal.setUid(result.getString(1));
				meetingSlipEntryModal.setName(result.getString(2));
				meetingSlipEntryModal.setContact(result.getString(3));
				meetingSlipEntryModal.setTiming(result.getString(4));
				meetingSlipEntryModal.setTrainer(result.getString(5));
				meetingSlipEntryModal.setTraining(result.getString(6));
				meetingSlipEntryModal.setDemoDate1(result.getString(7));
				meetingSlipEntryModal.setDemoDate2(result.getString(8));
				meetingSlipEntryModal.setDemoDate3(result.getString(9));
				meetingSlipEntryModal.setEmailStatus(result.getString(10));
			}
			connection.close();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return meetingSlipEntryModal;
	}


	
	public String chkRecord(String sendIdCardUid) {
		String rowInserted=null;
		String uid=sendIdCardUid;
		
		try{	
			
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			statement = (Statement) connection.createStatement();
			String query="SELECT COUNT(1) FROM idcarddetail WHERE uid ='"+uid+"'";  
			result=statement.executeQuery(query); 
			if(result.next()){
				String check=result.getString(1);
				rowInserted=check;
			}
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowInserted;
		
	}

	public int saveIdCardDetails(String sendIdCardUid, IdCardSendModal idCardSendModal) {

		int rowInserted=0;
		String uid=sendIdCardUid;
		String timing=idCardSendModal.getTiming();
		String trainer=idCardSendModal.getTrainer();
		String training=idCardSendModal.getTraining();
		String demodate1=idCardSendModal.getDemoDate1();
		String demodate2=idCardSendModal.getDemoDate2();
		String demodate3=idCardSendModal.getDemoDate3();


		try{	
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			PreparedStatement pstatement=connection.prepareStatement("insert into idcarddetail(uid,timing,trainer,training,demo_date1,demo_date2,demo_date3) values(?,?,?,?,?,?,?)");

			pstatement.setString(1,uid);  
			pstatement.setString(2,timing);  
			pstatement.setString(3,trainer);  
			pstatement.setString(4,training);
			pstatement.setString(5,demodate1);  
			pstatement.setString(6,demodate2);
			pstatement.setString(7,demodate3);


			rowInserted=pstatement.executeUpdate();  
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	public int updateIdCardDetails(String sendIdCardUid,IdCardSendModal idCardSendModal) {
		
		int rowInserted=0;
		String uid=sendIdCardUid;
		String timing=idCardSendModal.getTiming();
		String trainer=idCardSendModal.getTrainer();
		String training=idCardSendModal.getTraining();
		String demodate1=idCardSendModal.getDemoDate1();
		String demodate2=idCardSendModal.getDemoDate2();
		String demodate3=idCardSendModal.getDemoDate3();


		try{	
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			PreparedStatement pstatement=connection.prepareStatement("UPDATE idcarddetail SET timing='"+timing+"', trainer='"+trainer+"',training='"+training+"',demo_date1='"+demodate1+"',demo_date2='"+demodate2+"',demo_date3='"+demodate3+"' WHERE uid='"+uid+"'");

			rowInserted=pstatement.executeUpdate();  
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowInserted;
	}

	public List<MeetingSlipEntryModal> generateTrainerList() {
		List<MeetingSlipEntryModal> trainer=new ArrayList<MeetingSlipEntryModal>();
		try{

			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT NAME FROM employee";
			result=statement.executeQuery(query);

			while(result.next()){
					MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
					meetingSlipEntryModal.setTrainer(result.getString(1));
					trainer.add(meetingSlipEntryModal);
			}
			connection.close();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return trainer;
	}
	
	public void sendMail(String sendIdCardUid, IdCardSendModal idCardSendModal) {
		
		String emailStatus="true";
		
		InetAddress ip;
		String myIp;
		
		String uid=null;
		String name=null;
		String contact=null;
		String email=null;
		String timing=null;
		String trainer=null;
		String training=null;
		String demoDate1=null;
		String demoDate2=null;
		String demoDate3=null;

		try{

			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT meetingslipentries.uid,meetingslipentries.name, meetingslipentries.contact,meetingslipentries.email, idcarddetail.timing,idcarddetail.trainer,idcarddetail.training,idcarddetail.demo_date1,idcarddetail.demo_date2,idcarddetail.demo_date3  FROM meetingslipentries  INNER JOIN idcarddetail  ON meetingslipentries.uid=idcarddetail.uid  WHERE idcarddetail.uid='"+sendIdCardUid+"'";
			result=statement.executeQuery(query);

				if(result.next())
				{
					uid=result.getString(1);
					name=result.getString(2);
					contact=result.getString(3);
					email=result.getString(4);
					timing=result.getString(5);
					trainer=result.getString(6);
					training=result.getString(7);
					demoDate1=result.getString(8);
					demoDate2=result.getString(9);
					demoDate3=result.getString(10);
				}
			
				
					Properties properties =new Properties();
					properties.put("mail.smtp.host", "smtp.gmail.com");  
					properties.put("mail.smtp.socketFactory.port", "465");  
					properties.put("mail.smtp.socketFactory.class",  
							"javax.net.ssl.SSLSocketFactory");  
					properties.put("mail.smtp.auth", "true");  
					properties.put("mail.smtp.port", "465");
			try{
				
				ip=InetAddress.getLocalHost();
				myIp=ip.getHostAddress();
				
				
					Session session = Session.getDefaultInstance(properties,	new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							String username, password;
							username="organize.kittyparty@gmail.com";
							password="kittyparty";
							return new PasswordAuthentication(username,password);
						}
					});

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("organize.kittyparty@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));  
				message.setSubject("HTML Message"); 
				message.setContent(""
						+ "<div class=\"main\" style=\"border:1px solid blue;height:350px; width:490px;\">"
						+ "<div class=\"header\" style=\"padding:5px;border-bottom: 2px solid;height: 95px;background-color: rgba(38, 170, 224, 0.1);\">"
					    +	"<div style=\"float:left\">"
					   + 	"<img src=\"http://metazonetrainings.com/images/client/logo.png\" height=\"100px\" width=\"100px\">"
					    +    "</div>"
					     +   "<div style=\"float:left\">"
					    +		"<h1 style=\"font-size:24px;margin-left:40px;\">Metazone Infotech Pvt Ltd</h1>"
					     +       "<h4 style=\"text-align:center;text-decoration: underline;\">TRAINEE ID CARD</h4>"
					     +   "</div>"
						+ "</div>"
					    
					    +"<div class=\"content\" style=\"padding:5px;background-color: rgba(246, 135, 51, 0.11);\">"
					   + 	"<div class=\"uid\" style=\"padding: 5px\">"
					    +    	"UID:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+uid+">"        
					     +  " </div>"
					        
					    +    "<div class=\"name\" style=\"padding: 5px;float:left\">"
					     +   	"Name:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+name+">"        
					      +  "</div>"
					        
					     +   "<div class=\"Contact\" style=\"padding: 5px\">"
					       + 	"Contact:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+contact+">"        
					     +   "</div>"
					        
					     +   "<div class=\"timing\" style=\"padding: 5px;float:left\">"
					     +   	"Timing:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+timing+">"        
					      +  "</div>"
					        
					      +  "<div class=\"trainer\" style=\"padding: 5px\">"
					       + "	Trainer:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+trainer+">"        
					      +  "</div>"
					        
					     +   "<div class=\"training\" style=\"padding: 5px\">"
					      +  	"Training:-<input type=\"text\" style=\"height: 25px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+training+" >"        
					       + "</div>"
					        
					     +   "<div class=\"date1\" style=\"float:left;padding: 5px\">"
					      +   "	Demo's Date:-<input type=\"text\"  style=\"height: 25px;width:100px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+demoDate1+">"        
					        + "</div>"
					        
					     +   "<div class=\"date2\" style=\"float:left;padding: 5px\">"
					      +  	"<input type=\"text\"  style=\"height: 25px;width:100px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+demoDate2+">"        
					       + "</div>"
					        
					      +  "<div class=\"date3\" style=\"padding: 5px\">"
					       + "<input type=\"text\" style=\"height: 25px;width:100px;border: none;background-color: transparent;\" readonly=\"readonly\" value="+demoDate3+">"        
					       + "</div>"
					  +  "</div>"
					    
					  +  "<div class=\"footer\" style=\"text-align:center\">"
					   +	"\n<a style=\" background-color: blanchedalmond; font-size: medium; padding: 3px; border: 1px solid pink;text-decoration: none;\" href='http://"+myIp+":8080/MeetingSlip/fromAdminEnrolledDetailView?uidForEnrolled="+uid+"&identity=email'>Directly Enrolled</a>"
					    +   "</div>"
				+	"</div>" ,"text/html" );  
				
				Transport.send(message);  
				System.out.println("message sent");
				PreparedStatement pstatement=connection.prepareStatement("UPDATE idcarddetail SET email_status='"+emailStatus+"' WHERE uid='"+sendIdCardUid+"'");
				pstatement.executeUpdate();  
				connection.close();
			
			}
			catch (AddressException e) {
				e.printStackTrace();
			} catch (javax.mail.MessagingException e) {
				e.printStackTrace();
				emailStatus="false";
				PreparedStatement pstatement=connection.prepareStatement("UPDATE idcarddetail SET email_status='"+emailStatus+"' WHERE uid='"+sendIdCardUid+"'");
				pstatement.executeUpdate();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		 
	}
	
	public boolean checkingEnrollnmentInsideDatabase(String uidForEnrolled, MeetingSlipEntryModal meetingSlipEntryModal) {
		
		boolean toggle=false;
		try{

			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT * FROM enrolleddetalis WHERE uid='"+uidForEnrolled+"'";
			result=statement.executeQuery(query);
			if(result.next()){
					toggle=true;
					
			}
			statement = (Statement) connection.createStatement();
			String query1="SELECT * FROM meetingslipentries WHERE uid='"+uidForEnrolled+"'";
			result=statement.executeQuery(query1);

			if(result.next()){


					meetingSlipEntryModal.setName(result.getString(2));
					meetingSlipEntryModal.setContact(result.getString(3));
					meetingSlipEntryModal.setEmail(result.getString(4));
					meetingSlipEntryModal.setPurpose(result.getString(6));
					
			}
			
			connection.close();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return toggle;

	}


	public int addingEnrolledData(MeetingSlipEntryModal meetingSlipEntryModal) {
		
		String endDate=null;
		int rowInserted=0;
		String profileMeter=null;
		
		String admissionFormNumber=meetingSlipEntryModal.getApplicationFormNumber();
		String name=meetingSlipEntryModal.getName();
		String gender=meetingSlipEntryModal.getGender();
		String dateOfBirth=meetingSlipEntryModal.getDateOfBirth();
		String contact=meetingSlipEntryModal.getContact();
		String email=meetingSlipEntryModal.getEmail();
		String fatherName=meetingSlipEntryModal.getFatherName();
		String PhoneNumber=meetingSlipEntryModal.getPhoneNumber();
		String occupation=meetingSlipEntryModal.getOccupation();
		String presentAddress=meetingSlipEntryModal.getPresentAddress();
		String permanentAddress=meetingSlipEntryModal.getPermanentAddress();
		String uid=meetingSlipEntryModal.getUid();
		String password=meetingSlipEntryModal.getPassword();
		String confirmPassword=meetingSlipEntryModal.getConfirmPassword();
		
		List<AcademicDetailsModal> academicDetails=meetingSlipEntryModal.getAcademicDetails();
		for(int i=0;i<academicDetails.size();i++){
			AcademicDetailsModal adm=academicDetails.get(i);
			adm.setDocumentFileName(meetingSlipEntryModal.getUid()+"."+adm.getEducation()+"."+FilenameUtils.getExtension(adm.getDocumentFileName()));
		}
		
		
		
		String trainingEnrolled=meetingSlipEntryModal.getTrainingEnrolled();
		String date=meetingSlipEntryModal.getDate();
		meetingSlipEntryModal.setPhotoFileName(meetingSlipEntryModal.getUid()+"."+FilenameUtils.getExtension(meetingSlipEntryModal.getPhotoFileName()));
		String photoFileName=meetingSlipEntryModal.getPhotoFileName();
		
		
		
			
			if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && dateOfBirth.isEmpty() && gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="25";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="30";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="35";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && occupation.isEmpty() && PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="40";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="45";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !PhoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="50";
			}
			
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !PhoneNumber.isEmpty() && !presentAddress.isEmpty() && permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="60";
			}
			
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !PhoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && photoFileName.isEmpty()){
				profileMeter="70";
			}
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !PhoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && !photoFileName.isEmpty() && academicDetails.size()==0){
				profileMeter="80";
			}
			
			else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !PhoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && !photoFileName.isEmpty() && academicDetails.size()>0){
				profileMeter="98";
			}
			
			else{
				profileMeter="5";
			}
			
			
			
		try{	
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			statement = (Statement) connection.createStatement();
			String query1="SELECT * FROM feestructure WHERE entertraining='"+trainingEnrolled+"'";
			result=statement.executeQuery(query1);
			
			if(result.next()){
				int trainingDuration=Integer.parseInt(result.getString(3));
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // Now use today date.
				c.add(Calendar.MONTH, trainingDuration);
				endDate = sdf.format(c.getTime());
				
				Date startDateObj=null;
				Date endDateObj=null;
				
				 try {
				        startDateObj = sdf.parse(date);
				        endDateObj=sdf.parse(endDate);
				    } 
				 catch (ParseException e) {
				        e.printStackTrace();
				 }
				        List<String> dates = new ArrayList<String>();
				        Calendar calendar = Calendar.getInstance();
				        calendar.setTime(startDateObj);

				        while (!calendar.getTime().after(endDateObj))
				        {
				            Date resultDates = calendar.getTime();
				            String as=sdf.format(resultDates);
				            dates.add(as);
				            calendar.add(Calendar.MONTH, 1);
				            
				        }
				    }
			
			
			String destPathOfUserPic=ServletActionContext.getServletContext().getRealPath("/"+"/images/userPic/");
			
			File traineePicFile=new File(destPathOfUserPic+File.separator,meetingSlipEntryModal.getPhotoFileName());
			
			if(meetingSlipEntryModal.getPhoto()==null){
			PreparedStatement pstatement=connection.prepareStatement("insert into enrolleddetalis(admissionFormNumber,name,gender,dateOfBirth,contact,email,fatherName,phoneNumber,occupation,presentAddress,permanentAddress,uid,password,confirmPassword,trainingEnrolled,date,endDate,profileMeter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstatement.setString(1,admissionFormNumber);  
			pstatement.setString(2,name);
			pstatement.setString(3,gender);
			pstatement.setString(4,dateOfBirth);
			pstatement.setString(5,contact);
			pstatement.setString(6,email);
			pstatement.setString(7,fatherName);
			pstatement.setString(8,PhoneNumber);
			pstatement.setString(9,occupation);
			pstatement.setString(10,presentAddress);
			pstatement.setString(11,permanentAddress);
			pstatement.setString(12,uid);
			pstatement.setString(13,password);
			pstatement.setString(14,confirmPassword);
			pstatement.setString(15,trainingEnrolled);
			pstatement.setString(16,date);
			pstatement.setString(17,endDate);
			pstatement.setString(18,profileMeter);
			rowInserted=pstatement.executeUpdate();
			}
			else{
				FileUtils.copyFile(meetingSlipEntryModal.getPhoto(), traineePicFile);
				PreparedStatement pstatement=connection.prepareStatement("insert into enrolleddetalis(admissionFormNumber,name,gender,dateOfBirth,contact,email,fatherName,phoneNumber,occupation,presentAddress,permanentAddress,uid,password,confirmPassword,trainingEnrolled,date,photoPath,endDate,profileMeter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstatement.setString(1,admissionFormNumber);  
				pstatement.setString(2,name);
				pstatement.setString(3,gender);
				pstatement.setString(4,dateOfBirth);
				pstatement.setString(5,contact);
				pstatement.setString(6,email);
				pstatement.setString(7,fatherName);
				pstatement.setString(8,PhoneNumber);
				pstatement.setString(9,occupation);
				pstatement.setString(10,presentAddress);
				pstatement.setString(11,permanentAddress);
				pstatement.setString(12,uid);
				pstatement.setString(13,password);
				pstatement.setString(14,confirmPassword);
				pstatement.setString(15,trainingEnrolled);
				pstatement.setString(16,date);
				pstatement.setString(17,photoFileName);
				pstatement.setString(18,endDate);
				pstatement.setString(19,profileMeter);
				rowInserted=pstatement.executeUpdate();
			}
			
			
			
				String destPathOfUserDocuments=ServletActionContext.getServletContext().getRealPath("/"+"/images/documents/");
			for(int i=0;i<meetingSlipEntryModal.getAcademicDetails().size();i++)
			{
				AcademicDetailsModal adm=meetingSlipEntryModal.getAcademicDetails().get(i);
				String education=adm.getEducation();
				String year=adm.getYear();
				String college=adm.getCollege();
				String board=adm.getBoard();
				String marks=adm.getMarks();
				String documentFileName=adm.getDocumentFileName();
				
				File traineeDocumentFile=new File(destPathOfUserDocuments+File.separator,adm.getDocumentFileName());
				
					if(adm.getDocument()==null){
					
					PreparedStatement psAcademicDetails=connection.prepareStatement("insert into academicDetails (uid,admissionFormNumber,education,year,college,board,marks,documentPath) values(?,?,?,?,?,?,?,?)");
					
					psAcademicDetails.setString(1, uid);
					psAcademicDetails.setString(2, admissionFormNumber);
					psAcademicDetails.setString(3, education);
					psAcademicDetails.setString(4, year);
					psAcademicDetails.setString(5, college);
					psAcademicDetails.setString(6, board);
					psAcademicDetails.setString(7, marks);
					psAcademicDetails.setString(8, documentFileName);
					psAcademicDetails.executeUpdate();
					}
					else{
						FileUtils.copyFile(adm.getDocument(), traineeDocumentFile);
						PreparedStatement psAcademicDetails=connection.prepareStatement("insert into academicDetails (uid,admissionFormNumber,education,year,college,board,marks,documentPath) values(?,?,?,?,?,?,?,?)");						psAcademicDetails.setString(1, uid);
						psAcademicDetails.setString(2, admissionFormNumber);
						psAcademicDetails.setString(3, education);
						psAcademicDetails.setString(4, year);
						psAcademicDetails.setString(5, college);
						psAcademicDetails.setString(6, board);
						psAcademicDetails.setString(7, marks);
						psAcademicDetails.setString(8, documentFileName);
						psAcademicDetails.executeUpdate();
						
					}
				
			
			
			}
			
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowInserted;
	}
	
	public  List<AcademicDetailsModal> enrolledDetailView(String uidForEnrolled, MeetingSlipEntryModal meetingSlipEntryModal) {
		
		List<AcademicDetailsModal> listAcademicDetailsModals=null;
		
		try{
			
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT * FROM enrolleddetalis WHERE uid='"+uidForEnrolled+"'";
			result=statement.executeQuery(query);

			if(result.next()){
				meetingSlipEntryModal.setApplicationFormNumber(result.getString(1));
				meetingSlipEntryModal.setUid(result.getString(12));
				meetingSlipEntryModal.setName(result.getString(2));
				meetingSlipEntryModal.setDateOfBirth(result.getString(4));
				meetingSlipEntryModal.setContact(result.getString(5));
				meetingSlipEntryModal.setGender(result.getString(3));
				meetingSlipEntryModal.setFatherName(result.getString(7));
				meetingSlipEntryModal.setOccupation(result.getString(9));
				meetingSlipEntryModal.setPhoneNumber(result.getString(8));
				meetingSlipEntryModal.setTrainingEnrolled(result.getString(15));
				meetingSlipEntryModal.setEmail(result.getString(6));
				meetingSlipEntryModal.setPresentAddress(result.getString(10));
				meetingSlipEntryModal.setPermanentAddress(result.getString(11));
				meetingSlipEntryModal.setDate(result.getString(16));
				meetingSlipEntryModal.setPhotoFileName(result.getString(17));
				meetingSlipEntryModal.setEndDate(result.getString(18));
				meetingSlipEntryModal.setActualEndDate(result.getString(20));
				meetingSlipEntryModal.setIssueCertificate(result.getString(21));
				
			}
			
			listAcademicDetailsModals=new ArrayList<AcademicDetailsModal>();
			statement = (Statement) connection.createStatement();
			String query2="SELECT * FROM academicdetails WHERE uid='"+uidForEnrolled+"'";
			result=statement.executeQuery(query2);
			while(result.next()){
				AcademicDetailsModal adm=new AcademicDetailsModal();
				adm.setEducation(result.getString(3));
				adm.setYear(result.getString(4));
				adm.setCollege(result.getString(5));
				adm.setBoard(result.getString(6));
				adm.setMarks(result.getString(7));
				adm.setDocumentFileName(result.getString(8));
				listAcademicDetailsModals.add(adm);
			}
			
			
			connection.close();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return listAcademicDetailsModals;
	}

	public int addingEmployee(MeetingSlipEntryModal meetingSlipEntryModal) {
		
		int rowInserted=0;

		String name=meetingSlipEntryModal.getName();
		String email=meetingSlipEntryModal.getEmail();
		String contact=meetingSlipEntryModal.getContact();
		String qualification=meetingSlipEntryModal.getQualification();
		String specialization=meetingSlipEntryModal.getSpecialization();
		String department=meetingSlipEntryModal.getDepartment();
		String address=meetingSlipEntryModal.getAddress();
		meetingSlipEntryModal.setEmployeePhotoFileName(meetingSlipEntryModal.getName()+"."+FilenameUtils.getExtension(meetingSlipEntryModal.getEmployeePhotoFileName()));
		String employeePhotoFileName=meetingSlipEntryModal.getEmployeePhotoFileName();

		try{	
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			
			if(meetingSlipEntryModal.getEmployeePhoto()==null){
				PreparedStatement pstatement=connection.prepareStatement("INSERT INTO employee(NAME,email,contact,qualification,specialization,department,address) VALUES(?,?,?,?,?,?,?)");
				pstatement.setString(1,name);  
				pstatement.setString(2,email);  
				pstatement.setString(3,contact);  
				pstatement.setString(4,qualification);
				pstatement.setString(5,specialization);  
				pstatement.setString(6,department);  
				pstatement.setString(7,address);  
				rowInserted=pstatement.executeUpdate();  
			}
			else{
			PreparedStatement pstatement=connection.prepareStatement("INSERT INTO employee(NAME,email,contact,qualification,specialization,department,address,EmployeePhoto) VALUES(?,?,?,?,?,?,?,?)");
			pstatement.setString(1,name);  
			pstatement.setString(2,email);  
			pstatement.setString(3,contact);  
			pstatement.setString(4,qualification);
			pstatement.setString(5,specialization);  
			pstatement.setString(6,department);  
			pstatement.setString(7,address);  
			pstatement.setString(8,employeePhotoFileName);

			rowInserted=pstatement.executeUpdate();  
			
		
			String destPathOfEmployeePic=ServletActionContext.getServletContext().getRealPath("/"+"/images/employee/");
			File employeePicFile=new File(destPathOfEmployeePic+File.separator,meetingSlipEntryModal.getEmployeePhotoFileName());
			FileUtils.copyFile(meetingSlipEntryModal.getEmployeePhoto(), employeePicFile);
			}
			connection.close();
			}
		
		
		
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		return rowInserted;

		
	}

	public ArrayList<MeetingSlipEntryModal> viewEmployee() {
		
		ArrayList<MeetingSlipEntryModal> arrayList=null;

		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT * from employee";
			result=statement.executeQuery(query);
			arrayList=new ArrayList<>();
			while(result.next()){

				MeetingSlipEntryModal meetingSlipEntryModal=new MeetingSlipEntryModal();
				String employeeId=result.getString(1);
				String name=result.getString(2);
				String email=result.getString(3);
				String contact=result.getString(4);
				String qualification=result.getString(5);
				String specialization=result.getString(6);
				String department=result.getString(7);
				String address=result.getString(8);
				String employeePhotoFileName=result.getString(9);
				

				meetingSlipEntryModal.setUid(employeeId);
				meetingSlipEntryModal.setName(name);
				meetingSlipEntryModal.setEmail(email);
				meetingSlipEntryModal.setContact(contact);
				meetingSlipEntryModal.setQualification(qualification);
				meetingSlipEntryModal.setSpecialization(specialization);
				meetingSlipEntryModal.setDepartment(department);
				meetingSlipEntryModal.setAddress(address);
				meetingSlipEntryModal.setEmployeePhotoFileName(employeePhotoFileName);
				arrayList.add(meetingSlipEntryModal);
			}

			connection.close();
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return arrayList;
		
		
	}

	public void addingFeeStructure(MeetingSlipEntryModal meetingSlipEntryModal) {
		List<FeeStructureModal> feeStructure=meetingSlipEntryModal.getFeeStructure();
		try{
		Class.forName(MeetingSlipCommon.DRIVER);  
		Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
		
		for(int i=1;i<feeStructure.size();i++){
			FeeStructureModal feeStructureModal=feeStructure.get(i);
			String enterTraining=feeStructureModal.getEnterTraining();
			String enterFee=feeStructureModal.getEnterFee();
			String enterDuration=feeStructureModal.getEnterDuration();
			PreparedStatement psFeeStructure=connection.prepareStatement("INSERT INTO feestructure VALUES (?,?,?) ON DUPLICATE KEY UPDATE enterTraining = enterTraining");
			psFeeStructure.setString(1, enterTraining);
			psFeeStructure.setString(2, enterFee);
			psFeeStructure.setString(3, enterDuration);
			psFeeStructure.execute();
			}
		connection.close();
		}
		
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public void updateFeeStructure(String rowTraining, MeetingSlipEntryModal meetingSlipEntryModal) {
		
		try{
			
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			PreparedStatement ps=connection.prepareStatement("UPDATE feestructure SET enterFee='"+meetingSlipEntryModal.getEnterFee()+"', enterDuration='"+meetingSlipEntryModal.getEnterDuration()+"'  WHERE entertraining='"+rowTraining+"'");
			ps.executeUpdate();
			connection.close();
			}
			

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();	
			
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	}

	public List<FeeStructureModal> viewFeeStructure() {
		
		List<FeeStructureModal> feeStructureList=null;

		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT * from feeStructure";
			result=statement.executeQuery(query);
			feeStructureList=new ArrayList<FeeStructureModal>();
			while(result.next()){

				FeeStructureModal feeStructureModal=new FeeStructureModal();
				String enterTraining=result.getString(1);
				String enterFee=result.getString(2);
				String enterDuration=result.getString(3);
				
				feeStructureModal.setEnterTraining(enterTraining);
				feeStructureModal.setEnterFee(enterFee);
				feeStructureModal.setEnterDuration(enterDuration);
				feeStructureList.add(feeStructureModal);
			}

			connection.close();
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return feeStructureList;
		
		
	}

	public void editEmployeeDetails(MeetingSlipEntryModal meetingSlipEntryModal) {

		String uid=meetingSlipEntryModal.getUid();
		String name=meetingSlipEntryModal.getName();
		String contact=meetingSlipEntryModal.getContact();
		String email=meetingSlipEntryModal.getEmail();
		String address=meetingSlipEntryModal.getAddress();
		String qualification=meetingSlipEntryModal.getQualification();
		String department=meetingSlipEntryModal.getDepartment();
		String specialization=meetingSlipEntryModal.getSpecialization();
		
		meetingSlipEntryModal.setEmployeePhotoFileName(meetingSlipEntryModal.getUid()+"."+meetingSlipEntryModal.getName()+"."+FilenameUtils.getExtension(meetingSlipEntryModal.getEmployeePhotoFileName()));
		String employeePhotoFileName=meetingSlipEntryModal.getEmployeePhotoFileName();
		
		
		try{
			String destPathOfEmployeePic=ServletActionContext.getServletContext().getRealPath("/"+"/images/employee/");
			File employeePicFile=new File(destPathOfEmployeePic+File.separator,meetingSlipEntryModal.getEmployeePhotoFileName());
			
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			
			if(meetingSlipEntryModal.getEmployeePhoto()==null){
				PreparedStatement pstatement=connection.prepareStatement("update employee set name='"+name+"',contact='"+contact+"',email='"+email+"',address='"+address+"',qualification='"+qualification+"',"
					+ "department='"+department+"',specialization='"+specialization+"' where employeeId='"+uid+"'");
				pstatement.executeUpdate();
			}
			else{
				FileUtils.copyFile(meetingSlipEntryModal.getEmployeePhoto(), employeePicFile);
				PreparedStatement pstatement=connection.prepareStatement("update employee set name='"+name+"',contact='"+contact+"',email='"+email+"',address='"+address+"',qualification='"+qualification+"',"
						+ "department='"+department+"',specialization='"+specialization+"',employeePhoto='"+employeePhotoFileName+"' where employeeId='"+uid+"'");			
				pstatement.executeUpdate();
			}
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 ;
	}

	public int DeleteEmployeeDetails(String uidForEmployee) {
		
		int rowDelete=0;
		
		try{
			
		Class.forName(MeetingSlipCommon.DRIVER);  
		Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
		PreparedStatement ps=connection.prepareStatement("delete from employee where employeeId='"+uidForEmployee+"'");
		rowDelete=ps.executeUpdate();
		connection.close();
		}
		

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	
		return rowDelete;
		
	}

	public void deleteFeeRow(String serialIdForFeeStructure) {
		try{
			
		Class.forName(MeetingSlipCommon.DRIVER);  
		Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
		PreparedStatement ps=connection.prepareStatement("delete from feestructure where enterTraining='"+serialIdForFeeStructure+"'");
		ps.executeUpdate();
		connection.close();
		}
		

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		
	}

	public List<IdCardSendModal> generateTrainingList() {
		List<IdCardSendModal> training=new ArrayList<IdCardSendModal>();
		try{

			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT entertraining FROM feestructure";
			result=statement.executeQuery(query);

			while(result.next()){
					IdCardSendModal idCardSendModal=new IdCardSendModal();
					idCardSendModal.setTraining(result.getString(1));
					training.add(idCardSendModal);
			}
			connection.close();
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return training;
		
	}

	public void deleteMeetingSlipEntries(String uidForEnrolled) {
		try{
			
		Class.forName(MeetingSlipCommon.DRIVER);  
		Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
		PreparedStatement ps=connection.prepareStatement("delete from meetingslipentries where uid='"+uidForEnrolled+"'");
		ps.executeUpdate();
		
		PreparedStatement ps1=connection.prepareStatement("delete from enrolleddetalis where uid='"+uidForEnrolled+"'");
		ps1.executeUpdate();
		
		connection.close();
		}
		
		
		
		

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		
	}

	public void generateFeeSlipByAdmin(String uidForEnrolled, MeetingSlipEntryModal meetingSlipEntryModal) {
		try{
		Statement statement = null;
		ResultSet result = null;
		Class.forName(MeetingSlipCommon.DRIVER);
		Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
		statement = (Statement) connection.createStatement();
		String query="SELECT * from enrolleddetalis WHERE uid='"+uidForEnrolled+"'";
		result=statement.executeQuery(query);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
	
		
		String uid=null;
		String name=null;
		String dateforFees=null;
		String trainingEnrolled=null;
		
		
		  

		if(result.next()){
			uid=result.getString(12);
			name=result.getString(2);
			dateforFees=dateFormat.format(date);
			trainingEnrolled=result.getString(15);
			
			meetingSlipEntryModal.setUid(uid);
			meetingSlipEntryModal.setName(name);
			meetingSlipEntryModal.setDate( dateforFees);
			meetingSlipEntryModal.setTrainingEnrolled(trainingEnrolled);
			
		}
		
		statement = (Statement) connection.createStatement();
		String query1="SELECT * from feestructure WHERE entertraining='"+trainingEnrolled+"'";
		result=statement.executeQuery(query1);
		
		String fees=null;
		if(result.next()){
			fees=result.getString(2);
			int feeInt=Integer.parseInt(fees);
			String words=numberToWord(feeInt);
			meetingSlipEntryModal.setEnterFee(fees);
			meetingSlipEntryModal.setFeeWords(words);
		}
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	
		
		
	}

	public List<AddingFeeDetails> feeMonths(String uid) {
		
		List<AddingFeeDetails> addingFeeList=null;
		
		try{
			ResultSet result=null;
			Statement statement=null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="Select * from traineefees where uid='"+uid+"'";
			result=statement.executeQuery(query);
			addingFeeList=new ArrayList<AddingFeeDetails>();
			while(result.next()){
				
				
				String traineeUid=result.getString(2);
				String depositType=result.getString(5);
				String amount=result.getString(7);
				String feeStatus=result.getString(8);
				
				AddingFeeDetails addingFeeDetails=new AddingFeeDetails();
				
				addingFeeDetails.setTraineeDate(traineeUid);
				addingFeeDetails.setTraineeDepositType(depositType);
				addingFeeDetails.setTraineeSumOfFigure(amount);
				addingFeeDetails.setTraineeFeeStatus(feeStatus);
				
				addingFeeList.add(addingFeeDetails);
				
			}
			connection.close();
			}
			

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return addingFeeList;
		
	}
	
	 public static String numberToWord(int number)
	    {
	        String wordForm = "";
	        int quotient =0;
	        int remainder = 0;
	        int divisor = 0;
	        if(number<1000000000 && number>=1000000)
	        {
	            divisor = 1000000;
	            quotient = number/divisor;
	            remainder = number % divisor;
	            if(quotient!=0)
	            wordForm += numberToWord(quotient) + " " + "Million";
	            if(remainder!=0)
	                wordForm+= " " + numberToWord(remainder);
	        }
	        else if(number<1000000 && number>=10000)
	        {
	            divisor = 1000;
	            quotient = number/divisor;
	            remainder = number % divisor;
	            if(quotient!=0)
	            wordForm += numberToWord(quotient) + " " + "Thousand";
	            if(remainder!=0)
	                wordForm+= " " + numberToWord(remainder);
	        }
	        else if(number<10000 && number>=1000)
	        {
	            divisor = 1000;
	            quotient = number/divisor;
	            remainder = number % divisor;
	            if(quotient!=0)
	            wordForm += numberMap.get(quotient) + "Thousand";
	            if(remainder!=0)
	                wordForm+= numberToWord(remainder);

	        }else if(number<1000 && number>=100)
	        {
	            divisor = 100;
	            quotient = number/divisor;
	            remainder = number % divisor;
	            if(quotient!=0)
	            wordForm += numberMap.get(quotient) + " " + "Hundred";
	            if(remainder!=0)
	                wordForm +=numberToWord(remainder);

	        }else if(number<100 && number>=10)
	        {
	            divisor = 10;
	            quotient = number/divisor;
	            remainder = number % divisor;
	            if(quotient!=0)
	                wordForm+= numberMap.get(quotient*divisor);
	            if(remainder!=0)
	                wordForm+= numberMap.get(remainder);


	        }else if(number<10 && number>=0)
	        {
	            wordForm +=  numberMap.get(number);

	        }
	        return wordForm;
	    }

	public void installments(String uidForEnrolled, MeetingSlipEntryModal meetingSlipEntryModal) {
		
		try{
			ResultSet result=null;
			Statement statement=null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="Select trainingEnrolled from enrolleddetalis where uid='"+uidForEnrolled+"'";
			result=statement.executeQuery(query);
			if(result.next()){
				meetingSlipEntryModal.setTrainingEnrolled(result.getString(1));
			}
			
			statement = (Statement) connection.createStatement();
			String query1="Select * from feestructure where enterTraining='"+meetingSlipEntryModal.getTrainingEnrolled()+"'";
			result=statement.executeQuery(query1);
			if(result.next()){
				String fees=result.getString(2);
				String duration=result.getString(3);
				
				int feeInt=Integer.parseInt(fees);
				int durationInt=Integer.parseInt(duration);
				
				int resultdiv=feeInt/durationInt;
				String resultString=String.valueOf(resultdiv);
				
				String words=numberToWord(resultdiv);
				meetingSlipEntryModal.setEnterFee(resultString);
				meetingSlipEntryModal.setFeeWords(words);
				
				
			}
			connection.close();
			}
			

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		
		
	}

	public int addingFeesdetailsDb(AddingFeeDetails addingFeeDetails) {
		
		String paymentStatus=null;
		int rowInserted=0;

		String uid=addingFeeDetails.getTraineeUid();
		String date=addingFeeDetails.getTraineeDate();
		String name=addingFeeDetails.getTraineeName();
		String feeWords=addingFeeDetails.getTraineeSumOfRupees();
		String depositType=addingFeeDetails.getTraineeDepositType();
		String paymentType=addingFeeDetails.getTraineePaymentType();
		String enterFee=addingFeeDetails.getTraineeSumOfFigure();
		
		
		if(depositType.equals("CASH"))
		{
		 paymentStatus="Paid";
		}
		else{
		 paymentStatus="Due";
		}
		

		try{	
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);    
			PreparedStatement pstatement=connection.prepareStatement("INSERT INTO traineefees(uid,date,name,amountInWords,depositType,paymenttype,amountInfigure,paymentStatus) VALUES(?,?,?,?,?,?,?,?)");

			pstatement.setString(1,uid);  
			pstatement.setString(2,date);  
			pstatement.setString(3,name);  
			pstatement.setString(4,feeWords);
			pstatement.setString(5,depositType);  
			pstatement.setString(6,paymentType);  
			pstatement.setString(7,enterFee);
			pstatement.setString(8,paymentStatus); 

			rowInserted=pstatement.executeUpdate();  
			connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowInserted;

		
	}

	public void changePaymentSta(String juidForEnrolled, String jfeeOfMonth,String jpaymentStatus) {
		
		
		try{
			
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			PreparedStatement ps=connection.prepareStatement("UPDATE traineefees SET paymentStatus='"+jpaymentStatus+"' WHERE uid='"+juidForEnrolled+"' AND DATE='"+jfeeOfMonth+"'");
			ps.executeUpdate();
			connection.close();
			}
			

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		
	}

	public List<AcademicDetailsModal> getTraineeDetails(String uid, MeetingSlipEntryModal meetingSlipEntryModal) {
		
		List<AcademicDetailsModal> listAcademicDetailsModals=null;
		
		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="SELECT * FROM enrolleddetalis WHERE uid='"+uid+"'";
			result=statement.executeQuery(query);
			
			if(result.next()){
				meetingSlipEntryModal.setApplicationFormNumber(result.getString(1));
				meetingSlipEntryModal.setUid(result.getString(12));
				meetingSlipEntryModal.setPhotoFileName(result.getString(17));
				
				meetingSlipEntryModal.setName(result.getString(2));
				meetingSlipEntryModal.setDateOfBirth(result.getString(4));
				meetingSlipEntryModal.setContact(result.getString(5));
				meetingSlipEntryModal.setGender(result.getString(3));
				meetingSlipEntryModal.setFatherName(result.getString(7));
				meetingSlipEntryModal.setEmail(result.getString(6));
				meetingSlipEntryModal.setPhoneNumber(result.getString(8));
				meetingSlipEntryModal.setPresentAddress(result.getString(10));
				meetingSlipEntryModal.setPermanentAddress(result.getString(11));
				
				meetingSlipEntryModal.setTrainingEnrolled(result.getString(15));
				meetingSlipEntryModal.setDate(result.getString(16));
				meetingSlipEntryModal.setIssueCertificate(result.getString(21));

		}	
		
		listAcademicDetailsModals=new ArrayList<AcademicDetailsModal>();
		statement = (Statement) connection.createStatement();
		String query2="SELECT * FROM academicdetails WHERE uid='"+uid+"'";
		result=statement.executeQuery(query2);
		while(result.next()){
			AcademicDetailsModal adm=new AcademicDetailsModal();
			adm.setEducation(result.getString(3));
			adm.setYear(result.getString(4));
			adm.setCollege(result.getString(5));
			adm.setBoard(result.getString(6));
			adm.setMarks(result.getString(7));
			adm.setDocumentFileName(result.getString(8));
			listAcademicDetailsModals.add(adm);
		}
		
		connection.close();
	}
	catch(NumberFormatException e){
		e.printStackTrace();
	}

	catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();	
	}
	catch(SQLException e){
		e.printStackTrace();
	}

	return listAcademicDetailsModals;

	}

	public boolean traineeLogin(String uid, String password) {
	
		boolean status=false;
		try{
			Statement statement = null;
			ResultSet result = null;
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement = (Statement) connection.createStatement();
			String query="select * from enrolleddetalis where uid='"+uid+"' and password='"+password+"'";
			result=statement.executeQuery(query);
			status=result.next();
			connection.close();
		}
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return status;
		
	}

	public int adminLogin(String email, String password) {
		
		int verifyLogin=0;
		ResultSet resultSet=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement=connection.prepareStatement("SELECT COUNT(*) FROM adminlogin WHERE username='"+email+"' && password='"+password+"'");
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				verifyLogin=resultSet.getInt(1);
			}
			connection.close();
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
			System.out.println("Enter The Valid Types");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return verifyLogin;
		
	}

	public void updateEnrolledDetails(MeetingSlipEntryModal meetingSlipEntryModal) {
		String profileMeter=null;
		
		String uid=meetingSlipEntryModal.getUid();
		String admissionFormNumber=meetingSlipEntryModal.getApplicationFormNumber();
		
		meetingSlipEntryModal.setPhotoFileName(meetingSlipEntryModal.getUid()+"."+FilenameUtils.getExtension(meetingSlipEntryModal.getPhotoFileName()));
		String photoName=meetingSlipEntryModal.getPhotoFileName();
		String name=meetingSlipEntryModal.getName();
		String gender=meetingSlipEntryModal.getGender();
		String dateOfBirth=meetingSlipEntryModal.getDateOfBirth();
		String contact=meetingSlipEntryModal.getContact();
		String email=meetingSlipEntryModal.getEmail();
		String fatherName=meetingSlipEntryModal.getFatherName();
		String phoneNumber=meetingSlipEntryModal.getPhoneNumber();
		String occupation=meetingSlipEntryModal.getOccupation();
		String presentAddress=meetingSlipEntryModal.getPresentAddress();
		String permanentAddress=meetingSlipEntryModal.getPermanentAddress();
		
		List<AcademicDetailsModal> academicDetails=meetingSlipEntryModal.getAcademicDetails();
		if(academicDetails==null){

		}
		else{
		for(int i=0;i<academicDetails.size();i++){
			AcademicDetailsModal adm=academicDetails.get(i);
			adm.setDocumentFileName(meetingSlipEntryModal.getUid()+"."+adm.getEducation()+"."+FilenameUtils.getExtension(adm.getDocumentFileName()));
		}
		}
		String startDate=meetingSlipEntryModal.getDate();
		String endDate=meetingSlipEntryModal.getEndDate();
		String actualEndDate=meetingSlipEntryModal.getActualEndDate();
		String trainingEnrolled=meetingSlipEntryModal.getTrainingEnrolled();
		String issueCertificate=meetingSlipEntryModal.getIssueCertificate();
		
		
		if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && dateOfBirth.isEmpty() && gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="25";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="30";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && fatherName.isEmpty() && occupation.isEmpty() && phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="35";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && occupation.isEmpty() && phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="40";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="45";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !phoneNumber.isEmpty() && presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="50";
		}
		
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !phoneNumber.isEmpty() && !presentAddress.isEmpty() && permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="60";
		}
		
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !phoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && photoName.isEmpty()){
			profileMeter="70";
		}
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !phoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && !photoName.isEmpty() && academicDetails.size()==0){
			profileMeter="80";
		}
		
		else if(!name.isEmpty() && !contact.isEmpty() && !email.isEmpty() && !dateOfBirth.isEmpty() && !gender.isEmpty() && !fatherName.isEmpty() && !occupation.isEmpty() && !phoneNumber.isEmpty() && !presentAddress.isEmpty() && !permanentAddress.isEmpty() && !photoName.isEmpty() && academicDetails.size()>0){
			profileMeter="98";
		}
		
		else{
			profileMeter="5";
		}
		
		
		try{
			String destPathOfUserPic=ServletActionContext.getServletContext().getRealPath("/"+"/images/userPic/");
			File traineePicFile=new File(destPathOfUserPic+File.separator,meetingSlipEntryModal.getPhotoFileName());
			
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			
			if(meetingSlipEntryModal.getPhoto()==null){
				PreparedStatement pstatement=connection.prepareStatement("update enrolleddetalis set name='"+name+"',gender='"+gender+"',dateOfBirth='"+dateOfBirth+"',contact='"+contact+"',email='"+email+"',fatherName='"+fatherName+"',phoneNumber='"+phoneNumber+"',occupation='"+occupation+"',presentAddress='"+presentAddress+"',permanentAddress='"+permanentAddress+"',date='"+startDate+"',endDate='"+endDate+"',profileMeter='"+profileMeter+"',actualEndDate='"+actualEndDate+"',trainingEnrolled='"+trainingEnrolled+"',issueCertificate='"+issueCertificate+"' where uid='"+uid+"'");
				pstatement.executeUpdate();
			}
			else{
				FileUtils.copyFile(meetingSlipEntryModal.getPhoto(), traineePicFile);
				PreparedStatement pstatement=connection.prepareStatement("update enrolleddetalis set name='"+name+"',gender='"+gender+"',dateOfBirth='"+dateOfBirth+"',contact='"+contact+"',email='"+email+"',fatherName='"+fatherName+"',phoneNumber='"+phoneNumber+"',occupation='"+occupation+"',presentAddress='"+presentAddress+"',permanentAddress='"+permanentAddress+"',photoPath='"+photoName+"',date='"+startDate+"',endDate='"+endDate+"',profileMeter='"+profileMeter+"',actualEndDate='"+actualEndDate+"',trainingEnrolled='"+trainingEnrolled+"',issueCertificate='"+issueCertificate+"' where uid='"+uid+"'");
				pstatement.executeUpdate();
			}
			
		if(academicDetails==null){
			
		}
		else{
			String destPathOfUserDocuments=ServletActionContext.getServletContext().getRealPath("/"+"/images/documents/");
		for(int i=0;i<meetingSlipEntryModal.getAcademicDetails().size();i++)
		{
			AcademicDetailsModal adm=meetingSlipEntryModal.getAcademicDetails().get(i);
			String education=adm.getEducation();
			String year=adm.getYear();
			String college=adm.getCollege();
			String board=adm.getBoard();
			String marks=adm.getMarks();
			String documentFileName=adm.getDocumentFileName();
			
			File traineeDocumentFile=new File(destPathOfUserDocuments+File.separator,adm.getDocumentFileName());
			
				if(adm.getDocument()==null){
				
				PreparedStatement psAcademicDetails=connection.prepareStatement("insert into academicDetails (uid,admissionFormNumber,education,year,college,board,marks,documentPath) values(?,?,?,?,?,?,?,?) ON DUPLICATE KEY update year='"+year+"' ,college='"+college+"',board='"+board+"',marks='"+marks+"'");
				//INSERT INTO academicDetails (uid,admissionFormNumber,education,year,college,board,marks,documentPath) VALUES ('151','151-200','10th','2009','ymcs','cbse','65','djhg') ON DUPLICATE KEY UPDATE year='2009',college='ymca',board='cbse',marks='65',documentPath='djhg'
				psAcademicDetails.setString(1, uid);
				psAcademicDetails.setString(2, admissionFormNumber);
				psAcademicDetails.setString(3, education);
				psAcademicDetails.setString(4, year);
				psAcademicDetails.setString(5, college);
				psAcademicDetails.setString(6, board);
				psAcademicDetails.setString(7, marks);
				psAcademicDetails.setString(8, documentFileName);
				psAcademicDetails.executeUpdate();
				}
				else{
					FileUtils.copyFile(adm.getDocument(), traineeDocumentFile);
					PreparedStatement psAcademicDetails=connection.prepareStatement("insert into academicDetails (uid,admissionFormNumber,education,year,college,board,marks,documentPath) values(?,?,?,?,?,?,?,?) ON DUPLICATE KEY update year='"+year+"' ,college='"+college+"',board='"+board+"',marks='"+marks+"',documentPath='"+documentFileName+"'");
					psAcademicDetails.setString(1, uid);
					psAcademicDetails.setString(2, admissionFormNumber);
					psAcademicDetails.setString(3, education);
					psAcademicDetails.setString(4, year);
					psAcademicDetails.setString(5, college);
					psAcademicDetails.setString(6, board);
					psAcademicDetails.setString(7, marks);
					psAcademicDetails.setString(8, documentFileName);
					psAcademicDetails.executeUpdate();
					
				}
			
		
		
		}
		}
		
	
		
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		}

		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public int deleteAcademicfromDatabase(MeetingSlipEntryModal meetingSlipEntryModal) {
		int rowDelete=0;
		try{
			Class.forName(MeetingSlipCommon.DRIVER);  
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			PreparedStatement ps=connection.prepareStatement("delete from academicDetails where uid='"+meetingSlipEntryModal.getUid()+"' AND education='"+meetingSlipEntryModal.getEducation()+"'");
			rowDelete=ps.executeUpdate();
			connection.close();
			}
			

			catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return rowDelete;
			
		
	}

	public String forgetPasswordTrainee(MeetingSlipEntryModal meetingSlipEntryModal) {
		
		String password=null;
		ResultSet resultSet=null;
		PreparedStatement statement=null;
		
		try {
			Class.forName(MeetingSlipCommon.DRIVER);
			Connection connection=DriverManager.getConnection(MeetingSlipCommon.URL+MeetingSlipCommon.DBNAME,MeetingSlipCommon.USER,MeetingSlipCommon.PASSWORD);
			statement=connection.prepareStatement("select password from enrolleddetalis where email='"+meetingSlipEntryModal.getEmail()+"'");
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				password=resultSet.getString(1);
				
				
				Properties properties =new Properties();
				properties.put("mail.smtp.host", "smtp.gmail.com");  
				properties.put("mail.smtp.socketFactory.port", "465");  
				properties.put("mail.smtp.socketFactory.class",  
						"javax.net.ssl.SSLSocketFactory");  
				properties.put("mail.smtp.auth", "true");  
				properties.put("mail.smtp.port", "465");
		try{
			
			
				Session session = Session.getDefaultInstance(properties,	new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						String username, password;
						username="organize.kittyparty@gmail.com";
						password="kittyparty";
						return new PasswordAuthentication(username,password);
					}
				});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("organize.kittyparty@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(meetingSlipEntryModal.getEmail()));  
			message.setSubject("Password Recovery"); 
			message.setText("The Password For your registered Account is:"+password+"");
			Transport.send(message);  
			
		}
		
		catch(javax.mail.SendFailedException e){
			
			e.printStackTrace();
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
			}
			
			connection.close();
			
			}
		
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e){
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return password;
	
			
	}
	
}
