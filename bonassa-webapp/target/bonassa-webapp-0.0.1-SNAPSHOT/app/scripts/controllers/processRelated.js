'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:processRelatedCtrl
 * @description # processRelatedCtrl Controller of the webappApp
 */
angular.module('webappApp').controller(
		'processRelatedCtrl',
		function($scope, $modal, processRelatedFactory, toaster) {

			$scope.related = {};
			
			$scope.$on('rightSidebar:updated', function(event, process, processList) {
				$scope.process = process;
				$scope.list2 = processList;
			});

			function defaultValues(){	
				$scope.tag = 'Lista de Apensos do Processo nº ';
				$scope.showList = true;
				$scope.selectedRow = null;
				$scope.selectedRow2 = null;
				$scope.related = {
					process : $scope.process
				};
				$scope.processAttached = {};
			};
			
			function init(){
				defaultValues();
				processRelatedFactory.ProcessRelatedList($scope.process).then(function(data) {
					$scope.list = data.data;
					console.log($scope.list);	

					for(var i = 0; i < $scope.list.length; i++){
						for(var j = 0; j < $scope.list2.length; j++){
							if($scope.list[i].childProcess.id == $scope.list2[j].id){
								$scope.list[i].childProcess = $scope.list2[j];
								break;
							}
						}
					}
					
					console.log($scope.list);
				});
			};
			
			/*******MODAL********/

			var modal = $modal({
				scope : $scope,
				backdrop : 'static',
				template : 'views/processRelated/relatedMain.html',
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
			
			$scope.cancel = function() {
				$scope.showList = true;
				defaultValues();
			};
			
			$scope.setClickedRow = function(index) {
				$scope.selectedRow = index;
			};
			
			$scope.setClickedRow2 = function(index) {
				$scope.selectedRow2 = index;
			};
			
			$scope.setRelated = function(related){
				$scope.related = related;
			};
			
			$scope.setProcessAttached = function(process){
				$scope.processAttached = process;
			};			
			
			$scope.getProcessList = function() {
				ProcessFactory.ProcessList().then(function(data) {
					$scope.list2 = data.data;
					console.log($scope.list2);
				});
			};
			
			$scope.newRelated = function() {
				defaultValues();
				$scope.tag = 'Novo Apenso do Processo nº ';
				$scope.showList = false;
			};			
			
			$scope.save = function(){
				processRelatedFactory.ProcessRelatedNew($scope.process, $scope.processAttached).success(function() {
					toaster.pop('success', "", "Apenso cadastrado com sucesso!");
				}).error(function() {
					toaster.pop('error', "", "Apenso não cadastrado!");
				});
				defaultValues();
			};
			

			$scope.deleteRelated = function(){
				processRelatedFactory.ProcessRelatedDelete($scope.related).success(function() {
					toaster.pop('success', "", "Apenso excluído com sucesso!");
				}).error(function() {
					toaster.pop('error', "", "Apenso não excluído!");
				});
				defaultValues();
			};

		});
