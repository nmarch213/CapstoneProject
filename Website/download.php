<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Download</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="style.css" rel="stylesheet">
	</head>
	<header>
		<?php
			session_start();
			$page = "download";
			$show = 0;
			if(isset($_SESSION['logged_in'])){
				$show = $_SESSION['logged_in'];
			}	
			include 'header.php';
		?>
	</header>
	<body>
		<center>		
		<div class="container">
			<br>
			<img src="images/download-banner.png" width="80%"><br>
			<a href="http://www.freepik.com/free-photos-vectors/banner" style="font-size:8px;">Banner vector designed by Freepik</a>
			<hr/>
			<h2 style="text-align:left;">Overview</h2>
			<h4 style="text-align:left;">Get the app that helps you enjoy Intramurals on game day, even when your game day is a work day.</h4>
			<ul style="text-align:left;">
				<h4><li>Get up-to-date stats on the matches you care most about.</li></h4>
				<h4><li>Keep track of favorite and promising teams.</li></h4>
				<h4><li>See what the officials have to say about the match with our comment notification system.</li></h4>
				<h4><li>Chat with other fans about the action.</li></h4>
			</ul>
			<iframe name="votar" style="display:none;"></iframe>
			<div class="row">
				<div class="col-md-6">
					<h1>Get the App <a href=""><img src="images/android_badge.png" height="20%" width="40%"></a></h1>
				</div>
				<iframe name="votar" style="display:none;"></iframe>
				<div class="col-md-6">					
				</div>
			</div>
			<div class="row">
				<div class="col-md-3" style="text-align: center; padding-left: 5%;">
					<h1>Text Me the App</h1>
				</div>
				<div class="col-md-6">
					<form action="text.php" method="POST" onSubmit="alert('Text Sent.');" target="votar">				  <label>(10 digit) Phone Number: </label><input type="text" name="number" size="8px" required style="margin-top: 5%;margin-right:10px; margin-left:5px;">
						<label>Provider: </label>
							<select name="carrier" required style="margin-right:10px;margin-left:5px;">
								<option value="ATT">AT&T </option>
								<option value="SPT">Sprint </option>
								<option value="TMB">T-Mobile </option>
								<option value="VZN">Verizon </option>
								<option value="TST">Test (Email) </option>
							</select>
						<button type="submit">Text Me</button>
					</form>
				</div>
			</div>
			<br>
		</div>
		</center>
	</body>
</html>