package net.cristcost.study.gwt.client.create;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.client.create.AddTagView.Presenter;

public class AddTagActivity extends AbstractActivity implements Presenter {

  private final ClientFactory clientFactory;
  private AddTagView addTagView;

  public AddTagActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    addTagView = clientFactory.getAddTagView();
    addTagView.setPresenter(this);
    panel.setWidget(addTagView);
  }

  @Override
  public void addTag(String tag, boolean isPublic) {
    addTagView.setInfoMessage("Request sent...");
    addTagView.clearInput();
    clientFactory.getTagService().addTag(tag, isPublic, new AsyncCallback<Void>() {

      @Override
      public void onSuccess(Void result) {
        addTagView.setInfoMessage("Tag created!");
      }

      @Override
      public void onFailure(Throwable caught) {
        addTagView.setErrorMessage("Tag creation failure: " + caught.getMessage());
      }
    });
  }
}
