package kirjautuminen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    Scene login, omistus, asiakas;
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("kirjautuminen");
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        Label nimiLabel = new Label("Käyttäjänimi:");
        GridPane.setConstraints(nimiLabel, 1,1);

        TextField nimiInput = new TextField();
        nimiInput.setPromptText("käyttäjätunnus");
        GridPane.setConstraints(nimiInput, 2,1);

        Label salaLabel = new Label("Salasana:");
        GridPane.setConstraints(salaLabel, 1,2);

        PasswordField salaInput = new PasswordField();
        salaInput.setPromptText("salasana");
        GridPane.setConstraints(salaInput, 2,2);
        Button button = new Button("log in");
          Label virhe = new Label("");
          virhe.setFont(Font.font(14));
        virhe.setTextFill(Color.RED);
        GridPane.setConstraints(virhe, 2,0);
        button.setOnAction(e -> {
            if (nimiInput.getText().equals("Moi") && salaInput.getText().equals("Taitaa")){
               stage.setScene(omistus);

            }
            else if (nimiInput.getText().equals("Asiakas") && salaInput.getText().equals("kahvi")) {
               stage.setScene(asiakas);
            } else {
                virhe.setText("Väärä tunnus tai salasana");
            }
        });
        GridPane.setConstraints(button, 4,1);
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(nimiLabel, nimiInput, salaLabel, salaInput, button, virhe);
        login = new Scene(grid, 350, 350);
        Label text = new Label("Olet sisällä omistajana");
        Button close = new Button("Kirjaudu ulos");
        close.setOnAction(e -> {
                    stage.setScene(login);
                    nimiInput.clear();
                    salaInput.clear();
                    virhe.setText("");
                });
            Button close2 = new Button("sulje");
            close2.setOnAction(e -> {
                stage.setScene(login);
                nimiInput.clear();
                salaInput.clear();
                virhe.setText("");
        });
        //siakas scene
        Label teksti = new Label("Olet kirjautunut asiakkaana");
        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(teksti, close2);
        asiakas = new Scene(layout2, 350,350);
        VBox layout = new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(text, close);
        layout.setAlignment(Pos.CENTER);
        omistus = new Scene(layout, 350,350);
        stage.setScene(login);
        stage.show();

}
}
