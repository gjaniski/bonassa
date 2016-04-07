'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ParametersCtrl
 * @description # ParametersCtrl Controller of the webappApp
 */
angular.module('webappApp').controller(
		'ParametersCtrl',
		[
				'$scope',
				'parameterService',
				'parameterFactory',
				'$modal',
				'toaster',
				function($scope, parameterService, parameterFactory, $modal, toaster) {
					
					$scope.parameter = {};
					$scope.value = {};
					$scope.list = [];
					$scope.selectedRow = null;					
					
					init();
					
					function init(){
						parameterService.getParams().then(function(data) {
							$scope.list = data.data;
						});					
					};
					
					$scope.loadValues = function(param, index) {
						$scope.parameter = param;
						$scope.list2 = param.values;
						$scope.selectedRow = index;
						
						$scope.getParentValueList();
					};
					
					$scope.setClickedRow = function(index) {
						$scope.selectedRow2 = index;
					}

					/** ************************** */
					
					function defaultValues(){
						$scope.showList = true;
						$scope.tag = 'Lista de Valores do Parâmetro ';
						$scope.selectedRow2 = null;						
					};

					var myModal = $modal({
						scope : $scope,
						backdrop : 'static',
						template : 'views/parameter/parameterValueMain.html',
						show : false
					});

					$scope.showModal = function() {
						defaultValues();
						myModal.$promise.then(myModal.show);
					};

					$scope.exit = function() {
						myModal.$promise.then(myModal.hide);
					};

					/** ************************** */

					$scope.cancel = function() {
						$scope.showList = true;
					};
					
					$scope.setValue = function(value){
						$scope.value = {
							id : value.id,
							value : value.value
						};

						if(value.parent != null){
							$scope.value.parent = {
								id : value.parent.id
							};
						}
						console.log($scope.value);
					};
					
					$scope.getParentValueList = function(){
						$scope.parentValueList = [];
						if($scope.parameter.parent != undefined){
							for(var i = 0; i < $scope.list.length; i++){
								if($scope.parameter.parent.id == $scope.list[i].id){
									$scope.parentValueList = $scope.list[i].values;
									break;
								}
							}
						}
					};

					$scope.newValue = function() {
						$scope.value = {
							status : 1
						};
						$scope.tag = 'Novo Valor do Parâmetro: ';
						$scope.showList = false;
						$scope.update = false;
					};

					$scope.editValue = function() {
						$scope.tag = 'Editar Valor do Parâmetro: ';
						$scope.showList = false;
						$scope.update = true;
					};
					
					$scope.formInvalid = false;
					$scope.verifyRequiredFields = function(param) {
						console.log(param);
						if(param == false)
							$scope.formInvalid = true;
						else{
							$scope.save();
						}
					}
					
					$scope.save = function(){
															
						if(!$scope.update){
							parameterService.insertValue($scope.parameter, $scope.value).success(function() {
								toaster.pop('success', "", "Valor do parâmetro cadastrado com sucesso!");
							}).error(function() {
								toaster.pop('error', "", "Valor do parâmetro não cadastrado!");
							});
						}
						else{
							if($scope.update){
								parameterService.updateValue($scope.parameter, $scope.value).success(function() {
									toaster.pop('success', "", "Valor do parâmetro atualizado com sucesso!");
								}).error(function() {
									toaster.pop('error', "", "Valor do parâmetro não atualizado!");
								});
							}									
						}
						$scope.showList = true;
					};


				} ]).filter('status', function() {
					return function(status) {
						if (status === 1) {
							return 'Ativo';
						}
						return 'Inativo';
					}});
