package in.rahulojha.bookbank.api;


import in.rahulojha.bookbank.model.*;
import in.rahulojha.bookbank.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.annotation.Generated;
import org.springframework.web.multipart.MultipartFile;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
@Controller
@RequestMapping("${openapi.bookManagement.base-path:}")
@RequiredArgsConstructor
public class BookBankApiController implements BookBankApi {

    private final NativeWebRequest request;
    private final BookService bookService;


    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Book> apiBooksUploadPost(List<MultipartFile> files, String metadata) throws Exception {

        return ResponseEntity.ok(bookService.createBook(files, metadata));
    }
//
    @Override
    public ResponseEntity<Book> apiBooksIdGet(UUID id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @Override
    public ResponseEntity<PaginatedBooksResponse> apiBooksGet(Integer page, Integer size, String search, FormatEnum format, String genre, String author) {
        var paginatedResponse = new PaginatedBooksResponse();
        paginatedResponse.setContent(bookService.findAllBooks());
        paginatedResponse.setNumber(1);
        paginatedResponse.setSize(paginatedResponse.getContent().size());
        paginatedResponse.setTotalPages(1);
        paginatedResponse.setTotalElements(paginatedResponse.getContent().size());
        return ResponseEntity.ok(paginatedResponse);
    }

    @Override
    public ResponseEntity<Void> apiBooksIdPut(UUID id, BookMetadata bookMetadata) {
        bookService.updateBookById(id, bookMetadata);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> apiBooksIdDelete(UUID id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Stats> apiBooksStatsGet() {
        return ResponseEntity.ok(bookService.getAllStats());
    }
}
