'use strict';

/**
 * @ngdoc service
 * @name webappApp.ProcessService
 * @description
 * # ProcessService
 * Service in the webappApp.
 */
angular.module('webappApp').service('ProcessService', [ 'UriService', 'RequestService', 'SessionService', '$log',function(UriService, RequestService, SessionService, $log) {
	var service = this;
	
	service.list = function() {
		var url = UriService.getUri("engine:/process:/list");
			
		return RequestService.doRequest(url, null, 'GET');
	};
	
	service.insert = function(process) {
		var url = UriService.getUri("engine:/process:/insert");
		
		var params = {};

		params = process;
		
		params.creator = SessionService.getUser();

		delete params.creator.pictureId;
		
		for(var i = 0; i < params.processCustomer.length; i++){
			if(params.processCustomer[i].partner != undefined){
				delete params.processCustomer[i].partner.ticket;
				delete params.processCustomer[i].partner.userDto;
				params.processCustomer[i].partnerType = 'processCustomer';
			}
		}

		for(var i = 0; i < params.processOpponent.length; i++){
			if(params.processOpponent[i].partner != undefined){
				delete params.processOpponent[i].partner.ticket;
				delete params.processOpponent[i].partner.userDto;
				params.processOpponent[i].partnerType = 'processOpponent';
			}
		}

		for(var i = 0; i < params.processOther.length; i++){
			if(params.processOther[i].partner != undefined){
				delete params.processOther[i].partner.ticket;
				delete params.processOther[i].partner.userDto;
				params.processOther[i].partnerType = 'processOther';
			}
		}
		
		for(var i = 0; i < params.owners.length; i++){
			if(params.owners[i] != undefined){
				delete params.owners[i].distinct;
			}
		}

		console.log(params);
			
		return RequestService.doRequest(url, params, 'POST');
	};
	
	service.list = function() {
		var url = UriService.getUri("engine:/process:/list");
			
		return RequestService.doRequest(url, null, 'GET');
	};
	
	return service;
}]);
