'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:processPropertyCtrl
 * @description # processPropertyCtrl Controller of the webappApp
 */
angular.module('webappApp').controller(
		'processPropertyCtrl',
		function($scope, $modal, processPropertyFactory, parameterFactory, toaster) {

			$scope.property = {};
			
			$scope.$on('rightSidebar:updated', function(event, process) {
				$scope.process = process;
			});

			function defaultValues(){	
				$scope.tag = 'Lista de Bens do Processo nº ';
				$scope.showList = true;
				$scope.selectedRow = null;
				$scope.property = {
						type : 'veículo',
						process : $scope.process
				};			
				processPropertyFactory.ProcessPropertyList($scope.process).then(function(data) {
					$scope.list = data.data;
					console.log($scope.list);					
				});
			};
			
			function init(){
				defaultValues();
					
				parameterFactory.getParameterById(45).then(function(data) {
					$scope.statusList = data.data.values;
					console.log($scope.statusList);

					parameterFactory.getParameterById(46).then(function(data) {
						$scope.vehicleBrands = data.data.values;
						console.log($scope.vehicleBrands);

						parameterFactory.getParameterById(47).then(function(data) {
							$scope.vehicleModels = data.data.values;
							console.log($scope.vehicleModels);

							parameterFactory.getParameterById(48).then(function(data) {
								$scope.vehicleColors = data.data.values;
								console.log($scope.vehicleColors);

								parameterFactory.getParameterById(49).then(function(data) {
									$scope.depositTypes = data.data.values;
									console.log($scope.depositTypes);
								});
							});
						});
					});
				});	
			};
			
			/*******MODAL********/

			var modal = $modal({
				scope : $scope,
				backdrop : 'static',
				template : 'views/processProperty/propertyMain.html',
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

			$scope.controlVehicleModelList = function() {
				$scope.vehicleModelList = true;
			};

			$scope.setClickedRow = function(index) {
				$scope.selectedRow = index;
			};
			
			$scope.setProperty = function(property){
				$scope.property = property;
			};
			
			$scope.newProperty = function() {
				defaultValues();
				$scope.tag = 'Novo Bem do Processo nº ';
				$scope.showList = false;
				$scope.update = false;//It's used to control processProperty (inclusion or update)
				$scope.view = false;
			};
			
			$scope.editProperty = function() {
				$scope.tag = 'Editar Bem do Processo nº ';
				$scope.showList = false;
				$scope.update = true;//It's used to control processProperty (inclusion or update)
				$scope.view = false;
			};
			
			$scope.viewProperty = function() {
				$scope.tag = 'Visualização do Bem do Processo nº ';
				$scope.showList = false;
				$scope.view = true;
			};

			$scope.cancel = function() {
				$scope.showList = true;
				defaultValues();
			};
			
			$scope.save = function(){
								
				console.log($scope.update);				
				if(!$scope.update){
					console.log($scope.property);
					processPropertyFactory.ProcessPropertyNew($scope.property).success(function() {
						toaster.pop('success', "", "Bem cadastrado com sucesso!");
						defaultValues();
					}).error(function() {
						toaster.pop('error', "", "Bem não cadastrado!");
						defaultValues();
					});
				}
				else{
					if($scope.update){
						console.log($scope.property);
						 processPropertyFactory.ProcessPropertyUpdate($scope.property).success(function() {
							toaster.pop('success', "", "Bem atualizada com sucesso!");
							defaultValues();
						}).error(function() {
							toaster.pop('error', "", "Bem não atualizado!");
							defaultValues();
						});
					}									
				}
			};

		}).filter('vehicleModelFilter', function() {
			return function(input, property) {
				var i;
				var vehicleModels = [];
								
				if (input != null) {
					if (property.brand != null) {
						for (i = 0; i < input.length; i++) {
							if (input[i].parent.id === property.brand.id)
								vehicleModels.push(input[i]);
						}
					} else {
						vehicleModels = [];
					}
				}
		
				return vehicleModels;
			}
		});
