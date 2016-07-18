var app = angular.module('Application.services',[]);

app.service('activityService', function($http){
	
	this.getAll = function(search, page){
		return $http.get('api/activities', {params:{'name':search, 'page':page}});
	}
	
	this.getOne = function(id){
		return $http.get('api/activities/'+id);
	}
	
	this.remove = function(id){
		return $http.delete('api/activities/' + id);
	}
	
	this.add = function(activity){
		if(activity.id){
		return $http.put('api/activities/' + activity.id, activity);
		}
		else{
			return $http.post('api/activities', activity);
		}
	}
});