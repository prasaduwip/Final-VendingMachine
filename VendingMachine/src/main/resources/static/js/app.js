var app = angular.module('myApp', []);
app.service('products', function() {
	// each product in vending machine
	var products = [];
	/*var products1 = [
	                {
	                	id: 1,
	                	name: 'Thums Up',
	                	price: '1.25',
	                	size: '1 ltr',
	                	quantity: 20,
	                },
	                {
	                	id: 2,
	                	name: 'Pepsi',
	                	price: '1.25',
	                	size: '250 ml',
	                	quantity: 16,
	                },
	                {
	                	id: 3,
	                	name: 'Sprite',
	                	price: '1.20',
	                	size: '1.5 ltr',
	                	quantity: 25,
	                },
	                {
	                	id: 4,
	                	name: 'Mirinda',
	                	price: '1.25',
	                	size: '500 ml',
	                	quantity: 14,
	                },
	                {
	                	id: 5,
	                	name: 'Coca Cola',
	                	price: '1.50',
	                	size: '250 ml',
	                	quantity: 17,
	                },
	                {
	                	id: 6,
	                	name: 'Fanta',
	                	price: '2.50',
	                	size: '500 ml',
	                	quantity: 12,
	                },
	                {
	                	id: 7,
	                	name: 'Mazza',
	                	price: '1.00',
	                	size: '1 ltr',
	                	quantity: 15,
	                },
	                {
	                	id: 8,
	                	name: 'Slice',
	                	price: '1.75',
	                	size: '200 ml',
	                	quantity: 13,
	                },
	                {
	                	id: 9,
	                	name: 'Mountain Dew',
	                	price: '1.00',
	                	size: '200 ml',
	                	quantity: 15,
	                },
	                {
	                	id: 10,
	                	name: 'Limca',
	                	price: '1.75',
	                	size: '250 ml',
	                	quantity: 19,
	                }
	                ];*/
	return {
		init: function() {
			return products;
		},
		deduct: function(index) {
			products[index].quantity--;
		},
	};
});

app.controller('vendingMachine', function($scope, $http, $timeout, products, $window) {

	var baseURL = "http://localhost:8070/hcaservices";
	console.log('###init');
	$scope.prd = products.init();
	getAvailableProducts();

	// Base amount
	var loggedUser = $('#user').val();
	loggedUser = JSON.parse(loggedUser);
	$scope.accountBalance = loggedUser.accountBalance;

	$scope.pushDoorTxt = 'PUSH';
	$scope.greeting = true;
	$timeout(function() {
		$scope.greeting = false;
	});

	$scope.logout = function() {
		$window.location.href = baseURL + '/logout';
	},

	$scope.addCent = function() {
		$scope.accountBalance = $scope.accountBalance + 0.01;
		updateAccountBalance();
	},

	$scope.addQuarter = function() {
		$scope.accountBalance = $scope.accountBalance + 0.25;
		updateAccountBalance();
	},

	$scope.addDollar = function() {
		$scope.accountBalance = $scope.accountBalance + 1.00;
		updateAccountBalance();
	},

	$scope.onPushDoor = function() {
		$scope.pushDoorTxt = 'Have a Nice Day! :) ';
		$timeout(function() {
			$scope.pushDoorTxt = 'PUSH';
		}, 1500);
	};

	$scope.submitPayment = function(amnt) {
		var amnt = parseFloat(amnt);
		if (amnt > $scope.accountBalance) {
			$scope.selected.nofunds = true;
			return false;
		} else {
			$scope.accountBalance = $scope.accountBalance - amnt;
			updateAccountBalance();
			return true;
		}
	};

	$scope.select = function(index) {
		var p = $scope.prd[index];
		$scope.selected.price = p.price;
		$scope.selected.size = p.size;

		if ($scope.submitPayment(p.price)) {
			$scope.selected.dispensing = true;
			$scope.selected.price = 0.0;
			$timeout(function() {
				$scope.selected.dispensing = false;
				deductItemsQuantity(index);
			}, 1000);
		}
	};

	resetSelection();
	
	function _success(res) {
		//console.log(res);
	};

	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
	};
	
	function success_getAvailableProducts(res) {
		$scope.prd = res.data;
		console.log(res);
		//_refreshEmployeeData();
		//_clearFormData();
	};
	
	function getUser() {
		var loggedUser = $('#user').val();
		loggedUser = JSON.parse(loggedUser);
		return loggedUser;
	};
	
	function updateAccountBalance() {
		var loggedUser = getUser();
		loggedUser.accountBalance = $scope.accountBalance;
		$scope.selected.nofunds = false;
		$http({
			method: 'POST',
			url: baseURL + "/vendingmachine/updateAccountBalance",
			data: angular.toJson(loggedUser),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};
	
	function getAvailableProducts() {
		$http({
			method: 'GET',
			url: baseURL + "/vendingmachine/getAvailableProducts",
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(success_getAvailableProducts, _error);
	};
	
	function deductItemsQuantity(index) {
		$scope.prd[index].quantity--;
		$http({
			method: 'POST',
			url: baseURL + "/vendingmachine/updateProductQuantity",
			data: angular.toJson($scope.prd[index]),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	function resetSelection() {
		$scope.selected = {
				dispensing: false,
				nofunds: false,
		};
	};
});
