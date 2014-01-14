package net.cristcost.study.gwt.client.create;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddTagWidget extends Composite implements AddTagView {

  private Presenter presenter;

  @UiField
  Label messageLabel;

  @UiField
  TextBox tagTextBox;

  @UiField
  CheckBox publicTagCheckBox;

  @UiField
  Button addTagButton;

  interface AddTagWidgetUiBinder extends UiBinder<Widget, AddTagWidget> {
  }

  private static AddTagWidgetUiBinder uiBinder = GWT.create(AddTagWidgetUiBinder.class);

  @UiHandler("addTagButton")
  void onClickAddTag(ClickEvent e) {
    presenter.addTag(tagTextBox.getValue(), publicTagCheckBox.getValue());
  }

  @Override
  public void clearInput() {
    publicTagCheckBox.setValue(false);
    tagTextBox.setValue("");
    tagTextBox.setFocus(true);
  }

  public AddTagWidget() {
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
