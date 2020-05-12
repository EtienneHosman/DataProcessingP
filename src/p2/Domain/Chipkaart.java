package p2.Domain;

import java.sql.Date;

public class Chipkaart {

    private int kaartNummer;
    private Date geldig;
    private int klasse;
    private double saldo;
    private Reiziger eigenaar;

    public Chipkaart(int kaartNummer, Date geldig, int klasse, double saldo){
        this.kaartNummer = kaartNummer;
        this.geldig = geldig;
        this.klasse = klasse;
        this.saldo = saldo;
    }

    public Chipkaart(){

    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public Date getGeldig() {
        return geldig;
    }

    public void setGeldig(Date geldig) {
        this.geldig = geldig;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(Reiziger eigenaar) {
        this.eigenaar = eigenaar;
    }
}
