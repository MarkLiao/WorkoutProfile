workoutProfileModule.controller('listAllUsersController', function ($scope, $rootScope, $http) {
	var getAllUsers = function(){
		$http.get("/profiles/getAllProfiles").then(function(payload){
			if(payload != null && payload){
				$scope.listOfUsers = payload.data;
			}
		});
	}
	getAllUsers();
	
	
	$rootScope.$on("callGetAllUsers", function(){
		getAllUsers();
	});
	
	$scope.selectedListItemId = null;
	$scope.selectItemClick = function(selectedUser){
		var selectedItem = selectedUser.user;
		$scope.selectedListItemId = selectedUser.user.id;
		$rootScope.$emit("userIsSelected", selectedUser);
		
	};
	
	$scope.removeUser = function(selectedUser){
		$http.delete("/profiles/removeProfile/" + selectedUser.user.id, {}).then(function(payload){
			if(payload.data === "success"){
				getAllUsers();
			}
		},function(error){
			
		});
	};
});
