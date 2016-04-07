'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ReportsCtrl
 * @description # ReportsCtrl Controller of the webappApp
 */
angular.module('webappApp').controller('ReportsCtrl', function($scope, $location) {

	$scope.selected = {
		type : 'simple',
	};
	
	$scope.selectedNew = function(selected) {
			switch (selected.type) {
		    case 'simple':
		    	console.log("Processos Simples selecionado");
		    	break;
		    case 'advanced':
				$location.path("/reportsAdvanced");
				break;
		    case 'onGoing':
				console.log("Andamentos selecionado");
				break;
		    case 'compromisses':
				console.log("Pauta de Compromissos Processuais selecionado");	 
				break;
		    case 'tasks':
				console.log("Tarefas Extraconjugais selecionado");	 
				break;
		    case 'customers':
				console.log("Clientes selecionado");	 
				break;
		    case 'opponents':
				console.log("Lista de Partes Adversas selecionado");	 
				break;
		    case 'properties':
				console.log("Bens selecionado");	 
				break;
		    case 'requests':
				console.log("Pedidos selecionado");	 
				break;
		}
	};
	
	$scope.typeRadioOne = (typeof $scope.selected.status);
	$scope.radioOne = function(selected) {
		$scope.typeRadioOne = (typeof $scope.selected.status);
		return selected === $scope.selected.status;
	}
});
