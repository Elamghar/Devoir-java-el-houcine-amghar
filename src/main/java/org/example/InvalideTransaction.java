package org.example;

public class InvalideTransaction extends Exception {
    public  String msg;
    public InvalideTransaction(String msg){
        super(msg);
        this.msg=msg;
    }
}
