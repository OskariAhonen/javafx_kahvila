package kirjautuminen;
// Tuote luokka
public class Tuote {
private String nimi;
private int hinta;

public Tuote(String nimi, int input) {
        this.nimi = nimi;
        this.hinta = input;
        }



    public String getNimi() {
        return this.nimi;
        }

        public int getHinta() {
    return this.hinta;
        }
        }
