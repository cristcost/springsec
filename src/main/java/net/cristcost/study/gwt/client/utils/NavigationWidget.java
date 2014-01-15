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
package net.cristcost.study.gwt.client.utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class NavigationWidget.
 */
public class NavigationWidget extends Composite implements NavigationView {

  /**
   * The Interface NavigationWidgetUiBinder.
   */
  interface NavigationWidgetUiBinder extends UiBinder<Widget, NavigationWidget> {
  }

  /** The ui binder. */
  private static NavigationWidgetUiBinder uiBinder = GWT.create(NavigationWidgetUiBinder.class);

  /** The add. */
  @UiField
  AnchorElement add;

  /** The admin. */
  @UiField
  AnchorElement admin;

  /** The home. */
  @UiField
  AnchorElement home;

  /**
   * Instantiates a new navigation widget.
   */
  public NavigationWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.utils.NavigationView#setAddUrl(java.lang.String)
   */
  @Override
  public void setAddUrl(String url) {
    add.setHref(url);
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.utils.NavigationView#setAdminUrl(java.lang.String)
   */
  @Override
  public void setAdminUrl(String url) {
    admin.setHref(url);
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.utils.NavigationView#setHomeUrl(java.lang.String)
   */
  @Override
  public void setHomeUrl(String url) {
    home.setHref(url);
  }

}
