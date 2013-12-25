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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * The Class HomeController.
 */
@Controller
public class AppController {

  private static final Logger logger = Logger.getLogger(AppController.class.getName());

  @RequestMapping("/demo.html")
  public String demo() {
    logger.info("Accessing test GWT page");
    return "demo";
  }

  @RequestMapping("/gwt.html")
  public String gwt() {
    logger.info("Accessing test GWT page");
    return "gwt";
  }

  @RequestMapping("/login.html")
  public String login() {
    logger.info("Accessing login form page");
    return "login";
  }

  @RequestMapping("/index.html")
  public String index() {
    logger.info("Accessing index page");
    return "index";
  }
  
  @RequestMapping("/tags.html")
  public String tags() {
    logger.info("Accessing tags page");
    return "tags";
  }

  @RequestMapping("/page403.html")
  public String page403() {
    logger.info("Accessing unathorized page");
    return "page403";
  }
}
