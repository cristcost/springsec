package net.cristcost.launcher;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestSecLauncher {
  public static void main(String[] args) throws IOException {

    ConfigurableApplicationContext springContext =
        new ClassPathXmlApplicationContext("META-INF/spring/test-sec.xml");

    System.out.println("Press ENTER to exit");
    System.in.read();

    System.out.println("exit");
    springContext.close();
  }
}
