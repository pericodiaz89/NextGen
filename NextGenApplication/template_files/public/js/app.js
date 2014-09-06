//var url = 'http://127.0.0.1:8080/';
var url = 'http://nodejs-movamedellin.rhcloud.com/';
var app = angular.module('app', [
    'ngRoute',
    'controllers'
]);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeCtrl'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);

//Custom methods