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
package net.cristcost.study.gwt.client.create;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.client.create.AddTagView.Presenter;

// TODO: Auto-generated Javadoc
/**
 * The Class AddTagActivity.
 */
public class AddTagActivity extends AbstractActivity implements Presenter {

  /** The add tag view. */
  private AddTagView addTagView;

  /** The client factory. */
  private final ClientFactory clientFactory;

  /**
   * Instantiates a new adds the tag activity.
   * 
   * @param clientFactory the client factory
   */
  public AddTagActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.create.AddTagView.Presenter#addTag(java.lang.String,
   * boolean)
   */
  @Override
  public void addTag(String tag, boolean isPublic) {
    addTagView.setInfoMessage("Request sent...");
    addTagView.clearInput();
    clientFactory.getTagService().addTag(clientFactory.getCurrentUsername(), tag, isPublic,
        new AsyncCallback<Void>() {

          @Override
          public void onFailure(Throwable caught) {
            addTagView.setErrorMessage("Tag creation failure: " + caught.getMessage());
          }

          @Override
          public void onSuccess(Void result) {
            addTagView.setInfoMessage("Tag created!");
          }
        });
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget,
   * com.google.gwt.event.shared.EventBus)
   */
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    addTagView = clientFactory.getAddTagView();
    addTagView.setPresenter(this);
    panel.setWidget(addTagView);
  }
}
