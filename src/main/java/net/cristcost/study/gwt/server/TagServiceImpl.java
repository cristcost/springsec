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

import net.cristcost.study.gwt.shared.Tag;
import net.cristcost.study.gwt.shared.TagService;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
public class TagServiceImpl implements TagService {

  private final List<Tag> database = Collections.synchronizedList(new ArrayList<Tag>());

  // I'm not sure wheter it is best to have a "client send username and Spring Security validate it"
  // policy or "client don't send username and Spring Security is used to get it" policy
  // Below there is a commented method "String getCurrentUsername()" which can be used for
  // implementing the second policy
  @Override
  @PreAuthorize("isAuthenticated() and principal.username == #tagUser")
  public void addTag(String tagUser, String tag, boolean isPublic) {
    database.add(new Tag(tagUser, tag, isPublic));
  }

  @Override
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public void clearAllTags() {
    database.clear();
  }

  @Override
  @PreAuthorize("isAuthenticated() and principal.username == #tagUser")
  public void deleteTag(String tagUser, String tag) {
    Iterator<Tag> iter = database.iterator();
    while (iter.hasNext()) {
      Tag persistedTag = iter.next();
      if (persistedTag.getUsername().equals(tagUser) && persistedTag.getTag().equals(tag)) {
        iter.remove();
      }
    }
  }

  @Override
  @PostFilter("filterObject.isPublic() or "
      + "(principal instanceof T(org.springframework.security.core.userdetails.User)"
      + " and filterObject.username == principal.username) ")
  public List<Tag> listTags() {
    return new ArrayList<Tag>(database);
  }

  // private String getCurrentUsername() {
  // final SecurityContext securityContext = SecurityContextHolder.getContext();
  // final Authentication authentication = securityContext.getAuthentication();
  // final Object principal = authentication.getPrincipal();
  // if (principal instanceof User) {
  // User user = (User) principal;
  // return user.getUsername();
  // } else {
  // throw new RuntimeException("Error retrieving user information");
  // }
  // }
}
