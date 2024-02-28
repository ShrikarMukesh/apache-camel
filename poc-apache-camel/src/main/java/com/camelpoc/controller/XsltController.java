package com.camelpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class XsltController {

    @Autowired
    private TransformerFactory transformerFactory;

    @GetMapping(value = "/transform-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String transformXml() throws Exception {
        // Load XML data
        String xmlData = loadXmlData();

        // Load XSLT file
        String xsltPath = "classpath:BankAccountTransform.xsl";
        Resource xsltResource = new ClassPathResource(xsltPath);

        // Perform XSLT transformation
        String transformedXml = transformXmlWithXslt(xmlData, xsltResource.getInputStream());

        return transformedXml;
    }

    private String loadXmlData() {
        // Load XML data (replace with your own XML data loading mechanism)
        return "<bankAccount>" +
                "<accountNumber>123456789</accountNumber>" +
                "<balance>5000.00</balance>" +
                "<cards>" +
                "<card>" +
                "<cardNumber>1111 2222 3333 4444</cardNumber>" +
                "<cardType>Credit</cardType>" +
                "</card>" +
                "<card>" +
                "<cardNumber>5555 6666 7777 8888</cardNumber>" +
                "<cardType>Debit</cardType>" +
                "</card>" +
                "</cards>" +
                "<linkedParties>" +
                "<linkedParty>" +
                "<name>John Doe</name>" +
                "<relationship>Spouse</relationship>" +
                "</linkedParty>" +
                "<linkedParty>" +
                "<name>Jane Doe</name>" +
                "<relationship>Child</relationship>" +
                "</linkedParty>" +
                "</linkedParties>" +
                "</bankAccount>";
    }

    private String transformXmlWithXslt(String xmlData, InputStream xsltInputStream) throws Exception {
        // Create a Transformer instance
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltInputStream));

        // Perform the transformation
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        transformer.transform(new StreamSource(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))),
                new StreamResult(outputStream));

        return new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
    }
}
