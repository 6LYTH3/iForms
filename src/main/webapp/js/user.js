var app = angular.module('user', []);

app.controller('userCtrl', ['$scope', '$http',  function($scope, $http) {

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

  $scope.showalluser = function() {
    $http.get('/SCTTimestamp/showalluser').
    success(function(data) {
      $scope.users = data;
    });
  };

  $scope.changeot = function(gid) {
    if ($scope.ur.role == 'ROLE_ADMIN') {
      $http.get('/SCTTimestamp/changeot?gid=' + gid).
      success(function(data) {
        $scope.users = data;

        $('body').toast({
          content: 'OT Consent has been updated. Please re-login again.'
        });
      });
    }
  };

  $scope.chgpass = function(uid) {
    if ($scope.ur.id == uid) {
      var pass = document.getElementById("input-password").value;
      window.location = '/SCTTimestamp/chgpass?id=' + uid + '&newpass=' + pass;
    }
  };

  $scope.deluser = function() {
    if ($scope.ur.role == 'ROLE_ADMIN' && remove_id != '') {
      window.location = '/SCTTimestamp/del?id=' + remove_id;
    }
  };

  $scope.edituser = function(uid) {
    if ($scope.ur.role == 'ROLE_ADMIN' || $scope.ur.gid == uid) {
      window.location = '/SCTTimestamp/edit-profile.html?gid=' + uid;
    }
  };

  $scope.getmesgerr = function() {
    $scope.mesgerr = decodeURI(location.search.split('mesg=')[1]);
  };

  $scope.getuser = function() {
    $scope.dis = false;
    $scope.ta = false;
    $scope.tb = false;
    $scope.tc = false;
    $scope.to = false;
    var gid = decodeURI(location.search.split('gid=')[1]);
    $http.get('/SCTTimestamp/getByGid?gid=' + gid).
    success(function(data) {
      $scope.profiles = data;

      if ($scope.ur.role == 'ROLE_USER') {
        $scope.dis = true;
        var ot1 = document.getElementById("ot-1");
        ot1.classList.add("disabled");

        var ot2 = document.getElementById("ot-2");
        ot2.classList.add("disabled");
      }

      if (data.team === 'A') {
        $scope.ta = true;
      }

      if (data.team === 'B') {
        $scope.tb = true;
      }

      if (data.team === 'C') {
        $scope.tc = true;
      }

      if (data.team === 'OFFICE') {
        $scope.to = true;
      }

      if (data.otconsent === 'YES') {
        $scope.ot = true;
      } else {
        $scope.ot = false;
      }
    });
  };

  $scope.substring = function(str, start, end) {
    return str.substring(start, end);
  };
}]);
