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
			<option>Team</option>
			</select>
		</div>
		<div class="col-sm-3">
			<select class="form-control" name="match_teamB">
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
</div>
</body>