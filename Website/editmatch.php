<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
		<title>Edit <?php echo $_GET['date'];?></title>
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
			
			include 'database_info.php';
			$collection = $dbname->selectCollection('matchdetails');
			$match = $collection->findOne(array('date' => $_GET['date']));
			$_SESSION['match2change'] = $match['_id'];
			$collection = $dbname->selectCollection('teams');
			$teams = $collection->find(array()); 
			$collection = $dbname->selectCollection('leagues');
			$leagues = $collection->find(array());
		?>
   </header>
   <body>
		<div class="container fluid">
			<form action="edit.php?type=match" method="POST" onSubmit="alert('Edit Submitted')">
				<div class="row">
					<div class="col-sm-3">							
					</div>
					<div class="col-sm-6" style="text-align: center;">
						<label>Date</label>
						<input type="text" class="form-control" name="match_date" value="<?php echo $match['date'];?>" required>					
					</div>
				</div>				
				<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-3" style="text-align: center;">
						<label>Team</label>
						<select class="form-control" name="team_one_name">
						<?php
							foreach ($teams as $team) {							
						?>
							<option value="<?php echo $team['name'];?>"<?php if($team['name'] == $match['team_one_name']){?>selected<?php }?>><?php echo $team['name'];?></option>
						<?php
							}
						?>
						</select required>
					</div>
					<div class="col-sm-3" style="text-align: center;">
						<label>Team</label>
						<select class="form-control" name="team_two_name">
						<?php
							foreach ($teams as $team) {							
						?>
							<option value="<?php echo $team['name'];?>"<?php if($team['name'] == $match['team_two_name']){?>selected <?php }?>><?php echo $team['name'];?></option>
						<?php
							}
						?>
						</select required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-3" style="text-align: center;">
						<label>Score</label>
						<input type="number" class="form-control" name="team_one_score" value="<?php echo $match['team_one_score'];?>" required>
					</div>
					<div class="col-sm-3" style="text-align: center;">
						<label>Score</label>
						<input type="number" class="form-control" name="team_two_score" value="<?php echo $match['team_two_score'];?>" required>
					</div>
				</div>
				<br>
				<center>
				<div class="row">
					<input type="submit" name="submit" value="Submit Changes"/>
				</div>
				</center>
				<br>
			</form>
		</div>
	</body>
</html>