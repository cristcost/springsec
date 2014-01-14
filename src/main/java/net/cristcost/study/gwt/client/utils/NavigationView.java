package net.cristcost.study.gwt.client.utils;

import com.google.gwt.user.client.ui.IsWidget;

public interface NavigationView extends IsWidget {

  void setHomeUrl(String url);

  void setAddUrl(String url);

  void setAdminUrl(String url);
}
