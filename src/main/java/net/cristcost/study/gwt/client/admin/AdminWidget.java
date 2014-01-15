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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminWidget.
 */
public class AdminWidget extends Composite implements AdminView {

  /**
   * The Interface AdminWidgetUiBinder.
   */
  interface AdminWidgetUiBinder extends UiBinder<Widget, AdminWidget> {
  }

  /** The ui binder. */
  private static AdminWidgetUiBinder uiBinder = GWT.create(AdminWidgetUiBinder.class);

  /** The clear tag button. */
  @UiField
  Button clearTagButton;

  /** The message label. */
  @UiField
  Label messageLabel;

  /** The presenter. */
  private Presenter presenter;

  /**
   * Instantiates a new admin widget.
   */
  public AdminWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.admin.AdminView#clearMessage()
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
   * @see net.cristcost.study.gwt.client.admin.AdminView#setErrorMessage(java.lang.String)
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
   * @see net.cristcost.study.gwt.client.admin.AdminView#setInfoMessage(java.lang.String)
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
   * net.cristcost.study.gwt.client.admin.AdminView#setPresenter(net.cristcost.study.gwt.client.
   * admin.AdminView.Presenter)
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
  @UiHandler("clearTagButton")
  void onClickAddTag(ClickEvent e) {
    presenter.clearAll();
  }
}
