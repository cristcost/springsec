package net.cristcost.study.gwt.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import net.cristcost.study.gwt.client.admin.AdminView;
import net.cristcost.study.gwt.client.create.AddTagView;
import net.cristcost.study.gwt.client.list.ListTagsView;
import net.cristcost.study.gwt.client.utils.NavigationView;

public interface ClientFactory {

  EventBus getEventBus();

  PlaceController getPlaceController();

  ListTagsView getListTagView();

  AddTagView getAddTagView();

  AdminView getAdminView();

  NavigationView getNavigationView();

  GwtTagServiceAsync getTagService();

}
