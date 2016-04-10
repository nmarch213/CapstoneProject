<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>Add Page</title>
			<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<link href="style.css" rel="stylesheet">
       </head>	   				

<div id="maincontent"></div>
	<body>
		<!--Will get rid of hardcoded style properties eventually. For now I will spare them as I am a merciful god-->
		<div class="container" style="margin-top:50px;width:50%;">
			<form class="form-horizontal" method="post" action="" name="add_entry" id="add_entry" style="margin-top:10px;">
				<center>
				<h1>Add Entry</h1>			
				<div class="form-group">
					<div class="form-group">
						<div class="col-sm-3">
						</div>
						<div class="col-sm-6">
								<select class="form-control" name="entries" id="entries" onchange="myFunction()">
									<option value="none">Select</option>
									<option value="league">Add League</option>
									<option value="team">Add Team</option>
									<option value="match">Add Match</option>
								</select>			
						</div>
					</div>
				</div>			
				<hr/>
				<div name="entry_league" id="entry_league" style="display: none;">
					<?php include 'add_league.php' ?>																	
				</div>
				<div class="entry_team" id="entry_team" style="display: none;">
					<?php include 'add_team.php' ?>	
				</div>
				<div name="entry_match" id="entry_match" style="display: none">
					<?php include 'add_match.php' ?>	
				</div>
			</form>
		</div>
		<script type="text/javascript">
			//function that is called anytime the entries dropdown is changed
			function myFunction() {
				var entry = document.getElementById('entries');
				//if the dropdown has "Add League" selected, hides all the other divs and changes action to call the submit_league php file
				if (entry.value == "league") {
					document.getElementById('entry_league').style.display = "inline";
					document.getElementById('entry_team').style.display = "none";
					document.getElementById('entry_match').style.display = "none";
					document.getElementById('add_entry').action = "submit_league.php";
				}
				//if the dropdown has "Add Team" selected, hides all the other divs and changes action to call the submit_team php file
				else if (entry.value == "team") {
					document.getElementById('entry_league').style.display = "none";
					document.getElementById('entry_team').style.display = "inline";
					document.getElementById('entry_match').style.display = "none";
					document.getElementById('add_entry').action = "submit_team.php";
				}
				//et cetera
				else if (entry.value == "match") {
					document.getElementById('entry_league').style.display = "none";
					document.getElementById('entry_team').style.display = "none";
					document.getElementById('entry_match').style.display = "inline";
					document.getElementById('add_entry').action = "submit_match.php";
				}
				//if none of them is selected (i.e. user reselects "Select"), all divs are hidden. Since there's no submit button to click, this should stop user from trying to add empty info to the database. SHOULD. Just in case, though, action is changed to empty.
				//That way even if they do somehow submit it, DB isn't affected.
				else {
					document.getElementById('entry_league').style.display = "none";
					document.getElementById('entry_team').style.display = "none";
					document.getElementById('entry_match').style.display = "none";
					document.getElementById('add_entry').action = "";
				}
			}
		</script>
	</body>	
</html>