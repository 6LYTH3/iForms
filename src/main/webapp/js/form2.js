var app = angular.module('form2', []);

app.controller('form2Ctrl', ['$scope', '$http',  function($scope, $http) {
  var Form_ID = '';

  $scope.getFormId = function() {
    Form_ID = decodeURI(location.search.split('formId=')[1]);
  };

  $scope.showalldoc = function() {
    $http.get('/iforms/showAllMaster?type=CONTRACT').
    success(function(data) {
      $scope.docs = data;
    });
  };

  $scope.showdoc = function(formId) {
    window.location = '/iforms/form2-detail.html?formId=' + formId;
  };

  $scope.showmasterdoc = function() {
    $http.get('/iforms/getMasterFormId?formId=' + Form_ID).
    success(function(data) {
      $scope.master = data;
    });
  };

  $scope.showsection = function(topic) {
    $http.get('/iforms/getContractPriceFormIdAndTopic?formId=' + Form_ID + '&topic=' + topic).
    success(function(data) {
      switch (topic) {
        case 'DIRECT MATERIALS':
        $scope.materials = data;
        break;
        case 'DIRECT LABOUR':
        $scope.labour = data;
        break;
        case 'CONSTRUCTION EQUIPMENT':
        $scope.equipment = data;
        break;
        case 'INDIRECT LABOR':
        $scope.indirect = data;
        break;
        case 'TEMPORARY FACILITIES':
        $scope.temp = data;
        break;
        case 'GENERAL FIELD EXPENSES':
        $scope.general = data;
        break;
        case 'INSURANCE':
        $scope.insurance = data;
        break;
        case 'HSE':
        $scope.hse = data;
        break;
        case 'PROFIT':
        $scope.profit = data;
        break;
        case 'TAX':
        $scope.tax = data;
        break;
        default:

      }
    });
  };


}]);
