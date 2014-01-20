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

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.shared.Tag;

import java.util.Iterator;
import java.util.List;

/**
 * The Class ListTagActivity.
 */
public class ListTagActivity extends AbstractActivity implements ListTagsView.Presenter {

  /** The client factory. */
  private final ClientFactory clientFactory;

  /** The list tag view. */
  private ListTagsView listTagView;

  /** The tags. */
  private List<Tag> tags = null;

  /**
   * Instantiates a new list tag activity.
   * 
   * @param clientFactory the client factory
   */
  public ListTagActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView.Presenter#deleteTag(java.lang.String,
   * java.lang.String)
   */
  @Override
  public void deleteTag(final String tagUser, final String tag) {
    clientFactory.getTagService().deleteTag(tagUser, tag, new AsyncCallback<Void>() {

      @Override
      public void onFailure(Throwable caught) {
        listTagView.setErrorMessage("Error deleting tag: " + tag);
      }

      @Override
      public void onSuccess(Void result) {
        listTagView.setInfoMessage("Tag " + tag + " deleted");

        Iterator<Tag> iter = tags.iterator();
        while (iter.hasNext()) {
          Tag currentTag = iter.next();
          if (currentTag.getUsername().equals(tagUser) && currentTag.getTag().equals(tag)) {
            iter.remove();
          }
        }
        listTagView.setTags(tags, clientFactory.getCurrentUsername());
      }
    });
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView.Presenter#refreshTags()
   */
  @Override
  public void refreshTags() {
    clientFactory.getTagService().listTags(new AsyncCallback<List<Tag>>() {

      @Override
      public void onFailure(Throwable caught) {
        listTagView.setErrorMessage("Error while accessing the service.");
      }

      @Override
      public void onSuccess(List<Tag> result) {
        tags = result;
        listTagView.clearMessage();
        listTagView.setTags(tags, clientFactory.getCurrentUsername());
      }
    });

    listTagView.setInfoMessage("Loading...");
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
    listTagView = clientFactory.getListTagView();
    listTagView.setPresenter(this);

    panel.setWidget(listTagView);
    refreshTags();
  }
}
