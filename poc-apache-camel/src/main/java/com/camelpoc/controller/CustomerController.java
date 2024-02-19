package com.camelpoc.controller;

import com.camelpoc.entity.Customer;
import com.camelpoc.repo.CustomerRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

@RestController
class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/transform")
    public String transformXmlAndStore() {
        try {
            // Load XML and XSL files
            ClassPathResource xmlResource = new ClassPathResource("customer_info.xml");
            ClassPathResource xslResource = new ClassPathResource("transform.xsl");

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

            // Store the transformed XML into the database
            Customer customer = new Customer();
            customer.setXmlData(transformedXml);
            customerRepository.save(customer);

            return "Transformation successful and data stored into the database";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during transformation and storing data";
        }
    }
}

