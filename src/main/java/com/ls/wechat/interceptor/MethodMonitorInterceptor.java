package com.ls.wechat.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hx 16-08-19 17:02
 *         监控系统中接口调用执行时间
 */
public class MethodMonitorInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(MethodMonitorInterceptor.class);
    private final String SESSION_TAG = "SYS-Monitor-time";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletRequest.setAttribute(SESSION_TAG, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handlerObject, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute(SESSION_TAG);
        long executeTime = System.currentTimeMillis() - startTime;

        if (log.isDebugEnabled()) {
            if (handlerObject instanceof HandlerMethod) {
                HandlerMethod handler = (HandlerMethod) handlerObject;
                log.debug("[cost:{} ms, method:{}, class:{}]",
                        executeTime, handler.getMethod().getName(), handler.getBeanType());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
