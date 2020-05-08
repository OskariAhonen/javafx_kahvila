package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kirjautuminen {
    private BorderPane paaNakyma;
    private Kahvila kahvila;
    private Omistaja omistaja;
    private Asikaat asiakas;
    private GridPane layoyt;

    public Kirjautuminen(Kahvila kahvila) {
        this.paaNakyma = new BorderPane();
        this.kahvila = kahvila;
        this.omistaja = new Omistaja(kahvila);

    }
    public Parent nakyma(Stage stage) {
        Omistaja omistaja = new Omistaja(kahvila);
        Lisäys lisäys = new Lisäys(kahvila);
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

        paaNakyma.setCenter(grid);
        button.setOnAction(e -> {
            if (nimiInput.getText().equals("Moi") && salaInput.getText().equals("Taitaa")){
                Scene omistajaNakyma = new Scene(omistaja.nakyma(stage));
                paaNakyma.setCenter(omistajaNakyma.getRoot());

            }
            else if (nimiInput.getText().equals("Asiakas") && salaInput.getText().equals("kahvi")) {

            } else {
                virhe.setText("Väärä tunnus tai salasana");
            }
        });
        GridPane.setConstraints(button, 4,1);
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(nimiLabel, nimiInput, salaLabel, salaInput, button, virhe);


        return paaNakyma;
    }
}
