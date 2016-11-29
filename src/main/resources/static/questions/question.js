var app=angular.module("RAS");

app.controller("QuestionPanel",function($scope, $rootScope, questionDataService){
	// Navbar highlighting
	$(".navSelected").removeClass("navSelected");
	$("#navQuestion").addClass("navSelected");
});

app.service("questionDataService", function($http, $rootScope) {
	
});