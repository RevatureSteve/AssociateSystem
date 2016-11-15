var app=angular.module("RAS",["ngRoute"]);

app.controller("MainController",function($scope,$rootScope){
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