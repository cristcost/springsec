package net.cristcost.study.gwt.client.list;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.shared.Tag;

import java.util.Iterator;
import java.util.List;

public class ListTagActivity extends AbstractActivity implements ListTagsView.Presenter {

  private final ClientFactory clientFactory;
  private ListTagsView listTagView;
  private List<Tag> tags = null;

  public ListTagActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    listTagView = clientFactory.getListTagView();
    listTagView.setPresenter(this);

    panel.setWidget(listTagView);
    refreshTags();
  }

  @Override
  public void refreshTags() {
    clientFactory.getTagService().listTags(new AsyncCallback<List<Tag>>() {

      @Override
      public void onSuccess(List<Tag> result) {
        tags = result;
        listTagView.clearMessage();
        listTagView.setTags(tags);
      }

      @Override
      public void onFailure(Throwable caught) {
        listTagView.setErrorMessage("Error while accessing the service.");
      }
    });

    listTagView.setInfoMessage("Loading...");
  }

  @Override
  public void deleteTag(final String tagUser, final String tag) {
    clientFactory.getTagService().deleteTag(tagUser, tag, new AsyncCallback<Void>() {

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
        listTagView.setTags(tags);
      }

      @Override
      public void onFailure(Throwable caught) {
        listTagView.setErrorMessage("Error deleting tag: " + tag);
      }
    });
  }
}
