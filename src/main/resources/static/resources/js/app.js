var app=angular.module("RAS",["ngRoute", "ui.bootstrap"]);

app.controller("MainController", function($scope, $rootScope, dataService){
});

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "main.html"
    })
    .when("/main", {
        templateUrl : "main.html"
    })
    .when("/question", {
        templateUrl : "question.html"
    });
});

app.service("dataService", function($http, $rootScope) {
});