package net.cristcost.study.gwt.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tag implements Serializable {

  private boolean pub;

  private String tag;

  private String username;

  public Tag() {
  }

  public Tag(String username, String tag, boolean pub) {
    this.username = username;
    this.tag = tag;
    this.pub = pub;
  }

  public String getTag() {
    return tag;
  }

  public String getUsername() {
    return username;
  }

  public boolean isPublic() {
    return pub;
  }

  public void setPublic(boolean isPublic) {
    this.pub = pub;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
