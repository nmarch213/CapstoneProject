//Load Packages
var mongoose = require('mongoose');


//Define the Schema
var MatchDetailSchema = new mongoose.Schema({
	match_id:{
                type: Number,
                unique: true,
                required: true
        },
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
                type: Number,
                unique: false,
                required: true
        },
	team_two_score:{
                type: Number,
                unique: false,
                required: true
        },
	match_date:{
                type: String,
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
