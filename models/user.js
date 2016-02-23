//Load packages
var mongoose = require('mongoose');
var bcrypt = require('bcrypt-nodejs');

//Define the Schema
var UserSchema = new mongoose.Schema({
	email:{
		type: String,
		unique: true,
		required: true
	},
	password:{
		type: String,
		required:true
	}
});

UserSchema.pre('save', function(done){
	var user = this;

	//break if the password hasn't changed
	if(!user.isModified('password')) return done();

	//Password Changed, hash the password
	bcrypt.genSalt(5, function(err, salt) {
		if(err) return done(err);

	bcrypt.hash(user.password, salt, null, function(err, hash) {
		if(err) return done(err);
		user.password = hash;
		done();
	});
	});
});

UserSchema.methods.verifyPassword = function(password, cb){
	bcrypt.compare(password, this.password, function(err, isMatch){
		if(err) return cb(err)
		cb(null, isMatch);
	});
};

//Export the Mongoose Model
module.exports = mongoose.model('User', UserSchema);
