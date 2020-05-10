package kirjautuminen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;
import java.util.Optional;

public class Main extends Application {
    Kahvila kahvila = new Kahvila();
    Scene scene;
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Kirjautuminen kirautuminen = new Kirjautuminen(kahvila);
        BorderPane paaNakyma = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Toiminnot");
        MenuItem profiilinVaihto = new MenuItem("Vaihda profiili");
        MenuItem sammuta = new MenuItem("Samutta");
        menu.getItems().addAll(profiilinVaihto, sammuta);
        menuBar.getMenus().add(menu);

        profiilinVaihto.setOnAction(e -> {
            paaNakyma.setCenter(kirautuminen.nakyma(stage));
        });
        sammuta.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Vahvistus vaaditaan");
            alert.setContentText("Oletko varma että haluat sammuttaa ohjelman?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });








        paaNakyma.setPrefSize(400, 450);
        paaNakyma.setCenter(kirautuminen.nakyma(stage));
        paaNakyma.setTop(menuBar);
        scene = new Scene(paaNakyma);
        stage.setScene(scene);
        stage.show();

}

}

