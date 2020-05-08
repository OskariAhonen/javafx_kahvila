package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Omistaja {
    private GridPane layout;
    private Kahvila kahvila;
    private Button lisaaNappi;
public Omistaja(Kahvila kahvila) {
    this.layout = new GridPane();
    this.kahvila = kahvila;
    this.lisaaNappi = new Button("Lisää tuote");
}
public Parent nakyma (Stage stage) {
    layout.setPadding(new Insets(10,10,10,10));
    layout.setHgap(8);
    layout.setVgap(10);
    layout.setAlignment(Pos.CENTER);
    paivita(kahvila, layout, lisaaNappi);
    layout.getChildren().add(lisaaNappi);
    lisaaNappi.setOnAction(e -> {
        Lisäys.lisääTuote();
        paivita(kahvila, layout, lisaaNappi);
        layout.getChildren().add(lisaaNappi);

    });
    return this.layout;
}
    public void paivita(Kahvila kahvila, GridPane omistajaGrid, Button lisääNappi){
        int k = 0;
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

        GridPane.setConstraints(lisääNappi, 0, k);
    }
}