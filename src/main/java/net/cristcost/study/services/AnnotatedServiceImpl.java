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

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;

/**
 * The Class TestServiceImpl.
 */
public class AnnotatedServiceImpl implements TestService, ImplNameUtil {
  private static final Logger logger = Logger.getLogger(AnnotatedServiceImpl.class.getName());

  @Override
  public String getImplName() {
    return AnnotatedServiceImpl.class.getSimpleName();
  }

  @Override
  @PostFilter("hasPermission(filterObject, 'please')")
  public List<String> serviceFive() {
    logger.info("serviceFive");
    return new CopyOnWriteArrayList<>(Arrays.asList("one", "two", "three"));
  }

  @Override
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostAuthorize("returnObject.length() > 3")
  public String serviceFour(String input) {
    logger.info("serviceFour: " + input);
    return "ok " + input;
  }

  @Override
  public void serviceOne() {
    logger.info("serviceOne");
  }

  @Override
  @RolesAllowed("ROLE_ADMIN")
  public String serviceThree() {
    logger.info("serviceThree");
    return "ok";
  }

  @Override
  @Secured("ROLE_ADMIN")
  public void serviceTwo(String input) {
    logger.info("serviceTwo: " + input);
  }

}
