/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkilabra.GameEngine;

import shakkilabra.Assets.EnumTyyppi;
import shakkilabra.Assets.EnumVari;
import shakkilabra.Assets.Nappulat.Hevonen;
import shakkilabra.Assets.Nappulat.Kuningas;
import shakkilabra.Assets.Nappulat.Kuningatar;
import shakkilabra.Assets.Nappulat.Lahetti;
import shakkilabra.Assets.Nappulat.Torni;
import shakkilabra.Assets.Nappulat.Sotilas;
import shakkilabra.Grafiikka.Pelinaytto;

/**
 * Shakin pelilogiikka, joka vastaa nappuloiden luonnista ja liikuttelusta. L
 * Liikuttamisen yhteydessä simuloidaan nappulan siirtoa, ja tarkistetaan
 * mahdolliset esteet.
 *
 * @author marko
 */
public class Pelilogiikka {
    
    private boolean valkoisenVuoro;
    private Pelinaytto pelinaytto;
    
    public Pelilogiikka(Pelinaytto pelinaytto) {
        
        this.valkoisenVuoro = true;
        this.pelinaytto = pelinaytto;
        
    }

    /**
     * Luo nappulat aloitussijainteihin.
     *
     * @param nappulat NappulatSet, joka sisältää listan kaikista nappuloista
     */
    public void luoNappulatLaudalle(NappulaSet nappulat) {
        System.out.println("Luodaan nappulat...");

        //luodaan valoinen kunngas
        nappulat.lisaaNappula(new Kuningas(EnumVari.VALKOINEN, 7, 4));
        //luodaan valkoinen kuningatar
        nappulat.lisaaNappula(new Kuningatar(EnumVari.VALKOINEN, 7, 3));
        //luodaan valkoinen Lahetti
        nappulat.lisaaNappula(new Lahetti(EnumVari.VALKOINEN, 7, 2));
        nappulat.lisaaNappula(new Lahetti(EnumVari.VALKOINEN, 7, 5));
        //luodaan valoinen Torni
        nappulat.lisaaNappula(new Torni(EnumVari.VALKOINEN, 7, 0));
        nappulat.lisaaNappula(new Torni(EnumVari.VALKOINEN, 7, 7));
        //luodaan valkoiset hevoset
        nappulat.lisaaNappula(new Hevonen(EnumVari.VALKOINEN, 7, 6));
        nappulat.lisaaNappula(new Hevonen(EnumVari.VALKOINEN, 7, 1));
        //luodaan valkoiset Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.VALKOINEN, 6, 7));

        //luodaan musta kuningas
        nappulat.lisaaNappula(new Kuningas(EnumVari.MUSTA, 0, 4));
        //luodaan Musta kuningatar
        nappulat.lisaaNappula(new Kuningatar(EnumVari.MUSTA, 0, 3));
        //luodaan Musta Lahetti
        nappulat.lisaaNappula(new Lahetti(EnumVari.MUSTA, 0, 2));
        nappulat.lisaaNappula(new Lahetti(EnumVari.MUSTA, 0, 5));
        //luodaan musta Torni
        nappulat.lisaaNappula(new Torni(EnumVari.MUSTA, 0, 0));
        nappulat.lisaaNappula(new Torni(EnumVari.MUSTA, 0, 7));
        //luodaan Mustat Hevoset
        nappulat.lisaaNappula(new Hevonen(EnumVari.MUSTA, 0, 6));
        nappulat.lisaaNappula(new Hevonen(EnumVari.MUSTA, 0, 1));
        //luodaan mustat Sotilaat
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 0));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 1));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 2));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 3));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 4));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 5));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 6));
        nappulat.lisaaNappula(new Sotilas(EnumVari.MUSTA, 1, 7));
        
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
    public boolean oikeanPelaajanVuoro(NappulaSet nappulat) {
        
        if (nappulat.annaValittuNappula().getVari() == EnumVari.VALKOINEN && valkoisenVuoro) {
            return true;
        } else if (nappulat.annaValittuNappula().getVari() == EnumVari.MUSTA && !valkoisenVuoro) {
            return true;
        }
        
        if (this.valkoisenVuoro) {
            this.pelinaytto.kirjoitaPeliNayttoon("Valkoisen pelaajan vuoro!");
        } else {
            this.pelinaytto.kirjoitaPeliNayttoon("Mustan pelaajan vuoro!");
        }
        
        return false;
    }
    /**
     * Vaihtaa pelaajan vuoron
     */
    
    public void vaihdaPelaajanVuoro() {
        this.valkoisenVuoro = !this.valkoisenVuoro;
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
    public boolean nappulanLiikkumisToiminto(NappulaSet nappulat, int x, int y) {
        
        if (oikeanPelaajanVuoro(nappulat)) {
            
            System.out.println("Oikean pelaajan vuoro. ");
            
            if (onkoMahdollinenSiirto(nappulat, x, y)) {
                //Siirrytään seuraavaan vaiheeseen

                if (liikkuukoTyhjaanRuutuunVaiSyo(nappulat, x, y)) {
                    
                    tulostetaanSiirtoNayttoon(nappulat, x, y);
                    
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
     * Pelinäyttö tulostin. Voidaan syöttää vapaamuotoinen teksti.
     *
     * @param nappulat
     * @param x
     * @param y
     */
    private void tulostetaanSiirtoNayttoon(NappulaSet nappulat, int x, int y) {
        
        this.pelinaytto.kirjoitaPeliNayttoon(nappulat.annaValittuNappula().toString() + " siirtyi ruutuun " + x + ", " + y);
        
    }

    /**
     *
     * @param nappulat NappulatLista
     * @param x uusi X
     * @param y uusi Y
     * @return palauttaa true, jos siirto mahdollinen
     */
    private boolean onkoMahdollinenSiirto(NappulaSet nappulat, int x, int y) {
        
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
    private boolean liikkuukoTyhjaanRuutuunVaiSyo(NappulaSet nappulat, int x, int y) {
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
            if(!nappulat.onkoRuuduVapaa(x, y)){
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
    
}
