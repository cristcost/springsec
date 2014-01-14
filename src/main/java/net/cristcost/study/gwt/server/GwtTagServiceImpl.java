package net.cristcost.study.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import net.cristcost.study.gwt.client.GwtTagService;
import net.cristcost.study.gwt.shared.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GwtTagServiceImpl extends RemoteServiceServlet implements GwtTagService {

  private final List<Tag> database = Collections.synchronizedList(new ArrayList<Tag>());

  @Override
  public void addTag(String tag, boolean isPublic) {
    String username = "TODO-GET-FROM-SPRING-SECURITY";
    database.add(new Tag(username, tag, isPublic));
  }

  @Override
  public void deleteTag(String tagUse, String tag) {
    Iterator<Tag> iter = database.iterator();
    while (iter.hasNext()) {
      Tag persistedTag = iter.next();
      if (persistedTag.getUsername().equals(tagUse) && persistedTag.getTag().equals(tag)) {
        iter.remove();
      }
    }
  }

  @Override
  public List<Tag> listTags() {
    return new ArrayList<Tag>(database);
  }

  @Override
  public void clearAllTags() {
    database.clear();
  }
}
