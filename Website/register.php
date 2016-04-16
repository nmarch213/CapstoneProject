<!DOCTYPE html>
<head>
	<title>Register Page</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	
	include 'database_info.php';
	$collection = $dbname->selectCollection('users');
	
	$userPass = password_hash($_POST['reg_pass'], PASSWORD_DEFAULT);
	//Super jury-rigged but it gets the job done and replaces the incompatible $2y with the app-compatible $2a.
	$userPass = substr_replace($userPass, '$2a', 0, -(strlen($userPass)-3));
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
				'firstName' => $_POST['reg_fname'],
				'lastName' => $_POST['reg_lname'],
				'email' => $_POST['reg_email'],
				'password' => $userPass,
				'username' => $_POST['reg_usernm'],
				'official_user' => $_POST['official_user']
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