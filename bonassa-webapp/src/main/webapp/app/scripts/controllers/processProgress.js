'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ProcessprogressCtrl
 * @description
 * # ProcessprogressCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('processProgressCtrl',
			function($scope, $rootScope, $modal, $controller, userFactory, parameterFactory, processOnGoingFactory, toaster) {
		
		$scope.progress = {};
		$scope.formInvalid = false;
		
		$scope.$on('rightSidebar:updated', function(event, process) {
			$scope.process = process;
		});
		
		function defaultValues(){	
			$scope.tag = 'Lista de Andamentos do Processo nº ';
			$scope.showList = true;
			$scope.selectedRow = null;
			$scope.progress = {
				owners : [{}],
				showRepoClient : false,
				sendEmail : false,
				process : $scope.process
			};			

			processOnGoingFactory.ProcessOnGoingList($scope.process).then(function(data) {
				$scope.list = data.data;
				console.log($scope.list);
			});
		};
		
		function init(){
			defaultValues();
				
			parameterFactory.getParameterById(31).then(function(data) {
				$scope.actions = data.data.values;
				
				parameterFactory.getParameterById(32).then(function(data) {
					$scope.phases = data.data.values;
					
					userFactory.UserList().then(function(data) {
						$scope.owners = data.data;
					});
				});
			});	
		};
			
		
		/** *********MODAL**************** */
		
		var modal = $modal({
			scope : $scope,
			backdrop : 'static',
			template : 'views/processProgress/progressMain.html',
			show : false
		});

		$scope.showModal = function() {
			init();
			modal.$promise.then(modal.show);
		};
		
		$scope.exit = function() {
			modal.$promise.then(modal.hide);
		}
		
		/** ************************* */
		
		$scope.setClickedRow = function(index) {
			$scope.selectedRow = index;
		};
		
		$scope.setProgress = function(progress){
			$scope.progress = progress;
		};

		$scope.newProgress = function() {
			defaultValues();
			$scope.tag = 'Novo Andamento do Processo nº ';
			$scope.showList = false;
			$scope.update = false;//It's used to control processProgress (inclusion or update)
			$scope.view = false;
		};
		
		$scope.editProgress = function() {
			$scope.tag = 'Editar Andamento do Processo nº ';
			$scope.showList = false;
			$scope.update = true;//It's used to control processProgress (inclusion or update)
			$scope.view = false;
		};
		
		$scope.viewProgress = function() {
			$scope.tag = 'Visualização do Andamento do Processo nº ';
			$scope.showList = false;
			$scope.view = true;
		};

		$scope.cancel = function() {
			$scope.showList = true;
			defaultValues();
		};
		
		$scope.addOwner = function() {
			$scope.progress.owners.push('');
		};

		$scope.removeOwner = function(index) {
			$scope.progress.owners.splice(index, 1);
		};
		
		$scope.verifyRequiredFields = function(param) {
			if(param == false)
				$scope.formInvalid = true;
			else{
				$scope.save();
			}
		}
		
		$scope.save = function(){
			console.log($scope.update);				
			if(!$scope.update){
				console.log($scope.progress);
				processOnGoingFactory.ProcessOnGoingNew($scope.progress).success(function() {
					toaster.pop('success', "", "Andamento cadastrado com sucesso!");
					defaultValues();
				}).error(function() {
					toaster.pop('error', "", "Andamento não cadastrado!");
					defaultValues();
				});
			}
			else{
				if($scope.update){
					console.log($scope.progress);
					processOnGoingFactory.ProcessOnGoingUpdate($scope.progress).success(function() {
						toaster.pop('success', "", "Andamento atualizado com sucesso!");
						defaultValues();
					}).error(function() {
						toaster.pop('error', "", "Andamento não atualizado!");
						defaultValues();
					});
				}									
			}
		};

	});