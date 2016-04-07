'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:CustomerCtrl
 * @description # CustomerCtrl Controller of the webappApp
 */
angular
		.module('webappApp')
		.controller(
				'CustomerCtrl', 
				['$scope', '$routeParams', '$location', 'parameterFactory', 'customerFactory', 'toaster',

						function($scope, $routeParams, $location, parameterFactory,	customerFactory, toaster) {

							$scope.states = [];
							$scope.cities = [];
							$scope.civilStatusList = [];
							$scope.tag = 'Novo Cliente';
							$scope.customer = {
									type : 'f',
									category : 'customer'
							};
							
							init();
														
							function init(){
								if($routeParams.customer != undefined){
									$scope.tag = 'Edição do Cliente';
									$scope.customer = $routeParams.customer;
									console.log($scope.customer);
									
									if($scope.customer.state != null){
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
																
								if(path == "/customer/new"){
									console.log($scope.customer);
									customerFactory.NewCustomer($scope.customer).success(function() {
										toaster.pop('success', "", "Cliente cadastrado com sucesso!");
										returnTo();
									}).error(function() {
										toaster.pop('error', "", "Cliente não cadastrado!");
										returnTo();
									});
								}
								else{
									if(path == "/customer/edit"){
										console.log($scope.customer);
										customerFactory.UpdateCustomer($scope.customer).success(function() {
											toaster.pop('success', "", "Cliente atualizado com sucesso!");
											$scope.exit();
										}).error(function() {
											toaster.pop('error', "", "Cliente não atualizado!");
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
									$location.path("/customer/list").search({});
								
							};							

						} ]);
