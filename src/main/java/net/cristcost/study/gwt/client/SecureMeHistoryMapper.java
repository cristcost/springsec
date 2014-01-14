package net.cristcost.study.gwt.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import net.cristcost.study.gwt.client.admin.AdminPlace;
import net.cristcost.study.gwt.client.create.AddTagPlace;
import net.cristcost.study.gwt.client.list.ListTagsPlace;

@WithTokenizers({
    AdminPlace.Tokenizer.class, AddTagPlace.Tokenizer.class,
    ListTagsPlace.Tokenizer.class
})
public interface SecureMeHistoryMapper extends PlaceHistoryMapper {

}
