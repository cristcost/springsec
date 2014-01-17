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

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import net.cristcost.study.gwt.client.admin.AdminPlace;
import net.cristcost.study.gwt.client.create.AddTagPlace;
import net.cristcost.study.gwt.client.list.ListTagsPlace;
import net.cristcost.study.gwt.client.utils.NavigationView;
import net.cristcost.study.gwt.client.utils.NavigationWidget;

// TODO: Auto-generated Javadoc
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SecureMeApp implements EntryPoint {

  /** The app widget. */
  private SimplePanel appWidget = new SimplePanel();

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private Place defaultPlace = new ListTagsPlace();

  /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {
    ClientFactory clientFactory = GWT.create(StandardClientFactory.class);

    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();

    ActivityMapper activityMapper = new SecureMeActivityMapper(clientFactory);

    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(appWidget);

    SecureMeHistoryMapper historyMapper = GWT.create(SecureMeHistoryMapper.class);

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    // add navigation with gwt if the navigation div is found
    RootPanel navigationRootPanel = RootPanel.get("navigation");
    if (navigationRootPanel != null) {
      navigationRootPanel.add(createPopulatedMenu(historyMapper));
    }

    RootPanel.get("application").add(appWidget);
    historyHandler.handleCurrentHistory();
  }

  /**
   * Creates the populated menu.
   * 
   * @param historyMapper the history mapper
   * @return the navigation view
   */
  private NavigationView createPopulatedMenu(SecureMeHistoryMapper historyMapper) {
    NavigationView navWidget = new NavigationWidget();
    navWidget.setHomeUrl("#" + historyMapper.getToken(new ListTagsPlace()));
    navWidget.setAddUrl("#" + historyMapper.getToken(new AddTagPlace()));
    navWidget.setAdminUrl("#" + historyMapper.getToken(new AdminPlace()));
    return navWidget;
  }
}
