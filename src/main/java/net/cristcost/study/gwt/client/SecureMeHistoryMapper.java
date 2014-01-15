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

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import net.cristcost.study.gwt.client.admin.AdminPlace;
import net.cristcost.study.gwt.client.create.AddTagPlace;
import net.cristcost.study.gwt.client.list.ListTagsPlace;

/**
 * The Interface SecureMeHistoryMapper.
 */
@WithTokenizers({
    AdminPlace.Tokenizer.class, AddTagPlace.Tokenizer.class, ListTagsPlace.Tokenizer.class
})
public interface SecureMeHistoryMapper extends PlaceHistoryMapper {

}
