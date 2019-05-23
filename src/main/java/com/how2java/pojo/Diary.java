package com.how2java.pojo;

import java.io.Serializable;

public class Diary implements Serializable {
private int id;
private String writer;
private String date;
private String content;
private String title;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

}
