package in.rahulojha.bookbank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.rahulojha.bookbank.exception.BookNotFoundException;
import in.rahulojha.bookbank.model.Book;
import in.rahulojha.bookbank.model.BookMetadata;
import in.rahulojha.bookbank.model.FormatEnum;
import in.rahulojha.bookbank.model.Stats;
import in.rahulojha.bookbank.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MinioService minioService;

    /*--------------------------CREATE----------------------------*/
    public Book createBook(List<MultipartFile> books, String metadata) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        var bookMetadata =objectMapper.readValue(metadata, BookMetadata.class);

        for (var book: books) {
            minioService.uploadFile(bookMetadata.getTitle(), book);
            var bookEntity = new in.rahulojha.bookbank.entity.Book();

            bookEntity.setTitle(bookMetadata.getTitle());
            bookEntity.setAuthor(bookMetadata.getAuthor());
            bookEntity.setGenre(bookMetadata.getGenre());
            bookEntity.setYear(bookMetadata.getYear());
            bookEntity.setDescription(bookMetadata.getDescription());
            bookEntity.setTags(bookMetadata.getTags());
            bookEntity.setUploadDate(LocalDateTime.now());
            return Book.fromBookEntity(bookRepository.save(bookEntity));
        }
        return new Book();
    }



    /*--------------------------READ----------------------------*/
    public List<Book> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(Book::fromBookEntity)
                .toList();
    }

    public Book findBookById(UUID id) {
        return bookRepository.findById(id).stream()
                .map(Book::fromBookEntity)
                .findFirst()
                .orElseThrow(BookNotFoundException::new);
    }

    /*--------------------------UPDATE----------------------------*/
    public void updateBookById(UUID id, BookMetadata bookMetadata) {
        var bookEntity = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        bookEntity.setTitle(bookMetadata.getTitle());
        bookEntity.setAuthor(bookMetadata.getAuthor());
        bookEntity.setGenre(bookMetadata.getGenre());
        bookEntity.setYear(bookMetadata.getYear());
        bookEntity.setDescription(bookMetadata.getDescription());
        bookEntity.setTags(bookMetadata.getTags());

        bookRepository.save(bookEntity);
    }
    /*--------------------------DELETE----------------------------*/
    public void deleteBookById(UUID id) {
        var bookEntity = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);;
        bookRepository.delete(bookEntity);
    }




    public Stats getAllStats() {
        List<Book> books = findAllBooks();
        Stats stats = new Stats();
        if (books == null || books.isEmpty()) {
            return stats;
        }
        stats.setTotalBooks(books.size());
        stats.setPdfCount(books.stream().filter(book -> bookFilter.test(book, FormatEnum.PDF)).count());
        stats.setEpubCount(books.stream().filter(book -> bookFilter.test(book, FormatEnum.EPUB)).count());
        stats.setMobiCount(books.stream().filter(book -> bookFilter.test(book, FormatEnum.MOBI)).count());
        stats.setAzw3Count(books.stream().filter(book -> bookFilter.test(book, FormatEnum.AZW3)).count());
        stats.setAuthorCount(books.stream().map(Book::getAuthor).distinct().count());
        stats.setTotalFileSize(books.stream().map(Book::getFileSize).filter(Objects::nonNull).reduce(Long::sum).orElseGet(() -> 0L));
        return stats;
    }

    BiPredicate<Book, FormatEnum> bookFilter = (book, format) -> {
        assert book.getFormat() != null;
        return book.getFormat().equals(format);
    };






}
