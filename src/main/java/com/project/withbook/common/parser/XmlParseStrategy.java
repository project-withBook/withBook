package com.project.withbook.common.parser;

import org.w3c.dom.Document;

public interface XmlParseStrategy<T> {
    T parse(Document document);
}
