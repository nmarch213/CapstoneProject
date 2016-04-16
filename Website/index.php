<!-- Template Site Capstone -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
      <head>
            <title>IMSports</title>
			<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>			
			<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			<link href="style.css" rel="stylesheet">
       </head>	
	   <header>
			<?php
				session_start();
				$page = "index";
				$show = 0;
				if(isset($_SESSION['logged_in'])){
					$show = $_SESSION['logged_in'];
				}
				include 'header.php';
			?>
	   </header>
       <body>			
			<center>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">								
				<br>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">					
					<div class="item active">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/1.jpg" alt="April Second 2016. UWF defeats Mississippi College Nine to Zero."></a>
					</div>

					<div class="item">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/2.jpg" alt="April Seventh 2016. UWF defeats previously undefeated Hawaii Pacific Seven to Two."></a>
					</div>

					<div class="item">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/3.jpg" alt="Starters for the series finale against Union University."></a>
					</div>

					<div class="item">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/4.jpg" alt="April Fourth through Fifth 2016. UWF Men's Golf team places third out of fifteen in the Argonaut Invitational."></a>
					</div>
					
					<div class="item">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/5.jpg" alt="April Fourth through Fifth 2016. UWF Women's Golf team places third out of eighteen in the Argonaut Invitational."></a>
					</div>
					
					<div class="item">
					  <a href="https://twitter.com/goargos"><img id="carousel-img" src="images/carousel/6.jpg" alt="April Sixth 2016. UWF defeats Spring Hill Nine to Two."></a>
					</div>
				</div>				
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>				
				</br>
				</br>
				</br>
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
					<li data-target="#myCarousel" data-slide-to="5"></li>
				</ol>				
			</div>
			</center>
			<!--
			Gonna take out the footer because I think it looks ~cleaner~ without it
			<footer>
			</footer>
			-->			
       </body>	   	   	   
	   <script>
			var val = "<?php echo $_SESSION['logged_in'] ?>";
			if (val == "1")	{
				document.getElementById('log-in').style.display = "none";
				document.getElementById('logout').style.display = "inline";
				document.getElementById('add').style.display = "inline";
			}
			else	{
				document.getElementById('log-in').style.display = "inline";
				document.getElementById('logout').style.display = "none";
				document.getElementById('add').style.display = "none";
			}				
		</script>
</html>