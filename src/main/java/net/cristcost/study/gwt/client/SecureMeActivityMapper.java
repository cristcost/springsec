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

public class SecureMeActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public SecureMeActivityMapper(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

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
