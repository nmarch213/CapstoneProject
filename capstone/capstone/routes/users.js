var express = require('express');
var router = express.Router();
var MongoClient = require('mongodb').MongoClient;

router.get('/', function(req, res,next){	

MongoClient.connect('mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster',function(err,db)
   {
	if(err){
		throw err;
	}	
	console.log('Connected to the database');

	db.collection('User').find().toArray(function(err,result){
		if(err) {
			throw err;
		}
		res.send(result);
	});
   });


});

module.exports = router;
