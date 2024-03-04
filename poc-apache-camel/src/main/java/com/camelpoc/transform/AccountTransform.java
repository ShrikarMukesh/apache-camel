package com.camelpoc.transform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

@Slf4j
@Component
public class AccountTransform {

    public String accountTransform(){

        try {
            // Load XML and XSL files
            ClassPathResource xmlResource = new ClassPathResource("customer/account.xml");
            ClassPathResource xslResource = new ClassPathResource("customer/BankAccountTransform.xsl");

            // Parse XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(xmlResource.getInputStream());

            // Load XSLT stylesheet
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource styleSheet = new StreamSource(xslResource.getInputStream());
            Transformer transformer = transformerFactory.newTransformer(styleSheet);

            // Apply transformation
            StringWriter resultWriter = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(resultWriter));
            String transformedXml = resultWriter.toString();
            log.info(transformedXml+ "Transformation successful and data stored into the database");
           return transformedXml;


    } catch (Exception e) {
        e.printStackTrace();
        return "Error occurred during transformation and storing data";
    }
        }
}
