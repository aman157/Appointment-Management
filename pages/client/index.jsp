<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.css" />
<link rel="stylesheet" type="text/css" href="css/client/index.css" />


<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<script src="js/validation.js"></script>
<script src="js/custom.js"></script>
<script src="js/ajax.js"></script>
<!--jquery end-->
</head>

<body>



<div class="container-fluid">
<!--row 1-->	
    <div class="row header">
    	
        <nav class="navbar navbar-default navbar-inverse headerNav" role="navigation">
            <div class="navbar-header col-sm-9">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
             </div>
             <div class="collapse navbar-collapse" id="collapse">
                <ul class=" nav navbar-nav navigation ">
                    <li class="active"><a href="#"><span class="gly glyphicon glyphicon-home"></span> Home</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="gly glyphicon glyphicon-log-in"></span> LOGIN</a></li>
                </ul>  
            </div>
        </nav>
      
    </div>
<!--row 1 end-->


<!-- row 2-->
    	<div class="row">
            <div id="meetingSlip" class="meetingSlip">
           
                    <div class="meetingForm col-sm-offset-2 col-sm-8">
                        <div class="head">
                        <h1>Meeting Form</h1>
                        </div> 
                            
          <form name="meetingSlipEntryModal" id="meetingSlipEntryModal" action="meetingSlipEntries" method="post" class="form-horizontal col-sm-offset-1 ">

            
            <div class="form-group">
             <div class="col-sm-10">
             <input type="text" class=" form-control" id="inputName" name="name" placeholder="Enter Your Name" >
             	<span id="glyphiconName" class="form-control-feedback" aria-hidden="true"></span>	
             </div>
             <span id="inputNameSuccess" class="sr-only"></span>
           </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control " id="inputContact" name="contact" placeholder="Contact Number">
            <span id="glyphiconContact" class="form-control-feedback" aria-hidden="true"></span>
            </div>
				<span id="inputContactSuccess" class="sr-only"></span>
            </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control" id="inputEmail" name="email" placeholder="E-mail">
            <span id="glyphiconEmail" class="form-control-feedback" aria-hidden="true"></span>
            </div>
            <span id="inputEmailSuccess" class="sr-only"></span>
            </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control" id="inputCollage" name="college" placeholder="Collage/Organization">
            <span id="glyphiconCollege" class="form-control-feedback" aria-hidden="true"></span>
            </div>
            <span id="inputCollegeSuccess" class="sr-only"></span>
            </div>
            
            <fieldset>
             <legend>Purpose of meeting:-</legend>
            <div class="form-group">
            <div class="col-xs-6 col-sm-6">
            <select class="drp form-control " id="training" placeholder="Purpose of Meeting" name="purpose">
            <option value=""></option>
            <option value="Any Other">Any Other</option>
            </select>
             
             
            </div>
            <div class="col-sm-4"><input type="text" class="form-control " id="inputAnyOther" name="anyOther" placeholder="Any Other"></div>
            <span id="inputTrainingSuccess" class="sr-only"></span>
            </div>
            </fieldset>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control  col-sm-2" id="inputReference" name="reference" placeholder="Reference">
            <span id="glyphiconReference" class="form-control-feedback" aria-hidden="true"></span>
            </div>
            <span id="inputReferenceSuccess" class="sr-only"></span>
            </div>

            <div class="form-group">
            <div class="col-sm-5"><input type="text" class="form-control " id="inputDate"  name="date" readonly="readonly" ></div>
            </div>
            <input id="meetingsSlipSubmit" class="btn btn-primary col-sm-offset-5 submitBtn" type="submit" value="Submit" ></input>
         </form>
           
            </div>
          </div>
        </div>


<!-- row 2 end-->

<!--row 3 -->
	<div class="row footer">
    	<h3>Metazone Infotech Pvt Ltd</h3>
    </div>

<!--row 3 end-->

