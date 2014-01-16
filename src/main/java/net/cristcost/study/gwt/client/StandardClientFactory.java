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

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import net.cristcost.study.gwt.client.admin.AdminView;
import net.cristcost.study.gwt.client.admin.AdminWidget;
import net.cristcost.study.gwt.client.create.AddTagView;
import net.cristcost.study.gwt.client.create.AddTagWidget;
import net.cristcost.study.gwt.client.list.ListTagsView;
import net.cristcost.study.gwt.client.list.ListTagsWidget;
import net.cristcost.study.gwt.client.utils.NavigationView;
import net.cristcost.study.gwt.client.utils.NavigationWidget;

/**
 * A factory for creating StandardClient objects.
 */
public class StandardClientFactory implements ClientFactory {

  /** The add tag view. */
  private final AddTagView addTagView = new AddTagWidget();

  /** The admin view. */
  private final AdminView adminView = new AdminWidget();

  /** The event bus. */
  private final EventBus eventBus = new SimpleEventBus();

  /** The list tags view. */
  private final ListTagsView listTagsView = new ListTagsWidget();

  /** The navigation view. */
  private final NavigationView navigationView = new NavigationWidget();

  /** The place controller. */
  private final PlaceController placeController = new PlaceController(eventBus);

  /** The tag service. */
  private final GwtTagServiceAsync tagService = GWT.create(GwtTagService.class);

  /** The page config. */
  private final Dictionary pageConfig = Dictionary.getDictionary("getPageConfig");

  public StandardClientFactory() {
    if (getPageConfig() != null && getPageConfig().get("tagServiceEndpoint") != null) {
      ((ServiceDefTarget) tagService).setServiceEntryPoint(getPageConfig().get("tagServiceEndpoint"));
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getAddTagView()
   */
  @Override
  public AddTagView getAddTagView() {
    return this.addTagView;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getAdminView()
   */
  @Override
  public AdminView getAdminView() {
    return this.adminView;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getEventBus()
   */
  @Override
  public EventBus getEventBus() {
    return this.eventBus;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getListTagView()
   */
  @Override
  public ListTagsView getListTagView() {
    return this.listTagsView;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getNavigationView()
   */
  @Override
  public NavigationView getNavigationView() {
    return this.navigationView;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getPlaceController()
   */
  @Override
  public PlaceController getPlaceController() {
    return this.placeController;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.ClientFactory#getTagService()
   */
  @Override
  public GwtTagServiceAsync getTagService() {
    return tagService;
  }

  public Dictionary getPageConfig() {
    return pageConfig;
  }

}
