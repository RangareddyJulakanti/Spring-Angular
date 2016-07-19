var app = angular.module('Application.services',[]);

app.service('activityService', function($http){
	
	var url="api/activities";
	
	this.getAll = function(search, page){
		return $http.get(url, {params:{'name':search, 'page':page}});
	}
	
	this.getOne = function(id){
		return $http.get(url +'/'+id);
	}
	
	this.remove = function(id){
		return $http.delete(url +'/' + id);
	}
	
	this.add = function(activity){
		if(activity.id){
		return $http.put(url +'/' + activity.id, activity);
		}
		else{
			return $http.post(url, activity);
		}
	}
});

app.service('userService', function($http){
	
	var url = "api/users";
	
	this.getAll = function(search,page){
		return $http.get(url, {params:{'name':search, 'page':page}});
	}
	
	this.findOne = function(id){
		return $http.get(url+"/"+id);
	}
	
	this.remove = function(id){
		return $http.delete(url+"/"+id);
	}
	
	this.add = function(user){
		if(user.id){
			return $http.put(url +'/' + user.id, user);
		}
		else{
			return $http.post(url, user);
		}
	}
	
});