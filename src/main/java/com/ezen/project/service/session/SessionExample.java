package com.ezen.project.service.session;

import org.springframework.stereotype.Component;

@Component
public class SessionExample extends AbstractHttpSession<SessionExam01>{

	@Override
	protected String key() {
		return "SESSION_EXAM";
	}
}
