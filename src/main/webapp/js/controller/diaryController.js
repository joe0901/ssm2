// 定义控制器:
app.controller("diaryController",function($scope,$controller,$http,$location,diaryService,loginService){
	// AngularJS中的继承:伪继承
	$controller('baseController',{$scope:$scope});
	
	// 查询所有的品牌列表的方法:
	$scope.findAll = function(){
		// 向后台发送请求:
		diaryService.findAll().success(function(response){
			$scope.list = response;
		});
	}

	// 分页查询
	$scope.findByPage = function(page,rows){
		// 向后台发送请求获取数据:
		diaryService.findByPage(page,rows).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
	
	// 保存品牌的方法:
	$scope.save = function(){
		// 再添加之前，获得富文本编辑器中的内容。
		$scope.entity.content=editor.html();
		// 区分是保存还是修改
		var object;
		if($scope.entity.id != null){
			// 更新
			object = diaryService.update($scope.entity);
		}else{
			// 保存
			object = diaryService.save($scope.entity);
		}
		object.success(function(response){
			// {flag:true,message:xxx}
			// 判断保存是否成功:
			if(response!=null){
				// 保存成功
				alert(response);
				$scope.reloadList();
				$scope.entity.id = response;
			}else{
				// 保存失败
				alert(response.message);
			}
		});
	}
	
	// 查询一个: 这是原来的写法,但是点击修改按钮是跳转到编辑页面,所以这个方法用不上
//	$scope.findById = function(id){
//		var id = $location.search()['id'];
//		diaryService.findById(id).success(function(response){
//			// {id:xx,name:yy,firstChar:zz}
//			$scope.entity = response;
//		});
//	}
	
	// 查询一个: 这是在页面跳转之后 init调用的
	$scope.findById = function(){
		var id = $location.search()['id'];	//获取跳转带参
		var writer = $location.search()['writer'];	//获取跳转带参
		//alert(id)
		if(id!=undefined){
			diaryService.findById(id).success(function(response){
				// {id:xx,name:yy,firstChar:zz}
				$scope.entity = response;
				//回写富文本编辑器中的内容。
				editor.html($scope.entity.content);
			});
		}else{
			$scope.entity={writer:""};
			$scope.entity.writer = writer;
		}
	}
	
	// 删除品牌:
	$scope.dele = function(){
		diaryService.dele($scope.selectIds).success(function(response){
			// 判断保存是否成功:
			if(response.flag==true){
				// 保存成功
				// alert(response.message);
				$scope.reloadList();
				$scope.selectIds = [];
			}else{
				// 保存失败
				alert(response.message);
			}
		});
	}
	
	$scope.searchEntity={};
	
	// 假设定义一个查询的实体：searchEntity
	$scope.search = function(page,rows){
		// 向后台发送请求获取数据:
		diaryService.search(page,rows,$scope.searchEntity).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
	
	// 查询日记总数:
	$scope.count = function(){
		// 向后台发送请求:
		diaryService.count().success(function(response){
			$scope.count = response;
		});
	}
	

});
