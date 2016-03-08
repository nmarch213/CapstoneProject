//Load Packages
var mongoose = require('mongoose');


//Define the Schema
var MatchDetailSchema = new mongoose.Schema({
	team_one_name:{
                type: String,
                unique: false,
                required: true
        },
	team_two_name:{
                type: String,
                unique: false,
                required: true
        },
	team_one_score:{
                type: String,
                unique: false,
                required: true
        },
	team_two_score:{
                type: String,
                unique: false,
                required: true
        },
	match_id:{
                type: String,
                unique: true,
                required: true
        },
	match_date:{
                type: Date,
                unique: false,
                required: true
        },
	match_league:{
                type: String,
                unique: false,
                required: true
        }
});

//Export the Mongoose Model
module.exports = mongoose.model('MatchDetails', MatchDetailSchema);
