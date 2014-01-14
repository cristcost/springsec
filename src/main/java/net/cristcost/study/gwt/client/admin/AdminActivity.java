package net.cristcost.study.gwt.client.admin;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import net.cristcost.study.gwt.client.ClientFactory;
import net.cristcost.study.gwt.client.admin.AdminView.Presenter;

public class AdminActivity extends AbstractActivity implements Presenter {

  private final ClientFactory clientFactory;
  private AdminView adminView;

  public AdminActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    adminView = clientFactory.getAdminView();
    adminView.setPresenter(this);
    panel.setWidget(adminView);
  }

  @Override
  public void clearAll() {
    adminView.setInfoMessage("Request sent...");

    clientFactory.getTagService().clearAllTags(new AsyncCallback<Void>() {

      @Override
      public void onSuccess(Void result) {
        adminView.setInfoMessage("Database is clean!");
      }

      @Override
      public void onFailure(Throwable caught) {
        adminView.setErrorMessage("Action failure: " + caught.getMessage());
      }
    });
  }
    
  
}
