package com.how2java.mapper;
 
import java.util.List;

import com.github.pagehelper.Page;
import com.how2java.pojo.Diary ;
 
public interface DiaryMapper {
 
      
    public Long add(Diary  diary);  
       
      
    public void delete(Long id);  
       
      
    public Diary  get(Long id);  
     
      
    public Long update(Diary  diary);   
       
      
    public List<Diary > list(String name);
    
      
    public Long count();  
    
    public String lastEdit();


	public Long countMy(String name);
    
	 public Long afterSave(Diary  diary);


	public Page<Diary> list(Diary diary);  
    
}