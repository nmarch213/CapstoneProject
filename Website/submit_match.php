<!--Maybe someday soon we'll actually use these pages to insert info to the database, but for now it's just a reward for hitting submit-->

<!DOCTYPE html>
<head>
	<title>Match Added</title>
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
	$match_date = $_POST['match_date'];
	$match_scoreA = $_POST['match_scoreA'];
	$match_scoreB = $_POST['match_scoreB'];
	$match_teamA = $_POST['match_teamA'];
	$match_teamB = $_POST['match_teamB'];
	$values = array($match_date, $match_scoreA, $match_scoreB, $match_teamA, $match_teamB);
	$matching = true;
	
	include 'database_info.php';	
	$collection = $dbname->selectCollection('matchdetails');
	$matches = $collection->find();	
	
	if(in_array("", $values))	{
		$heading = "Failure Bro!";
		$display = "Whoops! You left one of the fields empty!";
	}
	else	{
		$doesExist = $collection->findOne(array('date' => $match_date, 'team_one_name' => $match_teamA, 'team_two_name' => $match_teamB));
		if($doesExist!=null)	{
			$heading = "Failure Bro!";
			$display = "Whoops! That match already exists!";
		}
		else if($match_teamA == $match_teamB) {
			$heading = "Failure Bro!";
			$display = "Whoops! A team can't play itself!";
		}
		else {
			$collection2 = $dbname->selectCollection('teams');
			$teams = $collection2->find();
			foreach ($teams as $team){
				if($team['name'] == $match_teamA){
					$trueleague = $team['league'];
					$truesport = $team['sport'];
				}
			}
			foreach($teams as $team){
				if($team['name'] == $match_teamB){
					if($team['league'] != $trueleague){
						$heading = "Failure Bro!";
						$display = "Whoops, those teams aren't in the same league!";
						$matching = false;
					}
					elseif($team['sport'] != $truesport){
						$heading = "Failure Bro!";
						$display = "Whoops, those teams aren't in the same sport!";
						$matching = false;
					}
				}
			}
			if($matching != false){
				$match_id = 0;
				foreach ($matches as $match){
					if($match['match_id'] > $match_id){
						$match_id = $match['match_id'];
					}
				}
				$match_id++;
				$post = array(
					'league'				=> $trueleague,
					'sport'					=> $truesport,
					'date'					=> $match_date,
					'gameTime' 				=> "20:00",
					'team_two_score'		=> $match_scoreB,
					'team_one_score'		=> $match_scoreA,
					'team_two_name'			=> $match_teamB,
					'team_one_name'			=> $match_teamA,
					'match_id'				=> $match_id
					
				);
				$collection->insert($post);
				$heading = "SUCCESS BRO!";
				
				$display = $trueleague . " " . $truesport . " match on " . $match_date . " added!";
			}
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