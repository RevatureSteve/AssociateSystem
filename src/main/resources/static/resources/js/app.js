var app=angular.module("RAS",["ngRoute", "ui.bootstrap"]);

app.controller("MainController", function($scope, $rootScope, dataService){
	$rootScope.lazilyInitializeDataTable=function(id){
		setTimeout(function(){
			$("#"+id).DataTable();
		},1000);
	}
});

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "main.html"
    })
    .when("/main", {
        templateUrl : "main.html"
    });
});

app.service("dataService", function($http, $rootScope) {
});