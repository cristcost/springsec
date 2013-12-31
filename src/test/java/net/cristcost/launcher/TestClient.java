package net.cristcost.launcher;

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

    service.serviceOne();
    service.serviceTwo("input");
    service.serviceThree();
    service.serviceFour("input");
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
