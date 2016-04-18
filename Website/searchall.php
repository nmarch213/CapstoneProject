<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
		<title>Custom Search</title>
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
			$page = "none";
			$show = 0;
			if(isset($_SESSION['logged_in'])){
				$show = $_SESSION['logged_in'];
			}
			include 'header.php';
		?>
   </header>
   <body>
		<div class="container">
		<?php
			include 'database_info.php';
			$collection = $dbname->selectCollection('teams');
			$teams = $collection->find(array());
			$collection = $dbname->selectCollection('matchdetails');
			$matches = $collection->find(array());
			
			echo '</h3><h1><a href="search.php?search=teams">Teams</a></h1><hr><h3>';
			foreach ($teams as $team){echo '<a href="teamresult.php?name=' . $team['name'] . '">' . $team['name'] . ' [' . $team['league'] . ' ' . $team['sport'] . ']' . '</a><br>';}
			echo '</h3><h1><a href="search.php?search=matches">Matches</a></h1><hr><h3>';
			foreach ($matches as $match){echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . ' ' . $team['sport'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';}
		?>
	</body>
</html>