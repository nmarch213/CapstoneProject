//Load Packages
var MatchDetails = require('../models/match_details');
var app = require('express')();
var server = require('http').Server(app);
var io = require('socket.io')(server);

//create endpoint for /api/ioconnect
exports.getConnect = function(req, res){
	io.on('connection',function(socket){
		console.log('user connected');
	});
};
