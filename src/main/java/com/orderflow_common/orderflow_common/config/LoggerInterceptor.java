package com.orderflow_common.orderflow_common.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static com.orderflow_common.orderflow_common.constant.ResponseConstant.MDC_TRACE_ID;

public class LoggerInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        String traceId = UUID.randomUUID().toString();
        MDC.put(MDC_TRACE_ID, traceId);
        request.setAttribute(MDC_TRACE_ID, traceId);

        LOGGER.info(
                "[preHandle][{}] [{}] {}", request, request.getMethod(), request.getRequestURI()
        );
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
        LOGGER.info("[postHandle][{}]", response);
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
        LOGGER.info("[afterCompletion][ {} ]", request);
    }
}
