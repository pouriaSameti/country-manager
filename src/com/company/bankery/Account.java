package com.company.bankery;
import com.company.Person.person ;
import com.company.bankery.Transaction.TransactionType ;
import javax.swing.* ;
import java.io.Serializable;
import java.util.ArrayList;
import com.company.graphics.BankFolder.* ;
import com.company.graphics.CountryFolder.GetTransactionsPanel;

public class Account extends Thread implements Serializable
{
    private person owner ;
    private LoginAccount loginInfo ;
    private int accountBalance ;
    private boolean isContinue ;
    private boolean isShow ;
    private ArrayList<Transaction> allTransaction = new ArrayList<>() ;
    //graphical fields
    public static Account currentAccount ;
    private transient AccountPanel accountPanel ;

    public Account(person owner, LoginAccount loginInfo, int balance)
    {
        this.owner = owner ;
        this.loginInfo = loginInfo ;
        this.accountBalance = balance ;
        this.isContinue = true ;
        this.isShow = false ;
        if (owner.getEmploymentStatus())
            this.depositToAccount(owner.getSalary());
        this.start();
    }

    public void depositToAccount(int value) {

        Transaction T = new Transaction(this.accountBalance, value, TransactionType.Deposit) ;
        this.setAccountBalance(T.getBalance());
        this.allTransaction.add(T) ;
    }

    public void withdrawalFromAccount(int value) {

        Transaction T = new Transaction(this.accountBalance, value, TransactionType.Withdrawal) ;
        this.setAccountBalance(T.getBalance());
        this.allTransaction.add(T) ;
    }

    private void calculateInterest() {

        Transaction T = new Transaction(this.getAccountBalance(), TransactionType.interest) ;
        this.allTransaction.add(T);
        this.setAccountBalance(T.getBalance());
        if (isShow)
        {
            GetTransactionsPanel.transactionTXA.append("ACCOUNT -> " + owner.getName() +
                    " " + owner.getLastName() +
                    T.getTransactionInfo() + "\n");
        }
    }

    @Override
    public void run()
    {
        while (this.isContinue)
        {
            try {
                Thread.sleep(60000);
                this.calculateInterest();
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public person getOwner() { return owner; }

    public LoginAccount getLoginInfo() { return loginInfo; }

    public void setContinue(boolean aContinue) { isContinue = aContinue; }

    public void setShow(boolean show) { isShow = show; }

    public ArrayList<Transaction> getAllTransaction() { return allTransaction; }

    public void setAccountBalance(int accountBalance) { this.accountBalance = accountBalance; }
    public int getAccountBalance() { return accountBalance; }

    //graphical method

    public void updateAccountPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                accountPanel.ownerLBL.setText(getOwner().getName() + " " + getOwner().getLastName());
                accountPanel.BalanceLBL.setText(getAccountBalance() + "$");
                return null ;
            }
        }.execute();
    }

    public void showAccountPanel()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                accountPanel = new AccountPanel() ;
                updateAccountPanel();
                accountPanel.setVisible(true);
                return null ;
            }
        }.execute();
    }

}
