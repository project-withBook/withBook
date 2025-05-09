package com.project.withbook.common.client;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;

@Component
public class ApiClient {

    public Document fetchXml(URI uri) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(uri.toURL().openStream());
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            throw new RuntimeException("에러 (커스텀으로 변경 예정)");
        }
    }
}
