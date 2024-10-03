package org.dad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private BorderPane root = new BorderPane();

    public BorderPane getRoot() {
        return root;
    }

    public ListView<?> getAmigosListView() {
        return amigosListView;
    }

    public Button getEnemyButton() {
        return enemyButton;
    }

    public Button getFriendButton() {
        return friendButton;
    }


    @FXML
    private ListView<?> amigosListView;

    @FXML
    private Button enemyButton;

    @FXML
    private Button friendButton;


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

    }

    @FXML
    void onenemyAction(ActionEvent event) {

    }

    @FXML
    void onfriendAction(ActionEvent event) {

    }

}
