package net.cristcost.launcher;

import java.util.logging.Logger;

public class TestService {
  private final static Logger logger = Logger.getLogger(TestService.class.getName());

  public void serviceOne() {
    logger.info("serviceOne");
  }

  public void serviceTwo(String input) {
    logger.info("serviceTwo: " + input);
  }

  public String serviceThree() {
    logger.info("serviceThree");
    return "ok";
  }

  public String serviceFour(String input) {
    logger.info("serviceFour: " + input);
    return "ok " + input;
  }
}
