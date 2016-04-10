//Load Packages
var MatchDetails = require('../models/match_details');

exports.addMatch = function(req, res){
	var match = new MatchDetails();

	//set match properties
	match.match_id = req.body.match_id;
	match.team_one_name = req.body.team_one_name;
	match.team_two_name = req.body.team_two_name;
	match.team_one_score = req.body.team_one_score;
	match.team_two_score = req.body.team_two_score;
	match.match_date = req.body.match_date;
	match.match_league = req.body.match_league;

	//save match
	match.save(function(err){
		if(err) res.send(err);

//		res.json({message: 'Match Added', data:match});
	});

};

exports.getMatch = function(req, res){
	MatchDetails.find({match_id: req.body.match_id}, function(err, match){
		if(err) res.send(err);

		console.log(req.body.match_id);
		console.log(JSON.stringify(match, null, 2));
		//Success
		res.json(match);	
	});
};
