package com.wen.security.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wen.security.util.CxhcUtil;
@RestController
@RequestMapping("/file")
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@PostMapping
	public void FileUpload(MultipartFile file) {
		logger.info(file.getOriginalFilename());
		if(file!=null) {
			System.out.println(file.getOriginalFilename());
			String path=CxhcUtil.getPath(CxhcUtil.getPrefixName(file.getOriginalFilename()));
			  try {  
		            file.transferTo(new File(path));  
		            System.out.println(path);
		        } catch (Exception e) {  
		            e.printStackTrace();  
		      }  	
		}
	}
	@GetMapping("/{id}")
	public void download (@PathVariable String id,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(id);
		InputStream inputStream=null;
		OutputStream putStream=null;
		try {
			 inputStream=new FileInputStream(new File("C:\\Users\\chenwq\\AppData\\Local\\Temp\\2017\\10\\27\\37163060.txt"));
			 putStream=response.getOutputStream();
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, putStream);
			putStream.flush();
			putStream.close();
			inputStream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
