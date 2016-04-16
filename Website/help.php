<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>Help</title>
			<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">			
			<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
			<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href="style.css" rel="stylesheet">
       </head>
	<header>
		<?php
			session_start();
			$page = "help";
			$show = 0;
				if(isset($_SESSION['logged_in'])){
					$show = $_SESSION['logged_in'];
				}	
			include 'header.php';
		?>	
	</header>
	<body data-spy="scroll" data-target="#myScrollspy" data-offset="15">
		<div class="container">	
			<center>
				<h1><a href=""><span class="glyphicon glyphicon-book"></span> Download the User Manual</a></h1>
			</center>
			<hr/>
			<div class="row">				
				<nav class="col-sm-3" id="myScrollspy">
					<ul class="nav nav-pills nav-stacked" data-spy="affix" data-offset-top="25">
						<li class="active"><a href="#section1">Making an account</a></li>
						<li><a href="#section2">Logging in</a></li>
						<li><a href="#section3">Searching for Matches</a></li>
						<li><a href="#section4">Favoriting a Match</a></li>
						<li><a href="#section5">Changing User Settings</a></li>
					</ul>
				</nav>
				<div class="col-sm-9">					
					<div id="section1">
						<h2>Making an account</h2>
						<hr/>
						<img src="images/help/Website_Register.png"/ width="75%">
						<p>Register online to be an official user. This allows you to edit match and team information and add official comments.</p>
						<img src="images/help/register.png" width="30%">
						<p>Registering in the application is simple and easy. But be warned, you can only register as an un-official user.</p>						
					</div>
					<br/>
					<div id="section2">
						<h2>Logging in</h2>
						<hr/>
						<img src="images/help/Website_Login.png" width="75%"/>
						<p>Log in to add matches, teams, and leagues.</p>
						<img src="images/help/login.png" width="30%">					
						<p>Log in to your account using the same information you registered with on this website or in the application.</p>
					</div>
					<br/>
					<div id="section3">
						<h2>Searching for Matches</h2>
						<hr/>
						<img src="images/img_3.jpg" width="75%"/>
					</div>
					<br/>
					<div id="section4">
						<h2>Favoriting a Match</h2>
						<hr/>
						<img src="images/img_4.jpg" width="75%"/>
					</div>
					<div id="section5">
						<h2>Changing User Settings</h2>
						<h4/>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>