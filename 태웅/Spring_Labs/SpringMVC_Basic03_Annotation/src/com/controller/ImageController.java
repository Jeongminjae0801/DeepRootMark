package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		System.out.println("image.jsp 출력");
		return "image/image";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Photo photo , HttpServletRequest request) throws IOException {
		
		/*
		 전제조건 : submit(Photo photo)
		 자동화 1: <form 태그 name="" 속성이 Photo 라는 클래스의 memberfield 명과 같아야 한다
		 
		 Photo photo = new Photo();
		 photo.setName("홍길동");
		 photo.setAge(100);
		 
		 photo.setImage("업로드한 파일명") : 해결
		 ( 방안 )
		 private CommonsMultipartFile file;
		 
		 */
		//System.out.println("name : " + photo.getName());
		//System.out.println("age : " + photo.getAge());
		
		//System.out.println("");
		CommonsMultipartFile imagefile = photo.getFile();
		//System.out.println(imagefile.getName());
		//System.out.println(imagefile.getBytes().length);
		//System.out.println(imagefile.getOriginalFilename());
		
		//위 정보로 Photo 클래스에 있는 image  memberfield 값을 생성한다
		
		//[실 파일 업로드 ....]
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path + "\\" + filename;
		
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(imagefile.getBytes());
		fs.close();
		
		return "image/image";
	}
}
