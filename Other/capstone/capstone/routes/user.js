var express = require('express');
var mongoose = require('mongoose');
var router = express.Router();

mongoose.connect('mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster',function(error)
{
	console.log(error);
});

//Mongoose Schema

var Schema = mongoose.Schema;
var UserSchema = new Schema(
{
	firstName: String,
	lastName: String,
	email: String
});

var User = mongoose.model('User', UserSchema);

var app = express();

app.get('/',function(req,res)
{
	res.send("<a href='/users'>Show Users</a>");
	console.log("u1");
});

app.get('/user', function (req, res) {
    User.find({}, function (err, docs) {
        res.json(docs);
	console.log('u2');
    });
});

app.get('/user/:email', function (req, res) {
    if (req.params.email) {
        User.find({ email: req.params.email }, function (err, docs) {
            res.json(docs);
        });
    }
});

module.exports = router;
