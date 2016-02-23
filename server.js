var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var session = require('express-session');

//Add Controllers
var userController = require('./controllers/user');
var authController = require('./controllers/auth');
var clientController = require('./controllers/client');
var oauth2Controller = require('./controllers/oauth2');

//Create Express App
var app = express();

//Set View Engine
app.set('view engine', 'ejs');

// Use the body-parser package in our application
app.use(bodyParser.urlencoded({
  extended: true
}));

// Use express session support since OAuth2orize requires it
app.use(session({
  secret: 'Super Secret Session Key',
  saveUninitialized: true,
  resave: true
}));

//MongoDB Connection
mongoose.connect('mongodb://kyanna:capstone123@ds059115.mongolab.com:59115/sportscaster');


app.use(bodyParser.urlencoded({
	extended: true
}));


//Creating Router
var router = express.Router();

//Endpoint for handling /user
router.route('/user')
	.post(userController.postUsers)
	.get(authController.isAuthenticated,userController.getUsers);

//Endpoint for handling /clients
router.route('/clients')
	.post(authController.isAuthenticated, clientController.postClients)
	.get(authController.isAuthenticated, clientController.getClients);

// Create endpoint handlers for oauth2 authorize
router.route('/oauth2/authorize')
  .get(authController.isAuthenticated, oauth2Controller.authorization)
  .post(authController.isAuthenticated, oauth2Controller.decision);

// Create endpoint handlers for oauth2 token
router.route('/oauth2/token')
  .post(authController.isClientAuthenticated, oauth2Controller.token);

//Register all routes with /api
app.use('/api', router);

//Start the server
app.listen(8080);
console.log('Server running on port 8080');
