app.controller('UserController',function($scope,UserService,$rootScope,$location,$cookieStore){
	if($rootScope.loggedInUser!=undefined)
		UserService.getUser().then(function(response){
		$scope.user=response.data
	},function(response){
		console.log(response.status)
		$scope.error=response.data
		$location.path('/login')
})
	
		$scope.register=function(){
		UserService.register($scope.user).then(
		 function(response){
			alert('Registered successfully.. please login..')
			$location.path('/login')
		 }
		,function(response){
			$scope.error=response.data
			console.log(response.status)
		})
	}
	
	
	$scope.login=function(){
		UserService.login($scope.user).then(function(response){
			$rootScope.loggedInUser=response.data
			$cookieStore.put('loggedInUser',response.data)
			console.log("Login : ")
			console.log(response.data)
			$location.path('/home')
			},function(response){
				$scope.error=response.data
				console.log(response.data)
				$location.path('/login')
			})
		
	}
		$scope.update=function(){
			UserService.update($scope.user).then(function(response){
				alert('Updated details successfully...')
				$rootScope.loggedInUser=response.data
				$cookieStore.put('loggedInUser',response.data)
				$location.path('/home')
			},function(response){
				console.log(response.status)
				if(response.status==401)
				$location.path('/login')
			
			})
		}
	
})


