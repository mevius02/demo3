package com.example.demo.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	/* API処理完了後(正常、異常問わず)必ず実行される */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex)
			throws Exception {
		logger.info("Interceptor.afterCompletion()ログ出力");
	}
}
