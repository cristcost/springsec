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
package net.cristcost.study.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * The Class HomeController.
 */
@Controller
public class AppController {

  private static final Logger logger = Logger.getLogger(AppController.class.getName());

  @RequestMapping("/index.html")
  public String index() {
    logger.info("Accessing index page");
    return "index";
  }

  @RequestMapping("/login.html")
  public String login() {
    logger.info("Accessing login form page");
    return "login";
  }

  @RequestMapping("/page403.html")
  public String page403() {
    logger.info("Accessing unathorized page");
    return "page403";
  }

  @RequestMapping("/page404.html")
  public String page404() {
    logger.info("Accessing page not found");
    return "page404";
  }

  @RequestMapping("/tags.basic.html")
  public String tagsBasic() {
    logger.info("Accessing tags.basic page");
    return "tags.basic";
  }

  @RequestMapping("/tags.sec.html")
  public String tagsSec() {
    logger.info("Accessing tags.sec page");
    return "tags.sec";
  }

  @RequestMapping("/demo.admin.html")
  public ModelAndView demoAdmin() {
    logger.info("Accessing demo.admin page");
    ModelAndView model = new ModelAndView("demo");
    model.addObject("title", "Page for Admin");
    model.addObject("page_description", "This page is accessible only to user with ADMIN role");
    return model;
  }

  @RequestMapping("/demo.user.html")
  public ModelAndView demoUser() {
    logger.info("Accessing demo.user page");
    ModelAndView model = new ModelAndView("demo");
    model.addObject("title", "Page for Users");
    model.addObject("page_description", "This page is accessible only to user with USER role");
    return model;
  }

  @RequestMapping("/demo.any.html")
  public ModelAndView demoAny() {
    logger.info("Accessing demo.any page");
    ModelAndView model = new ModelAndView("demo");
    model.addObject("title", "Page for Anyone");
    model.addObject("page_description", "This page is accessible to anyone");
    return model;
  }

  @RequestMapping("/demo.auth.html")
  public ModelAndView demoAuth() {
    logger.info("Accessing demo.auth page");
    ModelAndView model = new ModelAndView("demo");
    model.addObject("title", "Page for Authenticated users");
    model.addObject("page_description", "This page is accessible to authenticated user");
    return model;
  }

  @RequestMapping("/demo.unauth.html")
  public ModelAndView demoUnauth() {
    logger.info("Accessing demo.unauth page");
    ModelAndView model = new ModelAndView("demo");
    model.addObject("title", "Page for visitor NOT Authenticated");
    model.addObject("page_description",
        "This page is accessible only if you have not authenticated yet");
    return model;
  }

  @RequestMapping("/web.angular.html")
  public String webAngular() {
    logger.info("Accessing web.angular page");
    return "web.angular";
  }

  @RequestMapping("/web.gwt.html")
  public String webGwt() {
    logger.info("Accessing web.gwt page");
    return "web.gwt";
  }

  @RequestMapping("/web.jquery.html")
  public String webJquery() {
    logger.info("Accessing web.jquery page");
    return "web.jquery";
  }

  @RequestMapping("/gwt.hacked.html")
  public String gwtHacked() {
    logger.info("Accessing gwt.hacked page");
    return "gwt.hacked";
  }

  @RequestMapping("/gwt.secured.html")
  public String gwtSecured() {
    logger.info("Accessing gwt.secured page");
    return "gwt.secured";
  }

}
