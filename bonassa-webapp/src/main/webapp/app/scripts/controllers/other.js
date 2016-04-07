'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:OtherCtrl
 * @description # OtherCtrl Controller of the webappApp
 */
angular.module('webappApp').controller(
		'OtherCtrl', ['$scope', '$routeParams', '$location', 'parameterFactory', 'otherFactory', 'toaster',

			function($scope, $routeParams, $location, parameterFactory,	otherFactory, toaster) {

				$scope.states = [];
				$scope.cities = [];
				$scope.civilStatusList = [];
				$scope.tag = 'Novo Terceiro';
				$scope.other = {
						type : 'f',
						category : 'other'
				};
				
				init();
				
				function init(){
					if($routeParams.other != undefined){
						$scope.tag = 'Edição do Terceiro';
						$scope.other = $routeParams.other;
						console.log($scope.other);
						
						if($scope.other.state != null){
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
													
					if(path == "/other/new"){
						console.log($scope.other);
						otherFactory.NewOther($scope.other).success(function() {
							toaster.pop('success', "", "Terceiro cadastrado com sucesso!");
							returnTo();
						}).error(function() {
							toaster.pop('error', "", "Terceiro não cadastrado!");
							returnTo();
						});
					}
					else{
						if(path == "/other/edit"){
							console.log($scope.other);
							otherFactory.UpdateOther($scope.other).success(function() {
								toaster.pop('success', "", "Terceiro atualizado com sucesso!");
								$scope.exit();
							}).error(function() {
								toaster.pop('error', "", "Terceiro não atualizado!");
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
						$location.path("/other/list").search({});
				};							

			} ]);