var app=angular.module("RAS");

app.controller("InterviewsPanel",function($scope,$rootScope,interviewDataService){
	$scope.getAllInterviews=function(){
		return $scope.interviews;
	}
	$scope.refreshAll=function(){
		interviewDataService.getAllInterviews(function(response){
			$scope.interviews=response.data;
		});
	};
	$scope.refreshAll();
	
	// Dummy jobs/interviews!
	// We will get some dummy data and show it in a table
	$scope.dummyJobs = null;
	$scope.dummyInterviews = null;
	interviewDataService.getDummyJobs(function(response) {
		$scope.dummyJobs = response.data;
	})
	interviewDataService.getDummyInterviews(function(response) {
		$scope.dummyInterviews = response.data;
		console.log("interviews: " + JSON.stringify(response.data));
	})
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		callback({data:[{client:"WalMart",info:"Dummy #"+Math.floor(Math.random()*100)},{client:"Tech Mahindra",info:"Dummy"}]});
	};
	
	this.getDummyJobs = function(callback) {
		$http.get('dummyJobs').then(callback);
	}
	
	this.getDummyInterviews = function(callback) {
		$http.get('dummyInterviews').then(callback);
	}
});