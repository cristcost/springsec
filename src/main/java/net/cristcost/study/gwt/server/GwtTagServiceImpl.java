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
import net.cristcost.study.gwt.shared.TagService;

import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GwtTagServiceImpl extends RemoteServiceServlet implements GwtTagService {

  private TagService implementation;

  public void setImplementation(TagService implementation) {
    this.implementation = implementation;
  }

  @Override
  public void addTag(String tagUser, String tag, boolean isPublic) {
    implementation.addTag(tagUser, tag, isPublic);
  }

  @Override
  public void clearAllTags() {
    implementation.clearAllTags();
  }

  @Override
  public void deleteTag(String tagUser, String tag) {
    implementation.deleteTag(tagUser, tag);
  }

  @Override
  public List<Tag> listTags() {
    return implementation.listTags();
  }
}
