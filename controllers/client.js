//Load packages
var Client = require('../models/client');

//create endpoint /api/client for POST
exports.postClients = function(req, res){
	//create new instance of client model
	var client = new Client();

	//set client properties that come from Post
	client.name = req.body.name;
	client.id = req.body.id;
	client.secret = req.body.secret;
	client.userId = req.user._id;

	//save client, check err
	client.save(function(err){
		if(err){
			res.send(err);}
		
		res.json({message: 'Client added', data:client});
	});
};

//Create endpoint /api/client for GET
exports.getClients = function(req, res){
	Client.find({userId: req.user._id}, function(err, clients){
		if(err) res.send(err);

		res.json(clients);
	});
};
