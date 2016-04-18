<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
		<title>Edit <?php echo $_GET['name'];?></title>
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
			$collection = $dbname->selectCollection('teams');
			$team = $collection->findOne(array('name' => $_GET['name']));
			$_SESSION['team2change'] = $team['_id'];
		?>
   </header>
   <body>
		<div class="container fluid">
			<form action="edit.php?type=team" method="POST" onSubmit="alert('Edit Submitted')">
					<div class="row">
						<div class="col-sm-3">							
						</div>
						<div class="col-sm-6" style="text-align: center;">
							<label>Name</label>
							<input type="text" class="form-control" name="team_name" value="<?php echo $team['name'];?>" required>					
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
						</div>
						<div class="col-sm-3" style="text-align: center;">
							<label>League</label>
							<select class="form-control" id="team_league" name="team_league">
								<option value="Men's" <?php if($team['league'] == "Men's"){?> selected<?php }?>>Men's</option>
								<option value="Women's" <?php if($team['league'] == "Women's"){?> selected<?php }?>>Women's</option>
								<option value="CoRec" <?php if($team['league'] == "CoRec"){?> selected<?php }?>>CoRec</option>
							</select required>		
						</div>
						<div class="col-sm-3" style="text-align: center;">
							<label>Sport</label>
							<input type="text" class="form-control" name="team_sport" value="<?php echo $team['sport'];?>" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
						</div>
						<div class="col-sm-3" style="text-align: center;">
							<label>Wins</label>
							<input type="number" class="form-control" name="team_wins" value="<?php echo $team['wins'];?>" required>
						</div>
						<div class="col-sm-3" style="text-align: center;">
							<label>Losses</label>
							<input type="number" class="form-control" name="team_losses" value="<?php echo $team['losses'];?>" required>
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