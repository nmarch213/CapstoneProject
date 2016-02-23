//Load Packages
var mongoose = require('mongoose');

//Define Token Schema
var CodeSchema = new mongoose.Schema({
	value: 
	{ 
		type: String, 
		required: true 
	},
	redirectUri: 
	{
		type: String,
		required: true 
	},
	userId: 
	{ 
		type: String, 
		required: true 
	},
  	clientId: 
	{ 
		type: String, 
		required: true 
	}
});

//Export mongoose model
module.exports = mongoose.model('Code', CodeSchema);

