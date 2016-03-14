<!DOCTYPE html>
<head>
	<title>Register Page</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	
	include 'database_info.php';
	$collection = $dbname->selectCollection('test_users');
	
	$userPass = password_hash($_POST['reg_pass'], PASSWORD_DEFAULT);
	if($_POST['reg_email'] != $_POST['reg_confemail'])	{
		$heading = "Failure Bro!";
		$display = "Error, emails do not match";
		$href = "register.html";
	}
	else {
		$alreadyReg = $collection->findOne(array('email' => $_POST['reg_email']));
		if($alreadyReg!=null)	{
			$heading = "Failure Bro!";
			$display = "That email is already in use!";
			$href = "register.html";
		}
		else	{
			$post = array (
				'email' => $_POST['reg_email'],
				'pass' => $userPass
			);
			$collection->insert($post);
			$heading = "SUCCESS BRO!";
			$display = "You are now registered.";
			$href = "index.php";
		}
	}
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;"><?php echo $heading;?></h1>
			<p><?php echo $display;?></p>
			<a href=<?php echo $href;?>>Return</a>
		</div>
	</body>
</html>