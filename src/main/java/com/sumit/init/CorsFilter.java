package com.sumit.init;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component("CORSFilter")
@Profile("web")
@Slf4j
public class CorsFilter extends OncePerRequestFilter {
  public CorsFilter() {
    // empty
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    log.debug("Processing CORS request for {}", request.getRequestURI());
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

    if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
      log.debug("Procerssing CORS pre-flight request.");
      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
      response.addHeader("Access-Control-Max-Age", "604800");
    }
    filterChain.doFilter(request, response);
  }
}