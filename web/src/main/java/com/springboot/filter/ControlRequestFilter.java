package com.springboot.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import com.springboot.util.ControlUtil;

/**
 * 登陆过滤 
 */
//@Order(2)
//@WebFilter(filterName="controlRequestFilter", urlPatterns="/front/*")
public class ControlRequestFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlRequestFilter.class);
	private String controlPath = "control/control.xml";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
	    if (path.startsWith(servletRequest.getContextPath())) {
	        path = path.substring(servletRequest.getContextPath().length(), path.length());
	    }
		//校验action
		if(!ControlUtil.controlMap.isEmpty()) {
			if(!ControlUtil.controlMap.containsKey(path)) {
				LOGGER.info("系统未发现："+path);
				errorResponse(servletResponse,"系统未发现此path");
				return;
			}
		}
		//校验action
		String result = ControlUtil.validate(path,getRequestParamters(servletRequest));
		if(!StringUtils.isEmpty(result)) {
			errorResponse(servletResponse,result);
			return;
		}
		chain.doFilter(servletRequest, servletResponse);
	}
	
	private static void errorResponse(HttpServletResponse response,String msg) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
	
	private Map<String, String[]> getRequestParamters(HttpServletRequest request){
	    Map<String, String[]> params = new HashMap<>();
	    Enumeration<String> enums = request.getParameterNames();
	    while (enums.hasMoreElements())
	    {
	      String name = (String)enums.nextElement();
	      String[] value = request.getParameterValues(name);
	      params.put(name, value);
	    }
	    return params;
	  }
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ControlUtil.init(controlPath);
	}

	@Override
	public void destroy() {

	}

}
