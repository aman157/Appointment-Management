<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>addEmployee</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/admin/addEmployee.css" />

</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">A|D|D E|M|P|L|O|Y|E|E</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
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
                             	<li role="presentation"><a href="addMetingSlip?">Add Meeting Slip</a></li>
                              	<li role="presentation"><a href="logout?">Logout</a></li>
                            </ul>
                          </li>
                    </ul>
                </div>
    	
    </div>

<!--row 2 end-->

<!-- content row -->
<div class="row contentAddEmployee">
  <form class="form-horizontal" id="employeeInfo" action="addingEmployee" method="post" enctype="multipart/form-data" >
      <div class="col-sm-offset-2 col-sm-6">
      
       
          <div class="form-group">
              <div class="col-sm-4">
              <input type="text" class="col-sm-6  form-control inputAddEmployee " id="employeeName" name="name" placeholder="Employee Name"  >
             	<span id="spanEmployeeName"></span>
              </div>
              
              <div class="col-sm-6 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeEmail" name="email" placeholder="Email Id" >
              <span id="spanEmployeeEmail"></span>
              </div>
          </div>
          
          <div class="form-group">
              <div class=" col-sm-4 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeContact" name="contact" placeholder="Contact Number">
              <span id="spanEmployeeContact"></span>
              </div>
              
              <div class="col-sm-6 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeQualification" name="qualification" placeholder="Qualification(highest)" >
              <span id="spanEmployeeQualification"></span>
              </div>
          </div>
          
          
          <div class="form-group">
              <div class="col-sm-4 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeSpecialization" name="specialization" placeholder="Specialization Language" >
              <span id="spanEmployeeSpecialization"></span>
              </div>
              
              <div class="col-sm-6 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeDepartment" name="department" placeholder="Department">
              <span id="spanEmployeeDepartment"></span>
              </div>
          </div>
          
          <div class="form-group">
              <div class=" col-sm-10 ">
              <input type="text" class="form-control inputAddEmployee" id="employeeAddress" name="address" placeholder="Address" >
              <span id="spanEmployeeAddress"></span>
              </div>
          </div>
          
          <div class="addBtn">
          	<button type="submit" class="btn btn-primary btn-lg addButton">Add</button>
          </div>
          <div class="col-sm-offset-5 status">
          	<p><s:property value="status"/></p>
          </div>
      </div>
      
      <div class="col-sm-2 picDiv">
      	 <div class="form-group">
              <div class=" col-sm-12" id="employeePic">
              	
              </div>
              <input class="uploadEmployeePhoto" type="file"  name="employeePhoto">
              <span id="spanEmployeePic"></span>
          </div>
      
      </div>
  </form>
</div>
<!--content row End-->





    
 
</div>
<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/validation.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->
</body>
</html>

