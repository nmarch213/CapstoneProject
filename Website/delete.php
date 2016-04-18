<?php
	if(!isset($_SESSION)){
		session_start();
	}
	include 'database_info.php';
	if($_GET['type'] == "team"){
		$collection = $dbname->selectCollection('test_teams');
		$collection->remove(array('name' => $_GET['name']));
	}
	elseif($_GET['type'] == "match"){
		$collection = $dbname->selectCollection('test_matches');
		$collection->remove(array('date' => $_GET['date'], 'league' => $_GET['league']));
	}
	else{
		$collection = $dbname->selectCollection('test_leagues');
		$collection->remove(array('name' => $_GET['name']));
	}
	header("Location: searchall.php");
?>
