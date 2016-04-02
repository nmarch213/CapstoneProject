//Loading Packages
var User = require('../models/user');


//Create endpoint for /api/users for POST data
exports.postUsers = function(req, res, done){
	//create new User instance
	console.log('Trying to add user to database');
	var user = new User({
		email: req.body.email,
		password: req.body.password,
		username: req.body.username
	});
	//Save User
	user.save(function(err){
		if(err){
			console.log('Add failed, Email taken');
			res.send('Email Taken');
		}
		else{
			console.log('Success! User added!');
			res.send('Thanks for Registering!');
		}
	});
};

//Create endpoint for /api/users for GET
exports.getUsers = function(req, res){
	var authUser = new User({
		auth: 'Authenticated'

	});
	

	res.send('Authenticated');

};



