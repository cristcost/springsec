package net.cristcost.launcher;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClient implements Runnable {

  private final static Logger logger = Logger.getLogger(TestClient.class.getName());

  private TestService service = null;

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

  public void setService(TestService service) {
    this.service = service;
  }

  public void startMe() {
    logger.info("Starting thread");
    Thread t = new Thread(this);
    t.start();
  }
}
