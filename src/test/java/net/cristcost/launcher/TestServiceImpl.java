package net.cristcost.launcher;


import java.util.logging.Logger;

public class TestServiceImpl implements TestService {
  private final static Logger logger = Logger.getLogger(TestServiceImpl.class.getName());

  @Override
  public void serviceOne() {
    logger.info("serviceOne");
  }

  @Override
  public void serviceTwo(String input) {
    logger.info("serviceTwo: " + input);
  }

  @Override
  public String serviceThree() {
    logger.info("serviceThree");
    return "ok";
  }

  @Override
  public String serviceFour(String input) {
    logger.info("serviceFour: " + input);
    return "ok " + input;
  }
}
