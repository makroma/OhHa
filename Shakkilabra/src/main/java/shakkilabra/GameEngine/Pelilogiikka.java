    package shakkilabra.GameEngine;

import shakkilabra.Assets.EnumTyyppi;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Grafiikka.SiirrotNaytto;

/**
 * Shakin pelilogiikka, joka vastaa nappuloiden luonnista ja liikuttelusta. L
 * Liikuttamisen yhteydessä simuloidaan nappulan siirtoa, ja tarkistetaan
 * mahdolliset esteet.
 *
 * @author marko
 */
public class Pelilogiikka {
    
    private boolean valkoisenVuoro;
    private final SiirtoTulostaja siirtoNaytto;
    
    public Pelilogiikka(SiirrotNaytto pelinaytto) {
        this.siirtoNaytto = new SiirtoTulostaja(pelinaytto);
        this.valkoisenVuoro = true;
    }
    /**
     * PELILOGIIKKA!
     *
     * LIIKKUMINEN 1. Onko mahdollinen siirto 2. Liikkuuko nappula tyhjään
     * ruutuun vai syökö 3. Nappula kohtaiset liikkumismedodit tai
     * syömistapahtuma
     *
     * Jos siirto epäonnistuu, kirjoitetaan pelinäyttöön tästä
     *
     * @param nappulat Atribuuttina nappulat
     * @return Palauttaa true, jos siirto onnistui
     */
    public boolean onkoValitunPelaajanVuoro(NappulaSet nappulat) {
        
        if (nappulat.annaValittuNappula().getVari() == EnumVari.VALKOINEN && valkoisenVuoro) {
            return true;
        } else if (nappulat.annaValittuNappula().getVari() == EnumVari.MUSTA && !valkoisenVuoro) {
            return true;
        }
        
        if (valkoisenVuoro) {
            siirtoNaytto.kirjoitaSiirrotNayttoon("Valkoisen pelaajan vuoro!");
        } else {
            siirtoNaytto.kirjoitaSiirrotNayttoon("Mustan pelaajan vuoro!");
        }
        return false;
    }

    /**
     * Vaihtaa pelaajan vuoron
     */
    public void vaihdaPelaajanVuoro() {
        valkoisenVuoro = !valkoisenVuoro;
    }

    /**
     * NappulanLiikkumisToiminnon alussa tarkistettaaan, onko oikean pelaajan
     * vuoro, onko tehtävä siito nappulan mahdolliset siirrot listalla jos on,
     * siirrytään testiin "liikkuuko tyhjään vai syö", joka samalla hoitaa
     * nappulan liikuttamisen. jos toiminnot onnistuu palautetaan true
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     * @return jos toiminto onnistui, palautetaan true.
     */
    public boolean testaaNappulanSiirtoJaToteutaSe(NappulaSet nappulat, int x, int y) {
        int vanhaX = nappulat.annaValittuNappula().getKordinaatti().getX();
        int vanhaY = nappulat.annaValittuNappula().getKordinaatti().getY();
        
        if (onkoValitunPelaajanVuoro(nappulat)) {
            System.out.println("Oikean pelaajan vuoro. ");
            
            if (onkoMahdollinenSiirto(nappulat, x, y)) {
                //Siirrytään seuraavaan vaiheeseen

                if (liikkuukoTyhjaanRuutuunVaiSyoko(nappulat, x, y)) {
                    siirtoNaytto.tulostetaanSiirtoNayttoon(nappulat, vanhaX, vanhaY);
                    nappulat.annaValittuNappula().setValittu(false);
                    vaihdaPelaajanVuoro();
                    return true;
                }
                System.out.println("Siirto ei onnistunut");
                nappulat.annaValittuNappula().setValittu(false);
                return false;
                
            }
            System.out.println("Siirto ei ole mahdollinen");
            nappulat.annaValittuNappula().setValittu(false);
            return false;
        }
        System.out.println("Väärän pelaajan vuoro");
        nappulat.annaValittuNappula().setValittu(false);
        return false;
        
    }

