package bankappen_xml;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataHolder {
    private ArrayList<Account> databaseAccounts;
    JAXBContext context;
    
    public DataHolder(){
        databaseAccounts = new ArrayList<>();     
    }
    ///////////////////
    public void init() throws JAXBException{
        this.context = JAXBContext.newInstance(DataHolder.class);
    }
    public void setDatabaseAccounts(ArrayList<Account> databaseAccounts) {
        this.databaseAccounts = databaseAccounts;
    }
    
    @XmlElement
    public ArrayList<Account> getList() {
        return databaseAccounts;
    }
    ///////////////////
    
    public final void addAccount(Account newAccount){
        this.databaseAccounts.add(newAccount);
    } 
    public void printAccountsInfo() {
        System.out.println("Accounts : " + databaseAccounts.size());
        for (Account i : databaseAccounts){
            System.out.println(i.toString());
        }
    } 

    @Override
    public String toString() {
        return "AccountsArray : " + "databaseAccounts :\n" + databaseAccounts;
    }
    /*
    public Account getAccount (int accountNumber){
        for(Account currentAccount : databaseAccounts){
            if(currentAccount.getAccountNumber() == accountNumber){
                return currentAccount;
            }
        }
        return null; //TODO Change to throw exception!
    }  
    public boolean authenticateUser(int userAccountNumber, String userPIN){
        Account userAccount = getAccount(userAccountNumber);
        if(userAccount != null){
            return userAccount.validatePIN(userPIN);
        } else return false;
    }*/
 
}
