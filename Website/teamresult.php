<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
		<title><?php echo $_GET['name'];?></title>
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
		<div class="container fluid">
			<?php
				include 'database_info.php';
				$collection = $dbname->selectCollection('teams');
				$team = $collection->findOne(array('name' => $_GET['name']));
			?>
			<center>
			<h2><?php echo $team['name'];?></h2>
			<h3><i><?php echo $team['league'] . " " . $team['sport'];?></i></h3>
			<h3>Wins<span style="padding-left:20px;">Losses</h3>
			<div class="row">
				<div class="col-sm-2" style="padding-left:45%;">
					<h3><?php echo $team['wins'];?></h3>
				</div>
				<div class="col-sm-2">
					<h3><?php echo $team['losses'];?></h3>
				</div>
			</div>
			<div class="row">				
				<div class="col-sm-4">					
					<?php if($_SESSION['official']==1){?><a href="editteam.php?name=<?php echo $team['name'];?>"><h3>Edit Team</h3></a><?php }?>
				</div>
				<div class="col-sm-4">
					<h3><a href="searchall.php">Return</a></h3>
				</div>
					<?php if($_SESSION['official']==1){?><a href="delete.php?type=team&name=<?php echo $team['name'];?>" onclick="alert('Team Deleted')"><h3>Delete Team</h3></a><?php }?>
				<div class="col-sm-4">
				</div>
			</div>
			</center>
			<br/>
		</div>
	</body>
</html>