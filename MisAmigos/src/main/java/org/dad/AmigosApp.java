package org.dad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.dad.adapters.ImageAdapter;
import org.dad.adapters.LocalDateAdapter;
import org.dad.controllers.RootController;
import org.dad.models.Friend;
import org.hildan.fxgson.FxGson;

import org.dad.models.FriendsList;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

public class AmigosApp extends Application {

    private final RootController rootController = new RootController();

    Gson gson = FxGson
            .fullBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(Image.class, new ImageAdapter())
            .create();

    @Override
    public void init() throws Exception {
        // Cargar todos los amigos desde el fichero friends.json
        File friendsFile = new File("friends.json");
        if(friendsFile.exists()) {
            String json = Files.readString(friendsFile.toPath(), StandardCharsets.UTF_8);
            ListProperty<Friend> friends = gson.fromJson(json, FriendsList.class);
            rootController.getFriends().setAll(friends);
            System.out.println(friends.size() + " contactos leidos desde el fichero " + friendsFile);
        }
    }


    @Override
    public void start(Stage primayStage) throws Exception{
        primayStage.setTitle("Mis amigos");
        primayStage.setScene(new Scene(rootController.getRoot()));
        primayStage.show();
    }

    @Override
    public void stop() throws Exception {
        // Guardar los amigos en el fichero friends.json
        File friendsFile = new File("friends.json");

        String json = gson.toJson(rootController.getFriends());
        Files.writeString(friendsFile.toPath(), json, StandardCharsets.UTF_8);
        System.out.println("Cambios guardados en el fichero " + friendsFile);
    }

}
