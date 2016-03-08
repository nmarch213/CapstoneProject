<!DOCTYPE html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<body>
<h2>Add Team</h2>
<div class="form-group" id="entry_team">
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6" style="text-align: center;">
			<input type="text" class="form-control" name="team_name" placeholder="Team Name">					
		</div>				
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
			<select class="form-control" id="team_league" name="team_league">
			<!--Eventually we'll find a way to populate these with Leagues from the DB-->
			<option>League</option>
			<option value="football">Football</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="team_wins" placeholder="Win Count">
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="team_losses" placeholder="Loss Count">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">					
			<textarea rows="4" cols="42" name="team_players">Add Players</textarea>
		</div>
	</div>
	<div class="form-group">
		<input type="submit" name="submit" value="Submit" />
	</div>
</div>
</body>