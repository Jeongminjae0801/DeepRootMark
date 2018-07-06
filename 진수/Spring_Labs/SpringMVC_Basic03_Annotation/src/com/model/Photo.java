package com.model;
/*
create table Photo(
name varchar2(20),
age number,
image varchar2(50) --업로드한 파일명 (hong.jpg)
)
*/


import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Photo {
	private String name;
	private int age;
	private String image; //업로드한 파일명 (a.jpg , b.png ...)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	//POINT (파일 정보를 가지는 객체)
	private CommonsMultipartFile file; //뷰단의 파일 넘어오는 form 에서 type=file 의 id 값과 동일하게 맞춘다
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
}







