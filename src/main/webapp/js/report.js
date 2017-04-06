var app = angular.module('report', []);

app.controller('reportCtrl', ['$scope', '$http',  function($scope, $http) {

  var gid = '';
  var remove_id = '';
  $scope.currentuser = function() {
    $http.get('/SCTTimestamp/currentuser').
    success(function(data) {
      $scope.ur = data;
    });
  };

  $scope.initUid = function(uid) {
    remove_id = uid;
  }

  $scope.removereport = function() {
    if ($scope.ur.role == 'ROLE_ADMIN' && remove_id != '') {
      window.location = '/SCTTimestamp/delreport?id=' + remove_id;
    } else {
      alert("You are not have permission to remove it.")
    }
  }

  $scope.editreport = function(uid) {
    if ($scope.ur.role == 'ROLE_ADMIN' && ($scope.ur.gid == '505505' || $scope.ur.gid == '53483')) {
      window.location = 'update-report.html?id=' + uid;
    }
  };

  $scope.showallreport = function() {
    $http.get('/SCTTimestamp/showallreport').
    success(function(data) {
      $scope.rep = data;
    });
  };

  $scope.updatereport = function() {
    var uid = decodeURI(location.search.split('id=')[1]);
    var prnumber = document.getElementById("input-rp").value;
    var status = document.getElementById("input-status").value;
    var note = document.getElementById("input-note").value;
    window.location = '/SCTTimestamp/updatereport?id=' + uid + '&prnumber=' + prnumber + '&status=' + status + '&note=' + note;
  };

  $scope.getreport = function() {
    var uid = decodeURI(location.search.split('id=')[1]);
    $http.get('/SCTTimestamp/editreport?id=' + uid).
    success(function(data) {
      $scope.pr = data;
      $scope.pr_number = data.prnumber;
      $scope.status = data.status;
      $scope.note = data.note;
      $http.get('/SCTTimestamp/currentuser').
      success(function(u) {
        if (data.role == 'ROLE_USER') {
          gid = u.gid;
        }

        var a = data.pathFile.split("/");
        var d = a[a.length - 1].split("_");
        $http.get('/SCTTimestamp/showtrackerbydate?from=' + d[0] + '&to=' + d[1].replace(".csv","") + '&gid=').
        success(function(t) {
          $scope.trackers = t;
        });
      });
    });
  }

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

  $scope.getname = function(str) {
    var arr = str.split("/");
    return arr[arr.length - 1];
  };
}]);
