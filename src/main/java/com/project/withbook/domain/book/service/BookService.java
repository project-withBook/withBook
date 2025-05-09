package com.project.withbook.domain.book.service;

import com.project.withbook.common.mapper.XmlElementMapper;
import com.project.withbook.common.client.ApiClient;
import com.project.withbook.domain.book.client.BookApiUriBuilder;
import com.project.withbook.domain.book.dto.response.BookDetailResponse;
import com.project.withbook.domain.book.dto.response.BookSearchItemResponse;
import com.project.withbook.domain.book.model.BookInfo;
import com.project.withbook.domain.book.transform.ListParseStrategy;
import com.project.withbook.domain.book.transform.SingleParseStrategy;
import com.project.withbook.common.parser.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookApiUriBuilder bookApiUriBuilder;
    private final XmlParser xmlParser;
    private final ApiClient apiClient;
    private final XmlElementMapper<BookInfo> mapper;

    public List<BookSearchItemResponse> searchBooks(String query, String queryType) {

        URI uri = bookApiUriBuilder.buildUri(query, queryType);

        Document document = apiClient.fetchXml(uri);

        List<BookInfo> bookInfos = xmlParser.parse(document, new ListParseStrategy<>(mapper));

        return bookInfos.stream()
                .map(BookSearchItemResponse::from)
                .toList();
    }

    public BookDetailResponse getBook(String isbn) {

        URI uri = bookApiUriBuilder.buildUri(isbn);

        Document document = apiClient.fetchXml(uri);
        BookInfo bookInfo = xmlParser.parse(document, new SingleParseStrategy<>(mapper));
        return BookDetailResponse.from(bookInfo);

    }

}
