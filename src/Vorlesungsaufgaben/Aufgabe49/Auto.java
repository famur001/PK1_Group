package Vorlesungsaufgaben.Aufgabe49;

public class Auto{
    private String hersteller;
    private int baujahr;
    
    public Auto(String hersteller, int baujahr){
        this.hersteller = hersteller;
        this.baujahr = baujahr;
    }
    
    public Auto(int baujahr){
        this("unbekant", baujahr);
    }

    public String getHersteller() {
        return hersteller;
    }

    public int getBaujahr() {
        return baujahr;
    }
    
    
    public int alter(){
        return 2016 - baujahr;
    }

    @Override
    public String toString(){
        return hersteller + " mit Baujahr " + baujahr + "\n";
    }
}
