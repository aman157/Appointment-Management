<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>enrolledDetailView</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/admin/enrolledDetailView.css" />


</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">E|N|R|O|L|L|E|D D|E|T|A|I|L|S V|I|E|W</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation"><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown ">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
     						 Employee <span class="caret"></span></a>
                             <ul class="dropdown-menu">
                              	<li role="presentation"><a href="addEmployee?">Add Employee</a></li>
                                <li role="presentation"><a href="viewEmployee?">View Employee</a></li>
                            </ul>
                          </li>
                        <li role="presentation"><a href="feestructure?">Fee Structure</a></li>
                        <li role="presentation" class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
     						 Admin Sys <span class="caret"></span></a>
                             <ul class="dropdown-menu">
                             	<li role="presentation"><a href="addMetingSlip?">Add Meeting Slip</a></li>
                              	<li role="presentation"><a href="logout?">Logout</a></li>
                            </ul>
                          </li>
                    </ul>
                </div>
    	
    </div>

<!--row 2 end-->

<!--content row-->
<div class="enrolledDetailView row">
    <form id="updateEnrolledForm" class="form-horizontal" action="updatEnrolledDetail" method="post" enctype="multipart/form-data">
        <div class="col-sm-offset-1 col-sm-10 enrolledDetails">
        	<div class="col-sm-offset-1">
            <div class="row getinfo">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="admissionForm" class="control-label col-sm-6">Admission Form No:</label>
                        <div class="col-sm-6">
                        	<input type="text" class="form-control" name="applicationFormNumber" value="<s:property value="applicationFormNumber"/>" readonly="readonly" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<label for="Uid" class="control-label col-sm-6">UID:</label>
                    	<div class="col-sm-6">
                    		<input type="text" id="enrolledUid" class="form-control" name="uid" id="uid" value="<s:property value="uid"/>" readonly="readonly"/>
                    	</div>   
                  	</div>
                </div>
                
                <div class="col-sm-6 ">               	
                		<div class="col-sm-offset-3 photoSec photoLink">
                		<img id="traineePicUpdated" src="../MeetingSlip/images/userPic/<s:property value="photoFileName"/>"  alt="no-image" height="97" width="97" >
                		<input type="file" class="editedTraineePic" name="photo" />
                    </div>
                
                </div>
            </div>
            
            <div class="row basicInfo">
              <div class="form-group">
                <label for="candidateName" class="control-label col-sm-2">Name:</label>
                <div class="col-sm-3">
                	<input type="text" id="nameEnrolled" class="form-control" name="name" value="<s:property value="name"/>" disabled="disabled">
                </div> 
                
                <label for="dob" class="control-label col-sm-2">DOB:</label>
                  <div class="col-sm-3">
                  	<input type="text" id="dobEnrolled" class="form-control " name="dateOfBirth" value="<s:property value="dateOfBirth"/>" disabled="disabled">
                  </div>   
                  
              </div>
            </div>
            
           
            
            <div class="row">
                <div class="form-group">
                    <label for="contact No:-" class="control-label col-sm-2">Contact No:</label>
                    <div class="col-sm-3">
                    	<input type="text" id="contactEnrolled"class="form-control " name="contact" value="<s:property value="contact"/>" disabled="disabled">
                    </div> 
                    
                    <label for="gender" class="control-label col-sm-2">Gender:</label>
                <div class="col-sm-3">
                	<input type="text" id="genderEnrolled" class="form-control " name="gender"  value="<s:property value="gender"/>" disabled="disabled">
                </div>    
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                	 <label for="fatherName" class="control-label col-sm-2">Father"s Name:</label>
                  <div class="col-sm-3">
                  	<input type="text" id="fatherNameEnrolled" class="form-control " name="fatherName"  value="<s:property value="fatherName"/>" disabled="disabled">
                  </div> 
                  
                    <label for="occupation" class="control-label col-sm-2">Occupation:</label>
                    <div class="col-sm-3">
                    	<input type="text" id="occupationEnrolled" class="form-control " name="occupation"  value="<s:property value="occupation"/>" disabled="disabled">
                    </div>   
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                    <label for="phoneNo" class="control-label col-sm-2">Phone No:</label>
                    <div class="col-sm-3">
                    	<input type="text" id="phoneEnrolled" class="form-control " name="phoneNumber"  value="<s:property value="phoneNumber"/>" disabled="disabled">
                    </div>
                    
                    
                </div>
            </div>
            
            <div class="row">
               <div class="form-group">
                   <label for="email" class="control-label col-sm-2">E-mail:</label>
                   <div class="col-sm-5">
                    	<input type="text" id="emailEnrolled" class="form-control " name="email"  value="<s:property value="email"/>" disabled="disabled">
                   </div>  
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                  <label for="presentAddr" class="control-label col-sm-2">Present Address:</label>
                  <div class="col-sm-8">
                      <input type="text" id="presentAddressEnrolled" class="form-control" name="presentAddress"  value="<s:property value="presentAddress"/>" disabled="disabled">
                  </div>   
            	</div>
             </div>
             
             <div class="row">
                <div class="form-group">
                  <label for="permanentAddr"  class="control-label col-sm-2">Permanent Add.:</label>
                  <div class="col-sm-8">
                      <input type="text" id="permanentAddressEnrolled" class="form-control" name="permanentAddress"  value="<s:property value="permanentAddress"/>" disabled="disabled" >
                  </div>   
                </div>
             </div>
             
             
             <div class="row">
             	<div class="col-sm-10">
                    <fieldset>
                        <legend>Education</legend>
                        <table class="table table-striped " id="tableEnrolledDetailView">
                            <th>Education/Degree</th>
                            <th>Year</th>
                            <th>School/Clg</th>
                            <th>Board/University</th>
                            <th>Marks(%)</th>
                            <th>Documents</th>
                            <s:iterator value="academicDetailsFromDatabase" status="mystat" var="arr">
                            <tr id="<s:property value="%{#mystat.index}"/>">
                            	<td><select class="col-sm-12 form-control academic" id="<s:property value="%{#arr.education}" />" name="academicDetails[<s:property value="%{#mystat.index}"/>].education" disabled="disabled">
			                          	<option selected="selected" value="<s:property value="%{#arr.education}" />"><s:property value="%{#arr.education}" /></option>
			                            <option value="10th">10th</option>
			                            <option value="12th">12th</option>
			                            <option value="graduation">Graduation</option>
			                            <option value="graduation">Post Graduation</option>
			                            <option value="graduation">Doctorate</option>
			                          </select></td>
                            	<td><input type="text" class="col-sm-12 form-control academic" name="academicDetails[<s:property value="%{#mystat.index}"/>].year" value="<s:property value="%{#arr.year}" />" disabled="disabled"></input></td>
                            	<td><input type="text" class="col-sm-12 form-control academic" name="academicDetails[<s:property value="%{#mystat.index}"/>].college" value="<s:property value="%{#arr.college}" />" disabled="disabled"></input></td>
                            	<td><input type="text" class="col-sm-12 form-control academic" name="academicDetails[<s:property value="%{#mystat.index}"/>].board" value="<s:property value="%{#arr.board}" />" disabled="disabled"></input></td>
                            	<td><input type="text" class="col-sm-12 form-control academic" name="academicDetails[<s:property value="%{#mystat.index}"/>].marks" value="<s:property value="%{#arr.marks}" />" disabled="disabled"></input></td>
                            	<td class="text-center"><img class="editedPic" src="../MeetingSlip/images/documents/<s:property value="%{#arr.documentFileName}" />" alt="no-image" height="70" width="70"></td>
                            	<td><input type="file" class=" btn btn-primary editUploadedDoc" name="academicDetails[<s:property value="%{#mystat.index}"/>].document"  value="<s:property value="%{#arr.documentFileName}" />"/></td>
								<td><a href="#" id="deleteAcademicfromDatabase"class="deleteAcademic glyphicon glyphicon-trash"></a></td>
                            </tr>
                            </s:iterator>
                            
                        </table>
               	</fieldset>
                </div>
            </div>
                     <div class="row col-sm-offset-10">
  						<h4 ><a id="addEnrolledRow" href="#">Add Another</a></h4>
  					</div>
            
            
            <div class="row">
                     	<div class="col-sm-6">
                       	<fieldset>
                        	<legend>Fees Status</legend>
                     	 	<table class="table table-striped">
                             	<th>Date</th>
                                <th >Status</th>
                                <th>Payment Type</th>
                                <th>Amount</th>
                                <s:iterator value="addingFeedetailsFromDatabase" status="mystat" var="arr1">
                            <tr>
                            	
                            	<td ><s:property value="%{#arr1.traineeDate}" /></td>
                     			<td><select class="form-control paymntStatus" id="<s:property value="%{#arr1.traineeDate}" /> ">
                     			
                     			
                     				 <s:if test="%{#arr1.traineeFeeStatus.equals('Due')}">
                     					<option value="<s:property value="%{#arr1.FeeStatus}" />"><s:property value="%{#arr1.traineeFeeStatus}" /></option>
                     					<option value="Paid">Paid</option>
                     			</s:if>
                     			<s:else>
                     					<option value="<s:property value="%{#arr1.FeeStatus}" />"><s:property value="%{#arr1.traineeFeeStatus}" /></option>
                     					<option value="Due">Due</option>
                     			</s:else> 
                     					
                     			</select></td>
                     			<td ><s:property value="%{#arr1.traineeDepositType}" /></td>
                     			<td ><s:property value="%{#arr1.traineeSumOfFigure}" /></td>
                            </tr>
                            </s:iterator>
                            </table>
                     		</fieldset>
                     </div>
                 </div>
                 
              <div class="row">
                  <div class="col-sm-10">
                  	<legend>Training Details</legend>
                  		<div class="form-group">
                  			<label for="courseStarting" class="control-label col-sm-2">Starting Date:</label>
                 		 	<div class="col-sm-3">
                  				<input type="text" id="startingDate" name="date" class="form-control " value="<s:property value="date"/>" disabled="disabled">
                  			</div>   
                  
                  			<label for="courseEnding" class="control-label col-sm-2">Ending Date:</label>
                  			<div class="col-sm-3">
                  				<input type="text" id="endingDate" class="form-control " name="endDate" disabled="disabled" value="<s:property value="endDate"/>" >
                  			</div> 
                  		</div>
                        
                        <div class="form-group">
                              <label for="actualEnd" class="control-label col-sm-2">Actual End Date:</label>
                              <div class="col-sm-3">
                                  <input type="text" id="actualEndDate" name="actualEndDate" value="<s:property value="actualEndDate"/>" class="form-control" disabled="disabled">
                              </div> 
                              
                              <label for="trainingEnrolled" class="control-label col-sm-2">Training Enrolled:</label>
                    <div class="col-sm-3">
                        <input type="text" id="trainingEnrolled" class="form-control " name="trainingEnrolled"  value="<s:property value="trainingEnrolled"/>" disabled="disabled" >
                    </div>     
                        </div>
                        
                        <div class="form-group">
                              <label for="issueCertificate" class="control-label col-sm-2">Issue Certificate:</label>
                              <div class="col-sm-5">
                                  <select class="form-control" id="issueCertificate" name="issueCertificate" disabled="disabled" >
                                  	<option selected="selected"><s:property value="issueCertificate"/></option>
                                  	<option>Not Available</option>
                                  	<option>In Process</option>
                                    <option>Generated</option>
                                  </select>
                              </div>   
                        </div>
                  </div>
              </div>
         
        </div>
        </div>
    </form>
</div>

    <div class="row enrolledDetailsBtn">
                            <input type="button" class="enrolledPrintBtn btn btn-primary" value="Print"/>
                            <input type="button" class="enrolledEditBtn btn btn-primary" value="Edit"/>       
              </div>
<!--content row end-->


</div>
<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->
</body>
</html>


