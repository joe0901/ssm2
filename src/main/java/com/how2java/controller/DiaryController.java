package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.how2java.pojo.Diary;
import com.how2java.pojo.entity.PageResult;
import com.how2java.pojo.entity.Result;
import com.how2java.service.DiaryService;

// 告诉spring mvc这是一个控制器类
@RestController
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	DiaryService diaryService;

	public String showName() {
		// 获得用户名信息:
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return username;
	}

	@RequestMapping("findAll")
	public List<Diary> findAll() {
		List<Diary> list = diaryService.list(showName());
		return list;

		// ModelAndView mav = new ModelAndView();
		/*
		 * // 放入转发参数 mav.addObject("cs", cs); // 放入jsp路径 mav.setViewName("listDiary");
		 * return mav;
		 */
	}

	@RequestMapping("/save")
	public Result save(@RequestBody Diary diary) {
		try {
			diaryService.add(diary);

			return new Result(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "保存失败!");
		}
	}

	@RequestMapping("/findById")
	public Diary findById(int id) throws Exception {
		return diaryService.get(id);
	}

	@RequestMapping("/update")
	public Result update(@RequestBody Diary diary) {
		try {
			diaryService.update(diary);

			return new Result(true, "修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败!");
		}
	}

	@RequestMapping("/findByPage")
	public PageResult findByPage(int page, int rows) {
		System.out.println("findpage:name"+showName());
		return diaryService.findByPage(page, rows,showName());
	}

	@RequestMapping("/delete")
	public Result delete(int[] ids) {
		try {
			diaryService.delete(ids);
			return new Result(true, "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败!");
		}
	}

	@RequestMapping("/count")
	public int count() {
		return diaryService.count();
	}
	
	@RequestMapping("/countMy")
	public int countMy() {
		return diaryService.countMy(showName());
	}

	@RequestMapping("/lastEdit")
	public String lastEdit() {
		return diaryService.lastEdit();
	}
}