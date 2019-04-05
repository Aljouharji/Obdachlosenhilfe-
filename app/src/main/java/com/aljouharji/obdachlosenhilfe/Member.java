package com.aljouharji.obdachlosenhilfe;

public class Member {
private String Name;
private String Strasse ;
    private String Stadt;
    private String Plz;
    private Integer Telefon;
    private String Termin;
    private Integer Mahl;

    public Member() {
    }


    public Integer getMahl() {
        return Mahl;
    }

    public void setMahl(Integer mahl) {
        Mahl = mahl;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }

    public String getPlz() {
        return Plz;
    }

    public void setPlz(String plz) {
        Plz = plz;
    }

    public Integer getTelefon() {
        return Telefon;
    }

    public void setTelefon(Integer telefon) {
        Telefon = telefon;
    }

    public String getTermin() {
        return Termin;
    }

    public void setTermin(String termin) {
        Termin = termin;
    }
}
