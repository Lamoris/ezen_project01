package com.ezen.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("")
	public String helloWorld() {
		String hd = "내이름은 서현덕 맞을껄";
		return hd;
	}
}
