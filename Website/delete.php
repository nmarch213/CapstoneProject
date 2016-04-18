<?php
	if(!isset($_SESSION)){
		session_start();
	}
	include 'database_info.php';
	if($_GET['type'] == "team"){
		$collection = $dbname->selectCollection('teams');
		$collection->remove(array('name' => $_GET['name']));
	}
	elseif($_GET['type'] == "match"){
		$collection = $dbname->selectCollection('matchdetails');
		$collection->remove(array('date' => $_GET['date'], 'league' => $_GET['league']));
	}
	header("Location: searchall.php");
?>
