package com.zerobase.convpay.config;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Hello LogFilter : " + Thread.currentThread());
        chain.doFilter(request, response);
        log.info("Bye LogFilter : " + Thread.currentThread());
    }

}
