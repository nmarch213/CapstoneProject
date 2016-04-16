<?php
	if(!isset($_SESSION)){
		session_start();
	}
	include 'database_info.php';
	if($_GET['type'] == "team"){
		$collection = $dbname->selectCollection('test_teams');
		$collection->remove(array('_id' => $_GET['id']));
	}
	elseif($_GET['type'] == "match"){
		$collection = $dbname->selectCollection('test_matches');
		$collection->remove(array('date' => $_GET['date'], 'league' => $_GET['league']));
	}

	header("Location: searchall.php");
?>
