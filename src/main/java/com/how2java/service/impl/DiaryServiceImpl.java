package com.how2java.service.impl;

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
	
	@Override
	public int add(Diary diary) {
		return diaryMapper.add(diary);
	}

	@Override
	public void delete(int id) {
		diaryMapper.delete(id);
	}

	@Override
	public Diary get(int id) {
		return diaryMapper.get(id);
	}

	@Override
	public int update(Diary diary) {
		return diaryMapper.update(diary);
	}

	@Override
	public List<Diary> list() {
		return diaryMapper.list();
	}

	@Override
	public int count() {
		PageHelper.startPage(1, 2);
		return diaryMapper.count();
	}

	@Override
	// 分页查询
	public PageResult findByPage(int pageNum, int pageSize) {
		// 使用分页插件:
		PageHelper.startPage(pageNum, pageSize);
		Page<Diary> page = (Page<Diary>) diaryMapper.list();
		return new PageResult(page.getTotal(),page.getResult());
	}

}
