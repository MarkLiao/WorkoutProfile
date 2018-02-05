workoutProfileModule.controller('userStatsController', function ($scope, $rootScope, $http) {
	$scope.noUserSelected = true;
	
	$rootScope.$on("userIsSelected", function(){
		$scope.noUserSelected=false;
	});
});