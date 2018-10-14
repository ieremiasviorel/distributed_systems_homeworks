/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment_1.distributed_systems.flightmanagementsystem.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ADMIN".equals(auth.getAuthority())) {
				response.sendRedirect("/admin");
			} else if ("CLIENT".equals(auth.getAuthority())) {
				response.sendRedirect("/client");
			} else {
				response.sendRedirect("login?error");
			}
		}
	}
}
