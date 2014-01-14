package net.cristcost.study.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import net.cristcost.study.gwt.client.admin.AdminView;
import net.cristcost.study.gwt.client.admin.AdminWidget;
import net.cristcost.study.gwt.client.create.AddTagView;
import net.cristcost.study.gwt.client.create.AddTagWidget;
import net.cristcost.study.gwt.client.list.ListTagsView;
import net.cristcost.study.gwt.client.list.ListTagsWidget;
import net.cristcost.study.gwt.client.utils.NavigationView;
import net.cristcost.study.gwt.client.utils.NavigationWidget;

public class StandardClientFactory implements ClientFactory {

  private final EventBus eventBus = new SimpleEventBus();
  private final PlaceController placeController = new PlaceController(eventBus);
  private final ListTagsView listTagsView = new ListTagsWidget();
  private final AddTagView addTagView = new AddTagWidget();
  private final AdminView adminView = new AdminWidget();
  private final NavigationView navigationView = new NavigationWidget();
  private final GwtTagServiceAsync tagService = GWT.create(GwtTagService.class);

  @Override
  public EventBus getEventBus() {
    return this.eventBus;
  }

  @Override
  public PlaceController getPlaceController() {
    return this.placeController;
  }

  @Override
  public ListTagsView getListTagView() {
    return this.listTagsView;
  }

  @Override
  public AddTagView getAddTagView() {
    return this.addTagView;
  }

  @Override
  public AdminView getAdminView() {
    return this.adminView;
  }

  @Override
  public NavigationView getNavigationView() {
    return this.navigationView;
  }

  @Override
  public GwtTagServiceAsync getTagService() {
    return tagService;
  }

}
