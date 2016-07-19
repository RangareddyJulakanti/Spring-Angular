var app = angular.module('Application.controllers', []);

app.controller('UserController', function($scope, $location, $routeParams,
		userService) {

	$scope.init = function() {
		$scope.deletebt = true;
		$scope.user = {};
		if ($routeParams.id) {
			userService.findOne($routeParams.id).success(
					function(data, status, headers) {
						$scope.user = data;
					}).error(function() {
				alert('Greska Kod Ucitavanja Usera')
			})
		}
	}

	$scope.getAll = function() {
		userService.getAll($scope.search, $scope.page).success(
				function(data, status, headers) {
					$scope.users = data;
					$scope.totalPages = headers('total-pages');
					$scope.totalElements = headers('total-elements');
				}).error(function() {
			$scope.glyph = true;
			$scope.moveAway = true;
		})
	}

	$scope.remove = function(id) {
		userService.remove(id).success(function() {
			$scope.getAll();
		}).error(function() {
			alert('Greska Kod Ucitavanja Usera')
		})
	}

	$scope.save = function() {
		userService.add($scope.user).success(function() {
			$location.path('/users')
		}).error(function() {
			alert('Greska Kod Ucitavanja Usera')
		})
	}

});

app.controller('ActivityController', function($scope, $location, $routeParams,
		activityService) {
	$scope.init = function() {
		$scope.deletebt = true;
		$scope.activity = {};
		if ($routeParams.id) {
			activityService.getOne($routeParams.id).success(function(data) {
				$scope.activity = data;
			}).error(function() {
				alert('Greska Kod Ucitavanja Activitia')
			})
		}
	}
	$scope.getAll = function() {
		activityService.getAll($scope.search, $scope.page).success(
				function(data, status, header) {
					$scope.activities = data;
					$scope.totalPages = header('total-pages');
					$scope.totalElements = header('total-elements');
				}).error(function() {
			$scope.glyph = true;
			$scope.moveAway = true;
		})
	}

	$scope.remove = function(id) {
		activityService.remove(id).success(function() {
			$scope.getAll();
		}).error(function() {
			alert('Greska Kod Ucitavanja Activitia')
		})
	}

	$scope.save = function() {
		activityService.add($scope.activity).success(function(data) {
			$location.path('/activities')
		}).error(function() {
			alert('Greska Kod Ucitavanja Activitia')
		})
	}

});