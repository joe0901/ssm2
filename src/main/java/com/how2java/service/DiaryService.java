package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Diary;
import com.how2java.pojo.entity.PageResult;

public interface DiaryService {

	  public int add(Diary  diary) throws Exception;  
	       
	      
	    public void delete(int id);  
	       
	      
	    public Diary  get(int id) throws Exception;  
	     
	      
	    public int update(Diary  category) throws Exception;   
	       
	      
	    public List<Diary > list();
	    
	      
	    public int count();


		PageResult findByPage(int pageNum, int pageSize);


		public void delete(int[] ids);  

}
