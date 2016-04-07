'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:userCtrl
 * @description # userCtrl Controller of the webappApp
 */
angular
		.module('webappApp')
		.controller(
				'UserCtrl', 
				['$scope', '$routeParams', '$location', 'parameterFactory', 'userFactory', 'toaster',

					function($scope, $routeParams, $location, parameterFactory,	userFactory, toaster) {

						$scope.states = [];
						$scope.cities = [];
						$scope.civilStatusList = [];
						$scope.tag = 'Novo Usuário';
						$scope.user = {
								groups : [{}]
						};
						
						$scope.groupList = [{
							name : 'Administrador(a)',
							id : 5
						},{
							name : 'Secretário(a)',
							id : 6							
						}];
						
						init();
						
						function init(){
							if($routeParams.user != undefined){
								$scope.tag = 'Edição do Usuário';
								$scope.user = $routeParams.user;
								for(var i = 0; i < $scope.user.groups.length; i++){
									$scope.user.groups[i].name = '';
								}
								console.log($scope.user);
								
								if($scope.user.state != null){
									parameterFactory.getParameterById(1).then(function(data) {
										$scope.cities = data.data.values;
									});
								}
							}
							parameterFactory.getParameterById(19).then(function(data) {
								$scope.states = data.data.values;
								console.log($scope.states);
								
								parameterFactory.getParameterById(51).then(function(data) {
									$scope.civilStatusList = data.data.values;
								});
							});								
						};
						
						$scope.formInvalid = false;
						$scope.verifyRequiredFields = function(param) {
							if(param == false)
								$scope.formInvalid = true;
							else{
								$scope.save();
							}
						}
						

						$scope.setCityList = function(){
							if($scope.cities.length == 0){
								parameterFactory.getParameterById(1).then(function(data) {
									$scope.cities = data.data.values;
								});
							}
						};
						
						$scope.save = function(){
							var path = $location.path();
															
							if(path == "/user/new"){
								console.log($scope.user);
								userFactory.NewUser($scope.user).success(function() {
									toaster.pop('success', "", "Usuário cadastrado com sucesso!");
//									$scope.user.id = data;
									$scope.exit();
								}).error(function() {
									toaster.pop('error', "", "Usuário não cadastrado!");
									$scope.exit();
								});
							}
							else{
								if(path == "/user/edit"){
									console.log($scope.user);
									userFactory.UpdateUser($scope.user).success(function() {
										toaster.pop('success', "", "Usuário atualizado com sucesso!");
										$scope.exit();
									}).error(function() {
										toaster.pop('error', "", "Usuário não atualizado!");
										$scope.exit();
									});
								}									
							}
//							$scope.exit($scope.user);
						};
						
						$scope.exit = function() {
							$location.path("/user/list").search({});
						};		

						$scope.addGroup = function() {
							$scope.user.groups.push('');
						};

						$scope.removeGroup = function(index) {
							$scope.user.groups.splice(index, 1);
						};

				} ]);