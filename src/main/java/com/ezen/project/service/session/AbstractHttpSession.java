package com.ezen.project.service.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class AbstractHttpSession<T> {
	protected abstract String key();
	
	public void setAttribute(T value) {
		getSession().setAttribute(key(), value);
	}
	@SuppressWarnings("unchecked")
	public T getAttribute() {
		return (T) getSession().getAttribute(key());
	}
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected HttpServletRequest getRequest() {
		RequestAttributes requestAttributes =
				RequestContextHolder.getRequestAttributes();
		if(requestAttributes != null) {
			return ((ServletRequestAttributes)requestAttributes).getRequest();
		}
		return null;
	} 
	public void removeAttribute() {
		getSession().removeAttribute(key());
	}
	public void invalidate() {
		getSession().invalidate();
	}
}
