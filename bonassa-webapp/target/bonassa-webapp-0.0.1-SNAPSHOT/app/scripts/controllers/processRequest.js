'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:processRequestCtrl
 * @description # processRequestCtrl Controller of the webappApp
 */
angular.module('webappApp')
		.controller('processRequestCtrl', function($scope, $modal, processRequestFactory, parameterFactory, toaster) {

					$scope.request = {};
					
					$scope.$on('rightSidebar:updated', function(event, process) {
						$scope.process = process;
					});

					function defaultValues(){	
						$scope.tag = 'Lista de Pedidos do Processo nº ';
						$scope.showList = true;
						$scope.selectedRow = null;
						$scope.request = {
							askedDate : new Date(),
							lossProb : 1,
							lossProbPercentage : '25%',
							process : $scope.process
						};	
						processRequestFactory.ProcessRequestList($scope.process).then(function(data) {
							$scope.list = data.data;
							console.log($scope.list);
						});					
					};
					
					function init(){
						defaultValues();
							
						parameterFactory.getParameterById(43).then(function(data) {
							$scope.types = data.data.values;
							console.log($scope.types);
							
							parameterFactory.getParameterById(44).then(function(data) {
								$scope.statusList = data.data.values;
								console.log($scope.statusList);
							});
						});				
					};

					/*******MODAL********/

					var modal = $modal({
						scope : $scope,
						backdrop : 'static',
						template : 'views/processRequest/requestMain.html',
						show : false
					});

					$scope.showModal = function() {
						init();
						modal.$promise.then(modal.show);
					};
					
					$scope.exit = function() {
						modal.$promise.then(modal.hide);
					}
					
					/********************/
					
					$scope.setRadioToString = function() {
						$scope.request.lossProb = $scope.request.lossProb.toString();
					};
					
					$scope.setRadioToInteger = function() {
						$scope.request.lossProb = parseInt($scope.request.lossProb);
					};
					
					$scope.setClickedRow = function(index) {
						$scope.selectedRow = index;
					};
					
					$scope.setRequest = function(request){
						$scope.request = request;
						console.log($scope.request);
					};
					
					$scope.setUpdatedValue = function() {
						$scope.request.updatedValue = $scope.request.requestedValue	* $scope.request.initialInterest;
						console.log($scope.request);
					};

					$scope.setPercentage = function(request) {
						if ($scope.request.lossProb == 1)
							$scope.request.lossProbPercentage = "25%";
						else {
							if ($scope.request.lossProb == 2)
								$scope.request.lossProbPercentage = "50%";
							else{
								if ($scope.request.lossProb == 3)
									$scope.request.lossProbPercentage = "75%";
							}
						}
					};
					
					$scope.newRequest = function() {
						defaultValues();
						$scope.tag = 'Novo Pedido do Processo nº ';
						$scope.showList = false;
						$scope.update = false;//It's used to control processRequest (inclusion or update)
						$scope.view = false;
					};
					
					$scope.editRequest = function() {
						$scope.tag = 'Editar Pedido do Processo nº ';
						$scope.showList = false;
						$scope.update = true;//It's used to control processRequest (inclusion or update)
						$scope.view = false;
						$scope.setRadioToString();
					};
					
					$scope.viewRequest = function() {
						$scope.tag = 'Visualização do Pedido do Processo nº ';
						$scope.showList = false;
						$scope.view = true;
						$scope.setRadioToString();
					};

					$scope.cancel = function() {
						$scope.showList = true;
						defaultValues();
					};
					
					$scope.save = function(){
						
						$scope.setRadioToInteger();
						
						console.log($scope.update);				
						if(!$scope.update){
							console.log($scope.request);
							processRequestFactory.ProcessRequestNew($scope.request).success(function() {
								toaster.pop('success', "", "Pedido cadastrado com sucesso!");
								defaultValues();
							}).error(function() {
								toaster.pop('error', "", "Pedido não cadastrado!");
								defaultValues();
							});
						}
						else{
							if($scope.update){
								console.log($scope.request);
								processRequestFactory.ProcessRequestUpdate($scope.request).success(function() {
									toaster.pop('success', "", "Pedido atualizado com sucesso!");
									defaultValues();
								}).error(function() {
									toaster.pop('error', "", "Pedido não atualizado!");
									defaultValues();
								});
							}									
						}
					};
					
					$scope.datepickerOptions = {
			            format: 'dd-mm-yyyy',
			            language: 'pt',
//			            startDate: "2012-10-01",
//			            endDate: "2012-10-31",
			            autoclose: true,
			            weekStart: 0
			        };

				});