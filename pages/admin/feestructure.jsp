<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>feeStructure</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/admin/feeStructure.css" />

</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">F|E|E S|T|R|U|C|T|U|R|E</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation"><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown ">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
     						 Employee <span class="caret"></span></a>
                             <ul class="dropdown-menu">
                              	<li role="presentation"><a href="addEmployee?">Add Employee</a></li>
                                <li role="presentation"><a href="viewEmployee?">View Employee</a></li>
                            </ul>
                          </li>
                        <li role="presentation" class="active"><a href="feestructure?">Fee Structure</a></li>
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

<div class="row contentFee">
  <div class=" col-sm-offset-1 col-sm-10">
  	<form id="addTrainingStructure" action="addingFeeStructure" method="post">
    <table class="table table-condensed" id="tab_logic">
    	<th>Serial No.</th>
      <th>Training</th>
      <th>Fee</th>
      <th>Duration In Months</th>
      <s:iterator value="feeStructureList" status="mystat" var="arr">
      <tr id="addr0">
      	<td><input type="text" value="<s:property value="%{#mystat.index+1}" />" name="feeStructure[<s:property value="%{#mystat.index+1}" />].serialId" class="textBoxFee form-control serialNumber" readonly="readonly" /></td>

        <td><input type="text" value="<s:property value="%{#arr.enterTraining}" />" class="textBoxFee form-control enterTraining" placeholder="Enter training" name="feeStructure[<s:property value="%{#mystat.index+1}" />].enterTraining" readonly="readonly"/></td>
        <td><input type="text" value="<s:property value="%{#arr.enterFee}" />" class="textBoxFee form-control enterFee" placeholder="Enter Fess" readonly="readonly" name="feeStructure[<s:property value="%{#mystat.index+1}" />].enterFee"/></td>
        <td><input type="text" value="<s:property value="%{#arr.enterDuration}" />" class="textBoxFee form-control enterDuration" placeholder="Enter Duration" readonly="readonly" name="feeStructure[<s:property value="%{#mystat.index+1}" />].enterDuration"/></td>
       	<td ><input id="<s:property value="%{#mystat.index+1}" />" type="button" class="form-control btn btn-primary trainingEdit" value="Edit" name="<s:property value="%{#arr.enterTraining}" />"/></td>
       	
       	<td><input type="checkbox" class="form-control chkboxBtn" name="checkBox0"/></td>
       	
        <td ><input id="<s:property value="%{#mystat.index+1}" />" type="button" class="form-control btn btn-primary trainingDelete" value="Delete" disabled="disabled" name="<s:property value="%{#arr.enterTraining}" />"/></td>

      </tr>
      </s:iterator>
      
      <tr id="addr1"></tr>
      

    </table>
    </form>
  </div>
</div>


<div class="row">
  <div class="col-sm-offset-10">
  	<h4><a id="add_row" href="#">Add Another</a></h4>
  </div>
</div>

<div class="row">
  <div class="saveBtnFee col-sm-offset-5">
    <input type="button" class="btn btn-primary col-sm-2 saveFeeStructure" value="Add" />
  </div>
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


