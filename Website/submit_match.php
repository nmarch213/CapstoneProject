<!--Maybe someday soon we'll actually use these pages to insert info to the database, but for now it's just a reward for hitting submit-->

<!DOCTYPE html>
<head>
	<title>Match Added</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php		
	$match_league = $_POST['match_league'];
	$match_date = $_POST['match_date'];
	$match_location = $_POST['match_location'];
	$match_scoreA = $_POST['match_scoreA'];
	$match_scoreB = $_POST['match_scoreB'];
	$match_teamA = $_POST['match_teamA'];
	$match_teamB = $_POST['match_teamB'];
	$match_time = $_POST['match_time'];
	$values = array($match_league, $match_date, $match_location, $match_scoreA, $match_scoreB, $match_teamA, $match_teamB, $match_time);
	
	include 'database_info.php';
	$collection = $dbname->selectCollection('test_matches');
	
	if(in_array("", $values))	{
		$heading = "Failure Bro!";
		$display = "Whoops! You left one of the fields empty!";
	}
	else	{
		$doesExist = $collection->findOne(array('league' => $match_league, 'date' => $match_date, 'location' => $match_location));
		if($doesExist!=null)	{
			$heading = "Failure Bro!";
			$display = "Whoops! That match already exists!";
		}
		else {
			$post = array(
				'league'		=> $match_league,
				'date'			=> $match_date,
				'location'		=> $match_location,
				'scoreA'		=> $match_scoreA,
				'scoreB'		=> $match_scoreB,
				'teamA'			=> $match_teamA,
				'teamB'			=> $match_teamB,
				'match_time'	=> $match_time
			);
			$collection->insert($post);
			$heading = "SUCCESS BRO!";
			$display = $match_league . " match at " . $match_location . ", " . $match_date . " added!";
		}
	}
	
?>
<html>
	<body>
		<div class="container" style="margin-top:50px;width:50%; text-align:center;">
			<h1 style="color:red;"><?php echo $heading;?></h1>
			<p><?php echo $display;?></p>
			<a href="add_page.php">Return</a>
		</div>
	</body>
</html>