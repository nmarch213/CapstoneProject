<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>About Us</title>
			<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<link href="style.css" rel="stylesheet">
       </head>
		<header>
			<?php
				$page = "about";
				$show = 0;
				if(isset($_SESSION['logged_in'])){
					$show = $_SESSION['logged_in'];
				}	
				include 'header.php';
			?>
		</header>
	<body>
		<div class="container">
		<center><h2>About Us</h2></center>
			<div class="row">
				<div class="col-md-4">
					<img class="about_img" src="images/profile/nick.png" alt="Nicholas March"><b>Nicholas March</b>
					<p>WHAT ARE YOU</p>
					<p>Innnn west Philadelphia born and raised on the playground was where I spent most of my days. Chillin' out maxin' relaxin' all cool and all shooting some b-ball outside of the school</p>
				</div>
				<div class="col-md-4">
					<img class="about_img" src="images/profile/ryan.png" alt="Ryan Estevez"><b>Ryan Estevez</b>
					<p>an Idiot Sandwich</p>
					<p>I currently have eight warrants out for my arrest, all having to do with petty theft! I love M&Ms, even if I can't afford them.</p>
				</div>
				<div class="col-md-4">
					<img class="about_img" src="images/profile/dom.png" alt="Dominique Reese"><b>Dominique Reese</b>
					<p>Wrecked him? Damn near killed him</p>
					<p>They're eating her! And then they're going to eat me! ...Oh my goooOOOOOOOOOOOODDDDDDDDDDDD!</p>
				</div>
			</div>
			<div class="row">				
				<div class="col-md-4">
					<img class="about_img" src="images/profile/kyanna.jpg" alt="Kyanna Riley"><b>Kyanna Riley</b>
					<p>Hi, I'm Kyanna</p>
					<p>DB Admin, IT Specialist. I like watching movies on Netflix, programming, and long walks at the park. Snapchat me at ka3zy</p>
				</div>
				<div class="col-md-4">
					<img class="about_img" src="images/profile/helena.png" alt="Helena Gunter"><b>Helena Gunter</b>
					<p>Walking Talking Trash</p>
					<p>Catch me in a dirty alleyway tipped over and covered in mud and scratches!</p>
				</div>
			</div>
			<hr/>
			<center><h2>About the App</h2></center>
			<div class="row">
				<div class="col-md-12">
				<h4>Made in 2016, this app is a symbol of all we hope we will be remembered for. Speed, communication, virility, this app has it all. Constantly pulling and sending information at lightning fast speeds to and from our databases of the sports you know and love most. Is there a better app than this on the market? We think not.</h4>
				</div>
		</div>
	</body>
</html>