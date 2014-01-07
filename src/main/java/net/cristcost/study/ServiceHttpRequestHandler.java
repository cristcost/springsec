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
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class ServiceServlet.
 */
public class ServiceHttpRequestHandler implements HttpRequestHandler {

  private AuthenticationManager authenticationManager = null;

  private TestService service = null;

  @Override
  public void handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/plain");

    PrintWriter writer = response.getWriter();

    writer.println("Hello from a Spring's HttpRequestHandler");

    SecurityStudyUtil.testSecurity(request, writer, authenticationManager, service);
  }

  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public void setService(TestService service) {
    this.service = service;
  }

}
