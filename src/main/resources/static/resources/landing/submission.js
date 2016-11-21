var app=angular.module("RAS");

app.controller("SubmissionPanel",function($scope,$rootScope,submissionDataService){
	$scope.refreshAll=function(){
		submissionDataService.getAllSubmissions(function(response){
			$scope.submissions=response.data;
			$rootScope.lazilyInitializeDataTable("SubmissionTable");
		},
		function(){
			$rootScope.lazilyInitializeDataTable("SubmissionTable");
		});
	};
	$scope.refreshAll();
});

app.service("submissionDataService",function($http){
	this.getAllSubmissions=function(callback,fallback){
		$http.get('submissions').then(callback,fallback);
	};
});