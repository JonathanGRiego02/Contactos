package org.dad;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    // model

    private ObjectProperty<Friend> friend = new SimpleObjectProperty<>();

    public Friend getFriend() {
        return friend.get();
    }

    public ObjectProperty<Friend> friendProperty() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend.set(friend);
    }



    // View

    @FXML
    private TextField apellidoTextField;

    @FXML
    private DatePicker cumpleDatePicker;

    @FXML
    private Button fotoButton;

    @FXML
    private TextField mailTextField;

    @FXML
    private TextField movilTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private ImageView perfilImageView;

    @FXML
    private GridPane root;

    @FXML
    void onfotoAction(ActionEvent event) {

    }

    public TextField getApellidoTextField() {
        return apellidoTextField;
    }

    public void setApellidoTextField(TextField apellidoTextField) {
        this.apellidoTextField = apellidoTextField;
    }

    public DatePicker getCumpleDatePicker() {
        return cumpleDatePicker;
    }

    public void setCumpleDatePicker(DatePicker cumpleDatePicker) {
        this.cumpleDatePicker = cumpleDatePicker;
    }

    public Button getFotoButton() {
        return fotoButton;
    }

    public void setFotoButton(Button fotoButton) {
        this.fotoButton = fotoButton;
    }

    public TextField getMailTextField() {
        return mailTextField;
    }

    public void setMailTextField(TextField mailTextField) {
        this.mailTextField = mailTextField;
    }

    public TextField getMovilTextField() {
        return movilTextField;
    }

    public void setMovilTextField(TextField movilTextField) {
        this.movilTextField = movilTextField;
    }

    public TextField getNombreTextField() {
        return nombreTextField;
    }

    public void setNombreTextField(TextField nombreTextField) {
        this.nombreTextField = nombreTextField;
    }

    public ImageView getPerfilImageView() {
        return perfilImageView;
    }

    public void setPerfilImageView(ImageView perfilImageView) {
        this.perfilImageView = perfilImageView;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public FriendController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FriendView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friend.addListener(this::onFriendChanged);
    }

    private void onFriendChanged(ObservableValue<? extends Friend>o, Friend oldValue, Friend newValue) {
        if (oldValue != null ) {
            nombreTextField.textProperty().unbindBidirectional(oldValue.nameProperty());
            apellidoTextField.textProperty().unbindBidirectional(oldValue.surnameProperty());
            cumpleDatePicker.valueProperty().unbindBidirectional(oldValue.birthdateProperty());
            movilTextField.textProperty().unbindBidirectional(oldValue.phoneNumberProperty());
            mailTextField.textProperty().unbindBidirectional(oldValue.emailProperty());
            perfilImageView.imageProperty().unbindBidirectional(oldValue.photoProperty());
        }

        if (newValue != null) {
            nombreTextField.textProperty().bindBidirectional(newValue.nameProperty());
            apellidoTextField.textProperty().bindBidirectional(newValue.surnameProperty());
            cumpleDatePicker.valueProperty().bindBidirectional(newValue.birthdateProperty());
            movilTextField.textProperty().bindBidirectional(newValue.phoneNumberProperty());
            mailTextField.textProperty().bindBidirectional(newValue.emailProperty());
            perfilImageView.imageProperty().bindBidirectional(newValue.photoProperty());
        }
    }
}
