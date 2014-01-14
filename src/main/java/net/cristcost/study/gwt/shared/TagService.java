package net.cristcost.study.gwt.shared;

import java.util.List;

public interface TagService {

  void addTag(String tag, boolean isPublic);

  void deleteTag(String tagUser, String tag);
  
  List<Tag> listTags();
  
  void clearAllTags();
}
