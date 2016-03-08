
<!DOCTYPE html>
<head>
	<title>Team Added</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
	$team_name = $_POST['team_name'];
	$team_league = $_POST['team_league'];
	$team_wins = $_POST['team_wins'];
	$team_losses = $_POST['team_losses'];
	$team_players = $_POST['team_players'];	
	
	$username = 'kyanna';
	$pass = 'capstone123';
	
	$connecting_string =  'mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster';
	$connection=  new MongoClient($connecting_string);
	/*Also try
	$username = 'kyanna'
	$pass = 'capstone123'
	$connecting_string = 'mongodb://ds059115.mongolab.com:59115/sportscaster';
	$connection = new MongoClient($connecting_string,array('username'=>$username,'password'=>$pass));
	*/
	
	$dbname = $connection->selectDB('sportscaster');
	$collection = $dbname->selectCollection('test_teams');
	
	$post = array(
        'league'	=> $team_league,
        'name'   	=> $team_name,
        'wins'  	=> $team_wins,
		'losses' 	=> $team_losses,
		'players' 	=> $team_players
    );
    $collection->insert($post);
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;">SUCCESS BRO!</h1>
			<p><?php echo $team_name ?> added!</p>
			<a href="add_page.php">Return</a>
		</div>
	</body>
</html>