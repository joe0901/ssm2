// 定义控制器:
app.controller("homeController",function($scope,$controller,$http,$location,diaryService){
	// AngularJS中的继承:伪继承
	$controller('baseController',{$scope:$scope});
	
	// 查询日记总数:
	$scope.init = function(){
		// 向后台发送请求:
		diaryService.count().success(function(response){
			$scope.count = response;
		});
		diaryService.lastEdit().success(function(response){
			$scope.lastEdit = response.replace("\"","").replace("\"","");
		});
	}
	
});
