workoutProfileModule.controller('workoutProfileActivityController', function ($scope, $rootScope, $http) {
	
	$scope.selectedUserId = null;
	$rootScope.$on("userIsSelected", function(event, selectedUser){
		$scope.selectedUserId = selectedUser.user.id;
	});
	
	var getDropDowns = function(){
		$http.get("/userStats/loadActivityDropDowns", {}).then(function(payload){
			if(payload){
				$scope.dayOfWeekList = payload.data.dayOfWeekList;
				$scope.workoutActivityList = payload.data.workoutActivityTypeList;
			}
		});
	};
	
	getDropDowns();
	
	$scope.addActivity = function(containerValues){
		var object = {};
		object = containerValues.activity;
		object.userId = $scope.selectedUserId;
		$http.post("/userStats/createNewActivity", object).then(function(payload){
			//payload can be success or failure
			if(payload.data === "success"){
				$rootScope.$emit("newActivityAdded",{});
			}
		});
	};
	
	

});