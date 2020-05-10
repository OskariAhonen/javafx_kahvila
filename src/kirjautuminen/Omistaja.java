package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Optional;

public class Omistaja {
    private BorderPane paaNakyma;
    private GridPane layout;
    private Kahvila kahvila;
    private Button lisaaNappi;

public Omistaja(Kahvila kahvila) {
    this.paaNakyma = new BorderPane();
    this.layout = new GridPane();
    this.kahvila = kahvila;
    this.lisaaNappi = new Button("Lisää tuote");

}
public Parent nakyma (Stage stage) {
    stage.setTitle("Omistaja");
    layout.setPadding(new Insets(10,10,10,10));
    layout.setHgap(8);
    layout.setVgap(10);
    layout.setAlignment(Pos.CENTER);
    paivita(kahvila, layout, lisaaNappi);
    lisaaNappi.setOnAction(e -> {
        Lisäys.lisääTuote();
        paivita(kahvila, layout, lisaaNappi);

    });
    paaNakyma.setCenter(layout);
   paaNakyma.setPadding(new Insets(20,0,0,20));
    return this.paaNakyma;
}
    public void paivita(Kahvila kahvila, GridPane omistajaGrid, Button lisaaNappi){
    omistajaGrid.getChildren().clear();
        int k = 0;
        for (Tuote a : kahvila.getTuote()) {
            ;
            //tuotteen nimi ja hinta

            Label nimi = new Label();
            nimi.setText(a.getNimi() + ", " + a.getHinta() + "€");
            GridPane.setConstraints(nimi, 0,k);

            Button poistaNappi = new Button("Poista");
            poistaNappi.setOnAction(ee -> {
                Alert vahvistus = new Alert(Alert.AlertType.CONFIRMATION);
                vahvistus.setHeaderText("Vahvistus vaaditaan");
                vahvistus.setContentText("Oletko varma että haluat poistaa tuotteen " + a.getNimi());
                Optional<ButtonType> result = vahvistus.showAndWait();
                if (result.get() == ButtonType.OK){
                    kahvila.poistaTuote(a.getNimi());
                    omistajaGrid.getChildren().removeAll(nimi, poistaNappi);
                } else {

                }
            });
            GridPane.setConstraints(poistaNappi, 1, k);
            omistajaGrid.getChildren().addAll(nimi, poistaNappi);

            k = k + 1;

        }

        GridPane.setConstraints(lisaaNappi, 0, k);
        layout.getChildren().add(lisaaNappi);
    }

}