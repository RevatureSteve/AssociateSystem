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
		$("#dummyJobTable").DataTable();
	})
	interviewDataService.getDummyInterviews(function(response) {
		$scope.dummyInterviews = response.data;
		$("#dummyInterviewTable").DataTable();
	})
});

app.service("interviewDataService",function($http){
	this.getAllInterviews=function(callback){
		callback({
			data:[
				{
					interviewId:101,
					job:
					{
						jobId:101,
						account:
						{
							accountId:0,
							accountName:"ITC"
						},
						client:
						{
							clientId:0,
							clientName:"Walmart",
							clientAvgStartDate:null,
							clientAvgInterviewLength:null
						},
						status:
						{
							statusId:0,
							statusName:""
						},
						jobContractLength:null,
						jobTitle:"Jr. Java Developer"
					},
					user:{},
					interviewTime:null,
					interviewRound:1,
					interviewType:"",
					interviewFeedback:{}
				}
			]
		});
	};
	
	this.getDummyJobs = function(callback) {
		$http.get('dummyJobs').then(callback);
	}
	
	this.getDummyInterviews = function(callback) {
		$http.get('dummyInterviews').then(callback);
	}
});