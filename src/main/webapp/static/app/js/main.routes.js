var app = angular.module('Application.routes', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/activities', {
            templateUrl : '/static/app/html/partial/activity.html',
            controller : 'ActivityController'
        })
         .when('/activities/add', {
            templateUrl : '/static/app/html/partial/addActivity.html',
            controller : 'ActivityController'
        })
         .when('/activities/edit/:id', {
            templateUrl : '/static/app/html/partial/addActivity.html',
            controller : 'ActivityController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);