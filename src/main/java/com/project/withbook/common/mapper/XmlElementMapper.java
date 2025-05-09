package com.project.withbook.common.mapper;

import org.w3c.dom.Element;

public interface XmlElementMapper<T> {
    T fromElement(Element element);
}
