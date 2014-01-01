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

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

/**
 * The Class SecurityStudyUtil.
 */
public class SecurityStudyUtil {

  public static void dumpSecurityInformation(PrintWriter writer,
      AuthenticationManager authenticationManager) {
    writer.println("### Security Information ###");

    writer.println("Security Strategy is "
        + SecurityContextHolder.getContextHolderStrategy().toString());

    writer.println("Current Thread is " + Thread.currentThread().getName() + " ("
        + Thread.currentThread().getId() + ")");

    writer.println();

    if (authenticationManager != null) {
      writer.println("I've been injected with the AuthenticationManager");
    } else {
      writer.println("I've not been injected with the AuthenticationManager");
    }
    writer.println();

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      writer.println("There is an Authentication of type: " + authentication.getClass().getName());
      writer.println("Principal is of type: " + authentication.getPrincipal().getClass().getName()
          + " and is value is: " + authentication.getPrincipal().toString());
      for (GrantedAuthority ga : authentication.getAuthorities()) {
        writer.println(" - you have " + ga.getAuthority() + " authority");
      }

    } else {
      writer.println("There is no Authentication!");
    }
    writer.println();
  }

  public static void authenticate(PrintWriter writer, HttpServletRequest request,
      AuthenticationManager authenticationManager) {
    if (request.getParameter("user") != null) {

      UsernamePasswordAuthenticationToken authRequest =
          new UsernamePasswordAuthenticationToken(request.getParameter("user"),
              request.getParameter("pass"));
      try {
        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        writer.println("Authenticating user: " + request.getParameter("user"));
      } catch (AuthenticationException e) {
        writer.println("! Error while Authenticating: " + e.getMessage());
      }
      writer.println();
    }
  }

  public static void initAnonymous() {
    AnonymousAuthenticationToken auth =
        new AnonymousAuthenticationToken("anonymous", "anonymousUser",
            AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
    SecurityContextHolder.getContext().setAuthentication(auth);
  }

  public static void clearAuthentication() {
    SecurityContextHolder.clearContext();
  }

  public static void wait(PrintWriter writer, HttpServletRequest request,
      AuthenticationManager authenticationManager) {
    if (request.getParameter("entropy") != null) {
      try {
        int waitTime = Integer.parseInt(request.getParameter("entropy"));
        Thread.sleep(waitTime);
        writer.println("* Waiting for creating Thread entropy: " + waitTime + " ms");

      } catch (NumberFormatException | InterruptedException e) {
        writer.println("* Exception while creating Thread entropy: " + e.getMessage());
      }
      writer.println();
    }
  }

  public static void invokeSecuredBean(PrintWriter writer, TestService service) {
    writer.println("### Secured Bean Test ###");

    if (service != null) {
      try {
        service.serviceOne();
        writer.println("Executed service.serviceOne();");
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        service.serviceTwo("input");
        writer.println("Executed service.serviceTwo(...);");
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        String ret = service.serviceThree();
        writer.println("Executed service.serviceThree(); with result: " + ret);
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        String ret = service.serviceFour("input");
        writer.println("Executed service.serviceFour(...); with result: " + ret);
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
    } else {
      writer.println("Service bean not injected!");
    }
    writer.println();
  }
}
