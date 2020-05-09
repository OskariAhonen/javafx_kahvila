package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Asikaat {
    private Kahvila kahvila;
    private BorderPane PaaNakyma;
    private GridPane layout;
    private int saldo;
    private Label saldoLabel;
    private Label NimiLabel;
    private Button ostaNappi;
    public Asikaat(Kahvila kahvila) {
        this.kahvila = kahvila;
        this.PaaNakyma = new BorderPane();
        this.layout = new GridPane();
        this.saldo = 10;
        this.saldoLabel = new Label();
        saldoLabel.setText("Saldo:" + saldo + "€");
        this.ostaNappi = new Button("Osta");
    }
    public Parent nakyma(Stage stage) {
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(8);
        layout.setVgap(10);
        layout.setPrefSize(500,450);
        layout.setAlignment(Pos.CENTER);
        PaaNakyma.setCenter(layout);
        PaaNakyma.setTop(saldoLabel);
        paivita(kahvila, layout, ostaNappi);
        return PaaNakyma;
    }
    public void paivita(Kahvila kahvila, GridPane AsiakasGrid, Button nappi) {
        int k = 0;
        AsiakasGrid.getChildren().clear();
        for (Tuote a : kahvila.getTuote()) {
            NimiLabel = new Label();
            NimiLabel.setText(a.getNimi() + ", " + a.getHinta());
            GridPane.setConstraints(NimiLabel, 0,k);
            GridPane.setConstraints(ostaNappi, 1,k);
            AsiakasGrid.getChildren().addAll(NimiLabel, ostaNappi);
            k++;
            System.out.println("moi");
        }
    }
    }
