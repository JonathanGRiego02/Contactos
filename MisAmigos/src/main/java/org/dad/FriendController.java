package org.dad;

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

    }
}
