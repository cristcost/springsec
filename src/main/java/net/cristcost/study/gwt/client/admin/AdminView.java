package net.cristcost.study.gwt.client.admin;

import com.google.gwt.user.client.ui.IsWidget;

public interface AdminView extends IsWidget {

  void setPresenter(Presenter presenter);

  void setErrorMessage(String string);

  void setInfoMessage(String string);

  void clearMessage();

  public interface Presenter {
    void clearAll();
  }
}
