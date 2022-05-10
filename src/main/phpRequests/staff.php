<?php
// database connection code
//$con = mysqli_connect('localhost', 'database_user', 'database_password','database');

$con = mysqli_connect('localhost', 'root', '','3Ogotc@qNV7Q', 'uni-system-industry-project');

// get the post records
$firstName = $_POST['firstName'];
$lastName = $_POST['lastName']
$staffEmail = $_POST['staffEmail'];
$contactNumber = $_POST['contactNumber'];
$gender = $_POST['gender'];
$address= $_POST['address'];
$departmentId = $_POST['departmentId']

// database insert SQL code
$sql = "INSERT INTO `staff` ('firstName`, `lastName`, `contactNumber`, `staffEmail`, `gender`, `address`, `departmentId`) VALUES (, '$firstName', '$lastName', '$contactNumber', '$staffEmail', '$gender', '$address', '$departmentId')";

// insert in database
$rs = mysqli_query($con, $sql);

if($rs)
{
	echo "Contact Records Inserted";
}

?>