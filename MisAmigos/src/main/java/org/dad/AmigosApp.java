package org.dad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AmigosApp extends Application {

    private final RootController rootController = new RootController();

    @Override
    public void start(Stage primayStage) throws Exception{
        primayStage.setTitle("Mis amigos");
        primayStage.setScene(new Scene(rootController.getRoot()));
        primayStage.show();
    }
}
