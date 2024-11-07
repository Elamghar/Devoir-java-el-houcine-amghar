package org.example;
import java.util.Date;
public class Main {
    public static void main(String[] args) throws InvalideTransaction {

        banque b1=new banque("bmmce","maroc");
        banque b2=new banque("tejjari","france");
       client c1=new client("G1334","el houcine","Amghar","098765432","el@am");
        client c2=new client("G14","HILLO","NOOOOR","098732","e@m");
        compte cmpt1=new compte("1234567890H",new Date(),null,b1,100);
        compte cmpt2=new compte("17890H",new Date(),null,b2,1000);

        c1.addCompte(cmpt1);
        c2.addCompte(cmpt2);

        System.out.println(cmpt1);
        System.out.println(cmpt2);
        transaction  t1=new transaction(new Date(),"azertyu",cmpt1,cmpt2);
        try {
            t1.exchange(2000);
        }
        catch (InvalideTransaction e){
          System.out.println(e.msg);
        }
        System.out.println(cmpt1);
        System.out.println(cmpt2);

       System.out.println(c1);


    }
}