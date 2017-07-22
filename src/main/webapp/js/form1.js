var app = angular.module('form1', []);

app.controller('form1Ctrl', ['$scope', '$http',  function($scope, $http) {
  var Form_ID = '';

  $scope.getFormId = function() {
    Form_ID = decodeURI(location.search.split('formId=')[1]);
  };

  $scope.showalldoc = function() {
    $http.get('/showAllMaster?type=GENCONTR').
    success(function(data) {
      $scope.docs = data;
    });
  };

  $scope.showdoc = function(formId) {
    window.location = '/form1-detail.html?formId=' + formId;
  };

  $scope.showmasterdoc = function() {
    $http.get('/getMasterFormId?formId=' + Form_ID).
    success(function(data) {
      $scope.master = data;
    });
  };

  $scope.showsection = function(topic) {
    $http.get('/getGenernalConFormIdAndTopic?formId=' + Form_ID + '&topic=' + topic).
    success(function(data) {
      switch (topic) {
        case 'COMMON TEMPORARY FACILITY WORK':
        $scope.common = data;
        break;
        case 'CIVIL WORK':
        $scope.civil = data;
        break;
        case 'ARCHITECTURE WORK':
        $scope.archi = data;
        break;
        case 'STEEL STRUCTURE WORK':
        $scope.steel = data;
        break;
        case 'PIPING WORK':
        $scope.piping = data;
        break;
        case 'PAINTING WORK':
        $scope.painting = data;
        break;
        case 'INSULATION WORK':
        $scope.insulation = data;
        break;
        case 'EQUIPMENT INSTALLATION WORK':
        $scope.equip = data;
        break;
        case 'ELECTRICAL WORK':
        $scope.elec = data;
        break;
        case 'INSTRUMENT WORK':
        $scope.instrument = data;
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
