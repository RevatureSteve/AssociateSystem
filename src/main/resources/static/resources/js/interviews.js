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
				var toBeRemoved=$("#dataTables_empty").parentElement;
				if(toBeRemoved){
					toBeRemoved.parentElement.remove(toBeRemoved);
				}
				$("#InterviewTable").DataTable();
			},1000);
		});
		interviewDataService.getAllJobs(function(response){
			$scope.jobs=response.data;
			$("#dummyJobTable").DataTable();
		});
	};
	$scope.refreshAll();
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		$http.get('dummyInterviews').then(callback);
	};
	
	this.getAllJobs = function(callback) {
		$http.get('jobs').then(callback);
	}
});