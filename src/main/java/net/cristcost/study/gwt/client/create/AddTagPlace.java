package net.cristcost.study.gwt.client.create;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AddTagPlace extends Place {

  @Prefix("add")
  public static class Tokenizer implements PlaceTokenizer<AddTagPlace> {

    @Override
    public AddTagPlace getPlace(String token) {
      return new AddTagPlace();
    }

    @Override
    public String getToken(AddTagPlace place) {
      return "";
    }

  }

}
