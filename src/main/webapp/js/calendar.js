var app = angular.module('calendar', []);

app.controller('calendarCtrl', ['$scope', '$http',  function($scope, $http) {
  $scope.currentuser = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      $scope.ur = data;
    });
  };

  $scope.showHoliday = function() {
    $http.get('/SCTTimestamp/showHoliday').
    success(function(data) {
      $scope.hol = data;
    });
  };

  $scope.delHoliday = function(uid) {
    $http.get('/SCTTimestamp/delHoliday?id=' + uid).
    success(function(data) {
      $scope.hol = data;
    });
  };

  $scope.addHoliday = function() {
    var workdate = document.getElementById("datepicker-adv-1").value;
    var desc = document.getElementById("input-ds").value;
    var team = document.getElementById("input-tm").value;
    $http.get('/SCTTimestamp/addHoliday?workdate=' + workdate + '&description=' + desc + '&team=' + team).
    success(function(data) {
      $scope.hol = data;
    });
  };

  $scope.substring = function(str, start, end) {
    return str.substring(start, end);
  };
}]);
