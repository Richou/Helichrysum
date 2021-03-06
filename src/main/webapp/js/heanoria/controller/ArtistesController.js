var artistesPopupController = function ($scope, $modalInstance, $log, $http, ROOT_URL) {

	$scope.ok = function () {
		$modalInstance.close();
	};
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
}

heanoria.controller('ArtistesController', ['$scope', '$log', '$http', '$modal', 'ROOT_URL', 'API_PREFIX', 
		function ($scope, $log, $http, $modal, ROOT_URL, API_PREFIX){
	
	$scope.urlPrefix = ROOT_URL + '/' + API_PREFIX;
	$scope.isBusy = false;
	 
	$scope.artistes = [];
	
	$scope.getArtistes = function() {
		$scope.isBusy = true;
		$http({
			method: 'GET',
			url: $scope.urlPrefix + '/artistes/list'
		}).success(function(data, status) {
			$scope.artistes = data.items;
			$scope.isBusy = false;
		}).error(function(data, status) {
			$log.error(data);
			$scope.isBusy = false;
		});
	};
	
	$scope.openPopup = function() {
		$modal.open({
			templateUrl : 'addArtistesPopup',
			controller : 'artistesPopupController'
		})
	};
	
	$scope.getArtistes();
	
}]);