'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OpponentCtrl
 * @description # OpponentCtrl Controller of the webappApp
 */
angular
		.module('webappApp')
		.controller(
				'OpponentCtrl',
				['$scope', '$location',	'$routeParams',	'parameterFactory', 'opponentFactory', 'toaster',
				  function($scope, $location, $routeParams, parameterFactory, opponentFactory, toaster) {

							$scope.states = [];
							$scope.cities = [];
							$scope.civilStatusList = [];
							$scope.tag = 'Nova Parte Adversa';
							$scope.opponent = {
									type : 'f',
									category : 'opponent'
							};
							
							init();
							
							function init(){
								if($routeParams.opponent != undefined){
									$scope.tag = 'Edição da Parte Adversa';
									$scope.opponent = $routeParams.opponent;
									console.log($scope.opponent);
									
									if($scope.opponent.state != null){
										parameterFactory.getParameterById(1).then(function(data) {
											$scope.cities = data.data.values;
										});
									}
								}
								parameterFactory.getParameterById(19).then(function(data) {
									$scope.states = data.data.values;									
										
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
																
								if(path == "/opponent/new"){
									console.log($scope.opponent);
									opponentFactory.NewOpponent($scope.opponent).success(function() {
										toaster.pop('success', "", "Parte Adversa cadastrada com sucesso!");
										returnTo();
									}).error(function() {
										toaster.pop('error', "", "Parte Adversa não cadastrada!");
										returnTo();
									});
								}
								else{
									if(path == "/opponent/edit"){
										console.log($scope.opponent);
										opponentFactory.UpdateOpponent($scope.opponent).success(function() {
											toaster.pop('success', "", "Parte Adversa atualizada com sucesso!");
											$scope.exit();
										}).error(function() {
											toaster.pop('error', "", "Parte Adversa não atualizada!");
											$scope.exit();
										});
									}									
								}
							};
							
							function returnTo(){

								if($routeParams.process != undefined){
									$location.path("/process/new").search({
										newProcess : $routeParams.process
									});
								}
								else
									$scope.exit();
								
							};
							
							$scope.exit = function() {
								
								if($routeParams.process != undefined){
									$location.path("/process/new").search({
										newProcess : $routeParams.process
									});
								}
								else
									$location.path("/opponent/list").search({});
								
							};

						}]);