package com.jss.xmltransform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

@Service
@Slf4j
public class XMLToJSONConverter {
    public static void main(String[] args) {
        try {

            ClassPathResource xmlResource = new ClassPathResource("events/data.xml");
            ClassPathResource xslResource = new ClassPathResource("events/transform.xslt");

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

            log.info(transformedXml+ "Transformation "+ transformedXml);


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
