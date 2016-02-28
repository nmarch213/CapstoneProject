var express = require('express');
var router = express.Router();
var MongoClient = require('mongodb').MongoClient;
var http = require('http');
var fs = require('fs');
var url = require('url');


var userLogin = {
	"email" : 'test@test.com',
	"pass"  : 'pass'
};

router.route('/login')

.get(function(req, res)
{
	console.log("Attempting to log in");
	
	MongoClient.connect('mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster',
	function(err,db)
   {
        if(err){
                throw err;
        }
        console.log('Connected to the database');
        db.collection('User').find({"email" : "test@test.com"})(function(err,result){
                if(err) {
                        throw err;
                }
                res.send(result);
        });
   });
})





module.exports = router;