<!-- Modal for forget password-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog" role="document">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close clor" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title" id="myModalLabel">Metazone Login</h4>
    </div>
    <div class="modal-body">
    
      <div class="row">
          <img src="images/mzLogo.png" class="loginLogo img-responsive"/>
      
      </div>
    
      <div class="row modalRow adminemployeeBtn">
          <input type="button" id="adminBtn" class=" common btn btn-default active" value="Admin"/>
          <input type="button"  id="employeeBtn" class="common btn btn-default"  value="Trainee"/>
      </div>
      
      <div id="admin" class="row formRow">
          <form id="loginFormAdmin" action="loginAdmin" method="post" class="form-horizontal">
              <div class="form-group">
                <label for="userName" class="col-sm-offset-2 col-sm-2">UserName</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control adminEmail" id="email" name="email" placeholder="Enter your active Email Id" />
                </div>
              </div>
              
             <div class="form-group">
                <label for="password" class="col-sm-offset-2 col-sm-2">Password</label>
                <div class="col-sm-6">
                  <input type="password" class="form-control adminPassword " id="password" name="password" placeholder="Enter your Password" />
                </div>
              </div>
          </form>
      </div>
      
        <div id="employee" class="row formRow">
          <form id="loginFormEmployee" action="loginTrainee" method="post" class="form-horizontal">
              <div class="form-group">
                <label for="enrolledId" class="col-sm-offset-2 col-sm-2">EnrolledId</label>
                <div class="col-sm-6">
                  <input type="number" class="form-control" id="uid" name="uid" placeholder="Enter your Enrolled Id" />
                </div>
              </div>
              
             <div class="form-group">
                <label for="password" class="col-sm-offset-2 col-sm-2">Password</label>
                <div class="col-sm-6">
                  <input type="password" class="form-control" id="passwordTrainee" name="password" placeholder="Enter your Password" />
                </div>
              </div>
              
          </form>
      </div>
      
      <div class="row">
      
      	 <p class="col-sm-offset-4 col-sm-4" id="errorMessage"></p>
          <div class="col-sm-4">
              <p><a href="#" id="forgetPassword" >Forget Password??</a></p>
          </div>
      </div>
      
      
      <div class="row">
          <input type="button" class="col-sm-offset-5 btn btn-primary input-lg" id="login" onclick='mySubmit()' value="LOGIN" />
      </div>
      
    </div>
    <div class="modal-footer modalFooter">
      <p>Metazone Infotech Pvt Ltd</p>
    </div>
  </div>
</div>
</div>
<!--modal end-->


<!-- Modal -->
<div class="modal fade" id="modalForgetPassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog" role="document">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close clor" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title" id="myModalLabel">Metazone Password recovery Mail</h4>
    </div>
    <div class="modal-body">
    
      <div class="row">
          <img src="images/mzLogo.png" class="loginLogo img-responsive" style="height:100px;"/>
      
      </div>
   <!--  
      <div class="row modalRow adminemployeeBtn">
          <input type="button" id="adminBtn" class=" common btn btn-default active" value="Admin"/>
          <input type="button"  id="employeeBtn" class="common btn btn-default"  value="Trainee"/>
      </div>
      
      <div id="admin" class="row formRow">
      
      </div> -->
      
        <div id="employee" class="row formRow">
        <form id="forgetPasswordForm">
        	<div class="form-group">
        	<div class="col-sm-offset-3 col-sm-6">
        			<input type="text" id="forgetMailToSend" class="form-control"/>
        			<span id="glyphiconForgetPassword" class="form-control-feedback" aria-hidden="true"></span>
        	</div>
        	</div>
        </form>
 
      </div>
      
      <div class="row">
      <span id="ForgetPasswordStat" class="" ></span>
      
      </div>
      
      <div class="row">
          <input type="button" id="SendRecoveryPasswordMail" class="col-sm-offset-5 btn btn-primary input-sm"  value="SendMail" />
      </div>
      
    </div>
    <div class="modal-footer modalFooter">
      <p>Metazone Infotech Pvt Ltd</p>
    </div>
  </div>
</div>
</div>
<!--modal for forget password end-->


</div>



</body>
</html>
