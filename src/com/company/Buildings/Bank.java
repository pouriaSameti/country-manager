package com.company.Buildings;
import com.company.bankery.*;
import com.company.city ;
import com.company.country.Country ;
import com.company.graphics.BankFolder.* ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import com.company.Person.person;
import com.company.Person.person.* ;
import com.company.graphics.CountryFolder.GetTransactionsPanel;
import javax.swing.*;

public class Bank extends Thread implements Serializable
{
    private String name ;
    private city City ;
    private Country country ;
    private String address ;
    private int balanceOfBank ;
    private int numberOfAccounts ;
    private int setNumberOfPersonnel ;
    private HashMap<LoginAccount, Account> allAccounts = new HashMap<>() ;
    private ArrayList<person> allPersonnel = new ArrayList<>() ;
    private boolean isContinue ;
    private boolean isShow ;
    //graphical fields
    public static Bank currentBank ;
    private transient BankPanel bankPanel ;
    private transient BankInfo bankInfo ;

    public Bank(String name, city City, Country country, String address)
    {
        this.name = name ;
        this.City = City ;
        this.getCity().addBuilding(this);
        this.country = country ;
        this.address = address ;
        this.balanceOfBank = 0 ;
        this.numberOfAccounts = 0 ;
        this.isContinue = true ;
        this.isShow = false ;
        this.start();
    }

    public void hireJob()
    {
        ArrayList<person> tempBanker = new ArrayList<>() ;
        ArrayList<person> tempEmployee = new ArrayList<>() ;

        for (person p : getCity().getAllPeople())
        if (! p.getEmploymentStatus())
        {
            if (p.getJob().equals(job.banker))
                tempBanker.add(p) ;
            if (p.getJob().equals(job.bankEmployee))
                tempEmployee.add(p) ;
        }

        int numberOfBankers = 1 ;
        int numberOfEmployee = 4 ;

        if (tempBanker.size() < 1)
            numberOfBankers = 0 ;
        if (tempEmployee.size() < 4)
            numberOfEmployee = tempEmployee.size() ;

        for (int i = 0 ; i < numberOfBankers ; ++i)
            this.addPersonnel(tempBanker.get(i));

        for (int i = 0 ; i < numberOfEmployee ; ++i)
            this.addPersonnel(tempEmployee.get(i));
    }

    public void addPersonnel(person p)
    {
        if (p.getJob().equals(job.banker))
        {
            p.setSalary(40) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getBankName());
            this.getAllPersonnel().add(p) ;
            this.setSetNumberOfPersonnel(this.getAllPersonnel().size());
            //write part
            this.getCity().writeCity();
        }

