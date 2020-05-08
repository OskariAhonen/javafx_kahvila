package kirjautuminen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;
public class Main extends Application {
    Kahvila kahvila = new Kahvila();
    Scene scene;
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane paaNakyma = new BorderPane();
        paaNakyma.setPrefSize(400, 450);
        Kirjautuminen kirautuminen = new Kirjautuminen(kahvila);
        paaNakyma.setCenter(kirautuminen.nakyma(stage));
        scene = new Scene(paaNakyma);
        stage.setScene(scene);
        stage.show();

}

}

