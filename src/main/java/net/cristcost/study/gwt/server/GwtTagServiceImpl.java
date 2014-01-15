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
package net.cristcost.study.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import net.cristcost.study.gwt.client.GwtTagService;
import net.cristcost.study.gwt.shared.Tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GwtTagServiceImpl extends RemoteServiceServlet implements GwtTagService {

  /** The database. */
  private final List<Tag> database = Collections.synchronizedList(new ArrayList<Tag>());

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.shared.TagService#addTag(java.lang.String, boolean)
   */
  @Override
  public void addTag(String tag, boolean isPublic) {
    String username = "TODO-GET-FROM-SPRING-SECURITY";
    database.add(new Tag(username, tag, isPublic));
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.shared.TagService#clearAllTags()
   */
  @Override
  public void clearAllTags() {
    database.clear();
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.shared.TagService#deleteTag(java.lang.String, java.lang.String)
   */
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

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.shared.TagService#listTags()
   */
  @Override
  public List<Tag> listTags() {
    return new ArrayList<Tag>(database);
  }
}
