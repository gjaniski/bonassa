'use strict';

/**
 * @ngdoc overview
 * @name webappApp
 * @description # webappApp
 * 
 * Main module of the application.
 */
angular
		.module(
				'webappApp',
				[ 'ngAnimate',
				  'ngCookies',
				  'ngResource',
				  'ngRoute',
				  'ngSanitize',
				  'ngTouch',
				  'mgcrea.ngStrap',
				  'smart-table',
				  'restangular',
				  'ng-bootstrap-datepicker', 'toaster'])
		.config(function($routeProvider, $httpProvider) {
			$routeProvider
			  .when('/home', {
				templateUrl : 'views/home/home.html',
				controller : 'MainCtrl',
				allowAnonymous : false
			}).when('/process/list', {
				templateUrl : 'views/process/processList.html',
				controller : 'ProcessListCtrl',
				allowAnonymous : false
			}).when('/process/new', {
				templateUrl : 'views/process/process.html',
				controller : 'ProcessCtrl',
				allowAnonymous : false
			}).when('/process/edit', {
				templateUrl : 'views/process/process.html',
				controller : 'ProcessCtrl',
				allowAnonymous : false
			}).when('/process/view', {
				templateUrl : 'views/process/process.html',
				controller : 'ProcessViewCtrl',
				allowAnonymous : false
			}).when('/customer/list', {
				templateUrl : 'views/customer/customerList.html',
				controller : 'CustomerListCtrl',
				allowAnonymous : false
			}).when('/customer/new', {
				templateUrl : 'views/customer/customer.html',
				controller : 'CustomerCtrl',
				allowAnonymous : false
			}).when('/customer/edit', {
				templateUrl : 'views/customer/customer.html',
				controller : 'CustomerCtrl',
				allowAnonymous : false
			}).when('/customer/view', {
				templateUrl : 'views/customer/customer.html',
				controller : 'CustomerViewCtrl',
				allowAnonymous : false
			}).when('/opponent/list', {
				templateUrl : 'views/opponent/opponentList.html',
				controller : 'OpponentListCtrl',
				allowAnonymous : false
			}).when('/opponent/new', {
				templateUrl : 'views/opponent/opponent.html',
				controller : 'OpponentCtrl',
				allowAnonymous : false
			}).when('/opponent/edit', {
				templateUrl : 'views/opponent/opponent.html',
				controller : 'OpponentCtrl',
				allowAnonymous : false
			}).when('/opponent/view', {
				templateUrl : 'views/opponent/opponent.html',
				controller : 'OpponentViewCtrl',
				allowAnonymous : false
			}).when('/other/list', {
				templateUrl : 'views/other/otherList.html',
				controller : 'OtherListCtrl',
				allowAnonymous : false
			}).when('/other/new', {
				templateUrl : 'views/other/other.html',
				controller : 'OtherCtrl',
				allowAnonymous : false
			}).when('/other/edit', {
				templateUrl : 'views/other/other.html',
				controller : 'OtherCtrl',
				allowAnonymous : false
			}).when('/other/view', {
				templateUrl : 'views/other/other.html',
				controller : 'OtherViewCtrl',
				allowAnonymous : false
			}).when('/user/list', {
				templateUrl : 'views/user/userList.html',
				controller : 'UserListCtrl',
				allowAnonymous : false
			}).when('/user/new', {
				templateUrl : 'views/user/user.html',
				controller : 'UserCtrl',
				allowAnonymous : false
			}).when('/user/edit', {
				templateUrl : 'views/user/user.html',
				controller : 'UserCtrl',
				allowAnonymous : false
			}).when('/user/view', {
				templateUrl : 'views/user/user.html',
				controller : 'UserViewCtrl',
				allowAnonymous : false
			}).when('/reports', {
				templateUrl : 'views/report/reports.html',
				controller : 'ReportsCtrl',
				allowAnonymous : false
			}).when('/reports/advanced', {
				templateUrl : 'views/report/reportsAdvanced.html',
				controller : 'ReportsAdvancedCtrl',
				allowAnonymous : false
			}).when('/parameter/list', {
				templateUrl : 'views/parameter/parameterList.html',
				controller : 'ParametersCtrl',
				allowAnonymous : false
			}).when('/login', {
				templateUrl : 'views/login.html',
				controller : 'LoginCtrl',
				allowAnonymous : true
			}).otherwise({
				redirectTo : '/home'
			});
			
			$httpProvider.defaults.useXDomain = true;

		})
		.run(
			function($location, $rootScope, $log, authService, $route,
					SessionService) {

				function handleRouteChangeStart(event, next, current) {

					if ((next.allowAnonymous)
							&& (!authService.isAuthoraized())) {

						console
								.log('Autenticação Requerida. Redirecionado para Login');

						event.preventDefault();
					}

				}

				$rootScope.$on('$routeChangeStart', handleRouteChangeStart);

			})
			.filter('paginationFilter', function() {
			return function(input, start) {
				if (!input || !input.length) {
					return;
				}
				start = +start;
				return input.slice(start);
			}
			})
			.filter('cityFilter', function() {
				return function(input, param) {
					var i;
					var cities = [];
	
					if (input != null) {
						if (param.state != null) {
							for (i = 0; i < input.length; i++) {
								if(input[i].parent != null){
									if (input[i].parent.id === param.state.id)
										cities.push(input[i]);
								}
							}
						} else {
							cities = input;
						}
					}
	
					return cities;
				}
			});
