var express = require('express');
var router = express.Router();

//Get login Listening

router.get('/', function(req,res)
{
	res.send('Get Request for Login');
});

module.exports = router;
