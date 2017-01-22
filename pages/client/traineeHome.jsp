<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>traineeHome</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/client/traineeHome.css" />

<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->


</head>

<body>
<div class="container-fluid">
<!--row 1-->
<div class="row clientHeader">
    	<img class=" col-sm-2 gifImage" src="images/welcome.gif" /><p class="col-sm-3 welcomeName"><s:property value="name"/></p>
    	
	    	<form action="logoutTrainee" method="post" class="col-sm-offset-11">
	    		<input class="logout" type="submit" value="logout"></input>
	    	</form>
    	
</div>
<!--row one end-->

<!--row 2-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">T|R|A|I|N|E|E P|R|O|F|I|L|E<br />
</h3>
    </div>
    
<!-- row 2 end-->

<!--row 3-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="#">Home</a></li>
                        <li role="presentation" ><a href="#">Notifications</a></li>
                        <li role="presentation" ><a href="#">Worksheet</a></li>
                        <li role="presentation" ><a href="#">Attandence</a></li>
                    </ul>
                </div>
    	
    </div>

<!--row 3 end-->

<!--content row-->
<div class="row traineeProfile">
    <form class="form-horizontal">
        <div class="col-sm-offset-2 col-sm-8 enrolledDetails">
            <div class="row getinfo">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="admissionForm" class="control-label col-sm-6">Admission Form No:</label>
                        <div class="col-sm-6">
                        	<input type="text" class="form-control" value="<s:property value="applicationFormNumber"/>" readonly="readonly">
                        </div>
                    </div>
                    
                    <div class="form-group">
                    	<label for="Uid" class="control-label col-sm-6">UID:</label>
                    	<div class="col-sm-6">
                    		<input type="text" class="form-control " value="<s:property value="uid"/>" readonly="readonly">
                    	</div>   
                  	</div>
                </div>
                
                <div class="col-sm-6 ">
                	<div class="col-sm-offset-3 photoSec">
                	<img src="../MeetingSlip/images/userPic/<s:property value="photoFileName"/>"  alt="process" height="97" width="97" >
                    
                    </div>
                
                </div>
            </div>
            
            <div class="row basicInfo">
              <div class="form-group">
                <label for="candidateName" class="control-label col-sm-2">Name:</label>
                <div class="col-sm-3">
                	<input type="text" class="form-control " value="<s:property value="name"/>" readonly="readonly" >
                </div> 
                
                <label for="dob" class="control-label col-sm-2">DOB:</label>
                  <div class="col-sm-3">
                  	<input type="text" class="form-control " value="<s:property value="dateOfBirth"/>" readonly="readonly" >
                  </div>   
                  
              </div>
            </div>
            
           
            
            <div class="row">
                <div class="form-group">
                    <label for="contact No:-" class="control-label col-sm-2">Contact No:</label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control " value="<s:property value="contact"/>" readonly="readonly">
                    </div> 
                    
                    <label for="gender" class="control-label col-sm-2">Gender:</label>
                <div class="col-sm-3">
                	<input type="text" class="form-control " value="<s:property value="gender"/>" readonly="readonly">
                </div>    
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                	 <label for="fatherName" class="control-label col-sm-2">Father"s Name:</label>
                  <div class="col-sm-3">
                  	<input type="text" class="form-control " value="<s:property value="fatherName"/>" readonly="readonly">
                  </div> 
                  
                   <label for="email" class="control-label col-sm-2">E-mail:</label>
                   <div class="col-sm-3">
                    	<input type="text" class="form-control " value="<s:property value="email"/>"  readonly="readonly">
                   </div>     
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                    <label for="phoneNo" class="control-label col-sm-2">Phone No:</label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control " value="<s:property value="phoneNumber"/>" readonly="readonly">
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group">
                  <label for="presentAddr" class="control-label col-sm-2">Present Address:</label>
                  <div class="col-sm-8">
                      <input type="text" class="form-control " value="<s:property value="presentAddress"/>" readonly="readonly">
                  </div>   
            	</div>
             </div>
             
             <div class="row">
                <div class="form-group">
                  <label for="permanentAddr" class="control-label col-sm-2">Permanent Add.:</label>
                  <div class="col-sm-8">
                      <input type="text" class="form-control " value="<s:property value="permanentAddress"/>" readonly="readonly">
                  </div>   
                </div>
             </div>
             
             
             <div class="row">
             	<div class="col-sm-10">
                    <fieldset>
                        <legend>Education</legend>
                        <table class="table table-striped ">
                            <th>Education/Degree</th>
                            <th>Year</th>
                            <th>School/Clg</th>
                            <th>Board/University</th>
                            <th>Marks(%)</th>
                            <th>Documents</th>
                            
                             <s:iterator value="academicDetailsFromDatabase" status="mystat" var="arr">
                            <tr>
                            	
                            	<td  readonly="readonly"><s:property value="%{#arr.education}" /></td>
                            	<td readonly="readonly"><s:property value="%{#arr.year}" /></td>
                            	<td readonly="readonly"><s:property value="%{#arr.college}" /></td>
                            	<td readonly="readonly"><s:property value="%{#arr.board}" /></td>
                            	<td readonly="readonly"><s:property value="%{#arr.marks}" /></td>
                            	<td><img src="../MeetingSlip/images/documents/<s:property value="%{#arr.documentFileName}" />" alt="process" height="70" width="70"></td>
                            	
                            </tr>
                            </s:iterator>
                        </table>
               	</fieldset>
                </div>
            </div>
            
            <div class="row">
                     	<div class="col-sm-6">
                       	<fieldset>
                        	<legend>Fees Status</legend>
                     	 	<table class="table table-striped">
                             	<th>Month</th>
                                <th class="">Status</th>
                                <s:iterator value="addingFeedetailsFromDatabase" status="mystat" var="arr1">
                            <tr>
                            	
                            	<td  readonly="readonly"><s:property value="%{#arr1.traineeDate}" /></td>
                     			<td  readonly="readonly"><s:property value="%{#arr1.traineeFeeStatus}" /></td>
                     			
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
                        	
                             <label for="trainingEnrolled" class="control-label col-sm-2">Training Enrolled:</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control " value="<s:property value="trainingEnrolled"/>" readonly="readonly">
                                </div> 
                                
                  			<label for="courseStarting" class="control-label col-sm-2">Enrolled Date:</label>
                 		 	<div class="col-sm-3">
                  				<input type="text" class="form-control " value="<s:property value="date"/>" readonly="readonly" >
                  			</div>   
                  		</div>
                        
                        
                        <div class="form-group">
                              <label for="issueCertificate" class="control-label col-sm-2">Certificate Status:</label>
                              <div class="col-sm-5">
                                   <input type="text" class="form-control "  value="<s:property value="issueCertificate"/>"  readonly="readonly">
                              </div>   
                        </div>
                        
                     
                  </div>
              </div>
              
              
              <div class="row enrolledDetailsBtn">
                            <input type="button" class="btn btn-primary printTraineeProfile" value="Print"/>
                        
              </div>
         
        </div>
    </form>
</div>
<!--content row end-->

</div>

</body>
</html>


