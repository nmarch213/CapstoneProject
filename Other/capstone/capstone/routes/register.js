var express = require('express');
var router = express.Router();

//Get Register listing
router.get('/',function(req,res)
{
	res.send('Trying to connect to register');
});

module.exports = router;
