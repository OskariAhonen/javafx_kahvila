package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.Optional;

public class Asiakas {
    private Kahvila kahvila;
    private BorderPane PaaNakyma;
    private GridPane layout;
    private int saldo;
    private Label saldoLabel;
    private Label NimiLabel;
    private Button ostaNappi;
    private Omistaja omistaja;
    public Asiakas(Kahvila kahvila) {
        this.kahvila = kahvila;
        this.omistaja = new Omistaja(kahvila);
        this.PaaNakyma = new BorderPane();
        this.layout = new GridPane();
        this.saldoLabel = new Label();
        this.saldo = 20;
        saldoLabel.setText("Saldo: " + saldo + "€");
        this.ostaNappi = new Button("Osta");
    }
    public Parent nakyma(Stage stage) {
        stage.setTitle("Asiakas");
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(10);
        layout.setVgap(8);
        layout.setAlignment(Pos.CENTER);
        PaaNakyma.setPadding(new Insets(20, 0, 0, 20));
        PaaNakyma.setCenter(layout);
        PaaNakyma.setTop(saldoLabel);
        paivita(kahvila, layout, ostaNappi);
        ostaNappi.setOnAction(e -> {
            paivita(kahvila, layout, ostaNappi);
        });
        return this.PaaNakyma;
    }
    public void paivita(Kahvila kahvila, GridPane Grid, Button nappi) {
        int k = 0;
        Grid.getChildren().clear();
        for (Tuote a : kahvila.getTuote()) {
            NimiLabel = new Label();
            NimiLabel.setText(a.getNimi() + ", " + a.getHinta() + "€");
            ostaNappi = new Button("Osta");
            ostaNappi.setOnAction(e -> {
                Alert vahvistus = new Alert(Alert.AlertType.CONFIRMATION);
                vahvistus.setTitle("Vahvistus vaaditaan");
                vahvistus.setHeaderText("Vahvistus vaaditaan");
                vahvistus.setContentText("Oletko varma että haluat ostaa tuotteen: " + a.getNimi() + "?");
                Optional<ButtonType> result = vahvistus.showAndWait();
                if (result.get() == ButtonType.OK) {
                    if (saldo < a.getHinta()) {
                        Alert maksuVirhe = new Alert(Alert.AlertType.ERROR);
                        maksuVirhe.setHeaderText("Maksu virhe");
                        maksuVirhe.setContentText("Saldosi ei riitä tuotteeseen: " + a.getNimi() + ", " + "Saldo: " + saldo + "€");
                        maksuVirhe.setTitle("Saldosi ei riitä");
                        maksuVirhe.showAndWait();
                    } else {
                        saldo = saldo - a.getHinta();
                        saldoLabel.setText("Saldo: " + saldo + "€");

                    }
                }
            });
            GridPane.setConstraints(NimiLabel, 0,k);
            GridPane.setConstraints(ostaNappi, 1,k);
            Grid.getChildren().addAll(NimiLabel, ostaNappi);
            k++;
        }
        GridPane.setConstraints(nappi, 0, k);
    }
}
