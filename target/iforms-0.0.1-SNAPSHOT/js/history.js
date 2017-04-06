var app = angular.module('history', []);

app.controller('historyCtrl', ['$scope', '$http',  function($scope, $http) {

  var gid = '';
  var uid = '';
  $scope.currentuser = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      $scope.ur = data;
    });
  };

  $scope.genreport = function() {
    if (typeof $scope.date_from !== 'undefined' && typeof $scope.date_to !== 'undefined') {
      window.location = '/SCTTimestamp/genreport?from=' + $scope.date_from + '&to=' + $scope.date_to + '&gid=' + gid + '&id=' + uid;
    } else {
      alert("Please help fill effect date and Get History first!");
    }
  };

  $scope.showalltracker = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      if (data.role == 'ROLE_USER') {
        gid = data.gid;
      }

      $http.get('/SCTTimestamp/showalltracker?gid=' + gid).
      success(function(data) {
        $scope.trackers = data;
      });
    });
  };

  $scope.getHistory = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      uid = data.id; // Used for genreport. must get history frist!!!.
      if (data.role == 'ROLE_USER') {
        gid = data.gid;
      }

      $http.get('/SCTTimestamp/showtrackerbydate?from=' + $scope.date_from + '&to=' + $scope.date_to + '&gid=' + gid).
      success(function(data) {
        $scope.trackers = data;
      });
    });
  };

  $scope.delRecord = function(uid) {
    if ($scope.ur.role == 'ROLE_ADMIN' && uid != '') {
      window.location = '/SCTTimestamp/delrecord?id=' + uid;
    }
  };

  $scope.editRecord = function(uid) {
    var id = decodeURI(location.search.split('id=')[1]);
    $http.get('/SCTTimestamp/editrecord?id=' + id).
    success(function(data) {
      $scope.rawtrack = data;
    });
  };

  $scope.substring = function(str, start, end) {
    return str.substring(start, end);
  };
}]);
