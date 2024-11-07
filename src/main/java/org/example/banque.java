package org.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import  java.util.List;

public class banque {
    private String Nom,pay;
    List<compte> comptes;

    public banque(String nom,String p) {
        Nom = nom;
        pay=p;
        comptes=new ArrayList<>();
    }
    public void addCompte(compte c) throws InvalideTransaction {
        if(c==null)throw new InvalideTransaction("compte passer a banque is null");
        else {
            comptes.add(c);
        }
    }
    public List<compte> rechercheClientComptes(String Num){
        List <compte> ClientComptes=new ArrayList<>();
        for (compte c : comptes){
            if(c.getClient().getNumClient().equals(Num)){
                ClientComptes.add(c);
            }
        }
        return ClientComptes;
    }
    public String getNom() {return Nom;}
    public String getPay() {return pay;}
}
