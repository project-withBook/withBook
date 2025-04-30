package com.project.withbook.domain.book.service;

import com.project.withbook.domain.book.dto.response.BookInfoResponse;
import com.project.withbook.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Value("${aladin.ttb.key}")
    private String ttbKey;

    private final BookRepository bookRepository;

    public List<BookInfoResponse> searchBooks(String keyword, String title, String author, String publisher) {

        List<BookInfoResponse> bookList = new ArrayList<>();

        try {
            StringBuilder sb = new StringBuilder("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=" + ttbKey);

            appendQueryParam(sb, keyword, "Keyword");
            appendQueryParam(sb, title, "Title");
            appendQueryParam(sb, author, "Author");
            appendQueryParam(sb, publisher, "Publisher");

            sb.append("&MaxResults=20&start=1&output=xml&Version=20131101");

            URL url = new URL(sb.toString());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(url.openStream());
            document.getDocumentElement().normalize();

            NodeList itemList = document.getElementsByTagName("item");

            for (int i = 0; i < itemList.getLength(); i++) {
                Node node = itemList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    BookInfoResponse book = BookInfoResponse.of(
                            getTagValue("title", element),
                            getTagValue("author", element),
                            getTagValue("description", element),
                            getTagValue("publisher", element),
                            getTagValue("isbn13", element),
                            getTagValue("cover", element),
                            Integer.parseInt(getTagValue("customerReviewRank", element))
                    );

                    bookList.add(book);
                }
            }

            System.out.println("bookList = " + bookList);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.err.println("API 호출 또는 파싱 중 오류 발생: " + e.getMessage());}

        return bookList;
    }

    private void appendQueryParam(StringBuilder sb, String value, String queryType) {
        if (value != null && !value.isBlank()) {
            String encoded = URLEncoder.encode(value, StandardCharsets.UTF_8);
            sb.append("&Query=").append(encoded).append("&QueryType=").append(queryType);
        }
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() == 0) return "";
        return nodeList.item(0).getTextContent();
    }

}
