<!DOCTYPE html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php
include 'database_info.php';
$lcollection = $dbname->selectCollection('test_leagues');
$tcollection = $dbname->selectCollection('test_teams');
$leagues = $lcollection->find(array());
$teams = $tcollection->find(array());
?>
<body>
<h2>Add Match</h2>
<div class="form-group">
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
			<select class="form-control" id="match_league" name="match_league">
				<!--
				Basically this goes through all the values in the array of leagues we created earlier and for each one adds a value for our drop down.
				-->
				<?php foreach ($leagues as $league) { ?>
				<option value="<?php echo $league['name'];?>"><?php echo $league['name'];?></option>
				<?php } ?>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
		<input type="text" class="form-control" name="match_date" placeholder="Date (mm/dd/yyyy)">
		</div>
	</div>	
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-3">
			<select class="form-control" name="match_teamA">
				<?php				
				foreach ($teams as $team) {					
				?>
				<option value="<?php echo $team['name'];?>"><?php echo $team['name'];?></option>
				<?php
				}
				?>
			</select>
		</div>
		<div class="col-sm-3">
			<select class="form-control" name="match_teamB">
				<?php
				foreach ($teams as $team) {
				?>
				<option value="<?php echo $team['name'];?>"><?php echo $team['name'];?></option>
				<?php
				}
				?>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-2">
			<input type="number" class="form-control" name="match_scoreA" placeholder="Score" style="text-align: center;">
		</div>
		<div class="col-sm-2">
		</div>
		<div class="col-sm-2">
			<input type="number" class="form-control" name="match_scoreB" placeholder="Score" style="text-align: center;">
		</div>					
	</div>
	<div class="form-group">
		<input type="submit" name="submit" value="Submit" />
	</div>
</div>
</body>