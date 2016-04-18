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
			$collection = $dbname->selectCollection('test_leagues');
			$league = $collection->findOne(array('name' => $_GET['name']));
			$_SESSION['league2change'] = $league['_id'];
		?>
   </header>
   <body>
		<div class="container fluid">
			<form action="edit.php?type=league" method="POST" onSubmit="alert('Edit Submitted')">
				<br>
				<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6" style="text-align: center;">
						<input type="text" class="form-control" name="league_name" value="<?php echo $league['name'];?>">
					</div>
				</div>
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