    /**
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     * @return palauttaa true, jos siirto mahdollinen
     */
    public boolean onkoMahdollinenSiirto(NappulaSet nappulat, int x, int y) {
        
        System.out.println("Tyyppi: " + nappulat.annaValittuNappula());
        
        if (nappulat.onkoRuutuValitunNappulanSiirroissa(x, y)) {
            System.out.print("Siirto mahdollinen " + x + "," + y + ". ");
            return true;
        } else {
            System.out.println("Siirto ei mahdollinen" + x + "," + y);
            return false;
        }
    }

    /**
     * Liikkuuko vai syökö -testi. Jos liikkuu, niin siirrytään
     * liikkumismetodeihin muuten siirrytään syömistoimintaan
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     */
    private boolean liikkuukoTyhjaanRuutuunVaiSyoko(NappulaSet nappulat, int x, int y) {
        //Onko Ruutu tyhjä
        if (nappulat.onkoRuuduVapaa(x, y)) {
            System.out.println("Ruutu on vapaa");
            
            System.out.println("Syökö Nappula tähän sijaintiin vai liikkuuko se testi:");
            return nappulaTyypinTarkistusjaLiikkuminen(nappulat, x, y);
            
        } else {
            //Siirrytäänkö syömään
            System.out.println("Syödään nappulaa..");
            if (nappulat.syokoValittuNappulaSijaintiin(x, y) && nappulat.annaValittuNappula().getVari() != nappulat.getNappula(x, y).getVari()) {
                //Tarkista onko esteitä tiellä

                if (nappulaSyoTarkistus(nappulat, x, y)) {
                    
                    System.out.println("Liikutetaan valittu nappula sijaintiin..");
                    System.out.println("Valittu Nappula syö sijaintiin. Poistetaan nappulaa: " + nappulat.getNappula(x, y));
                    siirtoNaytto.tulostetaanSyontiNayttoon(nappulat, x, y);
                    nappulat.poistaNappula(nappulat.getNappula(x, y));
                    System.out.print("Nappula poistettu. Liikutaan sijaintiin. ");
                    nappulat.annaValittuNappula().liiku(x, y);
                    return true;
                }
            } else {
                System.out.println("Voit syödä vain vastustajan nappuloita.");
                return false;
            }
        }
        return false;
    }

