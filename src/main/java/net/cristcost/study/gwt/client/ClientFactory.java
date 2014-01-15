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
package net.cristcost.study.gwt.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import net.cristcost.study.gwt.client.admin.AdminView;
import net.cristcost.study.gwt.client.create.AddTagView;
import net.cristcost.study.gwt.client.list.ListTagsView;
import net.cristcost.study.gwt.client.utils.NavigationView;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Client objects.
 */
public interface ClientFactory {

  /**
   * Gets the adds the tag view.
   * 
   * @return the adds the tag view
   */
  AddTagView getAddTagView();

  /**
   * Gets the admin view.
   * 
   * @return the admin view
   */
  AdminView getAdminView();

  /**
   * Gets the event bus.
   * 
   * @return the event bus
   */
  EventBus getEventBus();

  /**
   * Gets the list tag view.
   * 
   * @return the list tag view
   */
  ListTagsView getListTagView();

  /**
   * Gets the navigation view.
   * 
   * @return the navigation view
   */
  NavigationView getNavigationView();

  /**
   * Gets the place controller.
   * 
   * @return the place controller
   */
  PlaceController getPlaceController();

  /**
   * Gets the tag service.
   * 
   * @return the tag service
   */
  GwtTagServiceAsync getTagService();

}
