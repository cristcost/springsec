package net.cristcost.study.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.cristcost.study.gwt.shared.Tag;

import java.util.List;

public interface GwtTagServiceAsync {

  void addTag(String tag, boolean isPublic, AsyncCallback<Void> callback);

  void clearAllTags(AsyncCallback<Void> callback);

  void deleteTag(String tagUser, String tag, AsyncCallback<Void> callback);

  void listTags(AsyncCallback<List<Tag>> callback);

}
