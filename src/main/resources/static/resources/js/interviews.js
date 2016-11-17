var app=angular.module("RAS");

app.controller("InterviewsPanel",function($scope,$rootScope,interviewDataService){
	$scope.getAllInterviews=function(){
		return $scope.interviews;
	}
	$scope.getAllJobs=function(){
		return $scope.jobs;
	}
	$scope.refreshAll=function(){
		interviewDataService.getAllInterviews(function(response){
			$scope.interviews=response.data;
			setTimeout(function(){
				$scope.interviewDataTable=$scope.interviewDataTable||$("#InterviewTable").DataTable();
				//$scope.interviewDataTable.draw();
			},1000);
		});
		interviewDataService.getAllJobs(function(response){
			$scope.jobs=response.data;
			setTimeout(function(){
				$scope.jobDataTable=$scope.jobDataTable||$("#dummyJobTable").DataTable();
				//$scope.jobDataTable.draw();
			},1000);
		});
	};
	$scope.refreshAll();
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		$http.get('interviews').then(callback);
	};
	
	this.getAllJobs = function(callback) {
		$http.get('jobs').then(callback);
	}
});