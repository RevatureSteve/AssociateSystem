var app=angular.module("RAS");

app.controller("InterviewsPanel",function($scope,$rootScope,interviewDataService){
	$scope.refreshAll=function(){
		interviewDataService.getAllInterviews(function(response){
			$scope.interviews=response.data;
			$rootScope.lazilyInitializeDataTable("InterviewTable");
		});
	};
	$scope.refreshAll();
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		$http.get('interviews').then(callback);
	};
});