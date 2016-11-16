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
});