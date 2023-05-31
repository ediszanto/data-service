package com.microservices.bootcamp.rds.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice
public class RestLoggingHandler extends CommonsRequestLoggingFilter implements ResponseBodyAdvice<Object> {
    public RestLoggingHandler() {
        this.setIncludeQueryString(true);
        this.setIncludePayload(true);
        this.setMaxPayloadLength(10000);
        this.setIncludeHeaders(false);
        this.setAfterMessagePrefix("Request data: [");
        this.setAfterMessageSuffix("]");
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {

    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest && response instanceof ServletServerHttpResponse){
            log.debug("Response data: [{}]", body);
        }
        return body;
    }
}
