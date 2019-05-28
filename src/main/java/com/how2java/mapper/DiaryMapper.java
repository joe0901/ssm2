package com.how2java.mapper;
 
import java.util.List;

import com.how2java.pojo.Diary ;
 
public interface DiaryMapper {
 
      
    public Long add(Diary  diary);  
       
      
    public void delete(int id);  
       
      
    public Diary  get(int id);  
     
      
    public int update(Diary  diary);   
       
      
    public List<Diary > list(String name);
    
      
    public int count();  
    
    public String lastEdit();


	public int countMy(String name);
    
    
}