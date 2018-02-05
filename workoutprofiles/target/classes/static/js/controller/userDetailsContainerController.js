workoutProfileModule.controller('userDetailsController', function($scope, $http, $rootScope){
	$scope.selectedUserId = null;
	//need to do a get request to see if there is existing values
	$rootScope.$on("userIsSelected", function(event, selectedUser){
		$scope.selectedUserId=selectedUser.user.id;
		$http.get("/profiles/getUserProfileById/" + $scope.selectedUserId, {}).then(function(payload){
			if(payload.data){
				var userDetails = payload.data;
				$scope.userDetails = {};
				$scope.userDetails.userId = $scope.selectedUserId;
				$scope.userDetails.userFirstName = userDetails.firstName;
				$scope.userDetails.userLastName = userDetails.lastName;
				$scope.userDetails.userAge = userDetails.age;
				if(userDetails.userDetailEntity){
					$scope.userDetails.userHeight = userDetails.userDetailEntity.userHeight;
					$scope.userDetails.userWeight = userDetails.userDetailEntity.userWeight;
					$scope.userDetails.userGender = userDetails.userDetailEntity.userGender;
				}
				
				
			}
		});
	});
	
	
	$scope.saveUserDetails = function(userDetails){
		var object = {};
		object = userDetails.userDetails;
		$http.post("/profiles/updateExistingProfile", object).then(function(payload){
			//this should update the new data if anything changes
		});
	};
	
	
});