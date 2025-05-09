package com.project.withbook.domain.book.transform;

import com.project.withbook.common.mapper.XmlElementMapper;
import com.project.withbook.common.parser.XmlParseStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ListParseStrategy<T> implements XmlParseStrategy<List<T>> {

    private final XmlElementMapper<T> mapper;

    public ListParseStrategy(XmlElementMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> parse(Document document) {

        NodeList nodes = document.getElementsByTagName("item");
        List<T> list = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                list.add(mapper.fromElement((Element) node));
            }
        }

        return list;
    }
}
