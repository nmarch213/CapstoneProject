<!--Maybe someday soon we'll actually use these pages to insert info to the database, but for now it's just a reward for hitting submit-->

<!DOCTYPE html>
<head>
	<title>League Added</title>
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
	$league_name = $_POST['league_name'];
	
	include 'database_info.php';
	$collection = $dbname->selectCollection('test_leagues');
	
	if($league_name == "")	{
		$heading = "Failure Bro!";
		$display = "Whoops! You left the field empty!";
	}
	else {
		$doesExist = $collection->findOne(array('name' => $league_name));
		if($doesExist!=null)	{
			$heading = "Failure Bro!";
			$display = "Whoops! That league already exists!";
		}
		else	{
			$post = array(
				'name'	=> $league_name
			);
			$collection->insert($post);
			$heading = "SUCCESS BRO!";
			$display = $league_name . " added!";
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