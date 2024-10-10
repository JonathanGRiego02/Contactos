package org.dad.controllers;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.dad.models.Friend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // Controllers
    private final FriendController friendController = new FriendController();

    // Model

    private final ListProperty<Friend> friends = new SimpleListProperty<>(FXCollections.observableArrayList(
            friend -> new Observable[] { friend.nameProperty(), friend.surnameProperty()
            }));
    private final ObjectProperty<Friend> selectedFriend = new SimpleObjectProperty<>();


    // View
    @FXML
    private BorderPane root = new BorderPane();

    @FXML
    private VBox emptyBox;

    @FXML
    private ListView<Friend> friendsListView;

    @FXML
    private Button enemyButton;

    @FXML
    private Button friendButton;
    public BorderPane getRoot() {
        return root;
    }

    public ListView<Friend> getFriendsListView() {
        return friendsListView;
    }

    public Button getEnemyButton() {
        return enemyButton;
    }

    public Button getFriendButton() {
        return friendButton;
    }

    public VBox getEmptyBox() {
        return emptyBox;
    }



    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bindings
        friendsListView.itemsProperty().bind(friends);
        selectedFriend.bind(friendsListView.getSelectionModel().selectedItemProperty());
        enemyButton.disableProperty().bind(selectedFriend.isNull());
        selectedFriend.addListener(this::onSelectFriendChange);

        friendController.friendProperty().bind(selectedFriend);
    }

    private void onSelectFriendChange(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {
        if (nv == null) {
            root.setCenter(emptyBox);
        } else {
            root.setCenter(friendController.getRoot());
        }
    }

    @FXML
    void onenemyAction(ActionEvent event) {
        friends.remove(selectedFriend.get());
    }

    @FXML
    void onfriendAction(ActionEvent event) {
        Friend miAmigo = new Friend();
        miAmigo.setName("Pepe");
        miAmigo.setSurname("Hernández");
        friends.add(miAmigo);
        friendsListView.getSelectionModel().select(miAmigo);
    }

    public ObservableList<Friend> getFriends() {
        return friends.get();
    }

    public ListProperty<Friend> friendsProperty() {
        return friends;
    }

}
