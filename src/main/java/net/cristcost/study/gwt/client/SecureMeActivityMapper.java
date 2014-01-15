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
package net.cristcost.study.gwt.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import net.cristcost.study.gwt.client.admin.AdminActivity;
import net.cristcost.study.gwt.client.admin.AdminPlace;
import net.cristcost.study.gwt.client.create.AddTagActivity;
import net.cristcost.study.gwt.client.create.AddTagPlace;
import net.cristcost.study.gwt.client.list.ListTagActivity;
import net.cristcost.study.gwt.client.list.ListTagsPlace;

// TODO: Auto-generated Javadoc
/**
 * The Class SecureMeActivityMapper.
 */
public class SecureMeActivityMapper implements ActivityMapper {

  /** The client factory. */
  private ClientFactory clientFactory;

  /**
   * Instantiates a new secure me activity mapper.
   * 
   * @param clientFactory the client factory
   */
  public SecureMeActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.gwt.place.shared.Place)
   */
  @Override
  public Activity getActivity(Place place) {
    if (place instanceof ListTagsPlace) {
      return new ListTagActivity(clientFactory);
    } else if (place instanceof AddTagPlace) {
      return new AddTagActivity(clientFactory);
    } else if (place instanceof AdminPlace) {
      return new AdminActivity(clientFactory);
    }
    return null;
  }
}
