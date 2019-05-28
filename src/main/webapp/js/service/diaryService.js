// 定义服务层:
app.service("diaryService",function($http){
	this.findAll = function(){
		return $http.get("../diary/findAll.do");
	}
	
	this.findByPage = function(page,rows){
		return $http.get("../diary/findByPage.do?page="+page+"&rows="+rows);
	}
	
	this.save = function(entity){
		return $http.post("../diary/save.do",entity);
	}
	
	this.update=function(entity){
		return $http.post("../diary/update.do",entity);
	}
	
	this.findById=function(id){
		return $http.get("../diary/findById.do?id="+id);
	}
	
	this.dele = function(ids){
		return $http.get("../diary/delete.do?ids="+ids);
	}
	
	this.search = function(page,rows,searchEntity){
		return $http.post("../diary/search.do?page="+page+"&rows="+rows,searchEntity);
	}
	
	this.selectOptionList = function(){
		return $http.get("../diary/selectOptionList.do");
	}
	
	this.count = function(){
		return $http.get("../diary/count.do");
	}
	
	this.lastEdit = function(){
		return $http.get("../diary/lastEdit.do");
	}
	
	this.countMy = function(){
		return $http.get("../diary/countMy.do");
	}
	
	this.afterSave = function(entity){
		return $http.post("../diary/afterSave.do",entity);
	}

});