package com.camelpoc.service;

import com.camelpoc.model.BankAccount;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class AccountService {

    public BankAccount getTransformedXml(String transformedXml ) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BankAccount.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(transformedXml);
            BankAccount bankAccount = (BankAccount) unmarshaller.unmarshal(reader);

            return bankAccount;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
