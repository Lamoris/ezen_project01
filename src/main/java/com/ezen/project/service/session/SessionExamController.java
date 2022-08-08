package com.ezen.project.service.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SessionExamController {
	private final SessionExample sessionExample;
	private final SessionExample02 sessionExample02;
	
	@PostMapping("")
	@ResponseBody
	public boolean SessionExampleResponse(HttpServletRequest request) {
		Member exam = new Member();
		// 인증내용
		sessionExample.setAttribute(exam);
		return true;
	}

}
