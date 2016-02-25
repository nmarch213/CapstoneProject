<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>Add Page</title>
			<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<link href="style.css" rel="stylesheet">
       </head>	   				

<div id="maincontent"></div>
	<body>
		<div class="container" style="margin-top:50px;width:50%;">
			<form class="form-horizontal" method="post" action="" name="add_entry" style="margin-top:10px;">
				<center>
				<h1>Add Entry</h1>			
				<div class="form-group">
					<div class="form-group">
						<div class="col-sm-3">
						</div>
						<div class="col-sm-6">
								<select class="form-control" name="entries" id="entries" >
									<option value="none">Select</option>
									<option value="league" onclick="myFunction()">Add League</option>
									<option value="team">Add Team</option>
									<option value="match">Add Match</option>
								</select>			
						</div>
					</div>
				</div>			
				<hr/>
				<div name="entry_league">
					<?php include 'add_league.php' ?>																	
				</div>
				<div class="entry_team">
					<?php include 'add_team.php' ?>	
				</div>
				<div name="entry_match">
					<?php include 'add_match.php' ?>	
				</div>
			</form>
		</div>
		<script language="javascript">			
		</script>
	</body>	
</html>