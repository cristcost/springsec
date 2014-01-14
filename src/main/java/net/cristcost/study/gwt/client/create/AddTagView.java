package net.cristcost.study.gwt.client.create;

import com.google.gwt.user.client.ui.IsWidget;

public interface AddTagView extends IsWidget {

  void setPresenter(Presenter presenter);

  void setErrorMessage(String string);

  void setInfoMessage(String string);

  void clearMessage();

  void clearInput();

  public interface Presenter {

    // note: the tag is expected to be created by the server and the username to
    // be extracted from spring securirty context
    void addTag(String tag, boolean isPublic);
  }
}
