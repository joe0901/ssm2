package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Diary;
import com.how2java.pojo.entity.PageResult;

public interface DiaryService {

	  public void add(Diary  diary) throws Exception;  
	       
	      
	    public void delete(Long id);  
	       
	      
	    public Diary  get(Long id) throws Exception;  
	     
	      
	    public Long update(Diary  category) throws Exception;   
	       
	      
	    public List<Diary > list(String name);
	    
	      
	    public Long count();


		PageResult findByPage(int pageNum, int pageSize,String name);


		public void delete(Long[] ids);  

		public String lastEdit();


		public Long countMy(String name);


		public Long afterSave(Diary diary);


		public PageResult findPage(Diary diary, int page, int rows);
}
