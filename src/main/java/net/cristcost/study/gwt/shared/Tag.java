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
package net.cristcost.study.gwt.shared;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Tag.
 */
@SuppressWarnings("serial")
public class Tag implements Serializable {

  /** The pub. */
  private boolean pub;

  /** The tag. */
  private String tag;

  /** The username. */
  private String username;

  /**
   * Instantiates a new tag.
   */
  public Tag() {
  }

  /**
   * Instantiates a new tag.
   * 
   * @param username the username
   * @param tag the tag
   * @param pub the pub
   */
  public Tag(String username, String tag, boolean pub) {
    this.username = username;
    this.tag = tag;
    this.pub = pub;
  }

  /**
   * Gets the tag.
   * 
   * @return the tag
   */
  public String getTag() {
    return tag;
  }

  /**
   * Gets the username.
   * 
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Checks if is public.
   * 
   * @return true, if is public
   */
  public boolean isPublic() {
    return pub;
  }

  /**
   * Sets the public.
   * 
   * @param isPublic the new public
   */
  public void setPublic(boolean isPublic) {
    this.pub = pub;
  }

  /**
   * Sets the tag.
   * 
   * @param tag the new tag
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  /**
   * Sets the username.
   * 
   * @param username the new username
   */
  public void setUsername(String username) {
    this.username = username;
  }
}
