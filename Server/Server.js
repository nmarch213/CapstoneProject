var express = require('express');
var app = express();
var net = require('net');
var http = require('http');
var PORT = 8081;
var HOST = 'localhost';

// Gets mongodb drivers
var mongodb = require('mongodb');

// Must work with "MongoClient" interface to connect to mongodb server.
var MongoClient = mongodb.MongoClient;

// Connection URL where mongodb server is running.
var url = 'mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster';

// Create instance of Server and waits for connection
net.createServer(function(sock) {
	console.log("CLIENT CONNECTED: " + sock.remoteAddress + ":" + sock.remotePort);
	
	var user;
	
	// data being accessed through socket 
	sock.on('data', function(data) {
		console.log("Recieved: " + data);
		user = JSON.parse(data);
	});

	// Server connects to MongoLab Database
	MongoClient.connect(url, function(err, db) {
		if (err) {
			console.log('Unable to connect to the mongoDB Server. Error: ', err);
		}
		else {
			console.log('Database Connection Established to', url);

			//Do work with database
			var collection = db.collection('User');
			
			// I try to Insert JSON data here
			collection.insert(user, function (err, result) {
				if (err) {
					console.log("INSERT ERROR!")
					console.log(err);
				}	
				else {
					console.log('Insert Successful');	
					
					// Close Database
					console.log("Disconnected from Database");
					db.close();
					
					// Send Response back to Client
					// NOTE: '\n' needs to be added at end of string since readLine() is being used in Java
					sock.write("User inserted into database" + '\n');
				}
			})
		}
	});
	
	sock.on('close',function(data) {
	console.log('CLIENT DISCONNECTED: ' + sock.remoteAddress + ' ' + sock.remotePort);
	});
	
}).listen(PORT, HOST);
console.log("Server listening on " + HOST + ":" + PORT);

//IGNORE EVERYTHING BELOW

app.get('/', function (req, res) {
	console.log("Got a GET request for homepage");
	res.send('Hello GET');
})

app.post("/", function(request, response){
	console.log("got a POST request for homepage");
	res.send('Hello POST');
})
