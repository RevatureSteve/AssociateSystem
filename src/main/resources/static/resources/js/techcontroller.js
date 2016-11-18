/**
 * 
 */
var app=angular.module("RAS");

app.controller("techController", function($scope, techDataService){
	

	$scope.questions;
	
	$scope.things = "Yo";
	
	techDataService.getQuestions(function(response){
		console.log(response.data);
		$scope.questions = response.data;
	});
	
	$scope.getPostsByCategory = function(catName){
		if(catName === "Show all"){
			techDataService.getQuestions(function(response){
				console.log(response.data);
				$scope.questions = response.data;
			})
			
		} else{
			
			techDataService.getQuestionsByTrack(catName, function(response){
				$scope.questions = response.data;
				$scope.$apply();
			})
		}
		}
	
});