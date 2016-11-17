var app=angular.module("RAS");

app.controller("InterviewsPanel",function($scope,$rootScope,interviewDataService){
	$scope.getAllInterviews=function(){
		return $scope.interviews;
	}
	$scope.refreshAll=function(){
		interviewDataService.getAllInterviews(function(response){
			$scope.interviews=response.data;
			setTimeout(function(){
				$scope.interviewDataTable=$scope.interviewDataTable||$("#InterviewTable").DataTable();
				//$scope.interviewDataTable.draw();
			},1000);
		});
	};
	$scope.refreshAll();
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		$http.get('interviews').then(callback);
	};
});