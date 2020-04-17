package kirjautuminen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
import java.util.List;
public class Lisäys {

    private static Kahvila kahvila;
    public Lisäys(Kahvila kahvila){
        this.kahvila = kahvila;
    }
    public static void lisääTuote() {
        Stage stage = new Stage();
        stage.setTitle("Lisää tuote");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label lisäNimi = new Label("Anna tuotteen nimi: ");
        GridPane.setConstraints(lisäNimi, 0,0);
        TextField nimiInput = new TextField();
        GridPane.setConstraints(nimiInput, 1,0);
        Label lisäHinta = new Label("Anna hinta: ");
        GridPane.setConstraints(lisäHinta, 0,1);
        TextField hintaInput = new TextField();
        GridPane.setConstraints(hintaInput, 1,1);
        Button lisää = new Button("Lisää");
        lisää.setOnAction(e -> {


            String i = hintaInput.getText();
            int hinta = Integer.parseInt(i);
            String nimi = nimiInput.getText();
            Tuote a = new Tuote(nimi, hinta);
            kahvila.lisaaTuote(a);
            stage.close();

        });

        GridPane.setConstraints(lisää, 0,2);
        Button sulje = new Button("Sulje");
        GridPane.setConstraints(sulje,1,2);
        sulje.setOnAction(e -> stage.close());
        grid.getChildren().addAll(lisäNimi, nimiInput, lisäHinta, hintaInput, lisää, sulje);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.showAndWait();


    }
}
