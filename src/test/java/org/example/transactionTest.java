package org.example;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class transactionTest {
    private compte sender;
    private compte receiver;
    private transaction t;

    @BeforeEach
    void setUp() {
        banque b1=new banque("bmmce","maroc");
        banque b2=new banque("tejjari","france");
        client c1=new client("G1334","el houcine","Amghar","098765432","el@am");
        client c2=new client("G14","HILLO","NOOOOR","098732","e@m");
        sender=new compte("1234567890H",new Date(),null,b1,100);
        receiver=new compte("17890H",new Date(),null,b2,50);
        t=new transaction(null,null,sender,receiver);
    }
    @Test
    void testSuccessfulTransaction() throws InvalideTransaction {
        double montant = 30.0;
        t.exchange(montant);
        // Verify sender and receiver
        assertEquals(70.0, sender.getDevice());
        assertEquals(80.0, receiver.getDevice());
    }

    @Test
    void testInvalidTransaction() {
        double montant = 200.0; // Amount exceeds sender's balance
        Exception exception = assertThrows(InvalideTransaction.class, () -> {
            t.exchange(montant);
        });

        // Verify the exception message
        assertEquals("compte sender sans provision", exception.getMessage());
    }

    @Test
    void testInvalidTransactionZeroAmount() throws InvalideTransaction {
        double montant = 0.0; // Zero amount should not change
            Exception e=assertThrows(InvalideTransaction.class,()-> {
                        t.exchange(montant);
                    });
        assertEquals("montant doit être non null",e.getMessage());
        // Verify balances re
        assertEquals(100.0, sender.getDevice());
        assertEquals(50.0, receiver.getDevice());
    }
    public static  void main(String [] args){
        
    }
}