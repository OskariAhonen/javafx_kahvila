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
import java.util.List;
public class Main extends Application {
    Kahvila kahvila = new Kahvila();
    Scene login, omistus, asiakas;
    private Button lisääNappi;
    private Button poistaNappi;
    private GridPane omistajaGrid;
    private TextField nimiInput;
    private Label salaLabel;
    private PasswordField salaInput;
    private Label virhe;
    private Label nimi;
    private Label teksti;
    private VBox layout2;
    private int k;
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

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
        button.setOnAction(e -> {
            if (nimiInput.getText().equals("Moi") && salaInput.getText().equals("Taitaa")){
            Scene omistajaNakyma = new Scene(Omistaja.);


            }
            else if (nimiInput.getText().equals("Asiakas") && salaInput.getText().equals("kahvi")) {

            } else {
                virhe.setText("Väärä tunnus tai salasana");
            }
        });
        GridPane.setConstraints(button, 4,1);
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(nimiLabel, nimiInput, salaLabel, salaInput, button, virhe);
        login = new Scene(grid, 350, 350);




        stage.setScene(login);
        stage.show();

}

}

