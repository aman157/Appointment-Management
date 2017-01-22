<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>feeSlip</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/client/feeSubmission.css" />

</head>

<body>
<div class="container-fluid" style="height:100%;width:100%">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">F|E|E|S S|L|I|P</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation"><a href="search?">Search</a></li>
                         <li role="presentation" class="dropdown ss">
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
<div class="col-sm-offset-3 col-sm-6 feeContent">
	<form id="feeSlipSubmit" class="form-horizontal">
    		<h2 class="head">Office Copy</h2>
			<div class="form-group">
				<label for="uid" class="col-sm-1">UID</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="exampleInputUid" readonly="readonly" name="traineeUid" value="<s:property value="uid"/> ">
                </div>

				<label for="date2" class="col-sm-offset-3 col-sm-1">Date</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="exampleInputDate" name="traineeDate" readonly="readonly" value="<s:property value="date"/>" >
				</div>
            </div>

        	<div class="form-group">
				<label for="recieved" class="col-sm-4">Recieved with thanks from</label>
				<div class="col-sm-8">
					<input type="text" class="form-control bottomLine" id="name" name="traineeName" readonly="readonly" value="<s:property value="name"/>">
				</div>
			</div>
            
            <div class="form-group">
				<label for="amount" class="col-sm-3">a sum of rupees</label>
				<div class="col-sm-9">
					<input type="text" class="form-control bottomLine" id="feeWords" readonly="readonly" name="traineeSumOfRupees" value="<s:property value="feeWords"/>">
				</div>
			</div>
			
            
            <div class="row">
            	<div class="col-sm-5">
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox1" class="chkbox" value="cash" > Cash
                  </label>
                  
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox2" class="chkbox" value="Cheque"> Cheque
                  </label>
                  
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox3" class="chkbox" value="DD"> DD
                  </label>
                </div>
                
              	<div class="col-sm-3">
                      <input type="text" class="form-control bottomLine" readonly="readonly" name="traineeDepositType" id="valueForCheckbox" value="" >
              	</div>
                
                <div class="col-sm-4">
                  <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" class="inlineRadio1" id="inlineRadio1" value="oneTime" checked="checked"> One Time
                  </label>
                  <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" class="inlineRadio1" id="inlineRadio2" value="installment"> Installment
                  </label>
              </div>
              
           </div>
              <span id="paymentMode"></span>
          
           
        <div class="form-group">
			
				<div class="col-sm-9">
					
				</div>
		</div>
        
        <div class="row amount">
        	<div class="col-sm-4">
				<input type="text" class="form-control" id="enterFee" name="traineeSumOfFigure" readonly="readonly" value="<s:property value="enterFee"/>">
			</div>
            
            <div class="col-sm-offset-2 col-sm-6">
            	<h6>Authorized Signatory</h6>
            </div>
        </div>
        
        
<!--trainee copy-->

        <h2 class="head">Trainee Copy</h2>
			<div class="form-group">
				<label for="uid" class="col-sm-1">UID</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="exampleInputUid" readonly="readonly" "uid" value="<s:property value="uid"/> ">
                </div>

				<label for="date2" class="col-sm-offset-3 col-sm-1">Date</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="exampleInputDate" readonly="readonly" value="<s:property value="date"/>" >
				</div>
            </div>

        	<div class="form-group">
				<label for="recieved" class="col-sm-4">Recieved with thanks from</label>
				<div class="col-sm-8">
					<input type="text" class="form-control bottomLine" name="name" readonly="readonly" value="<s:property value="name"/>">
				</div>
			</div>
            
            <div class="form-group">
				<label for="amount" class="col-sm-3">a sum of rupees</label>
				<div class="col-sm-9">
					<input type="text" class="form-control bottomLine" id="feeWordss" readonly="readonly" name="feeWords" value="<s:property value="feeWords"/>">
				</div>
			</div>
			
            
            <div class="row">
            	<div class="col-sm-5">
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox11" class="chkbox" value="cash" readonly="readonly"> Cash
                  </label>
                  
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox22" class="chkbox" value="Cheque" readonly="readonly"> Cheque
                  </label>
                  
                  <label class="checkbox-inline">
                      <input type="checkbox" id="inlineCheckbox33" class="chkbox" value="DD" readonly="readonly"> DD
                  </label>
                </div>
              	<div class="col-sm-3">
                      <input type="text" class="form-control bottomLine" readonly="readonly" id="valueForCheckbox1" value="" >
              	</div>
                
                <div class="col-sm-4">
                  <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptionss" class="inlineRadio11" id="inlineRadio11" value="oneTime" checked="checked" readonly="readonly"> One Time
                  </label>
                  <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptionss" class="inlineRadio11" id="inlineRadio22" value="installment" readonly="readonly"> Installment
                  </label>
              </div>
           </div>
          
           
        <div class="form-group">
			
				<div class="col-sm-9">
					
				</div>
		</div>
        
        <div class="row amount">
        	<div class="col-sm-4">
				<input type="text" class="form-control" id="enterFeee" name="enterFee" readonly="readonly" value="<s:property value="enterFee"/>">
			</div>
            
            <div class="col-sm-offset-2 col-sm-6">
            	<h6>Authorized Signatory</h6>
            </div>
        </div>
        
 <!--trainee copy-->

	</form>

</div>

<div class="row">
 		
      <div class=" btnPrint">
		<input type="button" class="btn btn-primary printFee" value="Print"/>
		<input type="button" class="btn btn-primary saveFees" value="SAVE"/>
		<span id="fessStat"></span>
	</div>
</div>
      


<!--content row -->
 
</div>
<!--jquerry-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<script src="js/validation.js"></script>
<!--jquery end-->
</body>
</html>

