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

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import net.cristcost.study.gwt.shared.Tag;

import java.util.List;

/**
 * The Class ListTagsWidget.
 */
public class ListTagsWidget extends Composite implements ListTagsView {

  /**
   * The Interface ListTagsWidgetUiBinder.
   */
  interface ListTagsWidgetUiBinder extends UiBinder<Widget, ListTagsWidget> {
  }

  /** The ui binder. */
  private static ListTagsWidgetUiBinder uiBinder = GWT.create(ListTagsWidgetUiBinder.class);

  /** The cell table. */
  @UiField
  CellTable<Tag> cellTable;

  /** The message label. */
  @UiField
  Label messageLabel;

  /** The refresh tags button. */
  @UiField
  Button refreshTagsButton;

  /** The presenter. */
  private Presenter presenter;

  /**
   * Instantiates a new list tags widget.
   */
  public ListTagsWidget() {

    initWidget(uiBinder.createAndBindUi(this));

    TextColumn<Tag> usernameColumn = new TextColumn<Tag>() {
      @Override
      public String getValue(Tag tag) {
        return tag.getUsername();
      }
    };

    TextColumn<Tag> tagColumn = new TextColumn<Tag>() {
      @Override
      public String getValue(Tag tag) {
        return tag.getTag();
      }
    };

    TextColumn<Tag> publicCheckColumn = new TextColumn<Tag>() {
      @Override
      public String getValue(Tag tag) {
        return tag.isPublic() ? "public" : "private";
      }
    };

    Column<Tag, String> deleteButtonColumn = new Column<Tag, String>(new ButtonCell()) {
      @Override
      public String getValue(Tag object) {
        return "Delete";
      }
    };
    deleteButtonColumn.setFieldUpdater(new FieldUpdater<Tag, String>() {
      @Override
      public void update(int index, Tag object, String value) {
        presenter.deleteTag(object.getUsername(), object.getTag());
      }
    });

    cellTable.addColumn(usernameColumn, "Name");
    cellTable.addColumn(tagColumn, "Address");
    cellTable.addColumn(publicCheckColumn, "Is Public?");
    cellTable.addColumn(deleteButtonColumn, "Delete");

    cellTable.setRowCount(0, true);
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView#clearMessage()
   */
  @Override
  public void clearMessage() {
    messageLabel.setVisible(false);
    messageLabel.setText("");
    // TODO: set class to null?
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView#setErrorMessage(java.lang.String)
   */
  @Override
  public void setErrorMessage(String errorMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(errorMessage);
    // TODO: set a bootstrap class for error
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView#setInfoMessage(java.lang.String)
   */
  @Override
  public void setInfoMessage(String infoMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(infoMessage);
    // TODO: set a bootstrap class for information
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * net.cristcost.study.gwt.client.list.ListTagsView#setPresenter(net.cristcost.study.gwt.client
   * .list.ListTagsView.Presenter)
   */
  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.cristcost.study.gwt.client.list.ListTagsView#setTags(java.util.List)
   */
  @Override
  public void setTags(List<Tag> tags) {
    cellTable.setRowData(0, tags);
    cellTable.setRowCount(tags.size(), true);
  }

  /**
   * On click refresh.
   * 
   * @param e the e
   */
  @UiHandler("refreshTagsButton")
  void onClickRefresh(ClickEvent e) {
    presenter.refreshTags();
  }
}
