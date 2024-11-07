package org.example;
import java.util.ArrayList;
import java.util.List;

public class client {
    private String numClient,Nom,Prenom,num,mail;
    private List<compte> compteList;


    public  client(String numClient,String nom,String prenom,String num,String mail){
        this.numClient=numClient;
        this.num=num;
        this.Prenom=prenom;
        this.Nom=nom;
        this.mail=mail;
        this.compteList=new ArrayList<>();
    }
    public  client(client c){
        this.numClient=c.getNumClient();
        this.num=c.getNum();
        this.Nom=c.getNom();
        this.mail=c.getMail();
        this.Prenom=c.getPrenom();
        this.compteList=new ArrayList<>();
        this.compteList.addAll(c.getCompteList());
    }
 //Getters
    public String getNumClient() {return numClient;}
    public String getNom() {return Nom;}
    public String getPrenom() {return Prenom;}
    public String getNum() {return num;}
    public String getMail() {return mail;}
    public List<compte> getCompteList() {return compteList;}
//Setters
    public void setNumClient(String numClient) {this.numClient = numClient;}
    public void setNom(String nom) {Nom = nom;}
    public void setPrenom(String prenom) {Prenom = prenom;}
    public void setNum(String num) {this.num = num;}
    public void setMail(String mail) {this.mail = mail;}
    public void AddCompt(compte cmpt) {
        compteList.add(cmpt);
    }

    public void addCompte(compte c) {
        compteList.add(c);
    }

    @Override
    public String toString() {
        List<String> st=new ArrayList<>();
        for (compte c:compteList){
            st.add(c.getNumCompte());
        }
        return "client{" +
                "numClient='" + numClient + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", num='" + num + '\'' +
                ", mail='" + mail + '\'' +
                ", compteList=" + st +
                '}';
    }
}
