package com.company.bankery;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable
{
    private int balance ;
    private Date time ;
    private TransactionType type ;
    private int transactionAmount ;

    //constructors----------------------------------------------------
    public Transaction(int initialBalance, int value, TransactionType type)
    {
        if (type.equals(TransactionType.Deposit)) {
            this.time = new Date() ;
            this.type = TransactionType.Deposit ;
            this.transactionAmount = value ;
            this.setBalance(initialBalance);
            this.depositToAccount(value);
        }

        if (type.equals(TransactionType.Withdrawal)) {
            this.time = new Date() ;
            this.type = TransactionType.Withdrawal ;
            this.transactionAmount = value ;
            this.setBalance(initialBalance);
            this.withdrawalFromAccount(value);
        }
    }

    public Transaction(int initialBalance, TransactionType type)
    {
        if (type.equals(TransactionType.interest)) {
            this.time = new Date() ;
            this.type = TransactionType.interest ;
            this.setBalance(initialBalance);
            this.getInterest();
        }
    }


    //methods----------------------------------------------------
    private void depositToAccount(int value) {

        int newBalance = this.getBalance() + value ;
        this.setBalance(newBalance);
    }

    private void withdrawalFromAccount(int value) {

        if (this.getBalance() > value) {
            int newBalance = this.getBalance() - value ;
            this.setBalance(newBalance);
        }

        else
            this.setBalance(this.getBalance());
    }


    private void getInterest() {

        int newBalance = this.getBalance() + (this.getBalance() * (18)) / 100 ;
        this.setBalance(newBalance);
    }


    public String getTransactionInfo() {

        if (!this.type.equals(TransactionType.interest))
            return this.getType() + " , time: " + this.getTime() + " , amount:" + this.getTransactionAmount() + " , Balance:" + this.getBalance() ;
        else
            return this.getType() + " , time: " + this.getTime() + " , percent: 18 % , " + "Balance:" + this.getBalance() ;
    }



    enum TransactionType
    {
        interest,Withdrawal,Deposit
    }


    public String getType(){ return this.type.name() ;}

    public int getTransactionAmount() { return transactionAmount; }

    public void setBalance(int balance) { this.balance = balance; }
    public int getBalance() { return balance; }

    public String getTime() { return new SimpleDateFormat("hh:mm:ss").format(this.time) ; }

}
