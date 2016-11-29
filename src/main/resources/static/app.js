var app=angular.module("RAS",["ngRoute", "ui.bootstrap"]);

app.controller("MainController", function($scope, $rootScope, dataService){
	$rootScope.lazilyInitializeDataTable=function(id){
		setTimeout(function(){
			$("#"+id).DataTable();
		},0);
	}
});

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "dashboard/dashboard.html"
    })
    .when("/main", {
        templateUrl : "dashboard/dashboard.html"
    })
    .when("/question", {
        templateUrl : "questions/questions.html"
    });
});

app.service("dataService", function($http, $rootScope) {
});