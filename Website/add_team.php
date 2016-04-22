<!DOCTYPE html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="style.css" rel="stylesheet">
</head>
<?php

?>
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
		<div class="col-sm-3">
			<select class="form-control" id="team_league" name="team_league">
				<option value="Men's">Men's</option>
				<option value="Women's">Women's</option>
				<option value="CoRec">CoRec</option>
			</select>	
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="team_sport" placeholder="Team Sport">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-3">
			<input type="number" class="form-control" name="team_wins" placeholder="Win Count">
		</div>
		<div class="col-sm-3">
			<input type="number" class="form-control" name="team_losses" placeholder="Loss Count">
		</div>
	</div>
	<div class="form-group">
		<input type="submit" name="submit" value="Submit" />
	</div>
</div>
</body>