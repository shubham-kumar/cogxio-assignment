var app = angular.module('mainApp', ['ui.bootstrap','ngRoute']);
app.config(['$routeProvider',function($routeProvider){
	$routeProvider.when('/biding',{
	    title:'Map',
	    templateUrl:'gmap.html',
	    controller:'gmapCtrl'
	  }).when('/',{
			title: 'Home',
	        templateUrl: 'index.html',
	        controller: 'mainCtrl'
		});
}]);
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
  	function getAllPlaces() {
    	$http.get("api/GetAllPlaces").success(function (response) {
            $scope.places = response;
        });
	};
  	
}]);

app.controller('gmapCtrl',function($scope,$rootScope){
	
});