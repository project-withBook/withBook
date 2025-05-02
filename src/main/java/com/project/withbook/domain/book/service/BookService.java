package com.project.withbook.domain.book.service;

import com.project.withbook.domain.book.dto.response.BookDetailResponse;
import com.project.withbook.domain.book.dto.response.BookSearchItemResponse;
import com.project.withbook.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import static com.project.withbook.domain.book.util.parser.BookXmlParser.parseBookDetail;
import static com.project.withbook.domain.book.util.parser.BookXmlParser.parseBookList;
import static com.project.withbook.domain.book.util.XmlUtils.parseXmlFromUrl;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    @Value("${aladin.ttb.key}")
    private String ttbKey;

    private final BookRepository bookRepository;

    private static final String ALADIN_SEARCH_API = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx";
    private static final String ALADIN_LOOKUP_API = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx";
    private static final String API_VERSION = "20131101";

    public List<BookSearchItemResponse> searchBooks(String query, String queryType) {

        try {
            if (query == null || query.isBlank() || queryType == null || queryType.isBlank()) {
                return Collections.emptyList();
            }

            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            URL url = new URL(
                    ALADIN_SEARCH_API
                            + "?ttbkey=" + ttbKey
                            + "&query=" + encodedQuery + "&queryType=" + queryType
                            + "&maxResults=20&start=1&output=xml&version=" + API_VERSION
            );

            Document document = parseXmlFromUrl(url);
            return parseBookList(document);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            log.error("알라딘 API 호출 또는 XML 파싱 중 오류 발생", e);
            throw new RuntimeException("에러 (커스텀으로 변경 예정)");
        }
    }

    public BookDetailResponse getBook(String isbn) {

        try {
            URL url = new URL(ALADIN_LOOKUP_API
                            + "?ttbkey=" + ttbKey
                            + "&itemIdType=isbn13&itemId=" + isbn
                            + "&output=xml&version=" + API_VERSION
                            + "&cover=big"
            );

            Document document = parseXmlFromUrl(url);
            return parseBookDetail(document);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            log.error("알라딘 API 호출 또는 XML 파싱 중 오류 발생", e);
            throw new RuntimeException("에러 (커스텀으로 변경 예정)");

        }
    }

}
