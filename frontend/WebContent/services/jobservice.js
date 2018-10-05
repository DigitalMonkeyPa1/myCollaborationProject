app.factory('JobService',function($http){
	var jobService={}
	var BASE_URL = "http://localhost:9090/middleware"
		
		
	jobService.addJob=function(job){
		return $http.post(BASE_URL + "/addjob",job)
	}

	jobService.getAllJobs=function(){
		return $http.get(BASE_URL + "/getalljobs")
	}

	jobService.getJob=function(id){
		return $http.get(BASE_URL + "/getjob/"+id)
	}

	return jobService;
})
	