        if (p.getJob().equals(job.bankEmployee))
        {
            p.setSalary(30) ;
            p.setEmploymentStatus(true);
            p.setWorkHouse(this.getBankName());
            this.getAllPersonnel().add(p) ;
            this.setSetNumberOfPersonnel(this.getAllPersonnel().size());
            //write part
            this.getCity().writeCity();
        }
    }

    public void removePersonnel(person p)
    {
        int indexOfPerson = this.getAllPersonnel().indexOf(p);
        this.getAllPersonnel().get(indexOfPerson).setSalary(0);
        this.getAllPersonnel().get(indexOfPerson).setEmploymentStatus(false);
        this.getAllPersonnel().get(indexOfPerson).setWorkHouse("");
        this.getAllPersonnel().remove(p);
        this.setSetNumberOfPersonnel(this.allPersonnel.size());
        //write part
        this.getCity().writeCity();
    }

    public void addAccount(Account account)
    {
        this.allAccounts.put(account.getLoginInfo(), account) ;
        this.updateBalance();
        this.setNumberOfAccounts(this.allAccounts.size()) ;
        this.getCity().writeCity();
    }


    public void removeAccount(Account account)
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                setBalanceOfBank(getBalanceOfBank() - account.getAccountBalance());
                allAccounts.remove(account.getLoginInfo()) ;
                Bank.currentBank.updateBankPanel();
                city.currentCity.setFinallyBudget();
                city.currentCity.updateCityPanel();
                setNumberOfAccounts(allAccounts.size()) ;
                return null ;
            }
        }.execute();
        this.getCity().writeCity();
    }

    public Account getAccount(String username, String password)
    {
        Account OWNER = null ;
        ArrayList<Account> accounts = new ArrayList<>(this.getAllAccounts().values()) ;
        for (Account account : accounts)
            if (account.getLoginInfo().getUsername().equals(username) && account.getLoginInfo().getPassword().equals(password))
                OWNER = account ;
        return OWNER ;
    }

    public void updateBalance()
    {
        ArrayList<Account> accountsList = new ArrayList<>(this.allAccounts.values()) ;
        int balance = 0 ;
        for (Account account : accountsList)
            balance = balance + account.getAccountBalance() ;
        for (person p : this.getAllPersonnel())
            balance = balance - p.getSalary() ;
        setBalanceOfBank(balance);
        this.getCity().writeCity();

        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                getCity().setFinallyBudget();
                updateBankPanel();
                getCity().updateCityBudgetOnPanel();
                getCity().updateCityPanel();
                return null ;
            }
        }.execute();
    }

    @Override
    public void run()
    {
        while (isContinue)
        {
            try {
                Thread.sleep(70000);
                this.updateBalance();
                if (isShow)
                {
                    GetTransactionsPanel.transactionTXA.append("BANK -> Balance of  " +
                                                                this.getBankName() + ":" +
                                                                this.getBalanceOfBank() + "\n");
                    GetTransactionsPanel.transactionTXA.append("CITY -> Balance of " +
                                                                this.getCity().getCityName() + " : " +
                                                                this.getCity().getBudgetOfCity() + "\n");
                }
            }
            catch (InterruptedException ie) {}
        }
    }


    public String getBankName() { return name; }

    public city getCity() { return City; }

    public ArrayList<person> getAllPersonnel() { return allPersonnel; }

    public void setSetNumberOfPersonnel(int setNumberOfPersonnel) { this.setNumberOfPersonnel = setNumberOfPersonnel; }

    public void setBalanceOfBank(int balanceOfBank) { this.balanceOfBank = balanceOfBank; }
    public int getBalanceOfBank() { return balanceOfBank; }

    public void setNumberOfAccounts(int numberOfAccounts) { this.numberOfAccounts = numberOfAccounts; }

    public void setContinue(boolean aContinue) { isContinue = aContinue; }

    public void setShow(boolean show) { isShow = show; }

    public HashMap<LoginAccount, Account> getAllAccounts() { return allAccounts; }

    @Override
    public String toString(){
        return getBankName() ;
    }


    //graphical method
    public void createBankPanel()
    {
        bankPanel = new BankPanel() ;
        bankPanel.setVisible(true);
    }

    public void updateBankPanel()
    {
        bankPanel.nameLBL.setText(getBankName());
        bankPanel.addressLBL.setText(address);
        bankPanel.personnelsLBL.setText(String.valueOf(getAllPersonnel().size()));
        bankPanel.accountsLBL.setText(String.valueOf(allAccounts.size()));
        bankPanel.balanceLBL.setText(String.valueOf(getBalanceOfBank()));
    }


    public void createBankMainPanel()
    {
        currentBank = this ;
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                createBankPanel();
                updateBankPanel();
                return null ;
            }
        }.execute();
    }

    public void showBankInfo()
    {
        new SwingWorker<>(){
            @Override
            public Object doInBackground() {
                bankInfo = new BankInfo() ;
                bankInfo.nameLBL.setText(getBankName());
                bankInfo.addressLBL.setText(address);
                bankInfo.personnelsLBL.setText(String.valueOf(getAllPersonnel().size()));
                bankInfo.accountsLBL.setText(String.valueOf(allAccounts.size()));
                bankInfo.balanceLBL.setText(String.valueOf(getBalanceOfBank()));
                bankInfo.setVisible(true);
                return null ;
            }
        }.execute();
    }
}
