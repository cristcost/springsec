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

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * The Class TestAspect.
 */
public class TestAspect {
  public Object traceInvocation(ProceedingJoinPoint joinpoint) {
    Object ret = null;
    System.out.println("Processing aspect in: " + joinpoint.getSignature());
    long start = System.currentTimeMillis();
    try {
      ret = joinpoint.proceed();
    } catch (Throwable e) {
      System.out.println("Exception in aspect: " + e.getMessage());
    }
    long end = System.currentTimeMillis();

    System.out.println("@executed in " + (end - start) + " ms");
    System.out.println();
    return ret;
  }
}
