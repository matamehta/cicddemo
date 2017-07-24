package com.karsun.kic;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Simple CORS filter. Intercepts all requests to the server and ensures that OPTIONS
 * method does not go further in to the Spring Boot application processing 
 * and is responded to from this filer itself.
 * 
 * @author Karsun Solutions LLC
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");

        // Defining the caching of the OPTIONS message to 10 minutes.  
        response.setHeader("Access-Control-Max-Age", "600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Key, Authorization, Cache-Control, Pragma, Expires");

        //Ensures that Access control headers if set as a part of the response object are exposed for processing on the client
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.
		response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

		if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// Intentionally blank
	}

	@Override
	public void destroy() {
		// Intentionally blank
	}
}
