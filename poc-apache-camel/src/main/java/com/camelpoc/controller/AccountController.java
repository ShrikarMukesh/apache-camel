package com.camelpoc.controller;

import com.camelpoc.model.BankAccount;
import com.camelpoc.service.AccountService;
import com.camelpoc.transform.AccountTransform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    AccountTransform accountTransform;

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/account", produces = MediaType.APPLICATION_XML_VALUE)
    public void transformXml() throws Exception {

        String xmlRes = accountTransform.accountTransform();
        BankAccount bankAccount = accountService.getTransformedXml(xmlRes);
        log.info("Bank account details" + bankAccount);

    }

}
