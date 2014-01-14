package net.cristcost.study.gwt.client.list;

import com.google.gwt.user.client.ui.IsWidget;

import net.cristcost.study.gwt.shared.Tag;

import java.util.List;

public interface ListTagsView extends IsWidget {

  void setTags(List<Tag> tags);

  void setErrorMessage(String string);

  void setInfoMessage(String string);

  void clearMessage();

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void refreshTags();

    void deleteTag(String tagUser, String tag);
  }

}
