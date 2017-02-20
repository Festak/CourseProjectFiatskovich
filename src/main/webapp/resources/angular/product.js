angular.module('product', [])
      .controller('ProductController', function ($scope, $http) {
          $scope.tags = [];

          $scope.getTags = function () {
              $http.get('/index').success(function (result) {
                  $scope.tags = result;
              })
                  .error(function (data) {
                      console.log(data);
                  });
          }
          

      });