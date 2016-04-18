<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
		<title><?php echo $_GET['name'];?></title>
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
		?>
   </header>
   <body>
		<div class="container fluid">
			<?php
				include 'database_info.php';
				$collection = $dbname->selectCollection('test_leagues');
				$league = $collection->findOne(array('name' => $_GET['name']));
			?>
			<center>
			<h2><?php echo $league['name'];?></h2>		
			<div class="row">				
				<div class="col-sm-4">					
					<?php if($_SESSION['official']==1){?><a href="editleague.php?name=<?php echo $league['name'];?>"><h3>Edit League</h3></a><?php }?>
				</div>
				<div class="col-sm-4">
					<h3><a href="searchall.php">Return</a></h3>
				</div>
					<?php if($_SESSION['official']==1){?><a href="delete.php?type=league&name=<?php echo $league['name'];?>" onclick="alert('League Deleted')"><h3>Delete League</h3></a><?php }?>
				<div class="col-sm-4">
				</div>
			</div>
			</center>
			<br/>
		</div>
	</body>
</html>