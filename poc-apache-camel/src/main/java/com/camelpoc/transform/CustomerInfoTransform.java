package com.camelpoc.transform;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringWriter;

public class CustomerInfoTransform {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Load XML and XSL files
        ClassPathResource xmlResource = new ClassPathResource("customer/customer_info.xml");
        ClassPathResource xslResource = new ClassPathResource("customer/transform.xsl");

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

        System.out.println(transformedXml);
    }
}
