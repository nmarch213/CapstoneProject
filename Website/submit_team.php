
<!DOCTYPE html>
<head>
	<title>Team Added</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<header>
	<?php		
		if(!isset($_SESSION)) 
		{ 
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
<?php
	$team_name = $_POST['team_name'];
	$team_league = $_POST['team_league'];
	$team_sport = $_POST['team_sport'];
	$team_wins = $_POST['team_wins'];
	$team_losses = $_POST['team_losses'];
	//$team_players = $_POST['team_players'];	
	$values = array($team_name, $team_league, $team_sport, $team_wins, $team_losses);//, $team_players);	
	include 'database_info.php';
	$collection = $dbname->selectCollection('teams');
	
	if(in_array("", $values))	{
		$heading = "Failure Bro!";
		$display = "Whoops! You left one of the fields empty!";
	}
	else {
		$doesExist = $collection->findOne(array('name' => $team_name));
		if($doesExist!=null)	{
			$heading = "Failure Bro!";
			$display = "Whoops! That team already exists!";
		}
		else	{
			$post = array(
				'league'	=> $team_league,
				'sport' 	=> $team_sport,
				'name'   	=> $team_name,
				'wins'  	=> $team_wins,
				'losses' 	=> $team_losses//,
				//'players' 	=> $team_players
			);
			$collection->insert($post);
			$heading = "SUCCESS BRO!";
			$display = $team_name . " added!";
		}
	}
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;"><?php echo $heading;?></h1>
			<p><?php echo $display; ?></p>
			<a href="add_page.php">Return</a>
		</div>
	</body>
</html>