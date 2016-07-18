
var app = angular.module('Application.controllers', []);


app.controller('ActivityController', function($scope, $location, $routeParams, activityService){
	$scope.init = function(){
		$scope.deletebt=true;
		$scope.activity = {};
		if($routeParams.id){
			activityService.getOne($routeParams.id)
			.success(function(data){
				$scope.activity = data;
			})
			.error(function(){
				alert('Greska Kod Ucitavanja Activitia')
			})
		}
	}
	$scope.getAll = function(){
		activityService.getAll($scope.search, $scope.page)
			.success(function(data, status, header){
				$scope.activities = data;
				$scope.totalPages = header('total-pages');
			})
			.error(function(){
				alert('Greska Kod Ucitavanja Activitia')
			})
	}
	
	$scope.remove = function(id){
		activityService.remove(id)
		.success(function(){
			$scope.getAll();
			})
			.error(function(){
				alert('Greska Kod Ucitavanja Activitia')
			})
	}
	
	$scope.save = function(){
		activityService.add($scope.activity)
		.success(function(data){
			$location.path('/activities')
			})
			.error(function(){
				alert('Greska Kod Ucitavanja Activitia')
			})
	}
	
});