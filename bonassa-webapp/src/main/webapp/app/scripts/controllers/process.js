'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:ProcessCtrl
 * @description # ProcessCtrl Controller of the webappApp
 */
angular.module('webappApp')
	   .controller(
				'ProcessCtrl', 
				['$scope', '$rootScope', '$modal', '$location', '$routeParams', 'ProcessFactory', 'parameterFactory', 
				 'customerFactory',	'userFactory', 'opponentFactory', 'otherFactory', '$cookies', '$cookieStore', 'toaster', 'ProcessService',
				 function($scope, $rootScope, $modal, $location,	$routeParams, ProcessFactory, parameterFactory, 
						  customerFactory, userFactory, opponentFactory, otherFactory, $cookies, $cookieStore, toaster, ProcessService) {
							
							$scope.process = {
								processCustomer : [{}],
								processOpponent : [{}],
								processOther : [{}],
								recoveredProperty : false,
								relatedProcess : false,
								checkedToExport : false,
								sentence : false,
								acordao : false,
								transit : false,
								instance : '1',
								activePassiveProcess : '1',
								lossProb : '1',
								endResult : '1',
								processCustomer : [ {} ],
								processOpponent : [ {} ],
								processOther : [ {} ],
								owners : [ {} ]
//								numProcess : null,
//								contCob : null,
//								fileLocale : null,
//								fileFolder : null,
//								state : null,
//								city : null,
//								county : null,
//								notarysOffice : null,
//								court : null,
//								link : null
							};							
							$scope.customerTypes = [];
							$scope.opponentTypes = [];
							$scope.otherTypes = [];
							$scope.files = [];
							$scope.folders = [];
							$scope.states = [];
							$scope.cities = [];
							$scope.counties = [];
							$scope.notaries = [];
							$scope.courts = [];
							$scope.links = [];
							$scope.actions = [];
							$scope.phases = [];
							$scope.ownersList = [];
							$scope.areas = [];
							$scope.objectTitles = [];
							$scope.offices = [];
							$scope.extras = [];
							$scope.costCenterList = [];
							$scope.places = [];
							$scope.tables = [];
							$scope.tableValues = [];
							$scope.motivations = [];	
							$scope.add = false;
							$scope.remove = false;
							$scope.buttons = true;
					
							init();

							function init() {								

								if ($routeParams.process != undefined) {
									$scope.tag = 'Edição do Processo nº ';
									console.log("Processo : ", $routeParams.process);
								} else {
									$scope.tag = 'Novo Processo'
									if($routeParams.newProcess != undefined)
										$scope.process = $routeParams.newProcess;
								}
								
								parameterFactory.getParameterByName().then(function(data) {
									var params = data.data;	
									
									for (var i = 0; i < params.length; i++) {
										if (params[i].id == 1){
											if($routeParams.process != undefined){
												if(($routeParams.process.state != undefined || $routeParams.process.state != null))
													$scope.cities = params[i].values;
												else
													$scope.cities = [];
											}
											if($routeParams.newProcess != undefined){
												if(($routeParams.newProcess.state != undefined || $routeParams.newProcess.state != null))
													$scope.cities = params[i].values;
												else
													$scope.cities = [];
											}
										}
										else if (params[i].id == 19)
											$scope.states = params[i].values;
										else if (params[i].id == 23){
											if($routeParams.process != undefined){
												if($routeParams.process.county != undefined || $routeParams.process.county != null)
													$scope.notaries = params[i].values;
												else
													$scope.notaries = [];
											}
											if($routeParams.newProcess != undefined){
												if(($routeParams.newProcess.county != undefined || $routeParams.newProcess.county != null))
													$scope.notaries = params[i].values;
												else
													$scope.notaries = [];
											}
										}
										else if (params[i].id == 24)
											$scope.courts = params[i].values;
										else if (params[i].id == 25)
											$scope.customerTypes = params[i].values;
										else if (params[i].id == 26)
											$scope.opponentTypes = params[i].values;
										else if (params[i].id == 27)
											$scope.otherTypes = params[i].values;
										else if (params[i].id == 28)
											$scope.files = params[i].values;
										else if (params[i].id == 29){
											if($routeParams.process != undefined){
												if($routeParams.process.fileLocale != undefined || $routeParams.process.fileLocale != null)
													$scope.folders = params[i].values
												else
													$scope.folders = [];
											}
											if($routeParams.newProcess != undefined){
												if(($routeParams.newProcess.fileLocale != undefined || $routeParams.newProcess.fileLocale != null))
													$scope.folders = params[i].values
												else
													$scope.folders = [];
											}
										}
										else if (params[i].id == 30)
											$scope.links = params[i].values;
										else if (params[i].id == 31)
											$scope.actions = params[i].values;
										else if (params[i].id == 32)
											$scope.phases = params[i].values;
										else if (params[i].id == 33)
											$scope.areas = params[i].values;
										else if (params[i].id == 34)
											$scope.objectTitles = params[i].values;
										else if (params[i].id == 35)
											$scope.offices = params[i].values;
										else if (params[i].id == 36)
											$scope.extras = params[i].values;
										else if (params[i].id == 37)
											$scope.costCenterList = params[i].values;
										else if (params[i].id == 38)
											$scope.places = params[i].values;
										else if (params[i].id == 39)
											$scope.tables = params[i].values;
										else if (params[i].id == 40)
											$scope.motivations = params[i].values;
										else if (params[i].id == 41)
											$scope.tableValues = params[i].values;
										else if (params[i].id == 52)
											$scope.counties = params[i].values;
									}
									
									userFactory.UserList().then(function(data) {
										$scope.ownerList = data.data;
										
										customerFactory.CustomerList().then(function(data) {
											$scope.customerList = data.data;											

											opponentFactory.OpponentList().then(function(data) {
												$scope.opponentList = data.data;
												
												otherFactory.OtherList().then(function(data) {
													$scope.otherList = data.data;

													parameterFactory.getParameterById(51).then(function(data) {
														$scope.civilStatusList = data.values;

														if ($routeParams.process != undefined) {
															$scope.process = $routeParams.process;
															console.log($scope.process);
															$scope.setRadiosToString();
														}
													});
												});												
											});
										});
									});
								});
							}

							/** *********TABS********* */

							$scope.tabs = [ {
								title : 'Principal',
								url : 'one'
							}, {
								title : 'Dados Extras',
								url : 'two'
							} ];

							$scope.currentTab = 'one';

							$scope.showTab = true;

							$scope.onClickTab = function(tab) {

								if ($scope.currentTab != tab.url) {
									$scope.showTab = !$scope.showTab;
								}
								$scope.currentTab = tab.url;
							}

							$scope.isActiveTab = function(tabUrl) {
								return tabUrl == $scope.currentTab;
							}

							/** *********************** */							
							
							$scope.setRadiosToString = function() {
								$scope.process.instance = $scope.process.instance.toString();
								$scope.process.activePassiveProcess = $scope.process.activePassiveProcess.toString();
								$scope.process.lossProb = $scope.process.lossProb.toString();
								$scope.process.endResult = $scope.process.endResult.toString();
							};
							
							$scope.setRadiosToInteger = function() {
								$scope.process.instance = parseInt($scope.process.instance);
								$scope.process.activePassiveProcess = parseInt($scope.process.activePassiveProcess);
								$scope.process.lossProb = parseInt($scope.process.lossProb);
								$scope.process.endResult = parseInt($scope.process.endResult);
							};
							
							$scope.formInvalid = false;
							$scope.verifyRequiredFields = function(param) {
								if(param == false)
									$scope.formInvalid = true;
								else{
									$scope.save();
								}
							}
							
							$scope.setFolderList = function(){
								if($scope.folders.length == 0){
									parameterFactory.getParameterById(29).then(function(data) {
										$scope.folders = data.data.values;
										console.log($scope.folders);
									});
								}
							};
							
							$scope.setCityList = function(){
								if($scope.cities.length == 0){
									parameterFactory.getParameterById(1).then(function(data) {
										$scope.cities = data.data.values;
									});
								}
							};
							
							$scope.setNotaryList = function(){
								if($scope.notaries.length == 0){
									parameterFactory.getParameterById(23).then(function(data) {
										$scope.notaries = data.data.values;
									});
								}
							};
														
							$scope.save = function(){
								var path = $location.path();
								
								$scope.setRadiosToInteger();
																
								if(path == "/process/new"){
									console.log($scope.process);
									ProcessFactory.NewProcess($scope.process).success(function() {
										toaster.pop('success', "", "Processo cadastrado com sucesso!");
										$scope.exit();
									}).error(function() {
										toaster.pop('error', "", "Processo não cadastrado!");
										$scope.exit();
									});
								}
								else{
									if(path == "/process/edit"){
										console.log($scope.process);
										ProcessFactory.UpdateProcess($scope.process).success(function() {
											toaster.pop('success', "", "Processo atualizado com sucesso!");
											$scope.exit();
										}).error(function() {
											toaster.pop('error', "", "Processo não atualizado!");
											$scope.exit();
										});
									}									
								}
							};
							
							$scope.exit = function() {
								$location.path("/process/list");
							};
							
							$scope.createCustomer = function() {
								$location.path("/customer/new").search({
									process : $scope.process
								});
							};
							
							$scope.createOpponent = function() {
								$location.path("/opponent/new").search({
									process : $scope.process
								});
							};
							
							$scope.createOther = function() {
								$location.path("/other/new").search({
									process : $scope.process
								});
							};	
							
							/** *************************** */

							$scope.addProcessCustomer = function() {
								$scope.process.processCustomer.push('');
							};

							$scope.removeProcessCustomer = function(index) {
								$scope.process.processCustomer.splice(index, 1);
							};

							/** *************************** */

							$scope.addProcessOpponent = function() {
								$scope.process.processOpponent.push('');
							};

							$scope.removeProcessOpponent = function(index) {
								$scope.process.processOpponent.splice(index, 1);
							};

							/** *************************** */

							$scope.addProcessOther = function() {
								$scope.process.processOther.push('');
							};

							$scope.removeProcessOther = function(index) {
								$scope.process.processOther.splice(index, 1);
							};
							
							/** *************************** */
							
							$scope.addOwner = function() {
								$scope.process.owners.push('');
							};

							$scope.removeOwner = function(index) {
								$scope.process.owners.splice(index, 1);
							};
							
							/** *************************** */

						} ]).filter('folderFilter',	function() {
								return function(input, process) {
									var j;
									var folders = [];
			
									if (input != null) {
										if (process != undefined) {
											if (process.fileLocale != null) {
												for (j = 0; j < input.length; j++) {
													if(input[j].parent != null){
														if (input[j].parent.id === process.fileLocale.id)
															folders.push(input[j]);
													}
												}
											} else {
												folders = input;
											}
										}
									}
			
									return folders;
								}
							}).filter('notaryFilter', function() {
								return function(input, process) {
									var k;
									var notaries = [];

									if (input != null) {
										if (process != undefined) {
											if (process.county != null) {
												for (k = 0; k < input.length; k++) {
													if(input[k].parent != null){
														if (input[k].parent.id === process.county.id)
															notaries.push(input[k]);
													}
												}
											} else {
												notaries = input;
											}
										}
									}

									return notaries;
								}
							});
		