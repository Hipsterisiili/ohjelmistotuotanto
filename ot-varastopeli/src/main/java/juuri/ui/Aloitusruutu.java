package juuri.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Aloitusruutu extends Application {
    
    @Override
    public void start(Stage ikkuna) throws IOException {
        ikkuna.setTitle("Tervetuloa");

        Label tilanne = new Label("tervetuloa");
        Button aloita = new Button("Aloita pelI");
        aloita.setOnAction((event) -> {
            launch(Graafinenui.class);
        });
        Button lopeta = new Button("Sulje peli");
        aloita.setOnAction((event) -> {
            ikkuna.close();
        });
        
        GridPane gp = new GridPane();
        gp.setConstraints(tilanne, 1, 1);
        gp.setConstraints(aloita, 1, 2);
        gp.setConstraints(lopeta, 1, 3);
        gp.getChildren().add(tilanne);
        gp.getChildren().add(aloita);
        gp.getChildren().add(lopeta);
        BorderPane bp = new BorderPane();
        bp.setCenter(gp);

        Scene kohtaus = new Scene(bp, 500, 500);
        ikkuna.setScene(kohtaus);
        ikkuna.show();
    }
}
