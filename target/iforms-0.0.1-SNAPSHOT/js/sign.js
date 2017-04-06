var app = angular.module('sign', []);

app.controller('signCtrl', ['$scope', '$http',  function($scope, $http) {

  var getlastsign = function(gid) {
    $http.get('/SCTTimestamp/lastsign?gid=' + gid).
    success(function(data) {
      $scope.track = data;
    });
  };

  $scope.currentuser = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      $scope.ur = data;
      getlastsign(data.gid);
    });
  };

  $scope.submiOT = function(uid) {
    var remark = document.getElementById("input-remark").value;
    window.location = "/SCTTimestamp/ot?id=" + uid + "&remark=" + remark;
  };

  $scope.signIn = function(uid) {
    window.location = "/SCTTimestamp/in?id=" + uid;
  };

  $scope.signOut = function(uid) {
    window.location = "/SCTTimestamp/out?id=" + uid;
  };

  $scope.substring = function(str, start, end) {
    return str.substring(start, end);
  };
}]);
