<!DOCTYPE html>
<head>
	<title>Login Page</title>
	<label>Login</label>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	$url = 'http://104.197.124.0:8081/api/user';
	$email = $_POST['login_email'];
	$password = $_POST['login_pass'];

	// //Initiate cURL.
	// $ch = curl_init($url);

	// $jsonData = array(
	// 	'email' => 'email',
	// 	'password' => 'password'
	// 	);
	// //encode in json
	// $jsonDataEncoded = json_encode($jsonData);

	// //tell the cURL that we want a post request
	// curl_setopt($ch, CURLOPT_POST, 1);

	// //attach our encoded JSON string
	// curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonDataEncoded);

	// //Set the content type to application/json
	// curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json;charset=UTF-8')); 
 
	// //Execute the request
	// $result = curl_exec($ch);
		if(!isset($_SESSION)){
		session_start();
	}

	if($email == 'test')	{
		$_SESSION["logged_in"] = true;
		$_SESSION["official"] = 1;
		$heading = "SUCCESS BRO!";
		$display = "Thank you for logging in ";
		$href = "index.php";
	}
	else	{
		$heading = "Failure Bro!";
		//$emailCheck = $collection->findOne(array('email' => $email));
		// if($emailCheck!=null)	{
		// 	$display = "Incorrect password!";
		// }
		// else	{
		// 	$display = "Error, no such user found.";
		// }
		$href = "login.html";
	}	
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;"><?php echo $heading;?></h1>
			<p><?php echo $display;?></p>
			<a href="<?php echo $href ?>">Return</a>
		</div>
	</body>	
</html>
