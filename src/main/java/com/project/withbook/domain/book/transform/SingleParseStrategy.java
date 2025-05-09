package com.project.withbook.domain.book.transform;

import com.project.withbook.common.mapper.XmlElementMapper;
import com.project.withbook.common.parser.XmlParseStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SingleParseStrategy<T> implements XmlParseStrategy<T> {

    private final XmlElementMapper<T> mapper;

    public SingleParseStrategy(XmlElementMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public T parse(Document document) {
        Node node = document.getElementsByTagName("item").item(0);
        if (node == null || node.getNodeType() != Node.ELEMENT_NODE) {
            throw new RuntimeException("에러 (커스텀으로 변경 예정)");
        }

        return mapper.fromElement((Element) node);
    }
}
