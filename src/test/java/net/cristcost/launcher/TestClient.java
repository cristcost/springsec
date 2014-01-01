package net.cristcost.launcher;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClient implements Runnable {

  private final static Logger logger = Logger.getLogger(TestClient.class.getName());

  private AuthenticationManager authenticationManager = null;
  
  private TestService service = null;

  public AuthenticationManager getAuthenticationManager() {
    return authenticationManager;
  }

  public TestService getService() {
    return service;
  }

  @Override
  public void run() {
    
    
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    logger.info("The service is of class: " + service.getClass().getName());

    SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_THREADLOCAL);
    
    UsernamePasswordAuthenticationToken authRequest =
        new UsernamePasswordAuthenticationToken("admin", "123");
       Authentication authentication = getAuthenticationManager().authenticate(authRequest);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    
    
    try {
      service.serviceOne();
    } catch (AuthenticationException | AccessDeniedException e) {
      logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
          + e.getClass().getSimpleName() + ")");
    }
    try {
      service.serviceTwo("input");
    } catch (AuthenticationException | AccessDeniedException e) {
      logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
          + e.getClass().getSimpleName() + ")");
    }
    try {
      service.serviceThree();
    } catch (AuthenticationException | AccessDeniedException e) {
      logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
          + e.getClass().getSimpleName() + ")");
    }
    try {
      service.serviceFour("input");
    } catch (AuthenticationException | AccessDeniedException e) {
      logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
          + e.getClass().getSimpleName() + ")");
    }
  }

  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public void setService(TestService service) {
    this.service = service;
  }

  public void startMe() {
    logger.info("Starting thread");
    Thread t = new Thread(this);
    t.start();
  }
}
