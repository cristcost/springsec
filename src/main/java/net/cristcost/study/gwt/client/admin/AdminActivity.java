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
package net.cristcost.study.gwt.client.admin;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.client.admin.AdminView.Presenter;

/**
 * The Class AdminActivity.
 */
public class AdminActivity extends AbstractActivity implements Presenter {

  /** The admin view. */
  private AdminView adminView;

  /** The client factory. */
  private final ClientFactory clientFactory;

  /**
   * Instantiates a new admin activity.
   * 
   * @param clientFactory the client factory
   */
  public AdminActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.admin.AdminView.Presenter#clearAll()
   */
  @Override
  public void clearAll() {
    adminView.setInfoMessage("Request sent...");

    clientFactory.getTagService().clearAllTags(new AsyncCallback<Void>() {

      @Override
      public void onFailure(Throwable caught) {
        adminView.setErrorMessage("Action failure: " + caught.getMessage());
      }

      @Override
      public void onSuccess(Void result) {
        adminView.setInfoMessage("Database is clean!");
      }
    });
  }

  /**
   * Start.
   * 
   * @param panel the panel
   * @param eventBus the event bus
   */
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    adminView = clientFactory.getAdminView();
    adminView.setPresenter(this);
    panel.setWidget(adminView);
  }

}
