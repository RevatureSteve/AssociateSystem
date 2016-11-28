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
        templateUrl : "home.html"
    })
    .when("/main", {
        templateUrl : "home.html"
    })
    .when("/question", {
        templateUrl : "question.html"
    });
});

app.service("dataService", function($http, $rootScope) {
});