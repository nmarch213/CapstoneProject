//Loading Packages
var User = require('../models/user');

//Create endpoint for /api/users for POST data
exports.postUsers = function(req, res){
	//create new User instance
	var user = new User({
	email: req.body.email,
	password: req.body.email
	});

	//Save User
	user.save(function(err){
		if(err)
			res.send(err);

		res.send({message: 'User Added'});
	});
};

//Create endpoint for /api/users for GET
exports.getUsers = function(req, res){
	//Find all Users
	User.find(function(err, users){
		if(err)
			res.send(err);

		res.json(users);
	});
};



