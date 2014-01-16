package net.cristcost.launcher;

import net.cristcost.study.services.ImplNameUtil;
import net.cristcost.study.services.TestService;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClient implements Runnable {

  private final static Logger logger = Logger.getLogger(TestClient.class.getName());

  private AuthenticationManager authenticationManager = null;

  private List<TestService> services = null;

  public AuthenticationManager getAuthenticationManager() {
    return authenticationManager;
  }

  @Override
  public void run() {
    for (TestService service : services) {
      logger.info("The service is of class: " + service.getClass().getName());
      if (authenticationManager != null) {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_THREADLOCAL);

        UsernamePasswordAuthenticationToken authRequest =
            new UsernamePasswordAuthenticationToken("admin", "123");
        Authentication authentication = getAuthenticationManager().authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
      try {
        service.serviceOne();
        System.out.println(((ImplNameUtil) service).getImplName() + ".serviceOne");
      } catch (AuthenticationException | AccessDeniedException e) {
        logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
            + e.getClass().getSimpleName() + ")");
      }
      try {
        service.serviceTwo("input");
        System.out.println(((ImplNameUtil) service).getImplName() + ".serviceTwo");
      } catch (AuthenticationException | AccessDeniedException e) {
        logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
            + e.getClass().getSimpleName() + ")");
      }
      try {
        String s = service.serviceThree();
        System.out.println(((ImplNameUtil) service).getImplName() + ".serviceThree: " + s);
      } catch (AuthenticationException | AccessDeniedException e) {
        logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
            + e.getClass().getSimpleName() + ")");
      }
      try {
        String s = service.serviceFour("input");
        System.out.println(((ImplNameUtil) service).getImplName() + ".serviceFour: " + s);
      } catch (AuthenticationException | AccessDeniedException e) {
        logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
            + e.getClass().getSimpleName() + ")");
      }
      try {
        List<String> serviceFive = service.serviceFive();
        if (serviceFive != null) {
          System.out.println(((ImplNameUtil) service).getImplName() + ".serviceFive: "
              + Arrays.toString(serviceFive.toArray()));
        } else {
          System.out.println(((ImplNameUtil) service).getImplName() + ".serviceFive retured null!");
        }
      } catch (AuthenticationException | AccessDeniedException e) {
        logger.log(Level.WARNING, "Auth failed: " + e.getMessage() + " ("
            + e.getClass().getSimpleName() + ")");
      }
    }
  }

  public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public void startMe() {
    logger.info("Starting thread");
    Thread t = new Thread(this);
    t.start();
  }

  public List<TestService> getServices() {
    return services;
  }

  public void setServices(List<TestService> services) {
    this.services = services;
  }
}
