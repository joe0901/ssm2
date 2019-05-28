package com.how2java.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.how2java.mapper.DiaryMapper;
import com.how2java.pojo.Diary;
import com.how2java.pojo.entity.PageResult;
import com.how2java.service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryMapper diaryMapper;
	
	final String filePath = "D:\\source\\website";
	final String fileKind = ".txt";
	
	@Override
	public Long add(Diary diary) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		diary.setDate(date);
		
		/**
		 * 将content存到txt,再将txt的路径存到 Diary类的content属性
		 */
		File file = new File(filePath,diary.getTitle()+fileKind);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(diary.getContent());
		bw.flush();
		bw.close();
		
		diary.setContent(file.getAbsolutePath());
		Long id = diaryMapper.add(diary);
		System.out.println("Long id = "+  id);
		return id;
	}

	@Override
	public void delete(int id) {
		diaryMapper.delete(id);
	}

	@Override
	public Diary get(int id) throws Exception {
		Diary diary = diaryMapper.get(id);
		BufferedReader br = new BufferedReader(new FileReader(diary.getContent()));
		StringBuilder sb = new StringBuilder();
		String content = null;
		while(null!= (content = br.readLine())) {
			sb.append(content);
		}
		diary.setContent(sb.toString());
		System.out.println("content:"+sb.toString());
		br.close();
		return  diary;
	}

	@Override
	public int update(Diary diary) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		diary.setDate(date);
		
		/**
		 * 将content存到txt,再将txt的路径存到 Diary类的content属性
		 */
		File file = new File(filePath,diary.getTitle()+fileKind);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(diary.getContent());
		bw.flush();
		bw.close();
		
		diary.setContent(file.getAbsolutePath());
		return diaryMapper.update(diary);
	}

	@Override
	public List<Diary> list(String name) {
		return diaryMapper.list(name);
	}

	@Override
	public int count() {
		return diaryMapper.count();
	}

	@Override
	// 分页查询
	public PageResult findByPage(int pageNum, int pageSize,String name) {
		// 使用分页插件:
		PageHelper.startPage(pageNum, pageSize);
		Page<Diary> page = (Page<Diary>) diaryMapper.list(name);
		System.out.println(page.size());
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public void delete(int[] ids) {
		for(int id:ids) {			
			diaryMapper.delete(id);
		}
	}

	@Override
	public String lastEdit() {
		return diaryMapper.lastEdit();
	}

	@Override
	public int countMy(String name) {
		return diaryMapper.countMy(name);
	}

}
