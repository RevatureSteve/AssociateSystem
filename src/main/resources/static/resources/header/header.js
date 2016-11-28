var appHeader=angular.module("RAS");

appHeader.controller("HeaderPanel",function($scope,$rootScope){
	$rootScope.updateNavbarSelection=function(newSelection){
		$(".navSelected").removeClass("navSelected");
		$("#nav"+newSelection).addClass("navSelected");
	};
});