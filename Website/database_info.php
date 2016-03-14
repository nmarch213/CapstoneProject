<?php
	
	$connecting_string =  'mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster';		
	$connection=  new MongoClient($connecting_string);
	/*Also try
	$username = 'kyanna'
	$pass = 'capstone123'
	$connecting_string = 'mongodb://ds059115.mongolab.com:59115/sportscaster';
	$connection = new MongoClient($connecting_string,array('username'=>$username,'password'=>$pass));
	*/
	$dbname = $connection->selectDB('sportscaster');
		
?>