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
				$collection = $dbname->selectCollection('test_leagues');
				$leagues = $collection->find(array());
				$collection = $dbname->selectCollection('test_teams');
				$teams = $collection->find(array());
				$collection = $dbname->selectCollection('test_matches');
				$matches = $collection->find(array());
				
				$searchTerm = $_GET['search'];
				$searchTerm = trim($searchTerm);
				if($searchTerm==''){echo '<h1>You have to search for something, silly!</h1>';}
				else{
					echo '<h1><a href="search.php?search=leagues">Leagues</a></h1><hr><h3>';
					$none=true;
					if($searchTerm=="leagues"){
						foreach($leagues as $league){echo '<a href="leagueresult.php?name=' . $league['name'] . '">' . $league['name'] . '</a><br>';}}
					else{
						foreach ($leagues as $league){
							$found = strpos(strtolower($league['name']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="leagueresult.php?name=' . $league['name'] . '">' . $league['name'] . '</a><br>';
							}
						}
						if($none===true){
							echo 'No leagues found';
						}
					}
					$none = true;
					echo '</h3><h1><a href="search.php?search=teams">Teams</a></h1><hr><h3>';
					if($searchTerm=='teams'){
						foreach ($teams as $team){echo '<a href="teamresult.php?name=' . $team['name'] . '">' . $team['name'] . ' [' . $team['league'] . ']' . '</a><br>';}}
					else{
						foreach ($teams as $team){
							$found = strpos(strtolower($team['league']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="teamresult.php?name=' . $team['name'] . '">' . $team['name'] . ' [' . $team['league'] . ']' . '</a><br>';
							}
							$found = strpos(strtolower($team['name']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="teamresult.php?name=' . $team['name'] . '">' . $team['name'] . ' [' . $team['league'] . ']' . '</a><br>';
							}		
						}
						if($none===true){
							echo 'No teams found';
						}
					}
					$none = true;
					echo '</h3><h1><a href="search.php?search=matches">Matches</a></h1><hr><h3>';
					if($searchTerm=='matches'){
						foreach ($matches as $match){echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';}}
					else{
						foreach ($matches as $match){
							$found = strpos(strtolower($match['date']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';
							}	
							$found = strpos(strtolower($match['league']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';
							}
							$found = strpos(strtolower($match['team_one_name']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';
							}		
							$found = strpos(strtolower($match['team_two_name']), strtolower($searchTerm));
							if($found===false){}else{
								$none=false;
								echo '<a href="matchresult.php?date=' . $match['date'] . '&league=' . $match['league'] . '">' . $match['date'] . ' [' . $match['league'] . '] <i>' . $match['team_one_name'] . '</i> vs <i>' . $match['team_two_name'] . '</i></a><br>';
							}	
						}
						if($none===true){
							echo 'No matches found</h3>';
						}
					}
					echo '<a href="searchall.php"><h2>Show all</h2></a>';
				}
			?>
		</div>
	</body>
</html>