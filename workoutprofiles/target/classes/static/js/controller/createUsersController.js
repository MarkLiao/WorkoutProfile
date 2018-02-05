workoutProfileModule.controller('createUsersController', function ($scope, $rootScope, $http) {
	
	$scope.createUserClear = function(){
		$scope.project = {};
	};
	
	$scope.createNewUser = function(){
		var object = {};
		object = $scope.project;
		
		$http.post("/profiles/createNewProfile", object).then(function(){
			$rootScope.$emit("callGetAllUsers",{});
		});
	};
});
