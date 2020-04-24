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
    Scene login, omistus, asiakas;
    private Button lisääNappi;
    private Button poistaNappi;
    private GridPane omistusGrid;
    private TextField nimiInput;
    private Label salaLabel;
    private PasswordField salaInput;
    private Label virhe;
    private Label nimi;
    private Label teksti;
    private VBox layout2;
    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Kahvila kahvila = new Kahvila();
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
        // omistja
        GridPane omistajaGrid = new GridPane();
        omistajaGrid.setPadding(new Insets(10,10,10,10));
        omistajaGrid.setHgap(10);
        omistajaGrid.setVgap(8);
        int i = 0;
        for (Tuote a : kahvila.getTuote()) {
            ;
                //tuotteen nimi ja hinta

                Label nimi = new Label();
                nimi.setText(a.getNimi() + ", " + a.getHinta() + "€");
                GridPane.setConstraints(nimi, 0,i);

                Button poistaNappi = new Button("Poista");
            poistaNappi.setOnAction(ee -> {
                kahvila.poistaTuote(a.getNimi());
                omistajaGrid.getChildren().removeAll(nimi, poistaNappi);
            });
                GridPane.setConstraints(poistaNappi, 1, i);
                omistajaGrid.getChildren().addAll(nimi, poistaNappi);

            i = i + 1;

        }
        Button lisääNappi = new Button("Lisää tuote");
        GridPane.setConstraints(lisääNappi, 0,i);
        lisääNappi.setOnAction(e -> {
            Lisäys.lisääTuote();
            int k = 0;
            omistajaGrid.getChildren().clear();
            for (Tuote a : kahvila.getTuote()) {
                ;
                //tuotteen nimi ja hinta

                Label nimi = new Label();
                nimi.setText(a.getNimi() + ", " + a.getHinta() + "€");
                GridPane.setConstraints(nimi, 0,k);

                Button poistaNappi = new Button("Poista");
                poistaNappi.setOnAction(ee -> {
                    kahvila.poistaTuote(a.getNimi());
                    omistajaGrid.getChildren().removeAll(nimi, poistaNappi);
                });
                GridPane.setConstraints(poistaNappi, 1, k);
                omistajaGrid.getChildren().addAll(nimi, poistaNappi);

                k = k + 1;

            }

            GridPane.setConstraints(lisääNappi, 0,k);
            omistajaGrid.getChildren().add(lisääNappi);
        });
        omistajaGrid.getChildren().add(lisääNappi);
        omistajaGrid.setAlignment(Pos.CENTER);
        omistus = new Scene(omistajaGrid, 350,350);
        //asiakas scene
        Button close2 = new Button("sulje");
        close2.setOnAction(e -> {
            stage.setScene(login);
            nimiInput.clear();
            salaInput.clear();
            virhe.setText("");

        });
        Label teksti = new Label("Olet kirjautunut asiakkaana");
        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(teksti, close2);
        asiakas = new Scene(layout2, 350,350);
        VBox layout = new VBox();
        layout2.setAlignment(Pos.CENTER);


        stage.setScene(login);
        stage.show();

}}

