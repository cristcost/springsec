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

// TODO: Auto-generated Javadoc
/**
 * The Class AddTagWidget.
 */
public class AddTagWidget extends Composite implements AddTagView {

  /**
   * The Interface AddTagWidgetUiBinder.
   */
  interface AddTagWidgetUiBinder extends UiBinder<Widget, AddTagWidget> {
  }

  /** The ui binder. */
  private static AddTagWidgetUiBinder uiBinder = GWT.create(AddTagWidgetUiBinder.class);

  /** The add tag button. */
  @UiField
  Button addTagButton;

  /** The message label. */
  @UiField
  Label messageLabel;

  /** The public tag check box. */
  @UiField
  CheckBox publicTagCheckBox;

  /** The tag text box. */
  @UiField
  TextBox tagTextBox;

  /** The presenter. */
  private Presenter presenter;

  /**
   * Instantiates a new adds the tag widget.
   */
  public AddTagWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.create.AddTagView#clearInput()
   */
  @Override
  public void clearInput() {
    publicTagCheckBox.setValue(false);
    tagTextBox.setValue("");
    tagTextBox.setFocus(true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.create.AddTagView#clearMessage()
   */
  @Override
  public void clearMessage() {
    messageLabel.setVisible(false);
    messageLabel.setText("");
    // TODO: set class to null?
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.create.AddTagView#setErrorMessage(java.lang.String)
   */
  @Override
  public void setErrorMessage(String errorMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(errorMessage);
    // TODO: set a bootstrap class for error
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.create.AddTagView#setInfoMessage(java.lang.String)
   */
  @Override
  public void setInfoMessage(String infoMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(infoMessage);
    // TODO: set a bootstrap class for information
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * net.cristcost.study.gwt.client.create.AddTagView#setPresenter(net.cristcost.study.gwt.client
   * .create.AddTagView.Presenter)
   */
  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  /**
   * On click add tag.
   * 
   * @param e the e
   */
  @UiHandler("addTagButton")
  void onClickAddTag(ClickEvent e) {
    presenter.addTag(tagTextBox.getValue(), publicTagCheckBox.getValue());
  }
}
