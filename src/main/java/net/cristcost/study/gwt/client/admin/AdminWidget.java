package net.cristcost.study.gwt.client.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AdminWidget extends Composite implements AdminView {

  private Presenter presenter;

  @UiField
  Label messageLabel;

  @UiField
  Button clearTagButton;

  interface AdminWidgetUiBinder extends UiBinder<Widget, AdminWidget> {
  }

  private static AdminWidgetUiBinder uiBinder = GWT.create(AdminWidgetUiBinder.class);

  @UiHandler("clearTagButton")
  void onClickAddTag(ClickEvent e) {
    presenter.clearAll();
  }

  public AdminWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void clearMessage() {
    messageLabel.setVisible(false);
    messageLabel.setText("");
    // TODO: set class to null?
  }

  @Override
  public void setErrorMessage(String errorMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(errorMessage);
    // TODO: set a bootstrap class for error
  }

  @Override
  public void setInfoMessage(String infoMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(infoMessage);
    // TODO: set a bootstrap class for information
  }
}
