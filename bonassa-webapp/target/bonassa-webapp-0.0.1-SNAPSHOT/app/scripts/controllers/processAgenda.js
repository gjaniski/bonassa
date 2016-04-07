'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:processAgendaCtrl
 * @description # processAgendaCtrl Controller of the webappApp
 */
angular.module('webappApp').controller(
		'processAgendaCtrl',
		function($scope, $modal, processAgendaFactory, parameterFactory, userFactory, toaster) {
			
			$scope.appointment = {};
			
			$scope.$on('rightSidebar:updated', function(event, process) {
				$scope.process = process;
			});

			function defaultValues(){	
				$scope.tag = 'Lista de Compromissos do Processo nº ';
				$scope.showList = true;
				$scope.selectedRow = null;
				$scope.appointment = {
					owners : [{}],
					date : new Date(),
					hasTerm : false,
					hearing : false,
					providence : false,
					emailAlert : false,
					remember : false,
					progressReleased : false,
					status : '1',
					process : $scope.process
				};	
				processAgendaFactory.ProcessAgendaList($scope.process).then(function(data) {
					$scope.list = data.data;
					console.log($scope.list);
				});			
			};
			
			function init(){
				defaultValues();

				userFactory.UserList().then(function(data) {
					$scope.owners = data.data;
					console.log($scope.owners);
					
					parameterFactory.getParameterById(42).then(function(data) {
						$scope.types = data.data.values;
						console.log($scope.types);
						
						parameterFactory.getParameterById(23).then(function(data) {
							$scope.notaries = data.data.values;
							
							parameterFactory.getParameterById(19).then(function(data) {
								$scope.states = data.data.values;
								console.log($scope.states);
								
								parameterFactory.getParameterById(1).then(function(data) {
									$scope.cities = data.data.values;
									console.log($scope.cities);
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
				template : 'views/processAgenda/appointmentMain.html',
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
				$scope.appointment.status = $scope.appointment.status.toString();
			};
			
			$scope.setRadioToInteger = function() {
				$scope.appointment.status = parseInt($scope.appointment.status);
			};
			
			$scope.setClickedRow = function(index) {
				$scope.selectedRow = index;
			};
			
			$scope.setAppointment = function(appointment){
				$scope.appointment = appointment;
			};
			
			$scope.newAppointment = function() {
				defaultValues();
				$scope.tag = 'Novo Compromisso do Processo nº ';
				$scope.showList = false;
				$scope.update = false;//It's used to control processAgenda (inclusion or update)
				$scope.view = false;
			};
			
			$scope.editAppointment = function() {
				$scope.tag = 'Editar Compromisso do Processo nº ';
				$scope.showList = false;
				$scope.update = true;//It's used to control processAgenda (inclusion or update)
				$scope.view = false;
				$scope.setRadioToString();
			};
			
			$scope.viewAppointment = function() {
				$scope.tag = 'Visualização do Compromisso do Processo nº ';
				$scope.showList = false;
				$scope.view = true;
				$scope.setRadioToString();
			};

			$scope.cancel = function() {
				$scope.showList = true;
				defaultValues();
			};
			
			$scope.addOwner = function() {
				$scope.appointment.owners.push('');
			};

			$scope.removeOwner = function(index) {
				$scope.appointment.owners.splice(index, 1);
			};
			
			$scope.formInvalid = false;
			$scope.verifyRequiredFields = function(param) {
				if(param == false)
					$scope.formInvalid = true;
				else{
					$scope.save();
				}
			}
			
			$scope.save = function(){
				
				$scope.setRadioToInteger();
				
				console.log($scope.update);				
				if(!$scope.update){
					console.log($scope.appointment);
					processAgendaFactory.ProcessAgendaNew($scope.appointment).success(function() {
						toaster.pop('success', "", "Compromisso cadastrado com sucesso!");
						defaultValues();
					}).error(function() {
						toaster.pop('error', "", "Compromisso não cadastrado!");
						defaultValues();
					});
				}
				else{
					if($scope.update){
						console.log($scope.appointment);
						processAgendaFactory.ProcessAgendaUpdate($scope.appointment).success(function() {
							toaster.pop('success', "", "Compromisso atualizado com sucesso!");
							defaultValues();
						}).error(function() {
							toaster.pop('error', "", "Compromisso não atualizado!");
							defaultValues();
						});
					}									
				}
			};
			
			$scope.datepickerOptions = {
	            format: 'dd-mm-yyyy',
	            language: 'pt',
//	            startDate: "2012-10-01",
//	            endDate: "2012-10-31",
	            autoclose: true,
	            weekStart: 0
	        };
		});
