<!DOCTYPE html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<body>
<h2>Add Match</h2>
<div class="form-group">
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
			<select class="form-control" name="match_league">
			<option>League</option>
			<!--Eventually we'll find a way to populate these with Leagues from the DB-->
			<option value="football">Football</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-3">
		<input type="text" class="form-control" name="match_date" placeholder="Date (mm/dd/yyyy)">
		</div>
		<div class="col-sm-3">
		<input type="text" class="form-control" name="match_location" placeholder="Location">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="match_scoreA" placeholder="X" style="text-align: center;">
		</div>
		<div class="col-sm-2">
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control" name="match_scoreB" placeholder="X" style="text-align: center;">
		</div>					
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-3">
			<select class="form-control" name="match_teamA">
			<!--Eventually we'll find a way to populate these with Team names from the DB-->
			<option>Team</option>
			</select>
		</div>
		<div class="col-sm-3">
			<select class="form-control" name="match_teamB">
			<!--Eventually we'll find a way to populate these with Team names from the DB-->
			<option>Team</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-4">
		</div>
		<div class="col-sm-4">
			<input type="text" class="form-control" name="match_time" placeholder="Time" style="text-align: center;">
		</div>
	</div>
	<div class="form-group">
		<input type="submit" name="submit" value="Submit" />
	</div>
</div>
</body>