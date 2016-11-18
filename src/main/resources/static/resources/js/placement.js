var app=angular.module("RAS");

app.controller("PlacementPanel",function($scope,$rootScope,placementDataService){
	$scope.refreshAll=function(){
		submissionDataService.getAllPlacements(function(response){
			$scope.placements=response.data;
			$rootScope.lazilyInitializeDataTable("PlacementTable");
		},
		function(){
			$rootScope.lazilyInitializeDataTable("PlacementTable");
		});
	};
	$scope.refreshAll();
});

app.service("placementDataService",function($http){
	this.getAllPlacements=function(callback,fallback){
		$http.get('submissions').then(callback,fallback);
	};
});