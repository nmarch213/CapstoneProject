var passport = require('passport');
var BasicStrategy = require('passport-http').BasicStrategy;
var BearerStrategy = require('passport-http-bearer').Strategy;
var LocalStrategy = require('passport-local').Strategy;

//importing Mongoose Models
var User = require('../models/user');
var Client = require('../models/client');
var Token = require('../models/token');

passport.use(new BasicStrategy(
	function(email, password, done){
		User.findOne({ email: email}, function(err, user){
			if(err) return done(err);

			//No User found w/ that username
			if(!user)
			{ return done(null, false);
			}
			//Make Sure Password is Correct
			user.verifyPassword(password, function(err, isMatch){
				if(err) return done(err);

				//Password did not match
				if(!isMatch)
				{ return done(null, false);
				}	
				//Sucessful
				return done(null, user);
			});
		});
	}
));

passport.use('client-basic', new BasicStrategy(
	function(email, password, done){
		Client.findOne({id: email}, function(err, client){
			if(err) return done(err);

			//No Client Found with that ID or password
			if(!client || client.secret !== password) return done(null, false);
			
			//Success
			return done(null, client);
		});
	}
));

passport.use(new BearerStrategy(
  function(accessToken, callback) {
    Token.findOne({value: accessToken }, function (err, token) {
      if (err) { return callback(err); }

      // No token found
      if (!token) { return callback(null, false); }

      User.findOne({ _id: token.userId }, function (err, user) {
        if (err) { return callback(err); }

        // No user found
        if (!user) { return callback(null, false); }

        // Simple example with no scope
        callback(null, user, { scope: '*' });
      });
    });
  }
));

passport.use(new LocalStrategy(
	function(email, password, done){
		User.findOne({email: email}, function(err, user){
			if(err) return done(err);

			//no User found
			if(!user) return done(null, false);

			//check password is correct
			user.verifyPassword(password, function(err, isMatch){
				if(err) return done(err);

				//password doesnt match
				if(!isMatch) return done(null, false);
		
				//Successful Login
				return done(null, user);
			});
		});
	}
));

exports.isBearerAuthenticated = passport.authenticate('bearer', {session: false});
exports.isClientAuthenticated = passport.authenticate('client-basic', {session: false});
exports.isAuthenticated = passport.authenticate(['basic','bearer'], {session: false});
