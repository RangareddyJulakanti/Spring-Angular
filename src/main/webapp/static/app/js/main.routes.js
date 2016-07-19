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
        .when('/users', {
            templateUrl : '/static/app/html/partial/users.html',
            controller : 'UserController'
        })
         .when('/users/add', {
            templateUrl : '/static/app/html/partial/addUser.html',
            controller : 'UserController'
        })
        .when('/users/edit/:id', {
            templateUrl : '/static/app/html/partial/addUser.html',
            controller : 'UserController'
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