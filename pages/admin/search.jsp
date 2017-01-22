<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>search</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/admin/adminHome.css" />

<link rel="stylesheet" type="text/css" href="css/admin/search.css" />

</head>

<body>
<div class="container-fluid">
<!--row 1-->
	<div class=" row administrationHeader ">
    	<h3 class="col-sm-offset-1">S|E|A|R|C|H</h3>
    </div>
    
<!-- row 1 end-->

<!--row 2-->
	<div class="row adminNavHeader">
            	<div class="col-sm-offset-7 adminNav">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="adminHome?">Adminstration</a></li>
                        <li role="presentation" class="active"><a href="search?">Search</a></li>
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

<!--row 3-->

<div class="contentSearch col-xs-12 col-sm-12">
			
            <div class="col-xs-6 col-sm-6">

			<form  class="form-horizontal col-sm-offset-2" action="searchForm" method="post">

				<div class="form-group">
                <div class="col-sm-5"><input type="text" class="form-control " name="uid"  placeholder="Unique Indentity Number"></div>
                <div class="col-sm-5"><input type="text" class="form-control " name="name" placeholder="Enter Your Name"></div>
               </div>


                <div class="form-group">
                <div class="col-sm-4"><input type="text" class="form-control "  name="contact" placeholder="Contact Number"></div>
                 <div class="col-sm-6"><input type="text" class="form-control " name="email" id="inputEmail" placeholder="E-mail"></div>
                </div>


                <div class="form-group">
                <div class="col-sm-10"><input type="text" class="form-control " name="college" id="inputCollage" placeholder="Collage/Organization"></div>
                </div>

                <div class="form-group">
                <div class="col-xs-6 col-sm-6">
                <select id="training" class="drp form-control " placeholder="Purpose of Meeting" name="purpose">
                <option value=""></option>
            </select>
                </div>
                <div class="col-sm-4"><input type="text" class="form-control" name="anyOther" placeholder="Any Other"></div>
                </div>

                <div class="form-group">
                <div class="col-sm-10"><input type="text" class="form-control col-sm-2" name="reference" placeholder="Reference"></div>
                </div>

                <div class="form-group">
                <div class="col-sm-5"><input type="text" class="form-control " name="date" placeholder="Date"></div>
                 <div class="col-sm-5"><input type="text" class="form-control" name="between" placeholder="Between"></div>
                </div>
                
                <div class="form-group">
                <div class="col-sm-10"><input type="text" class="form-control " name="education" placeholder="Education"></div>
                </div>
                
                <div class="form-group">
                <div class="col-sm-5"><input type="text" class="form-control " name="enrolledDate" placeholder="Enrolled Date"></div>
                <div class="col-sm-5"><input type="text" class="form-control " name="dueMonth" placeholder="Due Month"></div>
                </div>
                
                <input class="btn btn-primary col-sm-offset-6" type="submit" value="Search">
             </form>
             
             
		</div>
        
        <div class="col-sm-6 opacity">
        
        	<img src="images/search.png" class=" searchImage img-responsive" alt="Responsive image">
        
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
