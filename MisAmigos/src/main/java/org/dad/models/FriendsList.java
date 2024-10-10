package org.dad.models;

import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class FriendsList extends SimpleListProperty<Friend> {

    public FriendsList() {
        super(FXCollections.observableArrayList());
    }

}
