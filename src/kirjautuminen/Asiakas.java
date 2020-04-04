
// Asiakkaan tiedot kuten rahat ja bonuspisteet
package kirjautuminen;

import java.util.Scanner;

public class Asiakas {
    private int raha;
    private int bonus;

    public Asiakas() {
        this.raha = 100;
        this.bonus = 0;
    }

    public int tulostaRaha() {
        return this.raha;
    }
    public int getBonus() {
        return this.bonus;
    }
    public void otaRaha(String tuote, int maksu) {
       while (true) {
        Scanner ok = new Scanner(System.in);
        if (bonus < 10) {
            System.out.print("Oletko varma että haluat ostaa tuotteen " + tuote + " (k/e): ");
            String vahvistus = ok.nextLine();

            if (vahvistus.equals("k")) {
                if (raha < maksu) {
                    System.out.println("Tuotetta ei voi ostaa, liian vähän rahaa");
                    break;
                } else {
                    this.raha = raha - maksu;
                    System.out.println("tuote ostetiin.");
                    this.bonus = this.bonus + 1;
                    break;
                }
            } else if (vahvistus.equals("e")) {
                System.out.println("Tuotetta ei osteta");
                break;
            } else {
                System.out.println("Anna kelvollinen vastaus");
            }
        } else if (bonus == 10) {
            System.out.print("Haluatko käyttää 10 bonuspistettä saadaksesi tuotteen ilmaiseksi (k/e): ");
            String b = ok.nextLine();
            if (b.equals("k")) {
                System.out.println("Tuote ostetiin!");
                bonus = bonus - 10;
                break;
            } else if (b.equals("e")) {
                System.out.print("Oletko varma että haluat ostaa tuotteen rahoillasi (k/e): " + tuote + ": ");
                String vahvistus = ok.nextLine();
                if (vahvistus.equals("k")) {
                    if (raha < maksu) {
                        System.out.println("Tuotetta ei voi ostaa, liian vähän rahaa");
                        break;
                    } else {
                        raha = raha - maksu;
                        System.out.println("Tuote ostettiin!");
                        break;
                    }
                }


            }
        }
    }
    }



}