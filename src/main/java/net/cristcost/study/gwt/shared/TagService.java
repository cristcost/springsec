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

import java.util.List;

/**
 * The Interface TagService.
 */
public interface TagService {

  /**
   * Adds the tag.
   * 
   * @param tag the tag
   * @param isPublic the is public
   */
  void addTag(String tagUser, String tag, boolean isPublic);

  /**
   * Clear all tags.
   */
  void clearAllTags();

  /**
   * Delete tag.
   * 
   * @param tagUser the tag user
   * @param tag the tag
   */
  void deleteTag(String tagUser, String tag);

  /**
   * List tags.
   * 
   * @return the list
   */
  List<Tag> listTags();
}
