app.controller('AfterLoginController', function($scope) {
 //
});

app.controller('AfterHomeController', function($scope) {
 //
});

app.controller('AfterPageController', function($scope) {
 //
});

app.controller('OpenIdController', function($controller, $scope, $location) {
  $scope.checkSocial = true;
  angular.extend(this, $controller('LoginController', {
    $scope: $scope
  }));

  var queryStringParams = $location.search();
  var params = {};
  for (var key in queryStringParams) {
    if (queryStringParams.hasOwnProperty(key)) {
      params[key] = queryStringParams[key];
    }
  }
  
  $scope.login("#OAUTH#", "admin", params["_ctk"]);
});