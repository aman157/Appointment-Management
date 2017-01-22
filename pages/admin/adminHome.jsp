<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>adminHome</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link type="text/css" href="css/bootstrap-timepicker.min.css" />

<link type="text/css" href="css/bootstrap-datetimepicker.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" href="css/normalize.css">



<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 <script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
 <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/custom.js"></script>
<script src="js/ajax.js"></script>

<!--jquery end-->

</head>

<body>

<div class="container-fluid">

<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">A|D|M|I|N P|A|N|E|L</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation"><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown">
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

<!-- row 3 -->
	<div class="row tableRow">
    		
            <div class="  col-sm-12">
            		<table class="table table-bordered tableShades">
                     	<tr>
                     		<th>S.no</th>
                        	<th>Uid</th>
                            <th>Name</th>
                            <th>Contact</th>
                            <th>Email</th>
                            <th>Clg</th>
                            <th>Purpose</th>
                            <th>Any Other</th>
                            <th>Reference</th>
                            <th>Date</th>
                            <th colspan="5">Status</th>
                           
                        </tr>
                        <s:iterator value="arrayList" status="mystat" var="arr">
                        <tr>
                        	<td><s:property value="%{#mystat.index+1}" /></td>
                        	<td><s:property value="%{#arr.uid}" /></td>
                        	<td><s:property value="%{#arr.name}" /></td>
                        	<td><s:property value="%{#arr.contact}" /></td>
                        	<td><s:property value="%{#arr.email}" /></td>
                        	<td><s:property value="%{#arr.college}" /></td>
                        	<td><s:property value="%{#arr.purpose}" /></td>
                        	<td><s:property value="%{#arr.anyOther}" /></td>
                        	<td><s:property value="%{#arr.reference}" /></td>
                        	<td><s:property value="%{#arr.date}" /></td>
                        	<s:set var="emailStatus" value="%{#arr.emailStatus}" />
                      		<s:set var="enrolledStatus" value="%{#arr.enrolledStatus}" />
                      		<s:set var="profileMeter" value="%{#arr.profileMeter}" />
                     
                       		<s:if test="%{#emailStatus.equals('true')}">
                       			<td >Demo<a href="#" id="idcardDailog" onClick="idCardDailogFunction(<s:property value="%{#arr.uid}"/>)"><span id="gly" class="glyphicon glyphicon-ok"></span></a></td>
						 	</s:if>
						 	
							<s:else>
								<td class="blueDemo">Demo<a href="#" id="idcardDailog" onClick="idCardDailogFunction(<s:property value="%{#arr.uid}"/>)"><span id="gly" class="glyphicon glyphicon-remove"></span></a></td>
							</s:else>
							
							<s:if test="%{enrolledStatus==null}">
								<td><a href="fromAdminEnrolledDetailView?uidForEnrolled=<s:property value="%{#arr.uid}"/>" class="enrolledView"  >Enrolled</a><span class="glyphicon glyphicon-remove"></span></td>
                       			<td><span id="gly" class="glyphicon glyphicon-usd"></span></td>
                       		</s:if>
                       		
                       		<s:else>
                       			<td><a href="" class="enrolledView cssEnrolledOk"  >Enrolled</a><a href="enrolledDetailView?uidForEnrolled=<s:property value="%{#arr.uid}"/>" ><span class="glyphicon glyphicon-ok"></span></a></td>
                        		<td><a href="fromAdminFeeSLip?uidForEnrolled=<s:property value="%{#arr.uid}"/>"><span id="gly" class="glyphicon glyphicon-usd"></span> </a></td>
                        	</s:else>
                        	
                        	
                        	
                        	<s:if test="%{profileMeter==null}">
                        	<td><div class="avatar-container p-<s:property value="%{#arr.profileMeter}" />">
											<h6 class="info info-inner ">NE</h6>
											</div></td>
							</s:if>
							<s:else>
							<td><div class="avatar-container p-<s:property value="%{#arr.profileMeter}" />">
											<h6 class="info info-inner "><s:property value="%{#arr.profileMeter}" />%</h6>
											</div></td>
							</s:else>
							<td><a href="fromAdminEnrolledDetailViewDelete?uidForEnrolled=<s:property value="%{#arr.uid}"/>"><span id="gly" class="glyphicon glyphicon-trash"></span> </a></td>
                        </tr>
                        
                        
                        
                        
                        </s:iterator>
                        

                    </table>
            
            
            
            
            </div>
    </div>
<!--row 3 end-->

<!--modal box -->
	<div name=modalIdcard class="modal fade" id="idCard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
  			<div class="modal-content">
            	<div class="modal-header">
     <button type="button" class="close clor" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    </div>
            		<div class="row idCardDemoHeader">
                      <div class="col-sm-3">
                          <img src="images/mzLogo.png" class="img-responsive">
                      </div>
                        <div class="col-sm-8">
                            <h3>Metazone Infotech Pvt. Ltd</h3>
                            <div class="purposeIdCard">
                                <h4>TRAINEE ID CARD</h4>
                              </div>
                        </div>  
                 </div>
                 
                <div class="row">
                  <form class="form-horizontal">
                      <div class="form-group">
                          <label for="inputUid" class="col-sm-2 control-label">UID No:-</label>
                              <div class="col-sm-5">
                                <input type="text" name="uid" id="uid" class="form-control"  placeholder="UID No" value="" disabled="disabled">
                              </div>
                      </div>
                      
                      <div class="form-group">
                          <label for="inputName" class="col-sm-2 control-label">Name:-</label>
                              <div class="col-sm-5">
                                <input type="text" class="form-control" id="name" placeholder="Name" value="" disabled="disabled">
                              </div>
                      </div>
                      
                       <div class="form-group">
                          <label for="inputContact" class="col-sm-2 control-label">Contact:-</label>
                              <div class="col-sm-4">
                                	<input type="text" class="form-control" id="contact" placeholder="Contact" value="" disabled="disabled">
                              </div>
                              
                           <label for="inputTiming" class="col-sm-2 control-label">Timing:-</label>
                            <div class="col-sm-3  bootstrap-timepicker timepicker pull-left" >
                                	<input type="text" class="form-control input-small timepicker3" name="timing" id="timing" >
                      
                              </div>
                      </div>
                      
                      
                       <div class="form-group">
                          <label for="inputTrainer" class="col-sm-2 control-label">Trainer:-</label>
                              <div class="col-sm-4">
                              	<div id="drp">
                              	
                              	</div>
                                	
                              </div>
                              
                           <label for="inputTraining" class="col-sm-2 control-label">Training:-</label>
                            <div class="col-sm-3">
                                	<select class="drp form-control "  id="training" placeholder="Purpose of Meeting"  name="purpose" >
            						
            						</select>
                              </div>
                      </div>
                      
                      
                      <div class="form-group">
                      	<label for="inputDemoDate" class="col-sm-2 control-label">Demo's Dates </label>
                        	<div class="col-sm-3">
                             <input type="date"  class="form-control" name="demoDate1" id="demoDate1"  />
                            	
                            </div>
                            
                            <div class="col-sm-3">
                            	<input type="date" class="form-control" name="demoDate2" id="demoDate2"  />
                            </div>
                            
                            <div class="col-sm-3">
                            	<input type="date" class="form-control" name="demoDate3" id="demoDate3"  />
                            </div>
                      
                      </div>
                  </form> 
             	</div>    
                
                <div class="row idcardBtn">
                
                
                	<input type="button" id="idCardPdf" class="btn btn-primary" value="PDF" />
                	<input type="button" class="btn btn-primary" id="sendBtn" value="Send" />
                	<p id="mailStatus"></p>
                
                </div>              
              </div>
  			</div>
		</div>
</div>


<!--modal box end-->  

           
      
        
</div>       
 
</div>



</body>
</html>
