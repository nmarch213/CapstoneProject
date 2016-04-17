<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>Features</title>
			<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<link href="style.css" rel="stylesheet">
       </head>
		<header>
			<?php
				if(!isset($_SESSION)){
					session_start();
				}
				$page = "features";
				$show = 0;
				if(isset($_SESSION['logged_in'])){
					$show = $_SESSION['logged_in'];
				}				
				include 'header.php';
			?>
		</header>
	<body>
		<div class="container fluid">			
		<h1>Features</h1>
		<hr/>
		<ul style="list-style-type: none;">
			<h3><li><span class="glyphicon glyphicon-heart" style="padding-right:2%;font-size:2em;"></span>Track your favorite team, league or match</li>
			<li><span class="glyphicon glyphicon-comment" style="padding-right:2%;font-size:2em;"></span>See comments from other fans and official score keepers and make some of your own</li>
			<li><span class="glyphicon glyphicon-search" style="padding-right:2%;font-size:2em;"></span>Search for teams, leagues, or matches</li>
			<li><span class="glyphicon glyphicon-bell" style="padding-right:2%;font-size:2em;"></span>Get up-to-date info on the matches that matter most to you</li>
		</ul>
		<br>
		</div>		
	</body>
</html>