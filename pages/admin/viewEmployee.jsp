<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>viewEmployee</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/admin/viewEmployee.css" />

</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">V|I|E|W  E|M|P|L|O|Y|E|E</h3>
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
	<div class="row content">
    		
            <div class=" col-sm-12">
            		<table class="table table-bordered">
                     	<tr>
                        	<th>Emp Id</th>
                            <th>Name</th>
                            <th>Contact</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Qualification</th>
                            <th>Department</th>
                            <th>Spcialization</th>
                            <th>photo</th>
                        </tr>
                        
                        <s:iterator value="arraylist" status="mystat" var="arr">
                            <tr>
                            	
                            	<td><input type="text" id="uid" class="form-control" value="<s:property value="%{#arr.uid}" />" readonly="readonly"></input></td>
                            	<td><input type="text" id="name" class="form-control updateEmployee" value="<s:property value="%{#arr.name}" />" readonly="readonly"></input></td>
                            	<td><input type="text" id="contact" class="form-control updateEmployee" value="<s:property value="%{#arr.contact}"/>" readonly="readonly"></input></td>
                            	<td><input type="text" id="email" class="form-control updateEmployee" value="<s:property value="%{#arr.email}" />" readonly="readonly"></input></td>
                            	<td><textarea id="address" name="yourtextarea" style="width:100px;height:80px;resize:none;" readonly="readonly"><s:property value="%{#arr.address}" /></textarea></td>
                            	<%-- <td><input type="text" class="form-control" value="<s:property value="%{#arr.address}"/>" ></input></td> --%>
                            	<td><input type="text" id="qualification" class="form-control updateEmployee" value="<s:property value="%{#arr.qualification}" />" readonly="readonly"></input></td>
                            	<td><input type="text" id="department" class="form-control updateEmployee" value="<s:property value="%{#arr.department}" />" readonly="readonly"></input></td>
                            	<td><input type="text" id="specialization" class="form-control updateEmployee" value="<s:property value="%{#arr.specialization}" />" readonly="readonly"></input></td>
                            	<td class="text-center"><img id="employeeUpdatePic" src="../MeetingSlip/images/employee/<s:property value="%{#arr.employeePhotoFileName}" />" alt="process" height="70" width="70"></td>
                           		<td><input type="file" id="employeeUpdate" name="employeePhoto" style="width:95px;" disabled="disabled"></input></td>
                           		<td><input id="<s:property value="%{#arr.uid}" />" type="submit" class="btn btn-primary editEmployeeDetails" value="edit" /></td>

 								
                           		<form action="deleteEmployeeDetails.action?uidForEmployee=<s:property value="%{#arr.uid}" />" method="post">
                           		<td><input type="submit" id="delete" class="btn btn-primary" value="delete" disabled="disabled"/></td>
                           		</form>
                            </tr>
                            </s:iterator>
                    </table>
                    
            
            
            
            
            </div>
    </div>
    <!--content row End-->





    
 
</div>
<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<!--jquery end-->
</body>
</html>

