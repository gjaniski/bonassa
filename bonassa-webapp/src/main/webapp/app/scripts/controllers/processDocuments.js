'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ProcessdocumentsCtrl
 * @description # ProcessdocumentsCtrl Controller of the webappApp
 */
angular.module('webappApp').controller('processDocumentsCtrl',
		function($scope, $modal, processDocumentFactory) {

			$scope.document = {};
			
			$scope.$on('rightSidebar:updated', function(event, process) {
				$scope.process = process;
			});

			function defaultValues(){	
				$scope.tag = 'Lista de Documentos do Processo nº ';
				$scope.showList = true;
				$scope.selectedRow = null;
				$scope.document = {};				
			};
			
			function init(){
				defaultValues();
//				processDocumentFactory.ProcessDocumentList().success(function(data) {
					$scope.list = [{}];
//					console.log($scope.list);
//				});
			};
			
			/*******MODAL********/

			var modal = $modal({
				scope : $scope,
				backdrop : 'static',
				template : 'views/processDocument/documentMain.html',
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
			
			$scope.setClickedRow = function(index) {
				$scope.selectedRow = index;
			};
			
			$scope.setDocument = function(document){
				$scope.document = document;
			};
			
			$scope.newDocument = function() {
				console.log('Novo Documento');
			};
			
			$scope.viewDocument = function() {
				console.log('Visualizar Documento');
			};
			
			$scope.editDocument = function() {
				console.log('Editar Documento');
			};
		});
