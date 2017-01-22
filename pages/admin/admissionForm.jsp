<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>admissionForm</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/admin/admissionForm.css" />
<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />


<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/validation.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->
</head>

<body>
<div class="container-fluid">

<!--row 0-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">E|N|R|O|L|L|M|E|N|T</h3>
    </div>
    
<!-- row 0 end-->

<!--row 1-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation"><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown active">
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
                             	<li role="presentation"><a href="#">Add Meeting Slip</a></li>
                              	<li role="presentation"><a href="logout?">Logout</a></li>
                                <li role="presentation"><a href="#">Settings</a></li>
                            </ul>
                          </li>
                    </ul>
                </div>
    	
    </div>


<!--row 1 end-->

<div class="formAdmissionMargin">
    <div class="col-sm-offset-2 col-sm-8  col-xs-12 checkBAckground">
      <form class="form-horizontal formBackground" id="admissionFormEnrollnment" action="addingEnrolledDataToDatabase" method="post" enctype="multipart/form-data">
              <div class="form-group">
                  <label for="admissionForm" class="control-label col-sm-3">Admission Form No</label>
                  <div class="col-sm-3">
                  	<input type="text" class="form-control" name="applicationFormNumber" value="<s:property value="applicationFormNumber"/>" readonly="readonly"/>
                  </div>
              	  <div class=" col-sm-offset-2  col-sm-2 col-xs-offset-2 col-xs-4">
              	  	<div>
              	  	<img class="photoAdmission" src="images/avatar.png" alt="process" height="70" width="70"/>
              	  	
              		<input type="button" class="btn btn-xs btn-primary " value="+">
      			
											<input id="admissionUserPic" class="uploadUserPhoto" type="file" name="photo" />
											
									</button>
						</div>	
						
						<div><span id="photoStat"></span></div>	
              	  </div>
              	  
              </div>
          
          <fieldset>
            <legend>Personel Details</legend>
                <div class="form-group">
                    <label for="candidateName" class="control-label col-sm-1">Name:-</label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" id="admissionName" name="name" value="<s:property value="name"/>" readonly="readonly"/>
                    	  <span id="spanName" ></span> 
                    </div> 
                  
                    
                    <label for="gender" class="control-label col-sm-1">Gender:-</label>
                    <div class="col-sm-3">
                    	<!-- <input type="text" class="form-control" id="admissionGender" name="gender" /> -->
                    	<select class="form-control" id="admissionGender" name="gender" >
                            <option selected="selected" value="Male">Male</option>
                            <option value="Female">Female</option>
                            </select>
                    </div> 
                    
                    <label for="dob" class="control-label col-sm-1">DOB:-</label>
                    <div class="col-sm-3">
                    	<input type="date" class="form-control" id="admissionDOB" name="dateOfBirth" />
                    </div>  
                </div>
           
                <div class="form-group">
                    <label for="contact" class="control-label col-sm-1">Contact:-</label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" id="admissionContact" name="contact" value="<s:property value="contact"/>" readonly="readonly"/>
                    </div> 
                    
                    <label for="email" class="control-label col-sm-1">Email:-</label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" id="admissionEmail" name="email" value="<s:property value="email"/>" readonly="readonly"/>
                    </div> 
                </div>
            
            
                <div class="form-group">
                    <label for="fatherName" class="control-label col-sm-1">Father's Name:-</label>
                    <div class="col-sm-4">
                    	<input type="text" class="form-control" id="admissionFatherName" name="fatherName" />
                    	<span id="spanFatherName" ></span> 
                    </div>   
                </div>
            
            
              <div class="form-group">
              <label for="phone" class="control-label col-sm-1">Phone No:-</label>
              <div class="col-sm-3">
              <input type="text" class="form-control" id="admissionPhone" name="phoneNumber" />
              </div>
              
              <label for="Occupation" class="control-label col-sm-2">Occupation:-</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="admissionOccupation" name="occupation" />
                          <span id="spanOccupation" ></span> 
                      </div> 
              </div> 
            

            <div class="form-group">
            <label for="presentAddress" class="control-label col-sm-1">Present's  Address:-</label>
            <div class="col-sm-11">
            <input type="text" class="form-control" id="admissionPresentAddress" name="presentAddress"/>
            <span id="spanPresentAddress" ></span> 
            </div> 
            </div> 
            
 
            <div class="form-group">
            <label for="permanentAddress" class="control-label col-sm-2">Permanent's Address:-</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" id="admissionPermanentAddress" name="permanentAddress" />
            <span id="spanPermanentAddress" ></span> 
            </div>   
            </div>
          </fieldset>
          
          <fieldset>
            <legend>SignUp Details</legend>
            
                <div class="form-group">
                      <label for="uid" class="control-label col-sm-2">UID No:-</label>
                      <div class="col-sm-4">
                          <input type="text" class="form-control" name="uid" id="uid" value="<s:property value="uid"/>"  readonly="readonly" />
                      </div> 
                </div>  
              
              
              <div class="form-group">
              <label for="password" class="control-label col-sm-2">Password:-</label>
              <div class="col-sm-4">
                  <input type="password" class="form-control" id="admissionPassword" name="password" />
                  <span id="spanPassword" ></span>
              </div>  
              
               <label for="fatherName" class="control-label col-sm-2">Confirm Password:-</label>
              <div class="col-sm-3">
                  <input type="password" class="form-control" id="admissionConfirmPassword" name="confirmPassword"/>
                  <span id="spanConfirmPassword" ></span>
              </div>  
              
              </div>
                  
           </fieldset>
           
           <fieldset>
                    <legend>Academic Details</legend>
                <div class="anotherData">
                      
                        <div class=" form-group">
                      <label for="education" class="control-label col-sm-2">Education:-</label>
                      <div class="col-sm-2">
                          <select class="form-control" id="education" name="academicDetails[0].education" >
                          	<option value=""></option>
                            <option selected="selected" value="10th">10th</option>
                            <option value="12th">12th</option>
                            <option value="graduation">Graduation</option>
                            <option value="Post Graduation">Post Graduation</option>
                            <option value="Doctorate">Doctorate</option>
                          
                          </select>
                      </div>  
                      
                       <label for="year" class="control-label col-sm-1">Year:-</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="year" name="academicDetails[0].year" />
                      </div>  
                      
                        <label for="clg" class="control-label col-sm-1">clg/scl:-</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="college" name="academicDetails[0].college" />
                      </div>  
                      
                      </div>
                        
                        
                        <div class=" end btmLine form-group">
                       
                       <label for="board" class="control-label col-sm-2">Board/University:-</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="board" name="academicDetails[0].board"/>
                      </div>  
                      
                       <label for="marks" class="control-label col-sm-1">Marks(%):-</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="marks" name="academicDetails[0].marks"/>
                      </div>  
                      
                      <div class=" col-sm-3">
                          <input type="file" class="attachDocument btn btn-primary" id="documentFileName" name="academicDetails[0].document" />
                      		<span id="spanDocumentFileName" ></span>
                      </div>  
                  
                      </div>
                 </div>
                 <div id="check">
                 </div>
                 
                      
                      <div class="col-sm-offset-10">
                            <h5><a onclick="function"  class="addAnotherDetails" href="#" >Add Another Details</a></h5>
                      
                      </div>
                      
                  </fieldset>
                  
                  <fieldset>
                    <legend>Training details</legend>
                        
                         <div class="form-group">
                            
                             <label for="training" class="control-label col-sm-offset-3 col-sm-3">Training Enrolled:-</label>
                                 <div class="col-sm-3">
                                     <select class="drp form-control " id="training" placeholder="Purpose of Meeting" name="trainingEnrolled">
            							<option selected="selected" value="<s:property value="purpose"/>"><s:property value="purpose"/></option>
            						</select>
                                    </select>
                                </div> 
                             
                           </div>
                  
                  </fieldset>
                  
                 
                    <div class=" line col-sm-12">
                    
                    
                    </div>                          
                  
                  <div class="form-group">
                            
                             <label for="date" class="control-label  col-sm-1">Date:-</label>
                                 <div class="col-sm-3">
                                    <input type="text" id="inputDate" class="form-control" name="date" readonly="readonly"/>
                                </div> 
                             
                  </div>
                  
                    	 <div class="form-group idcardBtn">
                            
                                 <input type="submit" class="btn btn-primary admissionFormButtons" value="Submit"/>   
						</div>
      </form>
    </div>
</div>
        
<!--row 1 end-->        
      
</div>


</body>
</html>




