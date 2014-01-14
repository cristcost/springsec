package net.cristcost.study.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import net.cristcost.study.gwt.client.admin.AdminPlace;
import net.cristcost.study.gwt.client.create.AddTagPlace;
import net.cristcost.study.gwt.client.list.ListTagsPlace;
import net.cristcost.study.gwt.client.utils.NavigationView;
import net.cristcost.study.gwt.client.utils.NavigationWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SecureMeApp implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private Place defaultPlace = new ListTagsPlace();
  private SimplePanel appWidget = new SimplePanel();

  /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {
    ClientFactory clientFactory = GWT.create(StandardClientFactory.class);

    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();

    ActivityMapper activityMapper = new SecureMeActivityMapper(clientFactory);

    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(appWidget);

    SecureMeHistoryMapper historyMapper = GWT.create(SecureMeHistoryMapper.class);

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootPanel.get("navigation").add(createPopulatedMenu(historyMapper));
    RootPanel.get("application").add(appWidget);

    historyHandler.handleCurrentHistory();

  }

  private NavigationView createPopulatedMenu(SecureMeHistoryMapper historyMapper) {
    NavigationView navWidget = new NavigationWidget();
    navWidget.setHomeUrl("#" + historyMapper.getToken(new ListTagsPlace()));
    navWidget.setAddUrl("#" + historyMapper.getToken(new AddTagPlace()));
    navWidget.setAdminUrl("#" + historyMapper.getToken(new AdminPlace()));
    return navWidget;
  }
}
