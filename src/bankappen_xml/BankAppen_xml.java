package bankappen_xml;

import javax.xml.bind.JAXBException;

public class BankAppen_xml {
    public static void main(String[] args) throws JAXBException {
        DataHolder data = new DataHolder();
        data.addAccount(new Account(12345, "password", 31241, 42141));
        data.addAccount(new Account(21252, "password", 21242, 32251));
        data.addAccount(new Account(53212, "password", 13215, 25251));
        data.addAccount(new Account(32234, "password", 41122, 52251));
        
        XmlMagic xml = new XmlMagic(data);
        xml.pack("Accounts");
        xml.unpack("Accounts");
        DataHolder d2 = (DataHolder) xml.getObject();
        d2.printAccountsInfo();
    }
}