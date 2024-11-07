package org.example;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;

public class transaction {
    private Date dateStmp;
    private  String reference;
    private  compte Sender;
    private  compte Receiver;
    enum TypeVir{
        VIRIN,
        VIREST,
        VIRCKA,
        VIRMULTA
    };
    private TypeVir typevir;


        public transaction(Date date,String reference,compte Sender,compte Receiver){
            this.reference=reference;
            this.dateStmp=date;
            this.Receiver=Receiver;
            this.Sender=Sender;
            checkTypeVir(Receiver,Sender);
        }
        public void exchange(double montant) throws InvalideTransaction {
            if(montant==0){
                throw new InvalideTransaction("montant doit être non null");
            }
            if(this.Sender.getDevice()<montant && montant!=0){
                throw  new InvalideTransaction("compte sender sans provision");
            }
            else {
                //je dois tratter le cas d'apparition d'une erreur innatendu avec un lacement de semaphore
                    double newMt = this.Receiver.getDevice() + montant;
                    this.Receiver.setDevice(newMt);
                    this.Sender.setDevice(this.Sender.getDevice()-montant);
                    Sender.addTransaction(this);
                    Receiver.addTransaction(this);
                    System.out.println("Transaction bien effectué");
            }
        }

        private void checkTypeVir(compte r,compte s) {

            if (this.Sender.B.getNom().equals(this.Receiver.B.getNom())) {
                if (this.Sender.B.getPay().equals(this.Receiver.B.getPay()))
                    this.typevir = TypeVir.VIRIN;
                else
                    this.typevir = TypeVir.VIREST;

            } else
                this.typevir = TypeVir.VIRCKA;
        }

    public Date getDateStmp() {return dateStmp;}
    public String getReference() {return reference;}

    @Override
    public String toString() {
        return "transaction{" +
                "dateStmp=" + dateStmp +
                ", reference='" + reference + '\'' +
                ", Sender=" + Sender +
                ", Receiver=" + Receiver +
                ", typevir=" + typevir +
                '}';
    }
}
