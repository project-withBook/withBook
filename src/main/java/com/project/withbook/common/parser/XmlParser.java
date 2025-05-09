package com.project.withbook.common.parser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

@Component
public class XmlParser {
    public <T> T parse(Document document, XmlParseStrategy<T> strategy) {
        return strategy.parse(document);
    }
}
