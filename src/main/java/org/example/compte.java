package org.example;
import  java.util.*;
public class compte {
    banque B;
    //private client Client;
    private String numCompte;
    private Date dateCreation;
    private  Date dateUpdate;
    private double device;
    private List<transaction> transactions;
    public compte(String numCompte,Date dateCre,Date dateUpd,banque b,double device) {
        this.numCompte = numCompte;
        this.dateCreation=dateCre;
        this.dateUpdate=dateUpd;
        this.device=device;
        transactions =new ArrayList<>();
        //Client=new client(C);
        B=new banque(b.getNom(),b.getPay());
    }
    public String getNumCompte() {return numCompte;}

    public double getDevice() { return device; }

    public void setDevice(double device) {
        this.device = device;
    }

    public void addTransaction(transaction t) {
        transactions.add(t);
    }

    @Override
    public String toString() {
        return "compte{" +
                "B=" + B.getNom() +
               // ", Client=" + Client.getNom() +" "+ Client.getPrenom()+
                ", numCompte='" + numCompte + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                ", device=" + device +
                '}';
    }
}
