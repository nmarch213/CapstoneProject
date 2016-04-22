<!DOCTYPE html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php

?>
<body>
<h2>Add Match</h2>
<div class="form-group">
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
		<div class="col-sm-2">
			<input type="text" class="form-control" name="match_id" placeholder="Score2" style="text-align: center;">
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="team_one_name" placeholder="Score2" style="text-align: center;">
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