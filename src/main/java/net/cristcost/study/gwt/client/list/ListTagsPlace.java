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
package net.cristcost.study.gwt.client.list;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * The Class ListTagsPlace.
 */
public class ListTagsPlace extends Place {

  /**
   * The Class Tokenizer.
   */
  @Prefix("list")
  public static class Tokenizer implements PlaceTokenizer<ListTagsPlace> {

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
     */
    @Override
    public ListTagsPlace getPlace(String token) {
      return new ListTagsPlace();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
     */
    @Override
    public String getToken(ListTagsPlace place) {
      return "";
    }
  }
}
