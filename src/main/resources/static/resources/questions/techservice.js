/**
 * 
 */
var app=angular.module("RAS");

app.service("techDataService",function($http) {
	this.getQuestions = function(callback){
		$http.get('getQuestions').then(callback);
	};
	this.getQuestionsByTrack = function(catName, callback) {
		
		var serializedData = $.param({catName : catName});	
	
		$http({
			  method: 'GET',
			  url: 'getQuestionsByTrack',
			  data : serializedData,
			  headers: {
			        'Content-Type': 'application/x-www-form-urlencoded'
			    }
			}).then(callback);
		
	}
	
});