package com.project.withbook.domain.book.util.parser;

import com.project.withbook.domain.book.dto.response.BookDetailResponse;
import com.project.withbook.domain.book.dto.response.BookSearchItemResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class BookXmlParser {

    public static BookDetailResponse parseBookDetail(Document document) {
        Node node = document.getElementsByTagName("item").item(0);
        if (node == null || node.getNodeType() != Node.ELEMENT_NODE) {
            throw new RuntimeException("에러 (커스텀으로 변경 예정)");
        }

        return BookDetailResponse.from((Element) node);
    }

    public static List<BookSearchItemResponse> parseBookList(Document document) {
        List<BookSearchItemResponse> bookList = new ArrayList<>();
        NodeList itemList = document.getElementsByTagName("item");

        for (int i = 0; i < itemList.getLength(); i++) {
            Node node = itemList.item(i);
            if (node == null || node.getNodeType() != Node.ELEMENT_NODE) continue;
            bookList.add(BookSearchItemResponse.from((Element) node));
        }

        return bookList;
    }
}
