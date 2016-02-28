var express = require('express');
var app = express();
var PORT = 8080;

// Gets mongodb drivers
var mongodb = require('mongodb');

// Must work with "MongoClient" interface to connect to mongodb server.
var MongoClient = mongodb.MongoClient;

// Connection URL where mongodb server is running.
var url = 'mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster';

// Connects to Server
MongoClient.connect(url, function(err, db) {
	if (err) {
		console.log('Unable to connect to the mongoDB Server. Error: ', err);
	}
	else {
		console.log('Connection Established to', url);

	    //Do work with database
	    var collection = db.collection('User');

	    // Create users
	    var user1 = {_firstName_: 'Bob' };

        // Insert User
	    collection.insert(user1, function (err, result) {
	    	if (err) {
	    		console.log(err);
	    	}
	    	else {
	            console.log('Success');
	        }
	    })


	    //Close connection
	    console.log("Closing Connection...");
	    db.close();
	}
});
