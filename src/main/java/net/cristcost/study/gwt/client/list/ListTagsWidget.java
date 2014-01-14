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

public class ListTagsWidget extends Composite implements ListTagsView {

  interface ListTagsWidgetUiBinder extends UiBinder<Widget, ListTagsWidget> {
  }

  private static ListTagsWidgetUiBinder uiBinder = GWT.create(ListTagsWidgetUiBinder.class);

  @UiField
  CellTable<Tag> cellTable;

  @UiField
  Label messageLabel;

  @UiField
  Button refreshTagsButton;

  private Presenter presenter;

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

  @Override
  public void clearMessage() {
    messageLabel.setVisible(false);
    messageLabel.setText("");
    // TODO: set class to null?
  }

  @Override
  public void setErrorMessage(String errorMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(errorMessage);
    // TODO: set a bootstrap class for error
  }

  @Override
  public void setInfoMessage(String infoMessage) {
    messageLabel.setVisible(true);
    messageLabel.setText(infoMessage);
    // TODO: set a bootstrap class for information
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void setTags(List<Tag> tags) {
    cellTable.setRowData(0, tags);
    cellTable.setRowCount(tags.size(), true);
  }

  @UiHandler("refreshTagsButton")
  void onClickRefresh(ClickEvent e) {
    presenter.refreshTags();
  }
}
