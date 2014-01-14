package net.cristcost.study.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import net.cristcost.study.gwt.shared.TagService;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("tagService")
public interface GwtTagService extends RemoteService, TagService {


}
