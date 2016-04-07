'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ReportsadvancedCtrl
 * @description
 * # ReportsadvancedCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('ReportsAdvancedCtrl', function ($scope, parameterFactory, customerFactory, $location) {
	  	
	  	$scope.reportAdvanced = {
	  			form : 'summary',
	  			onGoing : 'all',
	  			vinculatedProcessList : false,
	  			requestsList : false,
	  			groupProcess : false,
	  			onlyOriginalProcess : false,
	  			othersList : false,
	  			opponentsList : false,
	  			customersList : false,
	  			instance : 'first',
	  			status : 'active',
	  			lossProb : 'remote',
	  			endResult : 'victory',
	  			printingType : 'paper',
	  			researchType : 'normal',
	  	};
	  		  	
	  	/*******************************************/
	  	
	  	$scope.last = false;
	  
		$scope.radioOne = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.form;
		}
		
		$scope.radioTwo = function(reportAdvanced) {
			$scope.last = false;
			$scope.setAmountLast = null;
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.onGoing;
		}
		
		$scope.controlLast = function() {
			$scope.last = true;
		};
		
		$scope.setLast = function() {
			$scope.reportAdvanced.onGoing = $scope.setAmountLast;
			console.log($scope.reportAdvanced);
		};
		
		$scope.checkBoxOne = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.vinculatedProcessList;
		}
		
		$scope.checkBoxTwo = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.requestsList;
		}
		
		$scope.checkBoxThree = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.groupProcess;
		}
		
		$scope.checkBoxFour = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.onlyOriginalProcess;
		}
		
		$scope.checkBoxFive = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.othersList;
		}
		
		$scope.checkBoxSix = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.opponentsList;
		}
		
		$scope.checkBoxSeven = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.customersList;
		}
		
		/*******************************************/	
		
		parameterFactory.getParameterById(19).success(function(data) {
			$scope.states = data.values;
		});
		
		parameterFactory.getParameterById(22).success(function(data) {
			$scope.counties = data.values;
		});
				
		$scope.checkBoxEight = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.sentence;
		}
		
		$scope.checkBoxNine = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.acordao;
		}
		
		$scope.checkBoxTen = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.transit;
		}
		
		$scope.checkBoxEleven = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.onlyOriginal;
		}
		
		$scope.checkBoxTwelve = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.checkingProcess;
		}
		
		$scope.radioThree = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.form;
		}
		
		$scope.radioFour = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.form;
		}
		
		/*******************************************/


		parameterFactory.getParameterById(23).success(function(data) {
			$scope.notaries = data.values;
		});

		parameterFactory.getParameterById(24).success(function(data) {
			$scope.courts = data.values;
		});

		parameterFactory.getParameterById(31).success(function(data) {
			$scope.actions = data.values;
		});

		parameterFactory.getParameterById(33).success(function(data) {
			$scope.areas = data.values;
		});

		parameterFactory.getParameterById(32).success(function(data) {
			$scope.phases = data.values;
		});

		customerFactory.CustomerList().success(function(data) {
			$scope.responsables = data;
		});

		parameterFactory.getParameterById(30).success(function(data) {
			$scope.links = data.values;
		});

		parameterFactory.getParameterById(34).success(function(data) {
			$scope.objectTitles = data.values;
		});
		
		parameterFactory.getParameterById(35).success(function(data) {
			$scope.offices = data.values;
		});

		parameterFactory.getParameterById(40).success(function(data) {
			$scope.motivations = data.values;
		});

		parameterFactory.getParameterById(36).success(function(data) {
			$scope.extras = data.values;
		});

		parameterFactory.getParameterById(37).success(function(data) {
			$scope.costCenterList = data.values;
		});
		
		$scope.checkBoxThirteen = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.hasContingency;
		}
		
		$scope.checkBoxFourtTeen = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.finalized;
		}
		
		$scope.checkBoxFifteen = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.recoveredProperty;
		}
		
		$scope.radioFive = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.lossProb;
		}
		
		$scope.radioSix = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.endResult;
		}		
 
		/*******************************************/		
		
		$scope.radioSeven = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.printingType;
		}
		
		$scope.radioEight = function(reportAdvanced) {
			console.log($scope.reportAdvanced);
			return reportAdvanced === $scope.reportAdvanced.endResult;
		}
		
		$scope.cancel = function(){
			$location.path("/reports");
		};
		
		$scope.sendReport = function(reportAdvanced){
			$location.path("/reports");
		};	
		
  });
