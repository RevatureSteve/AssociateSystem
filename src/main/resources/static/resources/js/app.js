var app=angular.module("RAS",["ngRoute"]);

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
        templateUrl : "login.html"
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