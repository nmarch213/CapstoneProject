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
			if(!isset($_SESSION)){
				session_start();
			}
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
				<h1><a href="https://www.dropbox.com/s/i2o6z0hulu412r8/User-Guide.pdf?dl=1"><span class="glyphicon glyphicon-book"></span> Download the User Manual</a></h1>
			</center>
			<hr/>
			<div class="row">				
				<nav class="col-sm-3" id="myScrollspy">
					<ul class="nav nav-pills nav-stacked">
						<li class="active"><a href="#section1">Making an account</a></li>
						<li><a href="#section2">Logging in</a></li>
						<li><a href="#section3">Checking a Match</a></li>
						<li><a href="#section4">Leaving a Comment</a></li>
						<li><a href="#section5">Changing User Settings</a></li>
					</ul>
				</nav>
				<div class="col-sm-9">					
					<div id="section1">
						<h2>Making an account</h2>
						<hr/>
						<img src="images/help/Website_Register.png" width="75%" alt="Website Register Page">
						<p>Register online to be an official user. This allows you to edit match and team information and add official comments.</p>
						<a href="images/help/register.png" target="_blank"><img src="images/help/register.png" width="30%" alt="Application Register Screen"></a>
						<p>Registering in the application is simple and easy. But be warned, you can only register as an un-official user.</p>						
					</div>
					<br/>
					<div id="section2">
						<h2>Logging in</h2>
						<hr/>
						<img src="images/help/Website_login.png" width="75%" alt="Website Login Page"/>
						<p>Log in to add matches, teams, and leagues.</p>
						<a href="images/help/login.png" target="_blank"><img src="images/help/login.png" width="30%" alt="Application Login Screen"></a>
						<p>Log in to your account using the same information you registered with on this website or in the application.</p>
					</div>
					<br/>
					<div id="section3">
						<h2>Checking a Match</h2>
						<hr/>
						<a href="images/help/homepage.png" target="_blank"><img src="images/help/homepage.png" width="30%" alt="Application Homepage"></a>
						<p>From the homepage, simply tap the match you want more information on to be taken to its result screen.</p>
					</div>
					<br/>
					<div id="section4">
						<h2>Leaving a Comment</h2>
						<hr/>						
						<a href="" target="_blank"><img src="images/help/comment.png" width="30%" alt="Application Match Result"/></a>
						<p>On the match's result screen you can leave a comment by inputting your message in the available field and tapping the submit arrow.</p>
					</div>
					<div id="section5">
						<h2>Changing User Settings</h2>
						<hr/>
						<a href="images/help/side menu.png" target="_blank"><img src="images/help/side menu.png" width="30%" alt="Application Side Menu"></a>
						<p>Tap the icon at the upper left of the screen to view the side menu. From here, choose 'Edit Profile'</p>
						<a href="images/help/update profile.png" target="_blank"><img src="images/help/update profile.png" width="30%" alt="Application Edit Profile Screen"></a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>