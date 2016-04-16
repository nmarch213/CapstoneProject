<?php
	if(!isset($_SESSION)){
		session_start();
	}
	
	include 'database_info.php';
	if($_GET['type'] === "team"){
		$collection = $dbname->selectCollection('test_teams');
		$team = $collection->findOne(array('_id' => $_SESSION['team2change']));
	
		$team['name'] = $_POST['team_name'];
		$team['league'] = $_POST['team_league'];
		$team['wins'] = $_POST['team_wins'];
		$team['losses'] = $_POST['team_losses'];
	
		$collection->save($team);
	}
	elseif($_GET['type'] === "match"){
		$collection = $dbname->selectCollection('test_matches');
		$match = $collection->findOne(array('_id' => $_SESSION['match2change']));
		
		$match['date'] = $_POST['match_date'];
		$match['league'] = $_POST['match_league'];
		$match['team_one_name'] = $_POST['team_one_name'];
		$match['team_two_name'] = $_POST['team_two_name'];
		$match['team_one_score'] = $_POST['team_one_score'];
		$match['team_two_score'] = $_POST['team_two_score'];
		
		$collection->save($match);
	}
	header("Location: searchall.php");
?>
