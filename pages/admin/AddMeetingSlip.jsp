<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AddMeetingSlip</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/client/index.css" />

</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">M|E|E|T|I|N|G S|L|I|P</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation" ><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
     						 Employee <span class="caret"></span></a>
                             <ul class="dropdown-menu">
                              	<li role="presentation"><a href="addEmployee?">Add Employee</a></li>
                                <li role="presentation"><a href="viewEmployee?">View Employee</a></li>
                            </ul>
                          </li>
                        <li role="presentation"><a href="feestructure?">Fee Structure</a></li>
                        <li role="presentation" class="dropdown active">
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

<!--row 2 end-->

<!--row 3-->
 	<div class="row">
            <div id="meetingSlip" class="meetingSlip">
           
                    <div class="meetingForm col-sm-offset-2 col-sm-8">
                        <div class="head">
                        <h1>Meeting Form</h1>
                        </div> 
                            
          <form name="meetingSlipEntryModal" id="meetingSlipEntryModal" action="meetingSlipEntriesbyAdmin" method="post" class="form-horizontal col-sm-offset-2 ">

            
            <div class="form-group">
             <div class="col-sm-10"><input type="text" class="form-control" id="inputName" name="name" placeholder="Enter Your Name"></div>
           </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control " id="inputContact" name="contact" placeholder="Contact Number"></div>
            </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control" id="inputEmail" name="email" placeholder="E-mail"></div>
            </div>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control" id="inputCollage" name="college" placeholder="Collage/Organization"></div>
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
            </div>
            </fieldset>

            <div class="form-group">
            <div class="col-sm-10"><input type="text" class="form-control  col-sm-2" id="inputCollage" name="reference" placeholder="Reference"></div>
            </div>

            <div class="form-group">
            <div class="col-sm-5"><input type="text" class="form-control " id="inputCollage" name="date" placeholder="Date"></div>
            </div>
            <!-- <button type="button" class="btn btn-primary col-sm-offset-5 submitBtn" onclick="loadDoc()">Submit</button> -->
            <input  class="btn btn-primary col-sm-offset-5 submitBtn" type="submit" value="Submit" ></input>
         </form>
           
                    </div>
                    </div>
        </div>
<!-- row 3 end-->

 
</div>
<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->
</body>
</html>
