
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<div>
		<a href="index.php"><img src="images/banner2.jpg" width="100%" height="150px"/></a>
	</div>
	
	<nav class="navbar navbar-default" id="bar">
		<div class="container-fluid" height=200>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="background-color:#003865;">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span> 
				</button>
				<a class="navbar-brand" href="index.php">IMSportcaster</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			  <ul class="nav navbar-nav">
				<li <?php if($page=="features"){?>class="active"<?php }?>><a href="features.php">Features</a></li>
				<li <?php if($page=="about"){?>class="active"<?php }?>><a href="about.php">About Us</a></li>
				<li <?php if($page=="help"){?>class="active"<?php }?>><a href="help.php">Help</a></li>
				<li <?php if($page=="download"){?>class="active"<?php }?>><a href="download.php">Download</a></li>
				<?php if($show!=1){?><li id="log-in" style="display:inline;"><a href="login.html">Sign In</a></li><?php } ?>
				<?php if($show==1){?><li id="logout" style="display:inline;"><a href="logout.php">Sign Out</a></li><?php } ?>
				<?php if($show==1 && $_SESSION['official']==1){?><li <?php if($page=="add_page"){?>class="active"<?php }?> id="add" style="display:inline;"><a href="add_page.php">Add Entry</a></li><?php } ?>
			  </ul>
			  <ul>
				<form name="cse" id="searchbox_demo" action="search.php" method="GET">
					<input type="text" class="form-control search" id="searchbar" name="search" placeholder="Search Entries...">					
				</form>
				</ul>
			</div>					
		</div>				
	</nav>
<!--
<nav class="navbar navbar-default" id="bar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Page 1</a></li>
        <li><a href="#">Page 2</a></li> 
        <li><a href="#">Page 3</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>-->