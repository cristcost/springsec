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
package net.cristcost.study.services;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * The Class SecurityStudyUtil.
 */
public class ServiceTestUtil {

  public static void testSecurity(String simpleName, HttpServletRequest request,
      PrintWriter writer, AuthenticationManager authenticationManager, List<TestService> services) {

    writer.println("Performing test on " + simpleName);
    writer.println();
    writer.println("I will perform a serie of method invocation on " + services.size()
        + " different beans");
    writer.println();

    // Suspend the the Thread for ms of time from "wait" parameter,
    // used to make some test on behavior of SecurityContext with multiple threads
    ServiceTestUtil.wait(writer, request, authenticationManager);

    SecurityContext oldContext = null;
    try {
      // if "user" and "pass" parameter are sent, override the security context and perform a new
      // authentication. Return old context that is needed to be restored at the end of the method
      oldContext = ServiceTestUtil.authenticate(writer, request, authenticationManager);

      // Dump current security information
      ServiceTestUtil.dumpSecurityInformation(writer, authenticationManager);

      // Invoke the beans
      for (TestService service : services) {
        ServiceTestUtil.invokeSecuredBean(writer, service);
      }
    } finally {
      ServiceTestUtil.clearAuthentication(writer, oldContext);
      // Note: I'm not resetting to anonymous, do it with SecurityStudyUtil.initAnonymous();
    }
  }

  private static SecurityContext authenticate(PrintWriter writer, HttpServletRequest request,
      AuthenticationManager authenticationManager) {

    SecurityContext initialContext = SecurityContextHolder.getContext();

    if (request.getParameter("user") != null) {

      UsernamePasswordAuthenticationToken authRequest =
          new UsernamePasswordAuthenticationToken(request.getParameter("user"),
              request.getParameter("pass"));
      try {
        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        writer.println("Authenticating user: " + request.getParameter("user"));
      } catch (AuthenticationException e) {
        writer.println("! Error while Authenticating: " + e.getMessage());
      }
      writer.println();
    }

    return initialContext;
  }

  private static void clearAuthentication(PrintWriter writer, SecurityContext oldContext) {
    if (oldContext != SecurityContextHolder.getContext()) {
      SecurityContextHolder.clearContext();
      SecurityContextHolder.setContext(oldContext);
      writer.println("@Restoring older context after secured session");
    }
  }

  private static void dumpSecurityInformation(PrintWriter writer,
      AuthenticationManager authenticationManager) {
    writer.println("### General Security Information ###");

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

  private static void initAnonymous() {
    AnonymousAuthenticationToken auth =
        new AnonymousAuthenticationToken("anonymous", "anonymousUser",
            AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
    SecurityContextHolder.getContext().setAuthentication(auth);
  }

  private static void invokeSecuredBean(PrintWriter writer, TestService service) {

    if (service != null) {
      String serviceName = service.getName();
      String serviceDescription = service.getDescription();

      writer.println("### Performing test on " + serviceName + "###");
      writer.println(serviceDescription);
      writer.println();

      try {
        service.serviceOne();
        writer.println("Executed " + serviceName + ".serviceOne();");
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        service.serviceTwo("input");
        writer.println("Executed " + serviceName + ".serviceTwo(...);");
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        String ret = service.serviceThree();
        writer.println("Executed " + serviceName + ".serviceThree(); with result: " + ret);
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        String ret = service.serviceFour("input");
        writer.println("Executed " + serviceName + ".serviceFour(...); with result: " + ret);
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
      try {
        List<String> ret = service.serviceFive();
        if (ret != null) {
          writer.println("Executed " + serviceName + ".serviceFive with result "
              + Arrays.toString(ret.toArray()));
        } else {
          writer.println("Executed " + serviceName + ".serviceFive with result null!");
        }
      } catch (AuthenticationException | AccessDeniedException e) {
        writer.println("Auth failed: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
      }
    } else {
      writer.println("Service bean not injected!");
    }
    writer.println();
    writer.println();
  }

  private static void wait(PrintWriter writer, HttpServletRequest request,
      AuthenticationManager authenticationManager) {
    if (request.getParameter("entropy") != null) {
      try {
        int waitTime = Integer.parseInt(request.getParameter("wait"));
        Thread.sleep(waitTime);
        writer.println("* Waiting for creating Thread entropy: " + waitTime + " ms");

      } catch (NumberFormatException | InterruptedException e) {
        writer.println("* Exception while creating Thread entropy: " + e.getMessage());
      }
      writer.println();
    }
  }

}
