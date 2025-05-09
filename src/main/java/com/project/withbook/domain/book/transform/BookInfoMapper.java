package com.project.withbook.domain.book.transform;

import com.project.withbook.common.mapper.XmlElementMapper;
import com.project.withbook.domain.book.model.BookInfo;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.time.LocalDate;

@Component
public class BookInfoMapper implements XmlElementMapper<BookInfo> {

    @Override
    public BookInfo fromElement(Element element) {
        return new BookInfo(
                getText(element, "title"),
                getText(element, "author"),
                getText(element, "description"),
                getText(element, "cover"),
                parseInt(getText(element, "customerReviewRank")),
                parseInt(getText(element, "itemPage")),
                getText(element, "publisher"),
                parseDate(getText(element, "pubDate")),
                getText(element, "isbn13")
        );
    }

    private String getText(Element element, String tag) {
        NodeList nodes = element.getElementsByTagName(tag);
        if (nodes.getLength() > 0 && nodes.item(0) != null) {
            String content = nodes.item(0).getTextContent();
            return (content != null) ? content : "";
        }
        return "";
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }

    private LocalDate parseDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return null;
        }
    }
}
