package net.cristcost.study.gwt.client.utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavigationWidget extends Composite implements NavigationView {

  private static NavigationWidgetUiBinder uiBinder = GWT.create(NavigationWidgetUiBinder.class);

  interface NavigationWidgetUiBinder extends UiBinder<Widget, NavigationWidget> {
  }

  @UiField
  AnchorElement home;
  @UiField
  AnchorElement add;
  @UiField
  AnchorElement admin;

  public NavigationWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setHomeUrl(String url) {
    home.setHref(url);
  }

  @Override
  public void setAddUrl(String url) {
    add.setHref(url);
  }

  @Override
  public void setAdminUrl(String url) {
    admin.setHref(url);
  }

}
