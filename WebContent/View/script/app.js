﻿var app = angular.module('mainApp', ['ui.bootstrap']);
app.filter('orderByRating', function(){
	return function(input, attribute) {
		var array = [];
		for(var objectKey in input) {
			array.push(input[objectKey]);
		}
		array.sort(function(a, b){
			a = parseFloat(a[attribute]);
			b = parseFloat(b[attribute]);
			return b - a;
		});
		return array;
	}
});
app.controller('mainCtrl', ['$scope', '$http','$location' , function ($scope, $http,$location) {
	console.log('mainctrl');
	$http.get("api/GetTotalPlace").success(function (response) {
		$scope.totalPlace = response;
	});
	getAllPlaces();

	$http.get("api/AllNameCategory").success(function (response) {
		$scope.allNameCatgs = response;
	});
	$scope.$watch('searchValue',function(){
		if($scope.searchValue == "")
			getAllPlaces();
	});
	$scope.setSearchData = function() {
		$http.get("api/PlaceByNameCategory/"+$scope.searchValue).success(function (response) {
			$scope.places = response;
		});
	};
	$scope.isChecked = false;
	$scope.isSort = function(){
		if(!$scope.isChecked)
			$scope.sortBy = 'rating';
		else
			$scope.sortBy = '';
		$scope.isChecked = !$scope.isChecked;
	}
	function getAllPlaces() {
		$http.get("api/GetAllPlaces").success(function (response) {
			$scope.places = response;
		});
	};

}]);