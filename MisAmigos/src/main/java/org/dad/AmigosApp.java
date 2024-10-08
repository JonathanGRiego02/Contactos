package org.dad;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hildan.fxgson.FxGson;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

public class AmigosApp extends Application {

    private final RootController rootController = new RootController();

    @Override
    public void init() throws Exception {
        // Cargar todos los amigos desde el fichero friends.json

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
        Gson gson = FxGson
                .fullBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String json = gson.toJson(rootController.getFriends());
        Files.writeString(friendsFile.toPath(), json, StandardCharsets.UTF_8);
        System.out.println("Cambios guardados en el fichero " + friendsFile);
    }

}
