workoutProfileModule.controller('activityListController', function($scope, $http, $rootScope, NgTableParams){	
	$scope.selectedUserId = null;
	$rootScope.$on("userIsSelected", function(event, selectedUser){
		$scope.selectedUserId=selectedUser.user.id;
		getUserActivityList();
	});
	
	$rootScope.$on("newActivityAdded", function(){
		getUserActivityList();
	});
	
	var getUserActivityList = function(){
		$http.get("/userStats/getUserActivityList/" + $scope.selectedUserId , {}).then(function(payload){
			if(payload){
				$scope.tableParams = new NgTableParams({}, { dataset: payload.data});
			}
		});
	};
	
});