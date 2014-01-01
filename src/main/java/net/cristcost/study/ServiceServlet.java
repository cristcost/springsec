/*
 * Copyright 2013, Cristiano Costantini, Giuseppe Gerla, Michele Ficarra, Sergio Ciampi, Stefano
 * Cigheri.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package net.cristcost.study;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class ServiceServlet.
 */
@SuppressWarnings("serial")
public class ServiceServlet extends HttpServlet {

  private AuthenticationManager authenticationManager = null;

  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/plain");

    PrintWriter writer = response.getWriter();

    writer.println("Hello from a standard HttpServlet");

    if (authenticationManager != null) {
      writer.println("I've been injected with the AuthenticationManager");
    } else {
      writer.println("I've not been injected with the AuthenticationManager");
    }

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      writer.println("There is an Authentication of type: " + authentication.getClass().getName());
    } else {
      writer.println("There is no Authentication!");
    }
  }
}
