var app=angular.module("RAS",["ngRoute", "ui.bootstrap"]);

app.controller("MainController", function($scope, $rootScope, dataService){
	$scope.bob = null;
	$scope.goToMain = function() {
		dataService.goToMain(function(response) {
			$scope.bob = JSON.stringify(response);
		});
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
	this.goToMain = function(callback) {
		$http.get('home').then(callback);
	}
})