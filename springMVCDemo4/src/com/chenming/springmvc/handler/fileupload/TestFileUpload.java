package com.chenming.springmvc.handler.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 测试文件上传
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/testFileUplad")
public class TestFileUpload
{
	@RequestMapping("/method1")
	public String method1(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file)
	{
		System.out.println("desc: "+desc);
		System.out.println("fileName: "+file.getOriginalFilename());
		
		return "fileupload/testFileUpload_success";
	}
}
