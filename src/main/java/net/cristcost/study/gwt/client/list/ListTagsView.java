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
package net.cristcost.study.gwt.client.list;

import com.google.gwt.user.client.ui.IsWidget;

import net.cristcost.study.gwt.shared.Tag;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface ListTagsView.
 */
public interface ListTagsView extends IsWidget {

  /**
   * The Interface Presenter.
   */
  public interface Presenter {

    /**
     * Delete tag.
     * 
     * @param tagUser the tag user
     * @param tag the tag
     */
    void deleteTag(String tagUser, String tag);

    /**
     * Refresh tags.
     */
    void refreshTags();
  }

  /**
   * Clear message.
   */
  void clearMessage();

  /**
   * Sets the error message.
   * 
   * @param string the new error message
   */
  void setErrorMessage(String string);

  /**
   * Sets the info message.
   * 
   * @param string the new info message
   */
  void setInfoMessage(String string);

  /**
   * Sets the presenter.
   * 
   * @param presenter the new presenter
   */
  void setPresenter(Presenter presenter);

  /**
   * Sets the tags.
   *
   * @param tags the new tags
   * @param username the username
   */
  void setTags(List<Tag> tags, String username);

}