    /**
     * Tarkistetaan nappulan liikkuminen ja esteet syömistilanteesssa.
     *
     * @param nappulat
     * @param x
     * @param y
     * @return palautetaan true, jos siirto on mahdollinen
     */
    private boolean nappulaSyoTarkistus(NappulaSet nappulat, int x, int y) {
        if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.SOTILAS)) {
            //Jos Sotilas, niin...
            return liikutaSotilasta(nappulat, x, y);
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.TORNI)) {
            //Jos Torni...
            return liikutaTornia(nappulat, x, y);
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.KUNINGATAR)) {
            //Jos Kuningatar...
            return liikutaKuningatarta(nappulat, x, y);
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.LAHETTI)) {
            //Jos Lahetti...
            return liikutaLahettia(nappulat, x, y);
        } else {
            //jos Hevonen tai kuningas
            return true;
        }
        
    }

    /**
     * Tarkistaa onko siirto mahdollinen, jos onnistuu liikutetaan nappulaa
     *
     * @param nappulat
     * @param x
     * @param y
     * @return palauttaa true, jos siirto onnistui
     */
    private boolean nappulaTyypinTarkistusjaLiikkuminen(NappulaSet nappulat, int x, int y) {
        if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.SOTILAS)) {
            //Jos Sotilas, niin...
            if (liikutaSotilasta(nappulat, x, y)) {
                nappulat.annaValittuNappula().liiku(x, y);
                return true;
            }
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.TORNI)) {
            //Jos Torni...
            if (liikutaTornia(nappulat, x, y)) {
                nappulat.annaValittuNappula().liiku(x, y);
                return true;
            }
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.KUNINGATAR)) {
            //Jos Kuningatar...
            if (liikutaKuningatarta(nappulat, x, y)) {
                nappulat.annaValittuNappula().liiku(x, y);
                return true;
            }
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.LAHETTI)) {
            //Jos Lahetti...
            if (liikutaLahettia(nappulat, x, y)) {
                nappulat.annaValittuNappula().liiku(x, y);
                return true;
            }
        } else if (nappulat.annaValittuNappula().getTyyppi().equals(EnumTyyppi.HEVONEN)) {
            //jos Hevonen
            nappulat.annaValittuNappula().liiku(x, y);
            return true;
        } else {
            nappulat.annaValittuNappula().liiku(x, y);
            return true;
        }
        return false;
    }

    /**
     * NAPPULAKOHTAISET LIIKKUMISMETODIT
     *
     * - Kuningas ja hevonen ei tarvitse erillisiä tarkistuksia esteistä
     *
     * Tässä tarkistetaan kuningattaren nykyinen sijainti ja verrataan sitä
     * uuteen sijaintiin. Suunnan mukaan siirrytään liikkeen simulointiin.
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     */
    private boolean liikutaKuningatarta(NappulaSet nappulat, int x, int y) {
        //Suoritetaan "onko matkanvarreella muista nappuluita" -testi
        int nappulanX = nappulat.annaValittuNappula().getKordinaatti().getX();
        int nappulanY = nappulat.annaValittuNappula().getKordinaatti().getY();
        //liikutaanko Y- vai X-akselilla
        if (nappulanX == x) {
            if (tarkistaEsteetYakselilla(nappulanY, y, nappulat, nappulanX)) {
                return true;
            }
        } else if (nappulanY == y) {
            if (tarkistaEsteetXakselilla(nappulanX, x, nappulat, nappulanY)) {
                return true;
            }
        } //Liikutaanko ViistoAkseleilla
        else if (nappulanX < x && nappulanY < y) {
            if (tarkistaEsteetkunXYonSuurempikuinSijainti(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX > x && nappulanY > y) {
            if (tarkistaEsteetkunXYonPienempiKuinSijainti(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX < x && nappulanY > y) {
            if (tarkistaEsteetkunXonSuurempiJaYonPienempi(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX > x && nappulanY < y) {
            if (tarkistaEsteetkunYonSuurempiJaXonPienempi(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        }
        return false;
        
    }

    /**
     * Tornin liikukkumissuunnan tarkistus
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     */
    private boolean liikutaTornia(NappulaSet nappulat, int x, int y) {
        //Suoritetaan "onko matkanvarreella muista nappuluita" -testi
        int nappulanX = nappulat.annaValittuNappula().getKordinaatti().getX();
        int nappulanY = nappulat.annaValittuNappula().getKordinaatti().getY();
        //liikutaanko Y- vai X-akselilla
        if (nappulanX == x) {
            if (tarkistaEsteetYakselilla(nappulanY, y, nappulat, nappulanX)) {
                return true;
            }
        } else if (nappulanY == y) {
            if (tarkistaEsteetXakselilla(nappulanX, x, nappulat, nappulanY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lähetin liikkumissuunnan tarkistus
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     */
    private boolean liikutaLahettia(NappulaSet nappulat, int x, int y) {
        //Suoritetaan "onko matkanvarreella muista nappuluita" -testi
        int nappulanX = nappulat.annaValittuNappula().getKordinaatti().getX();
        int nappulanY = nappulat.annaValittuNappula().getKordinaatti().getY();
        //Liikutaanko ViistoAkseleilla
        if (nappulanX < x && nappulanY < y) {
            if (tarkistaEsteetkunXYonSuurempikuinSijainti(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX > x && nappulanY > y) {
            if (tarkistaEsteetkunXYonPienempiKuinSijainti(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX < x && nappulanY > y) {
            if (tarkistaEsteetkunXonSuurempiJaYonPienempi(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        } else if (nappulanX > x && nappulanY < y) {
            if (tarkistaEsteetkunYonSuurempiJaXonPienempi(nappulanX, nappulanY, y, x, nappulat)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sotilaan liikkumissuunnan tarkistus
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     */
    private boolean liikutaSotilasta(NappulaSet nappulat, int x, int y) {
        if (!nappulat.syokoValittuNappulaSijaintiin(x, y)) {
            return true;
        } else {
            if (!nappulat.onkoRuuduVapaa(x, y)) {
                return true;
            }
            System.out.println("Voit liikkua vain syödessä tähän suuntaan");
            return false;
        }
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet jos Y on suurempi ja X on
     * pienempi
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetkunYonSuurempiJaXonPienempi(int nappulanX, int nappulanY, int y, int x, NappulaSet nappulat) {
        nappulanX--;
        nappulanY++;
        while (nappulanX > x && nappulanY < y) {
            if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                System.out.println("Edessä on toinen Nappula");
                return false;
            }
            nappulanY++;
            nappulanX--;
        }
        return true;
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet jos X on suurempi ja Y on
     * pienempi
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetkunXonSuurempiJaYonPienempi(int nappulanX, int nappulanY, int y, int x, NappulaSet nappulat) {
        nappulanX++;
        nappulanY--;
        while (nappulanX < x && nappulanY > y) {
            if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                System.out.println("Edessä on toinen Nappula");
                return false;
            }
            nappulanY--;
            nappulanX++;
        }
        return true;
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet kun X ja Y on suurempi kuin
     * nykyinen sijainti
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetkunXYonSuurempikuinSijainti(int nappulanX, int nappulanY, int y, int x, NappulaSet nappulat) {
        nappulanY++;
        nappulanX++;
        while (nappulanY < y && nappulanX < x) {
            if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                System.out.println("Edessä on toinen Nappula");
                return false;
            }
            nappulanY++;
            nappulanX++;
        }
        return true;
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet X ja Y on pienempi kuin
     * nykyinen sijainti
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetkunXYonPienempiKuinSijainti(int nappulanX, int nappulanY, int y, int x, NappulaSet nappulat) {
        nappulanY--;
        nappulanX--;
        while (nappulanY > y && nappulanX > x) {
            if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                System.out.println("Edessä on toinen Nappula");
                return false;
            }
            nappulanY--;
            nappulanX--;
        }
        return true;
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet X aakselilla
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetXakselilla(int nappulanX, int x, NappulaSet nappulat, int nappulanY) {
        if (nappulanX < x) {
            nappulanX++;
            while (nappulanX < x) {
                if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                    System.out.println("Edessä on toinen Nappula");
                    return false;
                }
                nappulanX++;
            }
            
        } else if (nappulanX > x) {
            nappulanX--;
            while (nappulanX > x) {
                if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                    System.out.println("Edessä on toinen Nappula");
                    return false;
                }
                nappulanX--;
            }
        }
        return true;
    }

    /**
     * ESTEIDEN TARKISTUSMETODIT Tarkistaa esteet Y akselilla
     *
     * @param nappulanX nappulan nykyinen X
     * @param nappulanY nappulan nykyinen Y
     * @param y Nappulan uusi X
     * @param x Nappulan uusi y
     * @param nappulat NappulatLista
     * @return True, jos ei esteitä
     */
    private boolean tarkistaEsteetYakselilla(int nappulanY, int y, NappulaSet nappulat, int nappulanX) {
        
        if (nappulanY < y) {
            nappulanY++;
            while (nappulanY < y) {
                if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                    System.out.println("Edessä on toinen Nappula");
                    return false;
                }
                nappulanY++;
            }
            
        } else if (nappulanY > y) {
            nappulanY--;
            while (nappulanY > y) {
                if (!nappulat.onkoRuuduVapaa(nappulanX, nappulanY)) {
                    System.out.println("Edessä on toinen Nappula");
                    return false;
                }
                nappulanY--;
            }
        }
        return true;
    }

//    public void testipeliRun() {
//
//        luoSotilaatLaudalle();
//
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
//
//        System.out.println("Valitaan musta sotilas...1,5");
//
//        nappulat.tulostaMahdollisetSiirrot(1, 5);
//        nappulat.asciiMahdollisetSiirrot(1, 5);
//
//        // nappulat.getNappula(1, 5).liiku(4, 5);
//        System.out.println("Musta nappula liikkuu");
//        nappulat.getNappula(1, 5).liiku(3, 5);
//
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
//
//        //nappulat.getNappula(5, 6).setElossa();
//        nappulat.tulostaNappulat();
//        System.out.println("Valkoinen liikkuu");
//        nappulat.getNappula(3, 5).liiku(4, 5);
//        nappulat.tulostaNappulat();
//        nappulat.asciiLautaTulostin();
//    }
    public boolean isValkoisenVuoro() {
        return valkoisenVuoro;
    }
    
    public void setValkoisenVuoro(boolean valkoisenVuoro) {
        this.valkoisenVuoro = valkoisenVuoro;
    }
}
