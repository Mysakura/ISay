package com.internetsaying.web.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.internetsaying.common.base.BaseResponse;
import com.internetsaying.exception.CommonException;
import com.internetsaying.exception.enums.ExceptionEnum;

@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
	
	private static Logger log = LoggerFactory.getLogger(CustomExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception e) {
		e.printStackTrace(); 	// 打印堆栈信息
		String xmlHttpRequest = request.getHeader("X-Requested-With");
		if(xmlHttpRequest != null){	//Ajax请求
			log.error("Ajax异常-请求路径-{}-请求参数-{}-异常-{}", request.getRequestURI(), request.getParameterMap(), e.getMessage());
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				PrintWriter writer = response.getWriter();
				if(e instanceof CommonException)
					writer.write(JSONObject.toJSONString(new BaseResponse<Void>(ExceptionEnum.REQUEST_FAILED.code, ((CommonException)e).getMessage(), null)));
				else
					writer.write(JSONObject.toJSONString(new BaseResponse<Void>(ExceptionEnum.REQUEST_FAILED.code, ExceptionEnum.REQUEST_FAILED.msg, null)));
				writer.flush();
			} catch (IOException e1) {
				log.error("Ajax异常-获取输出流出错-异常-{}", e1.getMessage());
			}
			return new ModelAndView();	//这一步不能返回null
		}else{
			log.error("URL异常-请求路径-{}-请求参数-{}-异常-{}", request.getRequestURI(), request.getParameterMap(), e.getMessage());
			//如果是文件异常，那么也属于Ajax，要返回JSON
			if(e instanceof MaxUploadSizeExceededException){
				try {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json");
					PrintWriter writer = response.getWriter();
					writer.write(JSONObject.toJSONString(new BaseResponse<Void>(ExceptionEnum.REQUEST_FAILED.code, "文件过大", null)));
					writer.flush();
				} catch (IOException e1) {
					log.error("URL异常-获取输出流出错-异常-{}", e1.getMessage());
				}
				return new ModelAndView();
			}
			ModelAndView mv = new ModelAndView("redirect:/error");
			if(e instanceof CommonException)
				request.getSession().setAttribute("error", ((CommonException)e).getMessage());
			else if(e instanceof AuthenticationException)
				request.getSession().setAttribute("error", ExceptionEnum.LOGIN_FAILED.msg);
			else
				request.getSession().setAttribute("error", ExceptionEnum.REQUEST_FAILED.msg);
			return mv;
		}
	}

}
