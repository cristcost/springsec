package net.cristcost.study.gwt.client.list;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ListTagsPlace extends Place {

  @Prefix("list")
  public static class Tokenizer implements PlaceTokenizer<ListTagsPlace> {

    @Override
    public ListTagsPlace getPlace(String token) {
      return new ListTagsPlace();
    }

    @Override
    public String getToken(ListTagsPlace place) {
      return "";
    }

  }

}
