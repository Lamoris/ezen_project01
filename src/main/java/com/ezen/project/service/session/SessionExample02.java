package com.ezen.project.service.session;

import org.springframework.stereotype.Component;

@Component
public class SessionExample02 extends AbstractHttpSession<SessionExam02>{

	@Override
	protected String key() {
		return "SESSION_EXAM02";
	}
}
